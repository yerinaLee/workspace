package edu.kh.variable;

public class VariableEx1 {
	
	public static void main(String[] args) {

		System.out.println("[변수 사용 x]");
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 * 10);
		System.out.println(3.141592653589793 * 10 * 10 * 20);
		System.out.println(4 * 3.141592653589793 * 10 * 10);

		System.out.println("-----------------------------");
		
		System.out.println("[변수 사용 O]");

		double pi = 3.141592653589793; //원주율
		int r = 5; //반지름
		int h = 20; //높이
		
		System.out.println(2 * pi * r); //원의 둘레
		System.out.println(pi * r * r); //원의 넓이
		System.out.println(pi * r * r * h); //원기둥의 부피
		System.out.println(4 * pi * r * r); //구의 겉넓이
		
		
	}
	

}
