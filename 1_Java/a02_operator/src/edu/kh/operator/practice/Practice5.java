package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korea = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		
		// 합계
		int sum = korea + eng + math;

		// 평균
//		double average = ((double)korea + eng + math) / 3.0; / 내가쓴거! 단순하게갑시당
		double average = sum / 3.0;
		// int / doublt
		// doublt(자동형변환) / double = double
		
		String result =
				((korea >= 40 && eng >= 40 && math >= 40) && average >= 60) 
					? "합격" : "불합격"; 

		System.out.println("\n합계 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println(result);
				
		
		
	}

}
