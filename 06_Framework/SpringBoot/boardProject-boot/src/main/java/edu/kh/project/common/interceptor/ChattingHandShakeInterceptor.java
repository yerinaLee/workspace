package edu.kh.project.common.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// session을 가로채는 내용을 정의하는 클래스
@Component
public class ChattingHandShakeInterceptor implements HandshakeInterceptor{

	// 웹소켓 요청이 핸들러에 도달하기 전에 수행
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		// http 요청이 된 경우인지 확인
		if(request instanceof ServletServerHttpRequest) {
			
			// 다운 캐스팅
			ServletServerHttpRequest req = (ServletServerHttpRequest)request;
			
			// 요청 클라이언트의 session을 얻어옴
			HttpSession session = req.getServletRequest().getSession();
			
            // Map<String, Object> attributes 
            // : WebsocketHandler 클래스의 WebSocketSession에서 사용하고자 하는 값을 세팅
            //   (attributes에 추가된 값은 WebSocketSession에 그대로 복사됨)
			attributes.put("session", session);
			
		}
		
		return true;
	}
	
	
	// 웹소켓 요청이 서버에서 클라이언트로 응답하기 전
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
	}
	
	
}
