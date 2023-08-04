package edu.kh.control.condition.ex;

import java.util.Scanner;

// 실행 기능 담당 클래스
public class ConditionEx {
	
	public void test1() {
		System.out.println("test1() 수행");		
	}
	
	public void test2() {
		System.out.println("test2() 수행");
	}
 	
	// if 예제 1
	public void ex1() {
		
		// 입력 받은 수가 양수인지 아닌지 검사
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
		if (input > 0) { // input이 0보다 커서 조건식이 true인 경우 수행
			System.out.println("양수입니다");
			System.out.println("ex1() 종료");			
		}
		
		if (input <= 0) {
			System.out.println("양수가 아닙니다.");
			System.out.println("ex1() 끝!");			
		}
	}	// 실행되는 클래스에서 ex1()을 부르면 {}안의 코드들이 실행될 것!
	
	
	// if 예제 2 - if - else
	// if : 조건식이 true인 경우 수행
	// else : 조건식이 false인 경우 수행 (이것 아님 저것!)	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
		if (input > 0) { // 양수인 경우
			System.out.println("양수입니다");
		} 
		
		else { // if 조건식이 false인 경우(양수가 아닌 경우) 수행
			// * else는 조건식을 따로 적지 않는다! *
			System.out.println("양수가 아닙니다");			
		}		
	}
	
	
	// if 예제 3 - 중첩 if문	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
//		if (input < 0) {
//			System.out.println("음수입니다.");
//		} else if (input > 0) {
//			System.out.println("양수입니다.");
//		} else {
//			System.out.println("0입니다.");
//		}
		
		if (input > 0) {
			System.out.println("양수 입니다.");
		} else { // 양수가 아닌 경우(0, 음수)
			
			//중첩 if문
			if (input == 0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("음수 입니다.");
			}		
		}
		
		
	}
		
	
	// if 예제 4 - if - else if - else
	public void ex4() {
		
		// 달(월)을 입력 받아 해당 달의 계절을 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월)을 입력해주세요 : ");
		int month = sc.nextInt();
		
		String season;

		if (month >= 3 && month <= 5) { // 봄 (3,4,5)
			season = "봄";
		} else if (month >= 6 && month <= 8) {
			season = "여름";
		} else if (month >= 9 && month <= 11) {
			season = "가을";
		} else if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else {
			season = "you put the wrong number";
		}
		
		// 결과 출력
		System.out.println(season);
		
		// **********************************************
		// 선언된 변수(지역 변수)는
		// 반드시 사용되기 전 초기화가 되어있어야 한다!
		// **********************************************
		
	}
	
	
	// if 예제 5
	public void ex5() {
		// 나이를 입력 받아
		// 13세 이하면 "어린이"
		// 13세 초과, 19세 이하면 "청소년"
		// 19세 초과는 "성인"
		// 0세 미만, 100세 초과는 "잘못 입력"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
//		String result;

//		if (age < 0 || age > 100) {
//			result = "잘못 입력";
//		} else if (age <= 13) {
//			if (age <= 7) {
//				result = "유아";
//			} else {
//				result = "어린이";				
//			}
//		} else if (age <= 19) {
//			result = "청소년";
//		} else {
//			result = "성인";
//		}
//		
//		System.out.println(result);

		
//		if (age >= 0 && age <= 13) {
////			System.out.println("어린이");
//			result = "어린이";
//		} else if (age > 13 && age <= 19) {
//			result = "청소년";
//		} else if (age > 19 && age <= 100 ) {
//			result = "성인";
//		} else {
//			result = "잘못 입력";
//		}
//		
//		System.out.println(result);
		
		
		// *** 쌤 풀이
		String result; // 결과 저장 변수 선언

		if (age  < 0 || age > 100) {
//			System.out.println("잘못 입력");
			result = "잘못 입력";
			
		} else { // 잘 입력함
			
			if (age <= 13) {		
//			System.out.println("어린이");
			result = "어린이";
			
		} else if (age <= 19) {
//			System.out.println("청소년");
			result = "청소년";
			
		} else 
//			System.out.println("성인");
			result = "성인";
		}
		
		System.out.println(result);
	
	}	
	

	// if 예제 6
	
	public void ex6() {
		
	      // 놀이기구 탑승 제한 검사
	      
	      // 나이가 12세 이상, 키 140.0cm 이상일 경우에만 "탑승 가능"
	      // 나이가 12세 미만 : "적정 연령이 아닙니다."
	      // 키 140.0cm 미만  : "적정 키가 아닙니다."
	      // 나이를 0세 미만 또는 100세 초과 입력 시 : "잘못 입력 하셨습니다."
	      
	      // [실행화면]
	      // 나이 입력 : 15
	      // 키 입력 : 170.5
	      // 탑승 가능
	      
	      /* 나이 제한 */
	      // 나이 입력 : 10
	      // 키 입력 : 150.5
	      // 적정 연령이 아닙니다.
	      
	      /* 키 제한 */
	      // 나이 입력 : 12
	      // 키 입력 : 135.3
	      // 적정 키가 아닙니다.
	      
	      /* 나이 0 미만 또는 100 초과 */
	      // 나이 입력 : 120
	      // 키 입력 : 183.3
	      // 잘못 입력 하셨습니다.
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();

		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
//		String result;
//		
//		if (age < 0 || age > 100) {
//			result = "잘못 입력 하셨습니다.";
//			
//		} else {
//			
//			if (age >= 12 && height >= 140.0) {
//				result = "탑승 가능";
//			
//			} 
//			  else {
//				
//				if (height < 140.0) { 
//					result = "적정 키가 아닙니다.";
//					
//				} else  {
//					result = "적정 연령이 아닙니다.";			
//				} 
//			}
//		}	
//		System.out.println(result);		
//		
//		
//		
//		쌤 풀이. 첫 문장부터 ㄱㄱ
//		if(age >= 12 && height >= 140.0) {
//			System.out.println("탑승 가능");
//		} 
//		
////		else 라고 쓰면 첫 if를 만족시키지 못하는 모든 상황이기 때문에 다시 새로운 조건을 건다 
//		else if(age < 12) {
//			System.out.println("적정 연령이 아닙니다.");
//			
//		} else if(height < 140.0) {
//			System.out.println("적정 키가 아닙니다.");
//	
//		} else {
//			System.out.println("잘못 입력하셨습니다.");
//		} 	//위에있는 모든게 아닌 상황들을 한번에 묶어서해봄 -> 첫문장에서 상한수를 제한하지 않아서 오류!
		
		// 조건문에서는 조건들 중 뭘 먼저 따져볼지를 정리하고 문제를 푸는 것이 좋다.
		// 일반적으로 안되는것들을 먼저 처리. 그 중에서도 조건식이 쉬운것들 먼저 ㄱㄱ
		
	
		if (age < 0 || age > 100) {
			System.out.println("잘못 입력 하셨습니다.");
			
		} else if(age < 12) {
			System.out.println("적정 연령이 아닙니다.");

		} else if(height < 140.0) {
			System.out.println("적정 키가 아닙니다.");
			
		} else {
				System.out.println("탑승 가능");
			} 
		
		
	}

}
