package edu.kh.project.common.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // bean으로 등록 => Spring이 알아서 다룰 수 있음
@Aspect // 공통 관심사가 작성된 클래스임을 명시
		// 공통 관심사 : 특정 지점에서 동작하는 코드
public class AfterAspect {
	   
	@After("execution(* edu.kh.project..*Controller*.*(..))")
	public void afterLog() {
		
		log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	

}
