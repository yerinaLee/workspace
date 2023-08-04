package edu.kh.oop.method;

import java.util.Scanner;

// 프로그램 동작 기능 제공 클래스
public class PersonService {
	
	// 필드에 Scanner를 선언해서
	// 메서드에서 Scanner를 더 이상 선언하지 않게함
	private Scanner sc = new Scanner(System.in);
	
	private String title;
	
	// 생성자
	public PersonService() {
		title = "======Person을 이용한 프로그램======";
	}
	
	public String getTitle() { // 프로그램 이름 반환
		return title;
	}
	
	// 사람 객체를 생성해서 반환하는 메서드
	public Person createPerson() {
		
		System.out.println("=== Person 객체 생성하기 ===");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();

		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		// 입력된 문자열에서 0번 문자만 반환
		
		// Person 객체 생성 + 입력 받은 값으로 필드 초기화
//		Person p = new Person();
//		p.setName(name);
//		p.setAge(age);
//		p.setGender(gender);
		
		// 매개변수 생성자
		Person p = new Person(name, age, gender);
		return p;		
	}
	
	
	// 매개변수로 전달 받은 Person을 이용해서
	// 필드에 저장된 값을 하나의 문자열로 만들어서 반환
	public String personFeilds(Person p) {
		
		// 홍길동 / 25세 / 남
		
		String str
			= p.getName() + " / " + p.getAge() + "세 / " + p.getGender();  
		
		return str;
		
	}
	
}
