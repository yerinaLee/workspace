package edu.kh.game.model.dao;

import static edu.kh.game.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.kh.game.model.dto.Gamer;

public class GameDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/** 회원가입
	 * @param conn
	 * @param gamer
	 * @return
	 */
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
				
				gamer = new Gamer(); 
				
				gamer.setGamerNo( rs.getInt("GAMER_NO") );
				gamer.setGamerNickname(nickName);
				gamer.setGamerPw(pass);
				gamer.setEnrollDate( rs.getString("ENROLL_DATE") );
				gamer.setTryCount( rs.getInt("TRY_COUNT")  );
				gamer.setGamerRecords( rs.getInt("GAMER_RECORDS") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return gamer;
	}


	/** 게임 기록 갱신 서비스
	 * @param conn
	 * @param gamerNo
	 * @param count
	 * @return
	 */
	public int gamePlay(Connection conn, int gamerNo, int count) {

		int result = 0;
		
		String sql ="UPDATE GAMER\r\n"
				+ "SET GAMER_RECORDS = ?\r\n"
				+ "WHERE GAMER_NO = ?\r\n";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, gamerNo);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 게임횟수 추가
	 * @param conn
	 * @param gamerNo
	 * @return
	 */
	public int gamePlayTry(Connection conn, int gamerNo) {
		
		int result = 0;
		
		String sql ="UPDATE GAMER\r\n"
				+ "SET TRY_COUNT = TRY_COUNT +1\r\n"
				+ "WHERE GAMER_NO = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gamerNo);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 게임 전체 랭킹
	 * @param conn
	 * @return
	 */
	public List<Gamer> ranking(Connection conn) {
		
		List<Gamer> gamerList = new ArrayList<Gamer>();
		
		String sql ="SELECT RANK() OVER(ORDER BY GAMER_RECORDS) \"RANKING\", GAMER_NICKNAME, GAMER_RECORDS \r\n"
				+ "FROM GAMER\r\n"
				+ "WHERE GAMER_RECORDS != 1000000";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int rank = rs.getInt("RANKING");
				String gamerNickname = rs.getString("GAMER_NICKNAME");
				int gamerRecords = rs.getInt("GAMER_RECORDS");
				
				Gamer gamer = new Gamer(gamerNickname, gamerRecords, rank);
				
				gamerList.add(gamer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return gamerList;
	}

}
