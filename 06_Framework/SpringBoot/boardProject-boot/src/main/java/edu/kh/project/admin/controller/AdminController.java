package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

}
