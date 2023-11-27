package com.kh.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	
	@PostMapping("loginTest")
	public String loginTest(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		if(id.equals("user01") && pw.equals("pass01")) {
			model.addAttribute("message", "성공");
		} else {
			model.addAttribute("message", "실패");
		}
		
		return "loginResult";
	}

}
