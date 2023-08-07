package edu.kh.poly.run;

import edu.kh.poly.model.dto.Animal;
import edu.kh.poly.model.dto.Fish;
import edu.kh.poly.model.dto.Person;

public class AbstractRun {
	
	public static void main(String[] args) {
		
		// 1. 추상 클래스는 진짜로 객체를 못만들까?
		// Animal animal = new Animal();		
		// Cannot instantiate the type Animal
		// -> Animal은 객체화 할 수 없다
		
		// 2. 상속 받은 자식 클래스는 객체 생성 가능
		Person p = new Person("포유류", "잡식", "이문세", 24);
		Fish f = new Fish("어류", "육식", 4);
		
		// 3. 추상 클래스는 부모 타입 참조 변수는 가능
		// -> 다형성(업캐스팅)
		Animal a1 = p; // Animal 참조 변수 = Person 객체 주소
		Animal a2 = f; // Animal 참조 변수 = Fish 객체 주소
		
		
		// 4. 추상 클래스 + 다형성 업캐스팅 + 동적 바인딩
		System.out.println(a1.toString());
		a1.breath();
		// 동적 바인딩의 성질을 이용하여
		// 추상 메서드인 Animal.breath()가 호출되는 경우가 없게 만듦

		System.out.println(a2.toString());
		a2.breath();

				
		System.out.println("-------------------");
		System.out.println(a1);
//		-> System.out.println(a1.toString()); 과 결과값이 같음
		// 참조변수를 print 구문에 작성 시
		// 컴파일러가 .toString()을 붙여줌 
		
	}

}
