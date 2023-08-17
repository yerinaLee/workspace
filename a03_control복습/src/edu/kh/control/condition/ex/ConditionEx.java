package edu.kh.control.condition.ex;

import java.util.Random;
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
	
	
	public void ex6() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		if (age < 0 || age > 100)System.out.println("잘못 입력 하셨습니다.");
		else if (age < 12) System.out.println("적정 연령이 아닙니다.");
		else if (height < 140.0) System.out.println("적정 키가 아닙니다.");
		else System.out.println("탑승 가능");
	}
	
	
	// SwitchEx
	
	Random random = new Random();
	
	public void ex2() {
		
		int ran = random.nextInt(5) + 1;
		
		String menu = null;
		
		switch(ran) {
		case 1 : menu = "돈까스"; break;
		case 2 : menu = "냉면"; break;
		case 3 : menu = "냉삼"; break;
		case 4 : menu = "라면"; break;
		case 5 : menu = "샌드위치"; break;
		}
		
		System.out.println(menu);
	}
	
	
	public void ex4() {
		
		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();

		System.out.print("연산자 : ");
		String cal = sc.next();

		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();

		int sum = 0;
		boolean flag = false;
		
		switch(cal) {
		case "+" : sum = num1+num2; break;
		case "-" : sum = num1-num2; break;
		case "/" : sum = num1/num2; break;
		case "*" : sum = num1*num2; break;
		case "%" : sum = num1%num2; break;
		default : flag = true;
		}
		
		if(flag) {
			System.out.println("잘못된 입력입니다.");
		} else {
			System.out.printf("%d %s %d = %d", num1, cal, num2, sum);
		}
	}
	
	public void ex55() {
		
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		String season = "";
		
		switch(month) {
		case 12 : case 1 : case 2 : season = "겨울"; break;
		case 3: case 4: case 5: season += "봄"; 
		case 6: case 7: case 8: season += "여름";
		case 9: case 10: case 11: season += "가을";
		}
		
		System.out.println(season);
	}
	
	
	// ConditionPractice
	
	public void practice1() {
		
		System.out.print("수를 입력해주세요 : ");
		int num = sc.nextInt();
		
		if( num <= 0 ) {
			System.out.println("양수만 입력해주세요.");
		} else if ( num % 2 == 0 ) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
	}
	
	
	
	public void practice2() {
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int total = kor+eng+math;
		
		if (total >= 60 && kor >= 40 && eng >= 40 && math >= 40) {
			System.out.printf("국어 : %d, 영어 : %d, 수학 : %d\n", kor, eng, math);
			System.out.printf("합계 : %d, 평균 : %.2f\n", total, total/3.0);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	
	public void practice5() {
		
		System.out.print("중간고사 점수 : ");
		int mid = sc.nextInt();
		
		System.out.print("기말고사 점수 : ");
		int fin = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		int task = sc.nextInt();
		
		System.out.print("출석 횟수 : ");
		int attend = sc.nextInt();
		
		System.out.println("========결과========");
		
		
		double total = mid*0.2 + fin*0.3 + task*0.3 + attend;
		
		if(total < 70 || attend < 20*0.7 ) {
			System.out.println("Fail");
		} else {
			System.out.println("Pass!!! congratulations!");
		}
		
		
		
	}
	
	
	
	
	
	
	
}
