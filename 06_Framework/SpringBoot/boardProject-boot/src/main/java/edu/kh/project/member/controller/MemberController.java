package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 찍어보기
@Controller  // 요청/응답 처리 + Bean 생성
@RequestMapping("/member") // 공통주소 (/member로 시작하는 주소)
@SessionAttributes({"loginMember"}) // Model 중 key값이 "loginMember"를 Session으로 올리기
public class MemberController {
	
	//MemberService 의존성 주입
	@Autowired
	private MemberService service;
	
	
	/** 로그인
	 * @param inputMember : 아이디, 비밀번호 파라미터
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return 메인페이지(/) 리다이렉트
	 */
	@PostMapping("login") // /member/login (POST)
	public String login(Member inputMember, Model model, RedirectAttributes ra) {

		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// 로그인 성공시
		if(loginMember != null) {
			// 쿠키 생성 코드 작성 예정
		}
		
		// 로그인 실패시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		// 로그인 결과를 session scope에 추가
		model.addAttribute("loginMember", loginMember);
			
		// 메인페이지 리다이렉트
		return "redirect:/";
	}
	

}
