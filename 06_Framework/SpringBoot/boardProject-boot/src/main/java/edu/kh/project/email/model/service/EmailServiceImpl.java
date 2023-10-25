package edu.kh.project.email.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import edu.kh.project.email.model.mapper.EmailMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final 필드 DI
public class EmailServiceImpl implements EmailService{
	
	private final EmailMapper mapper;
	private final JavaMailSender mailSender; // 자바에서 메일 보낼 때 사용하는 객체
	private final SpringTemplateEngine templateEngine; // html파일 내용을 읽어오는 용도
	
	   @Override
	   public int sendEmail(String htmlName, String email) {
	       //6자리 난수 인증번호 생성
	        String authKey = createAuthKey();
	        
	        try {
	           
	           // 제목
	           String subject = null;
	           
	           switch(htmlName) {
	           case "signup" : subject = "[boardProject] 회원가입 인증 번호 입니다."; break;
	           case "findPw" : subject = "[boardProject] 비밀번호 찾기 인증 번호 입니다."; break;
	           }
	           
	            //인증메일 보내기
	           // MimeMessage : JavaMail API에서 메일을 보내는데 사용하는 객체
	            MimeMessage mimeMessage = mailSender.createMimeMessage();
	            
	            // MimeMessageHelper : 스프링에서 제공하는 메일 발송 도우미
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
	            
	            mimeMessageHelper.setTo(email); // 받는 사람 이메일
	            mimeMessageHelper.setSubject(subject); /// 제목
	            mimeMessageHelper.setText(loadHtml(authKey, htmlName), true); // 내용(타임리프가 적용된 HTML), HTML 태그 해석여부 true
	            
	            // CID(Content-ID)를 이용해 메일에 이미지를 첨부하여 메일에서 사용
	            mimeMessageHelper.addInline("logo", new ClassPathResource("static/images/logo.jpg"));
	           
	            // 메일 보내기
	            mailSender.send(mimeMessage);
	            
	        }catch (Exception e) {
	           e.printStackTrace();
	           return 0;
	        }
	        
	        
	        
	        // 이메일과 인증번호를 DB에 저장
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("authKey", authKey);
	        map.put("email", email);
	        
	        // 우선 수정 시도
	        int result = mapper.updateAuthKey(map);
	        
	        // 수정 되지 않은 경우 == 인증번호 발급이 처음
	        if(result == 0) {
	           result = mapper.insertAuthKey(map); // 삽입
	        }
	        
	      // 결과 반환
	      return result;
	   }
	   
	   
	/** 인증번호 확인
	 *
	 */
	@Override
	   public int checkAuthKey(Map<String, Object> paramMap) {
	      return mapper.checkAuthKey(paramMap);
	   }
	   
	   
	   // thymeleaf를 통한 html 적용
	    public String loadHtml(String authKey, String htmlName) {
	       // org.thymeleaf.context.Context
	        Context context = new Context();
	        context.setVariable("authKey", authKey); // html에서 타임리프로 사용할 값 세팅
	        
	        // templates/email 폴더에서 htmlName과 이름이 일치하는 html 파일의 내용을 얻어와 반환(타임리프 적용)
	        return templateEngine.process("email/" + htmlName, context);
	        
	    }
	   
	   
	   
	    /** 인증번호 생성 (영어 대문자 + 소문자 + 숫자 6자리)
	     * @return authKey
	     */
	    public String createAuthKey() {
	        String key = "";
	        for(int i=0 ; i< 6 ; i++) {
	            
	            int sel1 = (int)(Math.random() * 3); // 0:숫자 / 1,2:영어
	            
	            if(sel1 == 0) {
	                
	                int num = (int)(Math.random() * 10); // 0~9
	                key += num;
	                
	            }else {
	                
	                char ch = (char)(Math.random() * 26 + 65); // A~Z
	                
	                int sel2 = (int)(Math.random() * 2); // 0:소문자 / 1:대문자
	                
	                if(sel2 == 0) {
	                    ch = (char)(ch + ('a' - 'A')); // 대문자로 변경
	                }
	                
	                key += ch;
	            }
	            
	        }
	        return key;
	    }
	
}
