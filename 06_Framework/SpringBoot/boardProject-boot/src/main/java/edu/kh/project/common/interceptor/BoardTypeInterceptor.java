package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.kh.project.board.model.service.BoardService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

// Interceptor : 요청/응답을 가로채는 객체
// Client <-> Filter <-> Dispatcher Servlet <-> Interceptor <-> Controller

/* HandlerInterceptor(인터셉터 처리기) 상속 */

@Slf4j
public class BoardTypeInterceptor implements HandlerInterceptor {
	
	@Autowired // BoardService Bean 의존성 주입(DI)
	private BoardService service;
	
	
	
	// preHandle(전처리) : Dispatcher Servlet -> Controller 사이
	//						요청을 가로채서 동작 (컨트롤러 전에! 요청을 가로채서 동작하겠다)
	
	// postHandle(후처리) : Dispatcher Servlet <- Controller 사이
	//						응답을 가로채서 동작 (컨트롤러 후에! 응답을 가로채서 동작하겠다)
	
	// afterCompletion(뷰 완성 후) : Client <- Dispatcher Servlet 사이
	//								forward한 뷰(html, jsp) 완성 후 동작

	
	// 전처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// application scope(서버 실행 시 1개만 생성, 종료 시 사라짐) 객체 얻어오기
		ServletContext application = request.getServletContext();
		
		// application scope에 boardTypeList가 없을 경우 (사실상 서버를 맨 처음 켰을 때만 DB를 조회하겠다)
		if(application.getAttribute("boardTypeList") == null) {
			
			log.info("------ BoardTypeInterceptor 동작 -------");
			
			// 게시판 종류 조회
			List<Map<String, Object>> boardTypeList = service.selectBoardTypeList();
			
			//application scope에 세팅
			application.setAttribute("boardTypeList", boardTypeList);
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	
	@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		}
	
	
	
	@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		}
	
	
}
