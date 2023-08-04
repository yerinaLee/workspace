package edu.kh.oop.cls.pack1;


//  클래스 : 객체의 속성, 기능을 정의한 문서

//  클래스 선언 방법
//  [접근제한자][예약어] class 클래스명 { 클래스 정의 } 
	
//  [] : 생략 가능
//	() : 무조건 생략
	
//  클래스 접근 제한자의 종류
//	1) public    : (공공의, 모두의) 어디서든 해당 클래스에 접근 가능
//				 같은 프로젝트 내 어디서든 해당 클래스에 접근 가능 
//	2) (default) :  (기본값)
//  		     같은 패키지 내에서만 해당 클래스 접근 가능
	
public class ClassTest1 {

	public void method1() {
		System.out.println("ClassTest1의 기능입니다.");
	}
}
