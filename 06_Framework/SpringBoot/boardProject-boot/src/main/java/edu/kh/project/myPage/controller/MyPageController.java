package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.myPage.model.service.MyPageService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
@Slf4j
public class MyPageController {
	
	
	@Autowired
	private MyPageService service;
	
	
	// 마이페이지 화면 전환 (forward)
	@GetMapping("info") // myPage/info
	public String info() {
		
		// templates/myPage/myPage-info.html로 포워드!
		return "myPage/myPage-info";
	}
	
	@GetMapping("changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	@GetMapping("profile")
	public String profile() {
		return "myPage/myPage-profile";
	}
	
	@GetMapping("secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	@GetMapping("sideMenu")
	public String sideMenu() {
		return "myPage/myPage-sideMenu";
	}
	
	
	
	
	
	
	

}
