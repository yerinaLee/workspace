package edu.kh.oop.cls.pack1;

// (default) 클래스는 다른 패키지에서 접근 불가능하다 (확인!)
//import edu.kh.oop.cls.pack2.ClassTest2;

public class TestRun1 {
	
	public static void main(String[] args) {
		
		
		// ClassTest1 객체 생성
		ClassTest1 c1 = new ClassTest1();
		// public - 같은 패키지 접근 가능

		
		// ClassTest1의 method1() 기능 호출
		c1.method1();
		
		
		// ClassTest2 객체 생성
//		ClassTest2 c2 = new ClassTest2();
//		-> 다른 패키지이므로 접근 불가 (default)
		
		
		
	}
	

}
