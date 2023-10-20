package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;

@Controller
@RequestMapping("user")
@SessionAttributes({"selectUser"})
public class UesrController {
	
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("selectOne")
	public String selectOne(String userId, Model model){

		// 서비스 호출
		User selectUser = service.selectOne(userId);
		
		// 조회 결과가 있을 경우
		if(selectUser != null) {
			model.addAttribute("selectUser", selectUser);
			return "/searchSuccess";
		}
		
		return "/searchFail";
	}
	
	

}
