package edu.kh.project.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/* 필터 클래스 생성하기 */
// 1. jakarta.servlet.Filter 인터페이스 상속받기
// 2. doFilter() 메서드 오버라이딩 하기

@Slf4j
public class LoginFilter implements Filter {
	
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
		
			log.info("[[로그인 필터 동작]]");
			
			// 요청, 응답 객체를 HTTP 통신에 사용할 수 있는 형태로
			// 다운 캐스팅 진행
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			// Session 객체 얻어오기
			HttpSession session = req.getSession();
			
			// 로그인이 되어있지 않은 경우 
			if(session.getAttribute("loginMember") == null) {
				
				// /loginError 리다이렉트
				resp.sendRedirect("/loginError");
			}
			
			else { // 로그인 되어 있는 경우
				
				// 다음 필터 또는 DispatcherServlet으로 연결
				chain.doFilter(request, response);
			}
			
		
			
		}

}
