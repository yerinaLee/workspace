package edu.kh.operator.ex;

public class OperatorEx5 {
	
	public static void main(String[] args) {
		
		// AND 연산자 (&&)
		//  - 둘 다 true이면 true, 나머진 false
		//  - ~와, 그리고(이고), 이면서(면서), 부터~까지, 사이
		
		// 104는 100 이상이면서 짝수인가?

		boolean result1 = (100 <= 104) && (104 % 2 == 0); 
		System.out.println("104는 100 이상이면서 짝수인가? " + result1);
		
		
		int num2 = 50;
		boolean result2 = (num2 <= 50) && (num2 % 3 == 0);
		System.out.println("num2는 50 이하이고 3의 배수인가? " + result2);
		
		
		int num3 = 67;
		boolean result3 = (1 <= num3) && (num3 <= 100); 
		System.out.println("num3는 1부터 100사이의 정수인가? " + result3);
		
		// --------------------------------------------------------------
		
		
		// OR 연산자 (||) : 둘 다 false이면 false, 아니면 true
		//  - 또는, ~이거나(거나)
		
		
		int num4 = 20;
		boolean result4 = (num4 > 10) || (num4 % 2 != 0) ;
		System.out.println("num4는 10을 초과하거나 홀수인가? " + result4);
		
		
		int num5 = 51;
		boolean result5 = (num5 >= 0 && num5 <= 50) || (num5 < 0) ;
		System.out.println("num5는 0이상 50이하의 수 또는 음수인가? " + result5);
		
		
		// --------------------------------------------------------------
		
		
		// 논리 부정(NOT) 연산자 (!)
		//  - 논리값을 반대로 바꾸는 연산자 
		
		System.out.println(!true); // false
		System.out.println(!false); // true

		
		int num6 = 11;
		boolean  result6 = num6 % 2 == 0 ; // 짝수 판별
		System.out.println("num6는 짝수? " + result6); // false
		System.out.println("num6는 홀수? " + !result6); // true
		
		
		int num7 = 30;
		boolean result7 = (num7 >= 1 && num7 <= 50) && !(num7 % 5 == 0) ;
		System.out.println("num7은 1부터 50사이 정수이면서 5의 배수가 아닌 수?" + result7 ); // false
		
		
		
		
	}

}
