package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {
	
	// ConditionEx
	
	public Scanner sc = new Scanner(System.in);
	
	public void ex5() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if (age < 0 || age > 100) {
			System.out.println("잘못 입력");
		} else if(age <= 13) {
			System.out.println("어린이");
		} else if (age <= 19) {
			System.out.println("청소년");
		} else if (age > 19) {
			System.out.println("성인");
		}
	}
	
	
	
	
	
	
	
}
