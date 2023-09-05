package edu.kh.jdbc.service;

// static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;
// 원래 static변수들을 클래스명.변수명 으로 써야하지만 import static은 클래스명(JDBCTemplate) 생략가능

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;


public class ProjectService {
	
	private ProjectDAO dao = new ProjectDAO();

	
	/** 회원가입 서비스
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DB연결 -> DAO 메서드 호출(Connection, 매개변수 전달)
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜젝션 제어
		if(result > 0) commit(conn);
		else			rollback(conn); // 커밋롤백이 서비스페이지가 필요한 이유!
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 view로 반환
		return result;
	}


	
	
	/** 로그인 서비스
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DB 연결 -> DAO 메서드 호출
//		Member member = dao.login(conn, email, pw); // PreparedStatement이용 방식
		
		Member member = dao.login2(conn, email, pw); // Statement 이용 방식
		
		// SELECT는 트랜잭션 제어 처리가 필요없음 -> 3번은 건너뜀
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. 결과 view로 반환
		return member;
	}
	
	
	/** MEMBER 테이블 전체 조회
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort){
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. 결과 view로 반환
		return memberList;
	}




	/** 회원 정보 업데이트
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {

		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환받기
		int result = dao.updateMember(conn, nickname, tel, memberNo);
		
		// 3. 트랜잭션 ㄱ
		if(result > 0) commit(conn);
		else			rollback(conn); 
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 view로 반환
		return result;
	}




	/** 회원 탈퇴 서비스
	 * @param pw
	 * @param memberNo
	 * @return
	 */
	public int updateDelFl(String pw, int memberNo) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출 후 결과 받기 
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		// 3. 트랜잭션 ㄱ
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. Connection 반환
		close(conn);
		
		// 5. 결과 반환
		return result;
	}




	/** 게시글 작성 서비스
	 * @param memberNo
	 * @param title
	 * @param content
	 * @return
	 */
	public int insertBoard(int memberNo, String title, String content) {
		
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, memberNo, title, content);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 게시글 목록 조회
	 * @return
	 */
	public List<Board> selectBoardList() {

		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn);
		
		close(conn);
		
		return boardList;
	}




	/** 게시글 상세 조회
	 * @param boardNumber
	 * @return
	 */
	public Board selectBoard(int boardNumber) {
		
		Connection conn = getConnection();
		
//		1) DAO - 게시글 상세 조회 메서드 호출
		Board board = dao.selectBoard(conn, boardNumber);
		
//		2) 게시글 상세 조회 결과가 있을 경우 -> 조회수 증가
//			(incrementReadCount(게시글 번호)) 수행
		if (board != null) {
			
			int result = dao.incrementReadCount(conn, boardNumber);
			
			// 트랜잭션 처리
			if (result > 0) {
				commit(conn);
				
				// DB와 데이터 동기화
				// (DB에서만 조회수가 1 증가하기 때문에
				//  조회해둔 board에도 조회수 1을 증가시킴)
				board.setReadCount( board.getReadCount() +1 );
			}
			else			rollback(conn);	
		}
		
		close(conn); // 커넥션 반환
		
		return board;
	}



	/** 게시글 번호와 사용자 번호 매칭
	 * @param memberNo
	 * @param boardNo
	 * @return
	 */
	public int checkBoard(int memberNo, int boardNo) {

		Connection conn = getConnection();
		
		int result = dao.checkBoard(conn, memberNo, boardNo);
		
		close(conn);
		
		return result;
	}



	/** 게시글 삭제
	 * @param memberNo
	 * @param boardNo
	 * @return
	 */
	public int deleteBoard(int boardNo) {

		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}




	/** 게시글 수정
	 * @param boardNo
	 * @param title
	 * @param content
	 * @return
	 */
	public int updateBoard(int boardNo, String title, String content) {
		
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn, title, content, boardNo);
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
	}




	

}
