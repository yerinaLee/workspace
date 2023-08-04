package edu.kh.operator.ex;

public class OperatorEx2 {
	
	// main 자동완성	
	// main 작성 후 -> ctrl + space(자동완성) -> main 선택  
	
	// System.out.println(); 자동완성
	// syso, sysout -> ctrl + space -> enter
	
	public static void main(String[] args) {
		
		/* 증감 연산자 : ++ / --
		 *  - 피연산자를 1씩 증가 또는 감소시키는 연산자 
		 *   (피연산자 : 연산을 당하는 변수나 값)
		 */
		
		System.out.println("[전위 연산]");		

		System.out.println("증가 연산 테스트");
		int num1 = 5;
		
		System.out.println(num1); //5
	
		System.out.println(++num1); //6
		System.out.println(++num1); //7
		System.out.println(++num1); //8
		System.out.println(++num1); //9
		
		
		System.out.println("감소 연산 테스트");
		int num2 = 10;
		
		System.out.println(num2); // 10
		System.out.println(--num2); // 9
		System.out.println(--num2); // 8
		System.out.println(--num2); // 7
		System.out.println(--num2); // 6
		
		System.out.println("---------------------");

		System.out.println("[후위 연산]");
		
		// ** 후위 연산은 우선 순위가 제일 마지막이다! **
		
		System.out.println("증가 연산 테스트");
		int num3 = 20;
		
		System.out.println(num3); // 20
		System.out.println(num3++); // 출력도 컴퓨터 입장에서는 연산이기에, 20 출력 후 21로 증가
		System.out.println(num3++); // 21 출력 후 22로 증가
		System.out.println(num3++); // 22 출력 후 23으로 증가
		System.out.println(num3); // 23
		
		System.out.println("감소 연산 테스트");
		int num4 = 99;
		
		System.out.println(num4--); // 99 출력 후 98로 감소
		System.out.println(num4--); // 98 출력 후 97로 감소
		System.out.println(num4--); // 97 출력 후 96으로 감소
		System.out.println(num4--); // 96 출력 후 95로 감소
		System.out.println(num4); // 95
		
		
		
		// ------------------------------------------------------------
		
		// 연습문제!
		int a = 3; // 4
		int b = 5; // 4
		
		int c = a++ + --b; // 7
		    // 3++ + 4 = 7

		// 최종적으로 a, b, c는 각각 얼마?
		// a = 4, b = 4, c = 7 
		
		System.out.printf("a = %d, b = %d, c = %d", a, b, c);

	}
	
	
}
