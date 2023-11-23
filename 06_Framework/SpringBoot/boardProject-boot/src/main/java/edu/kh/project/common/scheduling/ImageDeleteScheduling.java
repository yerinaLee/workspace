package edu.kh.project.common.scheduling;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.kh.project.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 클래스(설계도) -> 객체(설계도 보고 만든 것)

@Component // bean 등록(bean == spring container가 관리하는 객체)
@Slf4j
@PropertySource("classpath:/config.properties")
public class ImageDeleteScheduling {
	
	// config 파일에서 게시판, 회원 이미지 저장 경로 얻어오기
	@Value("${my.board.location}")
	private String boardLocation;

	@Value("${my.member.location}")
	private String memberLocation;
	
	@Autowired
	private BoardService service; // @required...는 controller에서만 사용 가능
	
	
	
//	@Scheduled(fixedDelay = 5000) // 이전 작업이 끝난 후 5초 후 수행
//	@Scheduled(fixedRate = 5000) // 이전 작업 시작 후 5초 후 수행
	
	//cron="초 분 시 일 월 요일 [년도]" - 요일 : 1(SUN) ~ 7(SAT)
//	@Scheduled(cron = "0,15,30,45 * * * * *") // 시계 초단위가 0, 15, 30, 45인 경우 수행(매분 시행!)
//	@Scheduled(cron = "0,30 * * * * *") // 시계 초단위가 0, 30인 경우 수행(매분 시행!)
	@Scheduled(cron = "0 0 * * * *") // 정시마다 수행
//	@Scheduled(cron = "0 0 0 * * *") // 자정마다 수행
//	@Scheduled(cron = "0 0 12 * * *") // 정오마다 수행
//	@Scheduled(cron = "0 0 0 1 * *") // 매달 1일 자정마다 수행
	public void scheduling() {
		
		log.info("스케쥴러 동작!");
		
		// DB, 서버 파일 목록 비교 후 DB에 없는
		// 서버이미지 파일 삭제 동작
		
		// 1. 서버 파일 목록 조회하기
		File boardFolder = new File(boardLocation);
		File memberFolder = new File(memberLocation);
		
		// File 객체 : 파일자체라기보단 어느 위치에 있는 파일과 연결하겠다는 의미로 제일 많이 씀. 폴더 참조!
		
		// 참조하는 폴더에 존재하는 파일 목록 얻어오기
		File[] boardArr = boardFolder.listFiles();
		File[] memberArr = memberFolder.listFiles();
		
		// 두 배열을 하나로 합침(for문 한번만 사용하기위해!)
		File[] imageArr = new File[boardArr.length + memberArr.length];
		
		// 배열 내용 복사(깊은 복사)
		System.arraycopy(boardArr, 0, imageArr, 0, boardArr.length);
		System.arraycopy(memberArr, 0, imageArr, boardArr.length, memberArr.length);
		
		// 배열 -> List 변환
		List<File> serverImageList = Arrays.asList(imageArr);

		
		// 2. DB 이미지파일 이름만 모두 조회
		List<String> dbImageList = service.selectDbImageList();
		
		
		// 3. 서버, DB 이미지 파일명을 비교하여
		// 서버에만 있고, DB에 없는 파일을 삭제
		
		if(!serverImageList.isEmpty()) { // 서버에 이미지가 있을 경우
			for(File serverImage : serverImageList) {
				//log.debug(serverImage.getName()); // 서버 파일 이름
				
				// List.indexOf(객체) :
				// List에 객체가 존재하면, 존재하는 index
				// 존재하지 않으면, -1 반환하는 메서드
				if(dbImageList.indexOf( serverImage.getName() ) == -1 ) {
					log.info(serverImage.getName() + "삭제");
					serverImage.delete(); //파일 삭제
				}
			}
		}
		
		
	}
	
}


/*
 * @Scheduled
 * 
 * * Spring에서 제공하는 스케줄러 - 스케줄러 : 시간에 따른 특정 작업(Job)의 순서를 지정하는 방법.
 * 
 * 설정 방법 
 * 1) XXX APllication.java 파일에 @EnableScheduling 어노테이션 추가
 * 2) 스케쥴링 동작을 위한 클래스 작성
 * 
 *
 * @Scheduled 속성
 *  - fixedDelay : 이전 작업이 끝난 시점으로 부터 고정된 시간(ms)을 설정.
 *    @Scheduled(fixedDelay = 10000) // 이전 작업이 시작된 후 10초 뒤에 실행
 *    
 *  - fixedRate : 이전 작업이 수행되기 시작한 시점으로 부터 고정된 시간(ms)을 설정.
 *    @Scheduled(fixedRate  = 10000) // 이전 작업이 끝난 후 10초 뒤에 실행
 *    
 *    가장 많이 사용!! 매일 오후 1시 요런식~
 * * cron 속성 : UNIX계열 잡 스케쥴러 표현식으로 작성 - cron="초 분 시 일 월 요일 [년도]" - 요일 : 1(SUN) ~ 7(SAT) 
 * ex) 2019년 9월 16일 월요일 10시 30분 20초 cron="20 30 10 16 9 2 " // 연도 생략 가능
 * 
 * - 특수문자 * : 모든 수. 
 * - : 두 수 사이의 값. ex) 10-15 -> 10이상 15이하 
 * , : 특정 값 지정. ex) 3,4,7 -> 3,4,7 지정 
 * / : 값의 증가. ex) 0/5 -> 0부터 시작하여 5마다 
 * ? : 특별한 값이 없음. (월, 요일만 해당) 
 * L : 마지막. (월, 요일만 해당)
 * @Scheduled(cron="0 * * * * *") // 매 분마다 실행
 * 
 * 
 * * 주의사항 - @Scheduled 어노테이션은 매개변수가 없는 메소드에만 적용 가능.
 * 
 */