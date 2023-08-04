package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int count = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
//		int result1 = candy / count ; 
//		int result2 = candy % count ; 
//		
//		System.out.println("\n1인당 사탕 개수 : " + result1);
//		System.out.println("남는 사탕 개수 : " + result2);
		
		System.out.printf("\n1인당 사탕 개수 : %d\n", candy / count);
		System.out.printf("남는 사탕 개수 : %d", candy % count);
		
	}

}
