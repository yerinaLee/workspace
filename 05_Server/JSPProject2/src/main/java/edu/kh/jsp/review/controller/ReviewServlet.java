package edu.kh.jsp.review.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// 톰캣(WAS)에서 제공하는 클래스
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet : Servlet으로 등록
// + 클라이언트의 요청 주소를 처리할 클래스를 매핑
@WebServlet("/review")
public class ReviewServlet extends HttpServlet{
	
	// doGet(req, resp) : GET 방식 요청 처리 메서드
	
	// HttpServletRequest : 클라이언트의 요청 정보(파라미터, ip)
	// HttpServletResponse : 서버 -> 클라이언트 응답하는 방법을 제공
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String req.getParameter("name속성값") : 파라미터 얻어오기
//		String[] req.getParameterValues("name속성값") : 파라미터 모두 얻어오기 
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge"); // input 타입에서 number여도 얻어올땐 무조건 String
		String gender = req.getParameter("gender");
		
		String[] hobbyArr = req.getParameterValues("hobby");
		// -> 체크된 값이 없으면 null
		
		// hobbyArr에 값이 있을때, 없을 때에 따라 알맞은 문자열 생성
		// - 있을 때 : 취미는 게임, 유투브 입니다.
		// - 없을 때 : 선택된 취미가 없습니다
		
		String str = null;
		
		if(hobbyArr == null) {
			str = "선택된 취미가 없습니다";
		} else {
			str = String.format("취미는 %s 입니다.", String.join(", ", hobbyArr));
		}

		
		// -------------------------------------------------------------------------------------
		
		/* JSP로 요청 위임(JSP한테 응답 화면좀 대신 만들어줘) */
		
		// JSP 파일 경로 작성(webapp 폴더 기준)
		String path = "/WEB-INF/views/review_result.jsp";
		
		// 요청 발송자(RequestDispatcher) 얻어오기
//		RequestDispatcher dispatcher = req.getRequestDispatcher("JSP 파일 경로");
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// Servlet에서 생성한 변수(str)를
		// 요청 위임된 JSP에서 사용할 수 있도록
		// HttpServletRequest에 속성(필드)로 추가
						// K ,   V
		req.setAttribute("str", str);
		
		// 요청 위임(forward) 수행
		dispatcher.forward(req, resp);
		
	}

}









