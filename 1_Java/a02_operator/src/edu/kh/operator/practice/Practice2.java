package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

//		String result = input > 0 ? "양수" : "양수 아님";
//		System.out.println("\n" + result);
		
		System.out.println("\n" + (input > 0 ? "양수" : "양수 아님") );
		
	}
	

}
