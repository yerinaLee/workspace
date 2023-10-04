package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Scope 관련 내장 객체
		
		// 1. page -> JSP에서 확인

		// --------------------------------------------------------------------
		
		// 2. request : 요청/위임 받은 페이지에서 유지
		// (위임되는 동안 계속 유지, 최소 2페이지)
		req.setAttribute("requestMessage", "request scope 입니다. I'm alive!");
		
		// --------------------------------------------------------------------
		
		// 3. session : 클라이언트 브라우저당 1개
		//				브라우저 종료 또는 session 만료시까지 유지
		//				(브라우저 종료 전까지 어디서든 사용 가능)
		
		// 3-1) session 범위 객체 얻어오기
		HttpSession session = req.getSession();
		
		// 3-2) session에 값 세팅(속성 추가)
		session.setAttribute("sessionMessage", "session scope입니다 하핳");
		
		
		// --------------------------------------------------------------------
		
		// 4. application : 서버에 1개만 존재
		//					서버 종료 시 까지 유지
		//					(서버 종료 전까지 어디서든 사용 가능)
		
		// 4-1) application scope 객체 얻어오기 // static 같은 개념, 메인화면에서 날짜별로 달라지는 것들 적용
		ServletContext application = req.getServletContext();
		
		application.setAttribute("applicationMessage", "application scope입니다");
		

		// --------------------------------------------------------------------
		
		// 5. 우선 순위 확인
		
		// -> 모든 범위에 같은 key 값으로 속성 세팅
		req.setAttribute("str", "request scope에 세팅된 문자열");

		session.setAttribute("str", "session scope에 세팅된 문자열");
		
		application.setAttribute("str", "application scope에 세팅된 문자열");
		
		
		// --------------------------------------------------------------------
		
		String path = "/WEB-INF/views/scope.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
}
