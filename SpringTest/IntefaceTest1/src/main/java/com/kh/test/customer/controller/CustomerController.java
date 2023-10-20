package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("add")
	public String add(Model model, Customer customer) {
		
		// 회원가입 서비스 호출
		int result = service.add(customer);
		
		// 성공시
		if(result > 0) {
			model.addAttribute("customerName", customer.getCustomerName());
		}
		
		return "result";
	}
	
	
	

}
