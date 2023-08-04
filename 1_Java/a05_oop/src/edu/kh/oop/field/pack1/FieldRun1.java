package edu.kh.oop.field.pack1;

public class FieldRun1 {
	
	
	public static void main(String[] args) {

		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		System.out.println(f1.v1); // public : 어디서든
		System.out.println(f1.v2); // protected : 같은 패키지 + 상속
		System.out.println(f1.v3); // (default) : 같은 패키지
		
//		System.out.println(f1.v4); // private : 같은 클래스
		// --> 다른 클래스라서 오류 
		
		System.out.println();
		f1.method1();
		
		
		
	}





}
