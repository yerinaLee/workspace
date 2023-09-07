package edu.kh.game.service;
import static edu.kh.game.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.game.model.dao.GameDAO;
import edu.kh.game.model.dto.Gamer;


public class GameService {
	
	
	private GameDAO dao = new GameDAO(); 
	
	/** 회원가입 서비스
	 * @param nickName
	 * @param pw
	 * @return
	 */
	public int insertGamer(Gamer gamer) {
		
		Connection conn = getConnection();
		
		int result = dao.insertGamer(conn, gamer);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원가입 서비스(게임참여 후)
	 * @param gamer
	 * @return
	 */
	public int insertGamerRecords(Gamer gamer) {

		Connection conn = getConnection();
		
		int result = dao.insertGamerRecords(conn, gamer);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 로그인 서비스
	 * @param nickName
	 * @param pass
	 * @return
	 */
	public Gamer login(String nickName, String pass) {

		Connection conn = getConnection();
		
		Gamer gamer = dao.login(conn, nickName, pass);
		
		close(conn);
		
		return gamer;
	}

	
	

}
