package edu.kh.operator.ex;
import java.util.Scanner;

public class OperatiorEx1 {
	
	public static void main(String[] args) {
		
		// 산술 연산자
		// + - * / %(modulo, mod, 나머지 연산)
		
		// 두개의 수를 입력받아 + = * / % 연산 결과를 모두 출력
		
		// [예시] (설계)
		// 정수 입력 1 : 5
		// 정수 입력 2 : 2

		// 5 + 2 = 7
		// 5 - 2 = 3
		// 5 * 2 = 10
		// 5 / 2 = 2.5
		// 5 % 2 = 1
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 입력 1 : ");
		int input1 = sc.nextInt();
	
		System.out.print("정수 입력 2 : ");
		int input2 = sc.nextInt();

		System.out.println(); // 줄바꿈 (개행)
				
		System.out.println(input1 + " + " + input2 + " = " + (input1 + input2));

		int minusResult = input1 - input2; // 입력받은 값의 - 결과를 저장
		System.out.println(input1 + " - " + input2 + " = " + (input1 - input2));
		System.out.println(input1 + " - " + input2 + " = " + minusResult);

		// * 연산 (printf 사용)
		// %d : 10진수 정수가 들어오는 칸
		// %f : 10진수 실수가 들어오는 칸

		// %.1f : 소수점 아래 1자리
		// %.2f : 소수점 아래 2자리
		// %.3f : 소수점 아래 3자리
		
		// System.out.printf("빈칸이 포함된 문자열" , 빈칸에 들어갈 값 );
		System.out.printf("%d x %d = %d" , input1, input2, input1 * input2 );

		System.out.println(); // 줄바꿈(개행)
		
		// / 연산		
//		System.out.printf("%d / %d = %d" , input1, input2, input1/input2); = 2

		System.out.printf("%d / %d = %.1f" , input1, input2, (double)input1/input2);
		System.out.println(); // 줄바꿈(개행)

		// [5 / 2의 결과가 2.5가 아닌 2인 이유]
		// 컴퓨터의 값처리 원칙에 의해
		// int / int의 결과는 int형이 된다
		// 그래서 5 /2의 결과는 (int)2.5의 결과 2가 된다.
		
		// [5 / 2의 결과를 2.5로 나오게 하려면...]
		// input1 또는 input2를 (double)로 강제형변환 시킨다.
		// 왜? 
		// (double)input1 / input2
		// -> double / int -> double / double(자동 형변환)
		
		
		// % (나머지) 연산 -> 몫이 정수로 다 나눠진 후 나머지가 출력됨(실수는 나눠지지 않음)
		System.out.printf("%d %% %d = %d", input1, input2, input1 % input2);
		// %% -> printf에서 문자열 "%"를 의미하는 기호
		
		
		
		
	}

}
