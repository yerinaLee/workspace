package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizza/order")
public class PizzaOrderServlet extends HttpServlet{
	
	// a태그 요청 == GET방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* 별도 처리 없이 바로 JSP로 요청 위임 */
		
		// RequestDispatcher : 요청 발송자
		// -> 지정된 JSP로
		// Servlet이 받은 요청 정보(req), 응답 정보(resp)를
		// 전달(발송)하는 역할
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("JSP경로");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizza_order.jsp");
		
		/* ******** */
		/* forward */
		/* ******** */
		
		/* 뜻 : 전송하다, 전달하다, 보내다, 발송하다
		 * 
		 * JSP로 요청, 응답을 보내는 기능
		 * 
		 * 특징
		 * - 브라우저 주소창은 요청 주소(/pizza/order)로 변함
		 * 	-> Servlet을 요청
		 * 
		 * - 브라우저 화면은 요청 위임된 JSP로 변함
		 * 
		 * - 실제 페이지 이동은 1회 진행
		 * 
		 * 클라이언트 요청 -> [Servlet이 요청 처리 + JSP가 응답 화면만 만듦]
		 *  
		 * */
		
		dispatcher.forward(req, resp);
	}
	
	//---------------------------------------------------------------------------

	
	// form태그 POST 방식 제출 시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		String pizza = req.getParameter("pizza"); // 치즈 피자-8000
		String size = req.getParameter("size"); // R || L
		
		int amount = Integer.parseInt( req.getParameter("amount") ); // 1, 2(개)...
		
		
		/* 피자 이름, 가격 나누기 */
		String[] arr = pizza.split("-"); // "-" 구분자로 쪼개서 String[] 반환
		// arr == {"치즈 피자", "8000"}
		
		String pizzaName = arr[0]; // "치즈 피자"
		int price = Integer.parseInt(arr[1]); // 8000
		
		
		/* L사이즈인 경우 4000원 추가 */
		if(size.equals("L")) price += 4000;
		
		
		/* 수량만큼 price에 곱하기 */
		price *= amount;
		// price = price * amount;
		
		
		/* JSP로 요청 위임(forward) */
		
		// JSP 경로는 webapp 폴더를 기준으로 작성!
		// "/" == webapp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizza_result.jsp");
		
		// JSP로 전달하는 req에는 파라미터가 담겨있다!
		// -> 그런데 pizzaName, price는 없다! (Servlet에서 만든 변수)
		
		// [해결방법]
		// req에 속성(Attribute)로 추가하면
		// JSP에서 꺼내 쓸 수 있다!
		// (속성 == 필드(변수))
		
//		req.setAttribute(key, value) : 속성 추가
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		dispatcher.forward(req, resp);
	}
	
	
	
}













