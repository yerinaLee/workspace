package edu.kh.operator.ex;

public class OperatorEx3 {
	
	public static void main(String[] args) {
		
		// 비교 연산자 : >     <   >=      a<=b       ==    !=
		// 				초과 미만 이상   a는 b이하   같음 같지 않음
		
		// * 복합 기호에서 등호(=)는 항상 오른쪽 *
		
		// * 비교 연산의 결과는 논리값(True/False) *
		
		int a = 100;
		int b = 200;
		
		System.out.println(a == b); // false
		System.out.println(a != b); // true

		System.out.println(a > b); // false
		System.out.println(a < b - 100); // false
		
		System.out.println(b <= a + a); // true
		System.out.println(a < b == true); // true
		
		
		System.out.println("------------------------------");
		
		
		System.out.println("[짝수 검사]");
		// 짝수 == 2로 나누었을 때 나머지가 0인 수
		//      == 2로 나누었을 때 나머지가 1이 아닌 수
		
		// %b : 논리형 출력을 위한 칸
		// \n : 개행문자 (줄을 바꾸는 문자 == 엔터 역할) 
		System.out.printf("3은 짝수? %b\n", 3 % 2 == 0);
		System.out.printf("4는 짝수? %b\n", 4 % 2 == 0);
		System.out.printf("6은 짝수? %b\n", 6 % 2 != 1);
		

		System.out.println("\n[홀수 검사]");
		// 홀수 == 2로 나누었을 때 나머지가 1인 수
		//      == 2로 나누었을 때 나머지가 0이 아닌 수

		System.out.printf("12345는 홀수? %b\n", 12345 % 2 == 1);
		System.out.printf("432는 홀수? %b\n", 432 % 2 != 0);
		
		
		System.out.println("---------------------------------");
		
		System.out.println("[3의 배수 검사]");
		
		// 3의 배수 == 3으로 나누었을 때 나머지가 0인 수
		System.out.printf("12341234는 3의 배수? %b \n", 12341234 % 3 == 0);
		System.out.printf("999는 3의 배수? %b \n", 999 % 3 == 0);

		
		System.out.println("\n[13의 배수 검사]");
		// 13의 배수 == 13으로 나누었을 때 나머지가 0인 수
		
		System.out.printf("3913은 13의 배수? %b \n", 3913 % 13 == 0);
		System.out.printf("3913은 13의 배수? %b \n", 3913 % 13 != 1);
		
		
		
		
		
	}
	
}
