package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {
	
	public static void main(String[] args) {
		
		// job코드를 적으면 같은 직급명 사원들이 나오게끔!
		// 사번, 사원명, 직급명, 부서명, 급여
		// 입사일빠른순, 급여 많은 순으로 정렬
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소
			String port = ":10000"; // DB 서버 컴퓨터 내에서 DB 프로그램 번호
			String dbName = ":ORCL"; // DB 이름
			
			String userName = "a230724_yrn"; // 사용자계정
			String pw = "921222"; // 비밀번호
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("JOB코드 입력(J1~J7) : ");
			String input = sc.next();
			
			if (input.equals("J1") || input.equals("J2") || input.equals("J3") || input.equals("J4") ||
					input.equals("J5") || input.equals("J6") || input.equals("J7")) {
				
				String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY\r\n"
						+ "FROM EMPLOYEE\r\n"
						+ "JOIN JOB USING (JOB_CODE)\r\n"
						+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
						+ "WHERE JOB_CODE = '"+input+"'\r\n"
						+ "ORDER BY SALARY DESC";
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					
					String empId = rs.getString("EMP_ID");
					String empName = rs.getString("EMP_NAME");
					String jobName = rs.getString("JOB_NAME");
					String deptTitle = rs.getString("DEPT_TITLE");
					int salary = rs.getInt("SALARY");
					
					System.out.printf("%s / %s / %s / %s / %d \n", 
							empId, empName, deptTitle, jobName, salary);
				}
				
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if ( rs != null ) rs.close();
				if ( stmt != null ) stmt.close();
				if ( conn != null ) conn.close();
			} catch(Exception e) {
				
			}
		}
		
	}

}
