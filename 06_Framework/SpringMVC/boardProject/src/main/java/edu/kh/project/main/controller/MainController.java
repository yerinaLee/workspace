package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Java 객체 : new 연산자에 의해서 class 내용대로 heap 영역에 생성되는 것 

// instance : 개발자가 만들고 관리하는 객체
// bean : Spring (Spring Container) 객체

@Controller // bean 등록 + Controller 역할을 할 것이라고 명시
			// - Controller 역할 : 요청/응답 제어

public class MainController {
	
	// "/"로 요청을 받게 되면
	@RequestMapping("/")
	public String mainPage() {
		
		return "common/main";
		// -> /WEB-INF/views/common/main.jsp로 forward
	}

}
