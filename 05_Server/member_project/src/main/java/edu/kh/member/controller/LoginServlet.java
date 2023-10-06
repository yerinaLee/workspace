package edu.kh.member.controller;

import java.io.IOException;
import java.sql.Connection;

import edu.kh.member.common.JDBCTemplate;
import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 요청 시 문자 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 제출된 파라미터(id, pw) 얻어오기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		// JDBC 세팅 확인(확인 완료 후 삭제)
//		Connection conn = JDBCTemplate.getConnection();
//		System.out.println(conn);
//		JDBCTemplate.close(conn);
		
		// 로그인 서비스 호출 후 결과 반환 받기
		// (로그인 == 회원 정보를 DB에서 읽어와 session에 기록)
		MemberService service = new MemberService();
		
		Member loginMember = service.login(id, pw);
		
		// 로그인 성공 시
		HttpSession session = req.getSession(); // session 얻어오기
				
		if (loginMember != null) {
			// session을 얻어와서 속성 추가
			session.setAttribute("loginMember", loginMember);
		}
		
		// *****************************
		// forward : 요청 위임
		// - 요청 처리 결과를 이용해서 응답화면을
		//   JSP에게 만들어달라고 넘겨주는 것
		
		// ex) 검색 -> 검색 결과 페이지
		//	   뉴스 제목 -> 뉴스 상세페이지
		//	   게시글 제목 -> 게시글 상세 페이지
		
		// *****************************
		// redirect : 재요청, 다른 servlet 요청
		
		// 요청 처리 후 별도의 응답화면을 보여주지 않고
		// 다른 페이지 주소로 다시 요청해서
		// 다른 페이지 화면을 보여줌
		
		// ex) 로그인 요청 -> 메인페이지(/) 재요청
		//   			   -> 클라이언트에게 메인 페이지 보임
		
//		resp.sendRedirect("요청 주소");
//		(요청 주소 == 브라우저 주소창에 치는 주소)
		
		resp.sendRedirect("/");
		
		
		
	}

}
