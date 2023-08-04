package edu.kh.oop.method;

public class PersonRun {
	
	
	public static void main(String[] args) {
		
		// 사람 객체 생성(기본 생성자)
		Person p1 = new Person();
		
		// p1이 참조하는 객체의 name 필드 값을 세팅
		p1.setName("저눠누");
		
		String result = p1.getName(); // "저눠누"
		// 반환형 String -> 반환 값을 String 변수에 저장 가능
		
		System.out.println("result : " + result);
		System.out.println("종료");
		
		p1.setAge(16);
		int age = p1.getAge();
		
		p1.setGender('남');
		char gender = p1.getGender();
		
		
		
		
		
		
		
		
	}
	

}
