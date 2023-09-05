package edu.kh.jdbc.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.kh.jdbc.model.dto.Member;


public class ProjectDAO {
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	

	public int insertMember(Connection conn, Member member) {
		
		// 1. 결과 저장할 변수 선언
		int result = 0;
		
		// 2.  SQL문 작성
		String sql = "INSERT INTO MEMBER "
				+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";
		
		try {
			// 3. pstmt 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. placeholder에 알맞은 값 대입
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	/** 로그인
	 * @param conn
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(Connection conn, String email, String pw) {
		
		// 1. 반환 후 저장 변수 선언
		Member member = null;
		
		// 2. SQL 작성 _ pstmt
//		String sql = "SELECT MEMBER_NO , MEMBER_NICKNAME , MEMBER_TEL , MEMBER_ADDRESS ,\r\n"
//				+ "	TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS') ENROLL_DATE\r\n"
//				+ "FROM MEMBER\r\n"
//				+ "WHERE MEMBER_EMAIL = ? \r\n"
//				+ "AND MEMBER_PW = ? \r\n"
//				+ "AND MEMBER_DEL_FL = 'N'";
		
		
//		 2. SQL 작성 _ stmt
		String sql = "SELECT MEMBER_NO , MEMBER_NICKNAME , MEMBER_TEL , MEMBER_ADDRESS ,\r\n"
				+ "	TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI:SS') ENROLL_DATE\r\n"
				+ "FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = '"+ email +"' \r\n"
				+ "AND MEMBER_PW = '"+pw+"' \r\n"
				+ "AND MEMBER_DEL_FL = 'N'";
		
		
		
		try {
			// 3. pstmt 객체 생성 + 보완
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, email);
//			pstmt.setString(2, pw);
//			
//			rs = pstmt.executeQuery();
			
			// 3. SQL 요청 보내기
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
				
				int memberNo = rs.getInt("MEMBER_NO");
				String memberNickName = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEL");
				String memberAddress = rs.getString("MEMBER_ADDRESS");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				member = new Member();
				
				member.setMemberEmail(email);
				member.setMemberNo(memberNo);
				member.setMemberNickname(memberNickName);
				member.setMemberTel(memberTel);
				member.setMemberAddress(memberAddress);
				member.setEnrollDate(enrollDate);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}


	/** 회원 정보 업데이트
	 * @param conn
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(Connection conn, String nickname, String tel, int memberNo) {

		// 1. 결과 반환할 변수 선언
		int result = 0;
		
		// 2. SQL 구문 작성
//		String sql = "UPDATE MEMBER\r\n"
//				+ "SET MEMBER_NICKNAME = ?,\r\n"
//				+ "MEMBER_TEL = ?\r\n"
//				+ "WHERE MEMBER_NO = ?\r\n";
		
		String sql = "UPDATE MEMBER\r\n"
				+ "SET MEMBER_NICKNAME = '"+nickname+"',\r\n"
				+ "MEMBER_TEL = '"+tel+"'\r\n"
				+ "WHERE MEMBER_NO = "+memberNo+"";
		
		
		try {
			
//			// 3. pstmt 생성 및 보완
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, nickname);
//			pstmt.setString(2, tel);
//			pstmt.setInt(3, memberNo);
//			
//			
//			// 4. SQL 구문 실행
//			result = pstmt.executeUpdate();
			
			
			// 3. stmt 생성
			stmt = conn.createStatement();
			
			// 4. SQL 구문 실행
			result = stmt.executeUpdate(sql);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			// 5. JDBC 객체 반환
			close(pstmt);
		}
		
		return result;
	}


	/** 회원 탈퇴
	 * @param conn
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelFl(Connection conn, int memberNo, String pw) {

		int result = 0;
		
//		String sql = "UPDATE MEMBER\r\n"
//				+ "SET MEMBER_DEL_FL = 'Y'\r\n"
//				+ "WHERE MEMBER_PW = ?\r\n"
//				+ "AND MEMBER_NO = ?";
		
		String sql = "UPDATE MEMBER\r\n"
				+ "SET MEMBER_DEL_FL = 'Y'\r\n"
				+ "WHERE MEMBER_PW = '"+pw+"'\r\n"
				+ "AND MEMBER_NO = "+memberNo+"";
		
		
		try {
			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, pw);
//			pstmt.setInt(2, memberNo);
//			
//			result = pstmt.executeUpdate();
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
			close(stmt);
			
		}
		
		return result;
	}


	/** 회원 전체 조회
	 * @param conn 
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(Connection conn, int sort) {

		List<Member> memberList = new ArrayList<Member>();
		
		String sql = "SELECT * FROM MEMBER";
		if (sort == 1) sql += " ORDER BY MEMBER_NO DESC";
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int memberNo = rs.getInt("MEMBER_NO");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				String memberPw       = rs.getString("MEMBER_PW");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel 	  = rs.getString("MEMBER_TEL");
				String memberAddress  = rs.getString("MEMBER_ADDRESS");
				Date enrollDate 	= rs.getDate("ENROLL_DATE");
				String memberDelFl  = rs.getString("MEMBER_DEL_FL");

				Member member = new Member(memberNo, memberEmail, memberPw, memberNickname, memberTel, 
							memberAddress, enrollDate.toString(), memberDelFl);
			
				memberList.add(member);
				
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberList;
	}


}
