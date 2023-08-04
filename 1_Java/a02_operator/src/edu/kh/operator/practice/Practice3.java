package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String result = 
				input == 0 ? "0" : (input > 0 ? "양수" : "음수");
		System.out.print(result);

//		System.out.println(input == 0 ? "0" : (input > 0 ? "양수" : "음수"));
			// 이렇게 한줄도 가능하지만 풀어서 직관적으로 쓰는 것을 보다 선호
		
		
		
	}

}
