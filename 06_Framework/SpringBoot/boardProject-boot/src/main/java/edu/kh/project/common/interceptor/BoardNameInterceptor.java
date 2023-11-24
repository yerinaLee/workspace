package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardNameInterceptor implements HandlerInterceptor{
	
	// 후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	      // application scope 내장 객체 얻어오기
	      ServletContext application = request.getServletContext();
	      
	      // Object 타입으로 불러오기가 되어서 다운캐스팅 함
	      List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)application.getAttribute("boardTypeList");

	      // URL(자원 경로)   : http://localhost/board/1
	      // URI(자원 식별자) : /board/1
	      String uri = request.getRequestURI();
	      
	      // uri.split("/") -> ["", "board", "1"]
	      int boardCode = Integer.parseInt(uri.split("/")[2]);
	      
	      // [{boardCode=1, boardName=공지사항}, {boardCode=2, boardName=자유 게시판}, {boardCode=3, boardName=질문 게시판}]
	      for(Map<String, Object> map : boardTypeList) {
	         int temp =  Integer.parseInt( String.valueOf(map.get("boardCode")) );
	         
	         if(temp == boardCode) {
	            request.setAttribute("boardName",  map.get("boardName"));
	         }
	      }
	      
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	

}
