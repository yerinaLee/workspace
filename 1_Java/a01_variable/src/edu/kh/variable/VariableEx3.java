package edu.kh.variable;

// import : 수입하다, 가져오다
import java.util.Scanner;

public class VariableEx3 {

	
	public static void main(String[] args) {
		
		
		// Scanner : 사용자 입력 시 필요 (객체)
		
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		// print : 출력 후 줄바꿈 X
		// println : 출력 후 줄바꿈(개행) O
		System.out.print("입력 : ");
		
		int input = sc.nextInt(); // 키보드에서 정수 입력 받은 후
								  // int형 변수 input에 대입

		System.out.println("입력 받은 값: " + input);
		
	}
	
	
}
