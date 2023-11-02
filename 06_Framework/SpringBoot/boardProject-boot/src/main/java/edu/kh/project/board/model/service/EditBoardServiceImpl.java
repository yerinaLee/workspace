package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImg;
import edu.kh.project.board.model.exception.BoardWriteException;
import edu.kh.project.board.model.mapper.EditBoardMapper;
import edu.kh.project.common.utility.Util;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@PropertySource("classpath:/config.properties")
public class EditBoardServiceImpl implements EditBoardService{

	private final EditBoardMapper mapper;
	
	@Value("${my.board.location}")
	private String folderPath; // 서버 저장 폴더 경로
	
	@Value("${my.board.webpath}")
	private String webPath; // 웹 이미지 요청 경로
	
	
	/** 게시글 삭제
	 * @param paramMap
	 * @return result
	 */
	@Override
	public int deleteBoard(Map<String, Integer> paramMap) {
		return mapper.deleteBoard(paramMap);
	}

	/** 게시글 작성
	 * @param board
	 * @param images
	 * @return boardNo(실패시 0)
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@Override
	public int insertBoard(Board board, List<MultipartFile> images) throws IllegalStateException, IOException {
		
		// 1. 게시글(BOARD 테이블) 부분만 먼저 INSERT
		
		// 1) 게시글 삽입 mapper 메서드 호출 후 결과 반환 받기(1 or 0)
		int result = mapper.insertBoard(board);
		
		if(result == 0) return 0; // 삽입 실패
		
		// 2) 게시글 삽입 성공 시
		//	 파라미터가 담긴 board 객체에서 boardNo 꺼내놓기
		//	 (board.boardNo 필드에는 <selectKey> 태그로 얻어온
		//	 시퀀스 값이 들어있다! 짜잔!)
		
		int boardNo = board.getBoardNo();
		
		// ------------------------------------------------------------
		
		
		// 2. 게시글(BOARD 테이블) 삽입 성공 시
		// 업로드 된 이미지가 있다면
		// BOARD_IMG 테이블에 INSERT
		
		// images : 업로드 된 파일 (MultipartFile) 리스트 (진짜 걍 이미지파일!)
		// uploadList : images 리스트에서 실제 업로드된 파일의 정보(파일명, 인덱스(순서))만 뽑아서
		//				모아둘 리스트
		//				(uploadList에 모인 데이터를 가지고 DB INSERT)
		
		List<BoardImg> uploadList = new ArrayList<>();
		
		// images에서 업로드 된 파일 선별하기
		for(int i=0; i<images.size(); i++) {
			
			// i번째 요소의 파일 크기가 0보다 크다 == 파일이 있다!
			if(images.get(i).getSize() > 0) {
				
				BoardImg img = new BoardImg();
				
				img.setBoardNo(boardNo); // 몇번 게시글의 이미지?
				img.setImgOrder(i); // 몇번째 이미지? (인덱스)

				// 원본 파일명(다운로드에서 사용)
				img.setImgOriginalName(images.get(i).getOriginalFilename()); 
				
				// 웹 접근 경로
				img.setImgPath(webPath);
				
				// 변경된 파일명
				img.setImgRename(Util.fileRename( images.get(i).getOriginalFilename() ));
				
				
				// 실제 업로드된 파일을 img에 세팅
				img.setUploadFile(images.get(i));
				
				// uploadList에 추가
				uploadList.add(img);
			
			} // if 끝
			
		} // for 끝
		
		// images에서 업로드 된 파일을 선별했으나 아무것도 없을 때
		if(uploadList.isEmpty()) {
			return boardNo;
		}
		
		
		// ***** images에 실제로 업로드된 이미지가 있을 때! *****
		// uploadList를 통째로 mapper로 전달해 일괄 삽입
		result = mapper.insertUploadList(uploadList);
		
		// 전달된 데이터가 모두 삽입되었을 경우
		if(result == uploadList.size()) {
			
			// 업로드 된 이미지를 서버(folderPath)에 저장
			for(BoardImg img : uploadList) {
				img.getUploadFile().transferTo(new File(folderPath + img.getImgRename()));
			}
			
		} else { // 삽입이 일부 안됐을 경우
			// 하나라도 실패하면 전체 롤백
			// -> 롤백하는 방법 == 예외 발생시 롤백!
			// --> 강제 예외 발생 (사용자 정의 예외)
			
			throw new BoardWriteException("파일 정보 DB 삽입 실패");
			
		}
		
		return boardNo;
	}
	
	
}
