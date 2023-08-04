package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	// 실습문제 1	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
//		String result;
//		
//		if (input <= 0) {
//			result = "양수만 입력해주세요.";
//		} else {			
//			if (input % 2 == 0) {
//				result = "짝수입니다.";
//			} else {
//				result = "홀수입니다.";
//			}
//		}
//		System.out.println(result);		
		
		
		// 쌤 풀이
		if(input > 0 && input % 2 == 0) { // 양수 + 짝수
			System.out.println("짝수 입니다.");
		} else if (input > 0 && input % 2 != 0) { // 양수 + 홀수
			System.out.println("홀수 입니다.");
		} else {
			System.out.println("양수만 입력해주세요.");
		}
		
		
		if(input > 0) { // 양수
			
			if(input % 2== 0) {
				System.out.println("짝수 입니다.");
			} else {
				System.out.println("홀수 입니다.");				
			}
			
		} else { // 양수 아님
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	
	// 실습문제 2
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		// 합계
		int sum = kor + math + eng;
		
		// 평균
		double avg = sum / 3.0;
		
		// 합격 여부
		if(avg >= 60 && kor >= 40 && math >= 40 && eng >= 40) {
//			System.out.printf("국어 : %d\n"
//					+ "수학 : %d\n"
//					+ "영어 : %d\n"
//					+ "합계 : %d\n"
//					+ "평균 : %.1f\n"
//					+ "축하합니다, 합격입니다!", 
//					kor, math, eng, sum, avg); //너무광기같다^_^
			
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);			
			
		} else { // 불합격
			System.out.println("불합격입니다.");
		}		
	}
	
	
	// 실습문제 3	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
//		switch(month) {
//		case 2 : System.out.printf("%d월은 28일까지 있습니다."); break;
//		case 1 : case 3 :  case 5 : case 7 : case 8 : case 10: case 12 : System.out.printf("%d월은 31일까지 있습니다.", month); break;
//		case 4 :  case 6 : case 9 : case 11 : System.out.printf("%d월은 30일까지 있습니다.", month); break;
//		default : System.out.printf("%d월은 잘못 입력된 달입니다.", month);
//		}		

		// 쌤 풀이
		int day = 0; // 해당하는 달의 마지막 일(날짜)을 저장
					// 단, 1~12월이 아니면 0을 저장
		
		switch(month) {
		case 1 : case 3 :  case 5 : case 7 : case 8 : case 10: case 12 : day = 31; break;
		
		case 4 :  case 6 : case 9 : case 11 : day = 30; break;
		
		case 2 : day = 28; break;
		
//		default : day = 0 ;
		}
		
		if (day == 0) { // 1~12사이가 입력되지 않았을 때
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		} else { // 1~12사이가 입력되었을 때
			System.out.printf("%d월은 %d일까지 있습니다.", month, day);
		}
	}
		
	
	// 실습문제 4	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();		
		
		double bmi = weight / (height * height);
		String result;
		
		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 23) {
			result = "정상체중";
		} else if (bmi < 25) {
			result = "과체중";
		} else if (bmi < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
	
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}
	
	
	// 실습문제 5	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int midex = sc.nextInt();

		System.out.print("기말 고사 점수 : ");
		int finex = sc.nextInt();

		System.out.print("과제 점수 : ");
		int task  = sc.nextInt();

		System.out.print("출석 횟수 : ");
		int time  = sc.nextInt();
		
//		double midscore = midex * 0.2;
//		double finscore = finex * 0.3;
//		double taskscore = task * 0.3;
//		
//		double score = midscore + finscore + taskscore + time;
//		
//		
//		System.out.println("================= 결과 =================");
//		if (time < 20*0.7) {
//			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", time);
//		} else  {
//			System.out.printf("중간 고사 점수(20) : %.1f\n", midscore );
//			System.out.printf("기말 고사 점수(30) : %.1f\n", finscore );
//			System.out.printf("과제 점수       (30) : %.1f\n", taskscore );
//			System.out.printf("출석 점수       (20) : %.1f\n", (double)time);
//			System.out.printf("총점 : %.1f\n", score);
//			
//
//			if (score >= 70) {
//				System.out.println("Pass");					
//			} else {
//				System.out.println("Fail [점수 미달]");
//			}		
//		}
		
		
		// 쌤 풀이
		
		System.out.println("================= 결과 =================");
		
		// 출석 횟수가 부족한 경우 (14회 이하)
		if (time <= 20 * (1 - 0.3)) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", time);
		} else { // 출석은 잘 했을 때
			
			// 점수 환산
			double midscore = midex * 0.2;
			double finscore = finex * 0.3;
			double taskscore = task * 0.3;
			double attScore = time * 5 * 0.2; // == attendance

			
			// 총점
			double score = midscore + finscore + taskscore + attScore;
			
			System.out.printf("중간 고사 점수(20) : %.1f\n", midscore );
			System.out.printf("기말 고사 점수(30) : %.1f\n", finscore );
			System.out.printf("과제 점수     (30) : %.1f\n", taskscore );
			System.out.printf("출석 점수     (20) : %.1f\n", attScore);
			System.out.printf("총점 : %.1f\n", score);
			
			if (score >= 70) {
				System.out.println("PASS");					
			} else {
				System.out.println("Fail [점수 미달]");
			}		
			
		}
		
	}


}
