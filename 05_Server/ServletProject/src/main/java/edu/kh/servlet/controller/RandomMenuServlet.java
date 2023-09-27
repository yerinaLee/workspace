package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/randomMenu")
public class RandomMenuServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// POST 방식 요청 시 글자 깨짐 방지
		req.setCharacterEncoding("UTF-8");

		// 제출된 파라미터 중 name이 menu인 input 요소의 값을
		// 모두 얻어와 String[]로 반환
		String[] menus = req.getParameterValues("menu");

		// 0 부터 배열 길이 미만의 정수형 난수 생성
		int x = (int)(Math.random() * menus.length);


		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String str = 
			"<!DOCTYPE html>"
		+	"<html>"
		+	"<head>"
		+		"<title>랜덤 결과</title>"
		+	"</head>"
		+	"<body>"
		+		"<ul>";

		for(int i=0 ; i<menus.length ; i++) {

			if(i == x) { // 난수 번째 인덱스인 경우
				str += "<li style='color:red; font-size:30px;'>" 
					+ menus[i]
					+ "</li>";

			} else {
				str += "<li>"+menus[i]+"</li>";
			}
		}

		str +=	"</ul>"
			+"</body>"
			+"</html>";


		// 만들어진 HTML 문자열 출력
		out.print(str);

	}
}