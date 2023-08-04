package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		
		String result = age < 0 ? "기원전에 태어나셨나요? 다시 입력해주세요!" : 
				((age < 4) ? "영유아" : 
					(age <= 13) ? "어린이" :
						(age <= 19) ? "청소년" :
							(age <= 130) ? "성인" : "와우! 기네스북에 오르시겠군요! 다시 입력해주세요!");
					
		System.out.println(result);
		
		
// 		음수 : age > 0
//		영유아 : age >= 0 && age < 4
//		어린이 : age <= 13
//		청소년 : age <= 19
//		성인 : age <= 130
//		130세이상 : 
		
		
		
	}

}
