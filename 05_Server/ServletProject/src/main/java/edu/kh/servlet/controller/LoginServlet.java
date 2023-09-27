package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login") // 현재 클래스를 Servlet으로 등록 + /login 매핑
public class LoginServlet extends HttpServlet{

	// POST 방식 요청은 doPost()로 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* POST 방식으로 전달된 데이터 중
		 * 영어, 숫자, 기본 특수문자가 아니면
		 * 톰캣 버전에 따라 깨지는 문제가 발생할 수 있다!
		 * 
		 * -> 요청 데이터의 문자 인코딩을 변경하여 문제 해결
		 *  */
		req.setCharacterEncoding("UTF-8");


		// 전달 받은 파라미터를 모두 얻어와 변수에 저장
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");

		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);


		// 아이디 : user01
		// 비밀번호 : pass01!
		// 이름 : 김개똥

		// 모두 일치하며 "로그인 성공"

		// 하나라도 일치하지 않으면 
		// "아이디 또는 비밀번호 또는 이름이 일치하지 않습니다"

		String result = null; // 성공/실패 문자열 저장

		if(id.equals("user01") && pw.equals("pass01!") && name.equals("김개똥")) {
			result = "로그인 성공";
		}
		else {
			result = "아이디 또는 비밀번호 또는 이름이 일치하지 않습니다";
		}


		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");

		out.print("<head> <title> 로그인 결과 </title> </head>");

		out.print("<body> <h2> "+result+" </h2> </body>");

		out.print("</html>");

	}
}