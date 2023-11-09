package edu.kh.project.main.model.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/* 웹소켓 요청을 어떻게 처리할지 정의하는 클래스 */

// 1) TextWebSocketHandler 상속
// 	-> afterConnectionEstablished 오버라이딩 (접속 확립)
//	   handleTextMessage 오버라이딩 (메세지 온거 어떻게할거?)
//	   afterConnectionClosed 오버라이딩 

// 2) bean 등록 (스프링이 알아서 객체로 만들고 상황에 맞게 동작)

@Slf4j
@Component // bean 등록 (@Controller, @Service의 부모 어노테이션)
public class TestWebsocketHandler extends TextWebSocketHandler{
	
	// WebSocketSession : 클라이언트 - 서버 전이중 통신을 담당하는 객체
	//					  클라이언트의 세션을 다룰 수 있음
	
	// session : 클라이언트 세션을 모아둔 set
	//			-> 모든 사용자, 원하는 사용자 찾기 가능
	
	// synchronizedSet : 동기화된 Set(안정성 증가)
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
	
	// Established : 확립된
	// 클라이언트 연결이 완료되고 통신할 준비가 될 때 수행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 연결이 확립된 후
		
		// 매개변수 session == 한 명의 클라이언트
		
		sessions.add(session); // 필드에 있는 set에 매개변수 session 추가
		// --> 누가 접속했는지 set을 이용해서 파악 가능(명단 만듦)
	}
	
	// 클라이언트로부터 메세지를 받았을 때 수행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// Payload : 전달 받은 데이터
		log.debug("전달 받은 내용 : " + message.getPayload());
		
		// 전달 받은 데이터를
		// 접속한 모든 사용자에게 보내기
		
		for(WebSocketSession s : sessions) {
			
			// 특정 클라이언트 메시지 -> 서버 -> 모든 클라이언트
			
			s.sendMessage(message);
		}
	}
	
	// 클라이언트 연결이 종료될 때 수행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 나간 클라이언트 set에서 제거(명단에서 제외)
		sessions.remove(session);
	}

}
