package edu.kh.oop.field.pack2;

public class Student {
	
	// 필드(속성)
	
	// 인스턴스 변수 : 인스턴스(객체) 생성 시
//					   메모리에 할당되는 변수
	
	// -> 필드에 작성되고 static이 없는건 다 인스턴스 변수
	
	public int grade = 3; // 학년 
						// 필드에 3 대입을 직접 작성 == 명시적 초기화
	
	public int ban; // 반
	public int number; // 번호
	public String name; // 이름
	
	// 인스턴스 초기화 블럭
	{
		// 인스턴스 생성 시
		// 인스턴스 변수 (static이 없는 필드)를 초기화 하는 용도
		
		grade = 5;
		ban = 10;
		number = 99;
		name = "임시";
		
	}
	
	
	// 클래스 변수
	// - 필드에 작성되고 static이 붙은 변수
	// - static 메모리 영역에 생성될 때 
	//   클래스명.변수명 으로 생성되기 때문에 클래스 변수라고 부른다.
	
	// static : 같은 타입의 객체끼리 필드 공유 목적
	
	// static 메모리 영역 == 정적 메모리 영역
	// -> 프로그램 실행 시 static 영역에 생성되고
	//    프로그램이 끝나기 전까지 고정(사라지지 않음)
	//	-> 고정된 static을 프로그램 어디서든 공유 가능
	//		(공유 메모리 영역)
	public static String schoolName = "세봉 중학교"; // 학교명
	
	
	// 클래스 초기화 블럭
	static {
		
//		name = "av";
		// 인스턴스 변수는 클래스 초기화 블럭에서 초기화 불가능
		
		schoolName = "서울 세봉 중학교";
		
	}
	
	
	
	
	// 기능
	public void study() {
		System.out.println("졸지 않고 공부를 열심히 합니다");
	}
	

}
