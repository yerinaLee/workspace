package edu.kh.jdbc.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.model.dao.ProjectDAO;
import edu.kh.jdbc.model.dto.Member;

public class ProjectService {
	
	
	private ProjectDAO dao = new ProjectDAO();
	
	

	/** 회원가입 서비스
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. Connection 생성하기
		Connection conn = getConnection();
		
		// 2. DAO로 정보 넘기기
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜젝션 제어
		if (result > 0 ) commit(conn);
		else			rollback(conn);
		
		// 4. Connection 반환
		close(conn);
		
		// 5. 결과 view로 반환
		return result;
	}



	/** 로그인
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {

		Connection conn = getConnection();
		
		Member member = dao.login(conn, email, pw);
		
		close(conn);
		
		return member;
	}



	/** 회원 정보 수정
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {

		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		int result = dao.updateMember(conn, nickname, tel, memberNo);
		
		// 3. 트랜젝션 제어
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		// 4. Conn 반환
		close(conn);
		
		// 5. 값 반환
		return result;
	}



	/** 회원 탈퇴
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelFl(int memberNo, String pw) {
		
		Connection conn = getConnection();
		
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}



	/** 회원 정보 전체 조회
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort) {

		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		close(conn);
		
		return memberList;
	}

}
