package edu.kh.test.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.model.dao.ShopDAO;
import edu.kh.test.model.dto.ShopMember;

public class ShopService {

	private ShopDAO dao = new ShopDAO();

	public ShopMember selectMember(String memberId) {
		
		Connection conn = getConnection();
		
		ShopMember sm = dao.selectMember(conn, memberId);
		
		close(conn);
		
		return sm;
	}
	
	
	
}
