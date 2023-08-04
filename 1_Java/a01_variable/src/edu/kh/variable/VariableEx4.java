package edu.kh.variable;
import java.util.Scanner;

public class VariableEx4 {
	
	public static void main(String[] args) {
		
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[정수 덧셈 계산기]");
		
		System.out.print("입력 1 : ");
		int input1 = sc.nextInt(); // 입력 받은 정수를 input1에 대입
		
		System.out.print("입력 2 : ");
		int input2 = sc.nextInt(); // 입력 받은 정수를 input2에 대입

		System.out.print("입력 3 : ");
		int input3 = sc.nextInt(); // 입력 받은 정수를 input2에 대입

		System.out.println(input1);
		System.out.println(input2);
		System.out.println(input3);
		
		// input1, input2를 더한 값을 int형 변수 result에 대입
		int result = (input1 + input2) * input3; 
		
		System.out.println("결과 : " + result);
		
	}

}
