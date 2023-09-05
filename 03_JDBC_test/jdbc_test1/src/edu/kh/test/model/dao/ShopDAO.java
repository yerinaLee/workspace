package edu.kh.test.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.model.dto.ShopMember;

public class ShopDAO {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public ShopMember selectMember(Connection conn, String memberId) {
		
		
		ShopMember sm = null;

		try {
			
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String id = rs.getString("MEMBER_ID");
				String pw = rs.getString("MEMBER_PW");
				String phone = rs.getString("PHONE");
				String gender = rs.getString("GENDER");
				
				sm = new ShopMember(id, pw, phone, gender);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return sm;
	}
	
	
	
	
	
	
}



