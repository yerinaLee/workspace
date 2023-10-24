package edu.kh.project.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.controller.MemberController;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
@SessionAttributes({"searchMember"})
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	/** 관리자 메인 페이지
	 * @return
	 */
	@GetMapping("main")
	public String adminMain() {
		// forward : 요청 위임
		// Thymeleaf
		// - prefix : classpath:/templates/
		// - suffix : .html
		return "admin/admin-main";
	}
	
	
	/** 이메일이 일치하는 회원 정보 조회
	 * @param inputEmail
	 * @param model
	 * @return searchMember
	 */
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		// 회원찾기 서비스 호출
		Member searchMember = service.selectMember(inputEmail);
		
		String path = null;

		// 이메일이 일치하는 회원이 존재하는 경우
		// model.addAttribute("key", value);
		// model.addAttribute("searchMember", value);
		// return "admin/success"; // forward
		if(searchMember != null) {
			path = "admin/success";
			model.addAttribute("searchMember", searchMember);

		// 이메일이 일치하는 회원이 존재하지않는 경우
		// return "admin/fail"; // forward
		} else {
			path = "admin/fail";
		}
		
		return path;
	}
	
	
	/** 회원 전체 조회
	 * @param model : 데이터 전달(request scope)
	 * @return
	 */
	@GetMapping("selectAll")
	public String selectAll(Model model) {
		
		// Collection : Java 자료구조 모음(List, Set, Map)
		List<Member> memberList = service.selectAll();
		
		// 조회 결과를 request scope로 전달
		model.addAttribute("memberList", memberList);
		
		return "admin/selectAll";
	}
	
	
	
	/** 전체 회원 조회(+정렬)
	 * @param model : 데이터 전달 객체
	 * @return
	 */
	@GetMapping("selectSort")
	public String selectSort(Model model,
			@RequestParam(value="sort", required = false, defaultValue = "1") int sort) {

		List<Member> memberList = service.selectSort(sort);
		
		model.addAttribute("memberList", memberList);
		
		return "admin/selectSort";
	}
	
	
	/** 회원 복구
	 * @param memberNo : 회원 번호
	 * @param memberEmail : 회원 이메일
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("restoration")
	public String restoration(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.restoration(memberNo);
		
		// 탈퇴 복구 완료
		if(result > 0) {
			ra.addFlashAttribute("message", "탈퇴 복구 완료");
			
		} else {
			ra.addFlashAttribute("message", "탈퇴 복구 실패");
		}
		
		//http://localhost/admin/selectMember?inputEmail=1
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	
	/** 관리자 권한 변경
	 * @param memberNo
	 * @param memberEmail
	 * @param ra
	 * @param authority
	 * @return
	 */
	@PostMapping("changeAuthority")
	public String changeAuthority(int memberNo, String memberEmail, int authority, RedirectAttributes ra) {
		
		int result = service.changeAuthority(memberNo, authority);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "권한 변경 완료");
			
		} else {
			ra.addFlashAttribute("message", "권한 변경 실패");
		}
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	
	/** 비밀번호 "1234"로 초기화
	 * @param memberNo
	 * @param memberEmail
	 * @param ra
	 * @return
	 */
	@PostMapping("initPw")
	public String initPw(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.initPw(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "비밀번호 초기화 완료");
			
		} else {
			ra.addFlashAttribute("message", "비밀번호 초기화 실패");
		}
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
	}
	
	
	// ------------------------------------------------------------------------------

	
	@GetMapping("ajaxTest")
	public String ajaxTest() {
		return "admin/ajaxTest";
	}
	
	
	
	
	

}
