package edu.kh.project.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 프로젝트 전역에서 발생하는 예외를 제어하는 컨트롤러
public class ExceptionController {
	

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		
		e.printStackTrace(); // 콘솔에 에러 발생 메서드 모두 출력
		
		// model : 값 전달 객체 (기본 request scope)
		// e : 예외 객체
		model.addAttribute("e", e);
		
		// forward구문. /WEB-INF/vies/common/error.jsp로 forward
		return "common/error";
	}

	

}
