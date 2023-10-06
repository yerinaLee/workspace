package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet ("/signup")
public class SignupServlet extends HttpServlet{
	
	// get방식 요청 시 signup.jsp로 응답(회원 가입 화면 보여줌)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path ="/WEB-INF/views/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	// 회원 가입 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
							// form태그 제출 요청
		
		// POST 방식 요청 문자 인코딩 변경
		req.setCharacterEncoding("UTF-8");
		
		// 파라미터 모두 얻어와 Member 객체에 저장
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		Member member = new Member();

		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setGender(gender);
		
		
		// 회원 가입 서비스 호출 후 결과 반환 받기
		MemberService service = new MemberService();
		int result = service.signup(member);
		
		
		// 회원 가입 성공 여부 메시지 지정하기
		String message = null;
		
		if(result > 0) message = "회원 가입 성공!";
		else		   message = "가입 실패ㅠ";
		
		// req.setAttribute("message", message);
		// -> redirect시 req가 삭제되어 message를 사용 못함
		
		// -> request scope 보다 넓은 범위의 객체에 속성 추가하여
		//	  문제를 해결!
		
		HttpSession session = req.getSession();
		session.setAttribute("message", message);
		
		// 메인 페이지 재요청(redirect)
		// -> 다시 요청하기 때문에
		//	  HttpServletRequest / Response 객체가 새로 만들어짐!
		//	  (기존 req, resp 삭제) // 중요!!!!!!!!!!!
		resp.sendRedirect("/");
		
	}
	
	
	

}
