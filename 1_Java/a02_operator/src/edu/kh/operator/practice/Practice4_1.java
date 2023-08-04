package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice4_1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
//		String result = ( age <= 13 ) ? "어린이" :
//			((age > 13 && age <= 19) ? "청소 년" : "성인");
//			((age > 19) ? "성인" : "청소년"); // 성인의 조건이 더 짧기에 보다 효율적!
			
		// age > 13 && age <= 19 : 청소년 조건
		// age > 19 : 성인 조건
		
		String result = 
				( age <= 13 ) ? "어린이" : (age <= 19 ? "청소년" : "성인");
		// 앞선 조건에서 이미 13 이하의 범위를 제한했기에 두번째 삼항조건식은 보다 간단하게 작성해도 ok

		// age가 15인 경우
		// 어린이를 찾는 조건 (age <= 13)을 만족하지 못하므로
		// 이후에는 age가 13이하인 경우를 범위에서 제외하면 된다.
		
		// -> 청소년을 찾는 조건 age <= 19 라고만 작성해도
		// 13 이하를 제외하기 때문에
		// age > 13 && age <= 19 조건과 동일한 조건이 성립한다.
		
		System.out.print("\n" + result);
		
//		영유아, 노인, 200세 ㅋㅋㅋㅋㅋ, 마이너스 등은 잘못 입력했습니다 적어보세요
//		실수를 적는것도 바꿔보기
		
	}

}
