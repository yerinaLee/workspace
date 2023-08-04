package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Child2;
import edu.kh.inheritance.model.dto.Parent;

public class TestRun {

	public static void main(String[] args) {
		
		// ctrl + shift + o : import 자동 추가
		// -> 단점 : 개발자가 직접 작성한 import 구문이 사라질 수도 있다
		
		// 부모 객체 생성
		Parent p1 = new Parent();
		Parent p2 = new Parent(100, "하");
		
		System.out.println("------------------------------------");
		Child1 c1 = new Child1("테슬라");
		Child2 c2 = new Child2("시그니엘");
		
		
		// 자식 객체를 생성했기 때문에
		// 자식의 생성자가 실행되는건 이해되는데
		// 왜? 부모의 기본생성자가 같이 실행이 되었을까???
		// -> 메모리 구조 보면서 확인
		
		
		/* 자식이 부모로부터 상속 받은 멤버(필드, 메서드) 사용 */
		
		// 아무리 상속받았다고 해도 private은 직접 접근이 불가능하다!
		// (부모님의 개인적인 것을 마음대로 건드릴 수 없다..ㅋ)
		// c1.money = 10;
		
		// 대신 간접 접근 방법 getter/setter 이용 가능
		System.out.println(c1.getMoney());
		System.out.println(c1.getLastName());
		
		System.out.println("-------------------");
		// 자식의 toString() 호출
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		 
		System.out.println("-------------------");
		System.out.println("오버라이딩");
		System.out.println(c1.getMoney());
		// StackOverflowError
		
		System.out.println("-------------------");
		Child2 c3 = new Child2(900, "박", "한남동유엔빌리지~");
		System.out.println(c3.getMoney()); // Parent
		System.out.println(c3.getLastName()); // Parent
		System.out.println(c3.getHouse()); // Child2
		
		System.out.println(c3.toString());

		
		
	}
}
