package edu.kh.member.model.service;

// JDBCTemplate 클래스에 존재하는 static이 붙은 필드/메서드를
// 클래스명 없이 호출할 수 있게함
import static edu.kh.member.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.dto.Member;

// Service : 비즈니스 로직
// - 알맞은 DAO 메서드 호출
// - 트랜잭션 처리 -> Connection 필요 -> Service에서 Connection 생성
// - 데이터 가공
public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	
	// alt + shift + j : 클래스, 메서드 설명(툴팁) + HTML 형식으로 작성
			
	/** 로그인 서비스
	 * <ul>
	 * 	<li> id, pw가 일치하는 회원 정보 반환하는 서비스</li>
	 * 	<li> id, pw가 일치하지 않으면 null 반환</li>
	 * </ul>
	 * @param id
	 * @param pw
	 * @return 회원정보 또는 null
	 */
	public Member login(String id, String pw) {
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 호출
		Member loginMember = dao.login(conn, id, pw);
		
		// 3) 트랜잭션 처리
		// -> SELECT는 할 필요 없음
		
		// 4) Connection 반환(close)
		close(conn);
		
		// 5) 결과 반환
		return loginMember;
	}


	/** 회원 목록 조회 서비스
	 * @return memberList
	 */
	public List<Member> selectMemberList() {
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 호출
		List<Member> memberList = dao.selectMemberList(conn);
		
		// 3) 트랜잭션 처리
		
		// 4) Connection 반환
		close(conn);
		
		return memberList;
	}


	/** 회원가입 서비스
	 * @param member
	 * @return
	 */
	public int signup(Member member) {
		Connection conn = getConnection();
		int result = dao.signup(conn, member);
		
		// 트랜잭션 처리
		if (result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}
	

}
