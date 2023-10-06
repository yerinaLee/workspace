package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/memberList")
public class MemberListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원 목록 조회 서비스 호출
		MemberService service = new MemberService();
		List<Member> memberList = service.selectMemberList();
		
		// request scope에 회원 목록(memberList)를 속성으로 추가
		req.setAttribute("memberList", memberList);
		
		// 결과 화면을 JSP에게 만들도록 요청 위임(forward)
		String path = "/WEB-INF/views/memberList.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
}
