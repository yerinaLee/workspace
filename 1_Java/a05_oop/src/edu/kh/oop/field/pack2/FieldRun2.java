package edu.kh.oop.field.pack2;

import edu.kh.oop.field.pack1.FieldTest1;

public class FieldRun2 extends FieldTest1 /* 상속 */ {
	
	public static void main(String[] args) {
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();

		System.out.println(f1.v1); // public
//		System.out.println(f1.v2); // protected : 같은 패키지 + 상속
//		System.out.println(f1.v3); // (default) : 같은 패키지
//		System.out.println(f1.v4); // private : 같은 클래스
		
	}
	
	public void testMethod() {
		System.out.println(v2); // 다른 패키지이지만 상속(protected)라서 가능
//		System.out.println(v3); // (default)라서 불가능
		
	}
	

}
