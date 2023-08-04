package edu.kh.operator.ex;
import java.util.Scanner;

public class OperatorEx4 {
	
	public static void main(String[] args) {

		/* [배수 확인 프로그램]
		 * 확인할 수 : 15
		 * 배수 : 4
		 * 
		 * 15는 4의 배수? false	 
		 * 
		 * ------------------------------
		 * 확인할 수 : 16
		 * 배수 : 4
		 * 
		 * 16는 4의 배수? true	 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[배수 확인 프로그램]");
		System.out.print("확인할 수 : ");
		int input1 = sc.nextInt();
		
		System.out.print("배수 : ");
		int input2 = sc.nextInt();

		// 결과 저장
		boolean result = input1 % input2 == 0;
		
		System.out.printf("\n%d는 %d의 배수? %b\n", input1, input2, result );			
		
	}

}
