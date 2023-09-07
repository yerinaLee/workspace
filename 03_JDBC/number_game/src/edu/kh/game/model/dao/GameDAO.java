package edu.kh.game.model.dao;

import static edu.kh.game.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kh.game.model.dto.Gamer;

public class GameDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertGamer(Connection conn, Gamer gamer) {

		int result = 0;
		
		String sql = "INSERT INTO GAMER\r\n"
				+ "VALUES (SEQ_GAMER_NO.NEXTVAL, ? , ? ,\r\n"
				+ "DEFAULT, DEFAULT, DEFAULT)\r\n"; // 게임참여횟수, 최고기록은 게임 후 회원가입하게되면 수정하기~
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gamer.getGamerNickname());
			pstmt.setString(2, gamer.getGamerPw());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}
	

	/** 회원가입 서비스(게임참여 후)
	 * @param conn
	 * @param gamer
	 * @return
	 */
	public int insertGamerRecords(Connection conn, Gamer gamer) {

		int result = 0;
		
		String sql = "INSERT INTO GAMER\r\n"
				+ "VALUES (SEQ_GAMER_NO.NEXTVAL, ? , ? ,\r\n"
				+ "DEFAULT, ?, ?)\r\n";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gamer.getGamerNickname());
			pstmt.setString(2, gamer.getGamerPw());
			pstmt.setInt(3, 1); // 게임 참여 횟수 기록
			pstmt.setInt(4, gamer.getGamerRecords()); // 게임 첫 기록
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}


	/** 로그인 서비스
	 * @param conn
	 * @param nickName
	 * @param pass
	 * @return
	 */
	public Gamer login(Connection conn, String nickName, String pass) {
		
		Gamer gamer = null;
		
		String sql = "SELECT GAMER.GAMER_NO, GAMER_NICKNAME , \r\n"
				+ "TO_CHAR(ENROLL_DATE, 'YYYYMMDD') ENROLL_DATE,\r\n"
				+ "TRY_COUNT , GAMER_RECORDS \r\n"
				+ "FROM GAMER\r\n"
				+ "WHERE GAMER_NICKNAME = ?\r\n"
				+ "AND GAMER_PW = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickName);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gamer.setGamerNo( rs.getInt("GAMER_NO") );
				gamer.setGamerNickname( rs.getString("GAMER_NICKNAME" ));
				gamer.setGamerPw( rs.getString("GAMER_PW" ));
				gamer.setEnrollDate( rs.getString("ENROLL_DATE") );
				gamer.setTryCount( rs.getInt("TRY_COUNT")  );
				gamer.setGamerRecords( rs.getInt("GAMER_RECORDS") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return gamer;
	}

}
