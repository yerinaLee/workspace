package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dto.Member;

// DAO(Data(DateBase) Access Object) : 데이터베이스 접근 객체
// - JDBC를 이용해서 DB에 SQL을 전달하여 수행 후 결과를 반환 받는 역할
public class MemberDAO {
	
	// 필드
	
	// JDBC 객체 참조 변수 선언(Connection은 Service에서 생성 -> 제외)
	private Statement stmt = null;
	private ResultSet rs = null;
	
	// PreparedStatement(준비된 Statement)
	// - 외부 변수 값을 SQL에 받아들일(삽입할) 준비가 되어있는 Statement
	// -> 성능, 속도, 면에서 Statement보다 우위
	// - ? (placeholder) : 변수를 위치시킬 자리 지정 (위치고정자)
	private PreparedStatement pstmt = null;
	
	
	/** 회원 가입
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		
		// 1. JDBC 객체 참조 변수 선언 -> 필드에 작성 완료
        // 2. DriverManager를 이용해 Connection 객체 생성
        //      -> Service에서 만들어서 전달 받음
	
		// -------------------------------------------------
		
		// DAO 작성법
		// 1. 최종 결과를 저장할 변수 선언 또는 객체 생성
		int result = 0;
		
		// 2. SQL 작성
		
		// 1) Statement를 이용해서 수행할 SQL의 작성법 --> 작성이 어려움
		//		--> Statement의 자식인 PreparedStatement 사용
//		String sql = 
//				"INSERT INTO MEMBER\r\n"
//				+ "VALUES (SEQ_MEMBER_NO.NEXTVAL,\r\n"
//				+ "	'"+member.getMemberEmail()+"',\r\n"
//				+ "	'"+member.getMemberPw()+"',\r\n"
//				+ "	'"+member.getMemberNickname()+"',\r\n"
//				+ "	'"+member.getMemberTel()+"',\r\n"
//				+ "	'"+member.getMemberAddress()+"',\r\n"
//				+ "	DEFAULT, DEFAULT)";
		
		// 2) PreparedStatement용 SQL 작성
		String sql
			= "INSERT INTO MEMBER "
			+ "VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT)";  // ? : 빈칸
		
		try {
			// 3. PreparedStatement 객체 생성
			// (Statement와 다르게 생성 시 sql을 매개 변수로 사용함)
			// -> SQL을 생성할 때 전달하여 ?에 값 대입을 준비함 
			pstmt = conn.prepareStatement(sql);
			
			
			// 4. ?(placeholder)에 알맞은 값 대입
			// **** 작성법 : pstmt.set자료형(순서, 값); ***
			
			// ** pstmt.setString()으로 문자열을 SQL에 대입하면
			//	 자동으로 양쪽에 ' '(홑따옴표)를 추가해준다!! (굉장히 편함)
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			
			// 5. SQL 수행(INSERT) 후 결과 반환(결과 행의 수) 받기
			result = pstmt.executeUpdate();
			// 매개변수에 SQL추가 X
			// 왜? 이미 pstmt 생성할 때 추가했기 때문에

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 사용한 JDBC 객체 자원 반환
			// (PreparedStatement는 Statement의 자식이다!)
			close(pstmt);
		}
		
		return result;
	}


	/** 회원 정보 수정
	 * @param conn
	 * @param member
	 * @return
	 */
	public int updateMember(Connection conn, Member member) {
		
		// 1. 최종 결과를 저장할 변수 선언 또는 객체 생성
		int result = 0; // DML 수행하면 행의 개수(int형 반환)
		
		// 이메일, 비밀번호가 일치하는 회원의
		// 닉네임, 전화번호, 주소를 수정
		// (아이디 중복 없다고 가정)
		
		// 2. SQL 작성
		String sql = "UPDATE MEMBER  "
				+ "SET MEMBER_NICKNAME = ?,  "
				+ "MEMBER_TEL = ?,  "
				+ "MEMBER_ADDRESS = ?  "
				+ "WHERE MEMBER_EMAIL = ?  "
				+ "AND MEMBER_PW = ?";
		
		try {
			// 3. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// -> 세팅된 sql의 ? 자리에 값 대입 준비
			
			// 4. ?(placeholder)에 알맞은 값 대입
			// **** 작성법 : pstmt.set자료형(순서, 값); ***
			
			pstmt.setString(1, member.getMemberNickname());
			pstmt.setString(2, member.getMemberTel());
			pstmt.setString(3, member.getMemberAddress());
			pstmt.setString(4, member.getMemberEmail());
			pstmt.setString(5, member.getMemberPw());

			
			// 5. SQL 수행(INSERT) 후 결과 반환(결과 행의 수) 받기
			// -> DML 수행 결과는 결과 행의 갯수(int)
			result = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. 사용한 JDBC 객체 자원 반환
			try {
				close(pstmt);
				
				// conn은 Service에서 close 처리하세요!!!
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 7. SQP 수행 결과 반환
		return result;
	}


	/** 회원 탈퇴
	 * @param conn
	 * @param member
	 * @return
	 */
	public int deleteMember(Connection conn, Member member) {
		
		// 1. 최종 결과 저장 변수 선언
		int result = 0;
		
		// 2. SQL 작성
		// ? == placeholder : PreparedStatement에서 사용할 빈칸(값 대입 예정)
		String sql = "DELETE FROM MEMBER\r\n"
				+ "WHERE MEMBER_EMAIL = ? \r\n"
				+ "AND MEMBER_PW = ? ";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			// sql을 미리 세팅해서 값 대입할 준비하기
			
			// 4. ?에 알맞은 값 세팅하기
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			
			// 5. SQL(DELETE) 수행 결과 반환(성공한 행의 갯수) 받기
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			// 6. JDBC 객체 자원 반환
			close(pstmt);
			
		}
		return result;
	}


	/** 비밀번호 변경
	 * @param conn 
	 * @param email
	 * @param pw
	 * @param newpw
	 * @return
	 */
	public int updatePw(Connection conn, String email, String pw, String newPw) {

		// 1. 최종 결과 저장 변수
		int result = 0;
		
		// 2. SQL 작성
		String sql = "UPDATE MEMBER\r\n"
				+ "SET MEMBER_PW = ?\r\n"
				+ "WHERE MEMBER_EMAIL = ?\r\n"
				+ "AND MEMBER_PW = ?";
		
		try {
			// 3. sql을 미리 세팅해서 값 대입할 준비하기
			pstmt = conn.prepareStatement(sql);
			
			// 4. ? 자리에 맞는 값 세팅하기
			pstmt.setString(1, newPw);
			pstmt.setString(2, email);
			pstmt.setString(3, pw);
			
			// 5. SQL(DELETE) 수행 결과 반환(성공한 행의 갯수) 받기
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 6. pstmt 반환
			close(pstmt);
		}
		return result;
	}
}
