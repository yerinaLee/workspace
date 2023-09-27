package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExampleServlet1 extends HttpServlet{

	// 1) jakarta.servlet.http.HttpServlet 상속 받기

	// 2) 요청을 처리할 method 타입에 따라서
	//	doGet() 또는 doPost() 메서드를 오버라이딩
	//  --> 자동 완성 시 내부 코드 모두 삭제

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpServletRequest
		// - 클라이언트 요청 시 자동 생성되는 객체
		// - 요청 시 전달된 데이터(파라미터)
		//	  + 요청한 클라이언트의 데이터(ip 등)

		// HttpServletResponse
		// - 클라이언트 요청 시 서버에서 생성되는 객체
		// - 서버 -> 클라이언트 응답 방법을 제공하는 객체


		/* 제출된 이름, 나이 얻어와 출력하기 */

		// String req.getParameter("input의 name 속성값");
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");

		System.out.println("inputName : " + name);
		System.out.println("inputAge : " + age);


		// (위쪽) 요청 처리
		// -------------------------------------------
		// (아랫쪽) 응답 처리

		// ** HttpServletResponse 이용해서
		//    HTML 문서를 만들어서 응답! **

		// 1) 응답하는 문서의 형식과 문자 인코딩 지정하기
		resp.setContentType("text/html; charset=UTF-8");
		// -> 글로 작성된 HTML 문서, 문자 인코딩 형식은 UTF-8로 지정

		// 2) 서버 -> 클라이언트로 HTML을 전달하기 위한
		//   출력 스트림 얻어오기
		PrintWriter out = resp.getWriter();

		// 3) 출력 스트림을 이용해서 HTML 코드를 출력

		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("<title>서버 응답 결과 페이지</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h1>");

		out.println(name + "님의 나이는 " + age + "세 입니다.");

		out.println("</h1>");
		out.println("</body>");

		out.println("</html>");
	}

}