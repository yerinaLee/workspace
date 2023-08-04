package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		int count = 0;
		
		if (input >= 1) {
			for ( ; input >= 1; input--) {
				
				count ++;
				System.out.print(count + " ");
				
			}			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		int count = 0;
		
		if (input >= 1) {
			for ( ; input >= 1; input--) {
				
				System.out.print(input + " ");
				
			}			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		
		
		
	}

	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		int count = 0;
		
//		for ( ; input >= 1; input--) {		
//			
//			if(input != 1) {
//				count++;
//				System.out.print(count);		
//				System.out.print(" + ");
//				sum += count;				
//			} else {
//				count++;
//				System.out.print(count);		
//				System.out.print(" = ");
//				sum += count;	
//			}			
//		}
//		System.out.print(sum);
		
		
		// 쌤 풀이 아이고 엄청우아하다
		for(int i=1; i <= input; i++) {
			
			sum += i;
			System.out.print(i);
			
			if(i < input) {
				System.out.print(" + ");
			} 			
		}		
		System.out.println(" = " + sum);		
		
	}	
	
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
//		if ( num1 > 1 && num2 > 1 ) {
//			
//			if (num1 > num2) { // num1이 num2보다 큰 경우
//				for(int i = num2; num2 <= num1; num2++) {
//					System.out.print(num2 + " ");				
//				}
//			} else if (num1 < num2) { // num1보다 num2가 큰 경우
//				for(int i = num1; num1 <= num2; num1++) {
//					System.out.print(num1 + " ");
//				}				
//			} else {
//				System.out.println(num1);
//			}
//					
//		}else {
//			System.out.println("1 이상의 숫자를 입력해주세요");
//		}
		
		
		// 쌤 풀이
		// 입력 받은 두 수가 모두 1 이상인가?
		
		// 생각을 좀 해봐야하는 방법 + 변수를 아는가?

		if( num1 > num2 ) {
			// 먼저 입력한 수가 더 큰 경우			
			// 두 변수의 값 교환(임시 변수 필요)
			int temp = num1;	
			num1 = num2;			
			num2 = temp;			
		}
		
		for(int i=num1; i<=num2; i++) {
			System.out.print(i + " ");
		}
		
		
		
		/* 방법1. 쉬운 방법
		if(num1 >= 1 && num2 >= 1) {	
			
			// 작은수부터 큰 수까지 1씩 증가하며 반복

			if(num1 <= num2) { // 먼저 입력한 수가 작거나 같을 때
				for (int i = num1; i <=num2; i++) {
					System.out.print(i + " ");
				}
				
			} else { // 나중에 입력한 수가 작을때
				
				for (int i = num2; i <=num1; i++) {
					System.out.print(i + " ");					
				}
			}		
			
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요");			
		} */
		
		
		
		
		
		
		
		
		
	}
	

	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		System.out.printf("==== %d단 ====\n", dan);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);			
		}
		
		
		
	}
	
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();

		if (dan >= 2 && dan <= 9) {
			for (; dan <= 9; dan++) {				
				System.out.printf("==== %d단 ====\n", dan);				
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d\n", dan, i, dan*i);			
				}				
				System.out.println();				
			}				
		} else {
			System.out.println("2~9 사이 숫자만 입력해주세요");			
		}
		
		
		// 쌤 풀이
		
//		if (!(input >=2 && input <= 9)) //2~9 사이가 아닐 경우
//		if ( dan < 2 || dan > 9 ) {  //2~9 사이가 아닐 경우
		
	}	
	
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			
			for (int j = 1; j <= i; j++) {
					
			 System.out.print("*");
				
			}
			
			System.out.println();
			
		}		
	}
	
	public void practice8() {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			
			for (int j = i ; j <= num; j++) {					
				System.out.print("*");				

			}			
			System.out.println();
			
		}
		
		
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			
			for (int s = i; s<=num-1; s++) {
				System.out.print(" ");			
			}			
			
			for (int j = 1; j <= i; j++) {			 
				System.out.print("*");				
			}
			
			System.out.println();
			
		}
		
		
	}
	
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num*2-1; i++) { // 행 5줄 make
			
			if (i <= num) { // 별이 줄어드는 임계점 체크
				
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
				
			} else {
				
				for (int j = i ; j >= num; j--) {
					System.out.print("*");
				}
				System.out.println();				
			}
							
			
		}
	
		
	
	
		}
		
	
	
	
		
}
	
	
	
	
	
	
	

