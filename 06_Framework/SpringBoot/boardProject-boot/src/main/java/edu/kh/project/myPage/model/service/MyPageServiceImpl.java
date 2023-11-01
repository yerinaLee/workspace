package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
@PropertySource("classpath:/config.properties")
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Value("${my.member.webpath}")
	private String webpath;
	
	@Value("${my.member.location}")
	private String folderPath;
	
	
	
	/** 회원 정보 수정
	 *
	 */
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공처리
		// 주소가 입력되지 않은 경우
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null); // null로 변환
		
		} else { // 주소가 입력된 경우
			// 배열 -> 문자열로 합쳐서 inputMember에 추가
			String address = String.join("^^^", memberAddress); //하나의 문자열로 합치기
			updateMember.setMemberAddress(address);
		}
		
		// mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	
	
	
	
	/** 비밀번호 변경
	 *
	 */
	@Override
	public int chagePw(int memberNo, String currentPw, String newPw) {

		// 1. 로그인한 회원의 비밀번호 조회
		// 현재 비밀번호 일치하는지 확인
		// 현재 비밀번호 DB에서 얻어오기
		String currentPw2 = mapper.findPw(memberNo); 
		
		// 2. 현재 비밀번호와 조회한 비밀번호 비교
		// 현재 비밀번호가 불일치한다면
		if(!bcrypt.matches(currentPw, currentPw2)) { // 같지 않다
			return 0;
		}
		
		
		// 3. 현재 비밀번호 일치한다면 새 비밀번호 변경
		// (주의사항) 마이바티스 코드의 파라미터는 1개만 가능!
		// -> 현재 newPw(암호화), memberNo 두개가 필요
		// --> 하나로 묶어서 해결!(Map, DTO)
		
		// 새로운 비밀번호 암호화 작업
		String encPw = bcrypt.encode(newPw);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("encPw", encPw);
		map.put("memberNo", memberNo);
		
		// 비밀번호 변경 ㄱㄱ
		return mapper.changePw(map);
	}
	
	
	
	/** 회원 탈퇴
	 * 
	 */
	@Override
	public int secession(int memberNo, String memberPw) {
		
		// 1. 로그인한 회원의 비밀번호가 일치하는지 확인
		String encPw = mapper.findPw(memberNo); 
		
		// 2. 현재 비밀번호와 조회한 비밀번호 비교
		// 현재 비밀번호가 불일치한다면
		if(!bcrypt.matches(memberPw, encPw)) { // 같지 않다
			return 0;
		}
		
		// 3. 일치할 경우 회원탈퇴 SQL 수행
		return mapper.secession(memberNo);
	}
	
	
	
	/** 프로필 이미지 수정
	 * @param profileImg : 실제 업로드된 프로필 이미지
	 * @param loginMember
	 * @param ra
	 * @return result
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */ 
	@Override
	public int profile(MultipartFile profileImg, Member loginMember) throws IllegalStateException, IOException {
		
		// 프로필 이미지 변경 실패 대비 (이전 프로필 이미지 경로 저장)
		String backup = loginMember.getProfileImg();
		
		// 변경된 파일명을 저장할 변수 선언
		// - 파일명 변경 이유! -> 파일명이 같으면 이전 파일을 덮어씌우기때문에
		String rename = null;
		
		// (중요)!!! 업로드 된 이미지가 있을 경우를 검사!!!!
		
		// 문자열 데이터  ->  데이터 != null (null을 이용해서 비교)
		
		// 파일 데이터(업로드 안되어도 MultipartFile 객체가 생성됨!!)
		// -> 업로드된 파일의 크기를 이용해 비교
		// -> 파일.getSize() > 0
		
		if(profileImg.getSize() > 0) { // 업로드된 파일이 있다면
			
			// 1) 파일명 변경
			rename = Util.fileRename( profileImg.getOriginalFilename() );
			
			// 2) 바뀐 파일명 + 경로를 loginMember 세팅
//			loginMember.setProfileImg( 경로 + rename ); // 경로는 config.properties에서 얻어오삼
			loginMember.setProfileImg( webpath + rename );
			
			// /images/member/202311011144523_00001.jpg
			
			
		} else { // 업로드된 파일이 없다면 -> 기본 이미지로 변경
			loginMember.setProfileImg(null); // 이미지 제거			
		}
		
		// mapper 호출
		int result = mapper.profile(loginMember);
		
		// DB업데이트 성공 시
		// 메모리에 임시 저장된 파일을 지정된 경로에 저장
		if(result > 0) {
			
			if( profileImg.getSize() > 0) { // 업로드 파일 있을 때
				
				// transfer : 옮기다, 갈아타다
				
				// 파일.transferTo(파일경로)
				// -> 메모리에 저장된 파일을 지정된 경로로 옮김(저장)
				profileImg.transferTo(new File(folderPath + rename));
				// C드라이브에 파일명으로 저장됨
			}
			
		} else { // DB 업데이트 실패
			
			// loginMember에 backup 해둔 이미지를 세팅
			loginMember.setProfileImg(backup);
			
		}
		
		return result;
	}
	
	
	
	
	
}
