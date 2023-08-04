package edu.kh.oop.method;

public class Person {
	
	// 필드 (캡슐화 원칙)
	private String name;
	private int age;
	private char gender;
	
	// 기본 생성자
	public Person() { };
	
	
	// 매개변수 생성자
	public Person(String name, int age, char gender) {

		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	
	// 메서드 Method : 객체의 기능
	
	// [작성법]
	// [접근제한자] [예약어] 반환형 메서드명 ( [매개변수] ) { }
	
	// name 필드에 전달 받은 값을 세팅하는 메서드
	// void : 메서드 수행 후 돌려 보내주는 결과가 없음

	public void setName(String name) {
		this.name = name;
		return; // return : 돌려 보내다, 반환하다
				// 현재 메서드를 종료하고
				// 현재 메서드를 호출한 곳으로 돌아간다
		
		// * 반환형이 void인 메서드는
		//  return을 작성하지 않아도 컴파일러가 자동으로 추가 *
	}
		
	
	// name 필드의 값을 호출한 곳으로 돌려 보내주는 메서드 작성
	public String getName() {
		
		// return : 메서드 종료 후 호출한 곳으로 돌아가기
		
		// return 값 : 메서드 종료 후 호출한 곳으로 값을 가지고 돌아가기
		
		// 반환형 : return할 값의 자료형
		return this.name;
		
	}
	
	
	// private int age; 필드의 값을 세팅, 얻어가는 메서드 작성
	
	public void setAge(int age) {
		this.age = age;
		// return; // void는 return 안쓰면 컴파일러가 자동 추가함
	}
	
	public int getAge() {
		return this.age;
	}
		
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}
	
	
	// 필드 하나에 값을 세팅하는 메서드 : setter
	// 필드 하나의 값을 반환하는 메서드 : getter
		
	
	

}
