package edu.kh.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home") // 공통 주소
public class HomeController {
	
	// 상세 주소
	@RequestMapping(value = "/view1", method = RequestMethod.GET)
	public String home1() {
		// -> forward 또는 redirect 때문에
		// Controller 메서드 반환형은 대부분 String
		
		/* Spring에서 forward 하는 방법 */
		// forward할 JSP 경로에서
		// ViewResolver의 prefix, suffix 부분을 제외한 경로를
		// return 값으로 작성
		return "home/view1";
	}

	@RequestMapping("/view2")
	public String home2() {
		return "home/view2";
	}
	
}
