package edu.kh.project.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 스프링 예외 처리 방법(우선순위별로 작성)
 * 
 * 1. 메서드에서 직접 처리 (try-catch, throws)
 * 
 * 2. 컨트롤러 클래스에서 클래스 단위로 모아서 처리
 * 	  ( @ExceptionHandler 어노테이션을 지닌 메서드를 작성 )
 * 	  (try-catch의 확장 버전)
 * 
 * 3. 별도 클래스를 만들어 프로젝트 단위로 모아서 처리 
 * 	  ( @ControllerAdvice 어노테이션을 지닌 클래스를 작성 )
 */

@ControllerAdvice
public class ExceptionController {
	
//	@ExceptionHandler(예외 종류)
//	public String 메서드명(Exception e + @) {
//		return forward 또는 redirect;
//	}
	
	// 예외 종류 : 메서드별로 처리할 예외를 지정
	//			ex) SQLException.class (SQL 관련 예외만 처리)
	//				IOException.class (입출력 관련 예외만 처리)
	//			    Exception.class (모든 예외만 처리)
	
	// + @ : Controller에서 사용 가능한 매개변수 모두 작성 가능
	//	ex) Model, RedirectAttributes 등
	
	@ExceptionHandler(Exception.class)
	public String allExceptionHandler(Exception e, Model model) {
		
		e.printStackTrace(); // 발생한 예외 원인, 메서드 추적
		
		// e : 예외 객체
		model.addAttribute("e", e); // 예외 정보를 담고 있는 객체 e를 model에 보낸다
		
		return "error/500";
	}

}
