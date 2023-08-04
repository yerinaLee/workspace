package edu.kh.oop.cls.pack2;

// ClassTest1 클래스를 가져오는 코드
import edu.kh.oop.cls.pack1.ClassTest1;

public class TestRun2 {
	
	public static void main(String[] args) {
		
		// ClassTest1 객체 생성
		// -> 다른 패키지
		// -> public은 어디서든 접근 가능하다고 했는데.. 왜 안되지?
		// --> 패키지가 다른 클래스를 접근하고자 할 때
		//	   import라는 작업을 해서 가져와 사용
		
		
		//	public means 공공재. 어디서든 "가져와서" 사용 가능
		// public은 어디서든 접근해 가져가서 사용 가능하다는 의미
		ClassTest1 c1 = new ClassTest1();
		
		c1.method1();
		
		
		
		// ClassTest2 객체 생성
		ClassTest2 c2 = new ClassTest2();
		// (default) 접근 제한자 : 같은 패키지에서 접근 가능 (확인!) 
		// + 같은 패키지는 import 필요 없음
		
		c2.method2();

		
		
		
	}
	

}
