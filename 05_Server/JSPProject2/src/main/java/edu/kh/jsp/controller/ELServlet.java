package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el")
public class ELServlet extends HttpServlet{
	
	// a태그 요청은 GET방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/el.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
	
	
	// form태그 POST 방식 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 문자 인코딩 처리(tomcat 9이하 버전 호환용)
		req.setCharacterEncoding("UTF-8");
		
		// 새로운 값을 HttpServletRequest에 속성으로 추가
		// -> req.setAttribute("K", V);
		
		// 기본 자료형, String 추가 가능 
		req.setAttribute("address", "서울시 중구 남대문로");
		req.setAttribute("score", 90);
		
		// 컬렉션(List, Set, Map) 가능
		List<String> strList = new ArrayList<String>();
		
		strList.add("과일");
		strList.add("나비");
		strList.add("다리미");
		strList.add("라디오");
		
		req.setAttribute("strList", strList);
		
		
		// DTO 또는 모든 객체 가능
		Book b1 = new Book("도시와 그 불확실한 벽", "무라카미 하루키", 19500);
		req.setAttribute("b1", b1);
		
		
		// --------------------------------------------------------------------
		
		// null, 빈칸, 비어있음 확인
		
		String test1 = null; // null

		String test2 = ""; // 빈칸
		
		List<String> test3 = null; // null
		
		List<String> test4 = new ArrayList<String>(); // 비어있음

		List<String> test5 = new ArrayList<String>(); // 비어있지 않음
		test5.add("카카카");
		test5.add("롸~~~롸라라라롸~");
		
		req.setAttribute("test1", test1);
		req.setAttribute("test2", test2);
		req.setAttribute("test3", test3);
		req.setAttribute("test4", test4);
		req.setAttribute("test5", test5);
		
		// --------------------------------------------------------------------
		
		// 요청 위임(forward) 구문 작성
		
		String path = "/WEB-INF/views/el_result.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
	
	
	
}



