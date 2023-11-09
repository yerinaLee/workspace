package edu.kh.project.chatting.model.websocket;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import edu.kh.project.chatting.model.dto.Message;
import edu.kh.project.chatting.model.service.ChattingService;
import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChattingWebsocketHandler extends TextWebSocketHandler{
    
    private final ChattingService service;
    
    // WebSocketSession : 클라이언트 - 서버간 전이중통신을 담당하는 객체 (JDBC Connection과 유사)
    private Set<WebSocketSession> sessions  = Collections.synchronizedSet(new HashSet<WebSocketSession>());
    
    // afterConnectionEstablished - 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행. 
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }
    
    
    //handlerTextMessage - 클라이언트로부터 텍스트 메세지를 받았을때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        
        // 전달받은 내용은 JSON 형태의 String
        log.info("전달받은 내용 : " + message.getPayload());
        
        // Jackson에서 제공하는 객체
        // JSON String -> DTO Object
        // 전달받은 내용 : {"senderNo":"4","targetNo":"11","chattingNo":"8","messageContent":"실시간"}
        ObjectMapper objectMapper = new ObjectMapper();
        
        Message msg = objectMapper.readValue( message.getPayload(), Message.class);
        // Message 객체 확인
        System.out.println(msg); 
        
        // DB 삽입 서비스 호출
        int result = service.insertMessage(msg);
        
        if(result > 0 ) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
            msg.setSendTime(sdf.format(new Date()) );
            
            log.info("세션 수 : " + sessions.size());
            
            // 전역변수로 선언된 sessions에는 접속중인 모든 회원의 세션 정보가 담겨 있음
            for(WebSocketSession s : sessions) {
                // WebSocketSession은 HttpSession의 속성을 가로채서 똑같이 가지고 있기 때문에
                // 회원 정보를 나타내는 loginMember도 가지고 있음.
                
                // 로그인된 회원 정보 중 회원 번호 얻어오기
//            	log.info(s.toString());
//            	log.info(s.getAttributes().toString());
//            	log.info(s.getAttributes().get("session").toString());
            	
            	HttpSession temp = (HttpSession)s.getAttributes().get("session");
//            	log.info(temp.getAttribute("loginMember").toString());
            	
                int loginMemberNo = ((Member)temp.getAttribute("loginMember")).getMemberNo();
                log.debug("loginMemberNo : " + loginMemberNo);
                
                // 로그인 상태인 회원 중 targetNo가 일티하는 회원에게 메세지 전달
                if(loginMemberNo == msg.getTargetNo() || loginMemberNo == msg.getSenderNo()) {
                    s.sendMessage(new TextMessage(new Gson().toJson(msg)));
                }
            }
        }
    }
    
    
    
    
    // afterConnectionClosed - 클라이언트와 연결이 종료되면 실행된다.
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        //log.info("{}연결끊김",session.getId());
    }
    
}