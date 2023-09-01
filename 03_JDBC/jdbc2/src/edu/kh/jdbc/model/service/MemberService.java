package edu.kh.jdbc.model.service;

import java.sql.Connection;

// import static : 지정된 static 필드/메서드를 가져옴
//					해당 클래스 것 처럼 사용가능하게함
//					--> 앞에 클래스명을 생략 가능
//					JDBCTemplate.getConnection() == getConnection()
import static edu.kh.jdbc.common.JDBCTemplate.*;

import edu.kh.jdbc.model.dao.MemberDAO;
import edu.kh.jdbc.model.dto.Member;

// Service : 비즈니스 로직 // 사실상 진짜 일하는 애, DB코드는 여기서 안써요!
// - 요청에 따른 필요 데이터를 반환
// + DB 연결 코드인 DAO를 호출
// + 트랜잭션 제어(commit, rollback) / DB에서 만든 코드의 결정권!
//   --> commit, rollback을 하려면 Connection이 필요하기 때문에
//		Service에서 Connection을 생성/닫기

public class MemberService {

	// 필드
	private MemberDAO dao = new MemberDAO();
	
	
	/** 회원가입 서비스
	 * @param member
	 * @return INSERT된 행의 갯수
	 */
	public int insertMember(Member member) {   // 형태는 여기서 크게 변하지 않아요~
		
		// 1. 커넥션 생성(JDBCTempleat을 이용해 얻어옴)
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(커넥션, 매개변수 전달)
		// -> insert 성공한 행의 갯수 반환
		int result = dao.insertMember(conn, member);
		
		// 3. 성공여부에 따른 트랜잭션 제어
		if(result > 0) commit(conn); // INSERT 성공
		else			rollback(conn); // INSERT 실패
		
		// 4. 커넥션 제거
		close(conn);

		// 5. SQL 수행 결과를 view 반환
		return result;
	}



	/** 회원 정보 수정 서비스
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {

		// 1. 커넥션 생성(JDBCTempleat을 이용해 얻어옴)
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(커넥션, 매개변수 전달)
		//	 -> update 성공한 행의 갯수 반환
		int result = dao.updateMember(conn, member);
		
		// 3. 성공여부에 따른 트랜잭션 제어 -> service에서 Connection을 만드는 이유임
		// 성공 : 1, 실패 : 0 
		if (result > 0) commit(conn); 
		else 			rollback(conn);
		
		// 4. 커넥션 제거
		close(conn);
		
		// 5. SQL 수행 결과를 view 반환
		return result;
	}



	/** 회원 탈퇴 서비스
	 * @param member
	 * @return
	 */
	public int deleteMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. dao 메서드 호출
		int result = dao.deleteMember(conn, member);
		
		// 3. 트랜잭션 처리
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 반환
		return result;
	}



	/** 비밀번호 변경 서비스
	 * @param email
	 * @param pw
	 * @param newpw
	 * @return
	 */
	public int updatePw(String email, String pw, String newPw) {

		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. dao 메서드 호출
		int result = dao.updatePw(conn, email, pw, newPw);
		
		// 3. 트랜잭션 처리
		if(result > 0) commit(conn);
		else 			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 반환
		return result;
	}
	
	
	
	
	
	

}
