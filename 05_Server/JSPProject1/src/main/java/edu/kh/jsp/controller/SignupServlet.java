package edu.kh.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/signup")
// - 현재 클래스를 Servlet으로 등록
// - /signup 요청이 올 경우 현재 클래스에서 처리
//	(실제로는 Servlet Container가 생성한 객체가 처리)

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 요청 시
		// 요청 데이터 깨짐 방지 코드 작성
		req.setCharacterEncoding("UTF-8");
		
		// 제출된 데이터(전달 받은 데이터) == 파라미터(Parameter) / 기본적으로 String자료형
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw"); 
		String pwCheck = req.getParameter("inputPwCheck"); 
		String name = req.getParameter("inputName"); 
		
		int age = Integer.parseInt( req.getParameter("inputAge") );
		
		
		// ---------------------------------------------------------------
		// 응답 화면을 Servlet이 아닌
		// JSP 한테 대신 만들어서
		// 클라이언트한테 응답하라고 하기!
		
		/* 요청 위임 */
		// 요청 처리 내용을 다른 곳으로 넘기는 것
		
		// RequestDispatcher :
		// 	- JSP로 요청/응답 객체를 전달하는 역할의 객체
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signup_result.jsp");
		
		dispatcher.forward(req, resp);
		
		// ---------------------------------------------------------------

		
//		resp.setContentType("text/html; charset=UTF-8"); // 출력 타입 설정
//		PrintWriter out = resp.getWriter(); // 출력 스트림 생성
//		
//		out.print(
//				"<!DOCTYPE html>"
//				+ "<html>"
//				+ "<head> <title>회원 가입 결과</title> </head>"
//				+ "<body>"	
//				);
//		
//		// 비밀번호가 일치하지 않을 경우
//		if(!pw.equals(pwCheck)){
//			out.print("<h3> 비밀번호가 일치하지 않습니다 </h3>");
//		} 
//		
//		// 나이가 14세 미만인 경우
//		else if (age < 14) {
//			out.print("<h3> 14세 이상만 가입 가능합니다 </h3>");
//		} 
//		
//		else {
//			out.print("<h3> 가입 성공 </h3>");
//			
//			out.printf("%s / %s / %s / %d", id, pw, name, age);
//		}
//		
//		out.print("</body></html>");
		
	}

}








