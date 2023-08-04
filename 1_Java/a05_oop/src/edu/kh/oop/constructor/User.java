package edu.kh.oop.constructor;

public class User {

	// 필드
	private String name;  
	private int age;  
	private String address;  
	
	// 생성자가 작성되지 않을 경우
	// -> 컴파일러가 기본 생성자를 추가해줌
	// public User(){ }
	// 위 한 줄을 추가해줌

	 public User(){ } // 기본 생성자를 명시적으로 작성
	 
	// 매개변수 생성자
	// -> 개발자가 생성자를 임의로 하나 이상 작성하면
	//	 컴파일러가 자동으로 기본 생성자를 추가하지 않는다!
	public User(String name) {
	
		// this 참조 변수
		// - 현재 객체(인스턴스)의 시작 주소를 저장하고 있는 참조 변수
		// - 객체(인스턴스) 생성 시 자동으로 내부에 추가됨
		// - 현재 객체가 가지고 있는 필드, 메서드를 명확하게 가리킬할 때 사용
		
		this.name = name;
		// 현재 객체의 name 필드에 전달 받은 name 값을 저장
		
	}
	
	// 오버로딩(OverLoading)
	// - 한 클래스 내부에 
	//   동일한 이름의 메서드, 생성자를 여러 개 작성하는 기법

	// --> 메서드, 생성자 이름은 하나인데
	//	매개변수의 차이에 따라서 알맞는 메서드, 생성자가 수행됨 
	
	// * 오버로딩 성립 조건 *
	// 1. 메서드, 생성자 이름이 같아야 한다!!!
	// 2. 매개변수의 개수, 순서, 타입 중 하나라도 달라야 한다
	// 3. 접근제한자는 상관 없음 (내가 원하는대로 바꿀 수 있음. 생성자는 보통 public만 써요)
	
	// 매개변수 생성자
	
	public User(String name, int age) { // 매개변수 개수가 다름		
		this.name = name;
		this.age = age;
	}
	
	public User(int age, String name) { // 순서가 다름
		this.name = name;
		this.age = age;
	}
	
	public User(String address, String name) { // 타입(자료형) 다름
		this.address = address;
		this.name = name;
		
	}
	
//	public User(String name, String address) {
		// 매개변수의 순서를 바꿔도
		// 자료형 순서가 그대로면 오버로딩 성립 X
		// ** 변수명보다 자료형이 더 중요시 생각해야된다!! **
		//	  (제발 변수명에 목숨걸지마요 ...)
//	}
	
	
	public User(String name, int age, String address) {
		this(age, name); // this() 생성자
		this.address = address;
	}
	
	
	
}
