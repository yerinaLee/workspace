package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCReview {

	public static void main(String[] args) {
		
		// 부서명을 입력 받아
		// 해당 부서에 근무하는 모든 사원의
		// 사번, 이름, 부서명, 직급명을 직급코드 오름차순으로 조회
		
		// 보통 SQL먼저 짜는게 better
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null; // DB연결정보를 저장한 객체
		Statement stmt = null; // DB에 SQL 수행 -> 결과 반환 받는 객체
		ResultSet rs = null; // SELECT 결과를 저장하는 객체(1행씩만 접근 가능)
		
		try {
			
			// 2. DriverManager를 이용해 Connection 객체 생성
			
			// 2-1) Oracle JDBC Driver 객체를 메모리에 로드(적재)하기 _ 메모리로드 : 객체생성해라! but new 구문으론 안댐
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) DB 연결 정보를 이용해서 Connection 객체 생성
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소
			String port = ":10000"; // DB 서버 컴퓨터 내에서 DB 프로그램 번호
			String dbName = ":ORCL"; // DB 이름
			
			String userName = "a230724_yrn"; // 사용자계정
			String pw = "921222"; // 비밀번호
			
			// DriverManager : Connection 만드는 객체
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			// 3. SQL 작성
			Scanner sc = new Scanner(System.in);
			
			System.out.print("부서명 입력 : ");
			String input = sc.next();
					
			// 입력 받은 문자열이 저장된 변수를 sql에 추가할 때
			// 양쪽에 홑따옴표('')를 반드시 작성해야한다!
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)\r\n"
					+ "WHERE DEPT_TITLE = '"+ input +"'\r\n"
					+ "ORDER BY JOB_CODE";

			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			// 연결된 DB와 대화(SQL 수행/결과 반환)를 하기 위한 객체 생성
			
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql); // 이번에 수행할건 DQL이기에 Query로~
			
			
			// 6.SQL(SELECT) 결과가 담겨있는 ResultSet(rs)를
			//	한 행씩 반복 접근하며 각 행의 컬럼 값을 얻어와 출력
			
			boolean flag = true; // true이면 조회 결과 없음, false면 있음
			
			
			while(rs.next()) {
				flag = false; // while문이 한 번이라도 수행되면 false로 변경
				
				// 현재 행의 EMP_ID 컬럼 값을 String 형태로 얻어와 저장
				String empId = rs.getString("EMP_ID");
				String empName = rs.getNString("EMP_NAME");
				String deptTitle = rs.getNString("DEPT_TITLE");
				String jobName = rs.getNString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s \n",
						empId, empName, deptTitle, jobName);
				
//				System.out.println(empId + " " + empName + " " + deptTitle + " " + jobName);
				
			}
			
			
			if(flag) { // while문 종료 후에 flag 값이 true == 조회 결과 없음
				System.out.println("일치하는 부서가 없습니다.");
			}
			
			
		} catch (Exception e) { // 예외 최상위 부모로 모든 예외 잡아서 처리(다형성)
			e.printStackTrace();
			
		} finally {
			// 7. JDBC 객체 자원 반환(역순)
			
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}