package edu.kh.project.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.admin.model.service.AjaxService;
import edu.kh.project.member.model.dto.Member;

@Controller
@RequestMapping("ajax") // 상위 공통 주소
public class AjaxController {
	
	
	@Autowired
	private AjaxService service;
	
	
	
	 /** 회원 번호가 일치하는 회원 이메일 조회
	 * @param memberNo : 입력된 회원 번호 
	 * @return
	 */
	@GetMapping("selectMemberNo")
	@ResponseBody
	public String selectMemberNo(int memberNo){
		
		String email = service.selectMemberNo(memberNo);
		
		// 동기식(기존 방식)으로 응답 할 때
		// 1) Model 객체에 데이터 세팅
		// 2) 지정된 html로 forward
		// 3) 갱신된 화면에 데이터를 출력
		
		//-----------------------------------
		
		/* 비동기 방식으로 응답하는 방법! */
		// - 비동기 통신은 페이지 갱신(화면 새로 만들기)이 목적 X
		// - 단순히 요청에 맞는 응답 데이터만 주고 받는것이 목적 O

		// -> 조회 결과 email을 요청한 곳으로 반환
		
		return email;
		// templates/member01@naver.com.html
		
		// ******** !문제 발생! ******** 
		// - email을 반환 하려는데
		//  Controller는 반환된 값을 ViewResolver로 전달해
		//	자동으로 /templates/반환값.html로
		//	forward를 수행하는 문제 발생!!
		
		// [해결방법]
		// Controller의 메서드 반환값이
		// forward를 위한 경로가 아닌
		// 비동기 요청한 곳으로 돌아가야되는 값 자체임을 명시하는
		// 어노테이션 @ResponseBody를 메서드 위에 추가 // 밀입국 ㅋㅋㅋㅋㅋㅋㅋㅋ
	}
	
	
	/** 이메일이 일치하는 회원의 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	@GetMapping("selectEmail")
	@ResponseBody // forward 아니고 값 자체 반환할꺼임(비동기)
	public String selectEmail(String inputEmail){
		return service.selectEmail(inputEmail);
	}
	
	
	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return Member
	 */
	@GetMapping(value="selectMember", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Member selectMember(int no){
		
		// Java 객체는 JS에서 사용 불가능!! (왜? 형태부터 다름) 
		
		// Java 객체 -> JS 객체로 변환 작업 필요!
		
		// 1) Java 객체를 JSON으로 변환
		//	* JSON : JS 객체 모양 문자열 (String)
		//	  -> HttpMessageConverter 가 변환 (자동으로댐)
		
		// 2) JSON(문자열) 형태의 데이터를 JS로 전달(응답)
		//	 + JSON이니까 JS 객체로 변환해서 사용해! 라는 구문을 첨부
		//	  -> @XXXMapping 구문에
		//		produces="application/json; charset=UTF-8" 추가
		
		// 3) JS에서 자동으로 JS 객체로 변환되어 사용 가능
		
		
		return service.selectMember(no);
	}
	
	
	/** 입력된 문자열을 포함하는 모든 이메일 조회
	 * @param keyword
	 * @return emailList
	 */
	@GetMapping(value="selectEmailList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<String> selectEmailList(String keyword){
		return service.selectEmailList(keyword);
	}
	
	

}
