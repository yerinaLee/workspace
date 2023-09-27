package edu.kh.servlet.controller;

	import java.io.IOException;
	import java.io.PrintWriter;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	// 1) HttpServlet 상속 받기
	// 2) doGet() 또는 doPost() 오버라이딩
	// 3) 제출된 데이터(파라미터) 꺼내기
	// 4) 필요한 로직 처리
	// 5) 응답 형태 지정(setContentType)
	// 6) 응답용 스트림 얻어오기
	// 7) html 코드 출력하기

	// 어노테이션(Annotation) : 컴파일러가 읽는 주석(설명)

	// @WebServlet("/연결할 요청 주소") 어노테이션
	// - 해당 클래스를 Servlet으로 등록하고
	//   () 내부에 작성된 주소 요청 시 해당 클래스와 연결

	//  --> web.xml의 <servlet>, <servlet-mapping> 자동 생성 역할

	@WebServlet("/example2")
	public class ExampleServlet2 extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			// String req.getParameter("name속성")
			//	- 제출된 input 값 중 name이 일치하는 input의 value 얻어오기
			//    (같은 name이 여러 개인 경우 첫 번째만 얻어옴)

			// String[] req.getParameterValues("name속성")
			// 	- name이 일치하는 모든 input의 value값을 
			//    하나의 String[] 배열로 반환

			String orderer = req.getParameter("orderer");
			String coffee = req.getParameter("coffee");
			String type = req.getParameter("type");
			String[] opt = req.getParameterValues("opt");

			System.out.println("디버그 모드로 파라미터 확인");


			// 커피 종류 따라서 가격 설정
			int price = 0;
			switch(coffee) {
			case "아메리카노": 	price = 1000; break;
			case "에스프레소": 	price = 1000; break;
			case "카푸치노": 	price = 2000; break;
			case "민초라떼": 	price = 3000; break;
			case "돌체콜드브루": price = 4000; break;
			}

			// type이 ICE이면 500원 추가
			if(type.equals("ICE")) 	price += 500;



			// 5) 응답 형태 지정(setContentType)
			resp.setContentType("text/html; charset=UTF-8");

			// 6) 응답용 스트림 얻어오기
			PrintWriter out = resp.getWriter();


			// 7) html 코드 출력하기
			out.print("<!DOCTYPE html>"
					+ "<html lang=\"en\">"
					+ "<head>"
					+ "  <title>"+orderer+"님 주문 결과</title>"
					+ "</head>"
					+ "<body>"
					+ "  <h3>주문자명 : "+orderer+"</h3>"
					+ "  <h3>커피 : "+type+" "+coffee+"</h3>");


			// 옵션이 선택되어 있는지 확인
			if(opt != null) { // 체크 하나도 안되어있으면 null
				out.print("<h3>선택한 옵션 : ");

				for(String o : opt) {
					switch(o) {
					case "mild" : out.print(" 연하게"); break;
					case "addIce" : out.print(" 얼음 추가"); break;
					}
				}

				out.print("</h3>");
			}


			out.print("  <h3>결제 금액 : "+price+" 원</h3>"
					+ "</body>"
					+ "</html>");

		}

}


