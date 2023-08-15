package edu.kh.control.loop.ex;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LoopEx {
	
	Scanner sc = new Scanner(System.in);
	
	
	//for 예제 5 - 1부터 10까지 정수의 합 구하기
	public void ex5() {
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
		
		
		
		
		
	// for 예제 7
	// 3부터 30까지 3씩 증가하며 출력
	// + 출력되는 수들의 합을 마지막에 출력
	public void ex7() {
		
		int sum = 0;
		
		for(int i = 3; i <= 30; i+=3) {
			
			System.out.print(i + " ");
			sum += i;
			
		}
			
		System.out.println("\n출력된 모든 수의 합 : " + sum);
	}
	
	
	// 시작, 끝, 증가할 수를 입력 받아
	// 지정된 범위까지 모두 출력 후
	// 합계도 출력
	
	// 시작 : 1
	// 끝 : 5
	// 증가할 수 : 2
	// 1 3 5
	// 합계 : 9
	public void ex8() {
		
		System.out.print("시작 : ");
		int start = sc.nextInt();
		
		System.out.print("끝 : ");
		int end = sc.nextInt();
		
		System.out.print("증가할 수 : ");
		int add = sc.nextInt();
		
		int sum = 0;
		
		for (int i = start; i <= end; i+=add) {
			System.out.print(i + " ");
			sum += i;
		}
		
		System.out.println("\n합계 : " + sum);
	}


	// 1부터 10까지 모든 정수 출력
	// 단, 짝수는 [] 감싸서 출력
	
	// 1 [2] 3 [4] 5 [6] 7 [8] 9 [10]	
	public void ex9() {
		
		for(int i = 1; i<=10; i++) {
			if(i % 2 == 0) {
				System.out.printf("[%d] ", i);
			} else {
				System.out.print(i + " ");
			}
		}
	}

	
	// 1부터 10까지 모든 정수 출력
	// 단, 홀수는 () 감싸서 출력
	// + 1은 "시작" 10은 "끝"이라고 출력

	// 시작 2 (3) 4 (5) 6 (7) 8 (9) 끝 
	public void ex10() {
		
		for(int i = 1; i<= 10; i++) {
			
			if (i == 1) {
				System.out.print("시작 ");
			} else if ( i == 10 ) {
				System.out.print("끝 ");
			} else if(i % 2 == 1) {
				System.out.printf("(%d) ", i);
			} else {
				System.out.print(i + " ");
			}
		}
	}
	
	// 1부터 20까지 1씩 증가하는 반복문을 이용해
	// 짝수의 합, 홀수의 합
	public void ex11() {
		
		int sum1 = 0; // 짝수
		int sum2 = 0; // 홀수
		
		for(int i = 1; i<= 20; i++) {
			if (i % 2 == 0) sum1 += i;
			else sum2 += i;
		}
		
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);
	}
	
	
	// (1부터 100까지 1씩 증가하는 반복문을 이용)
	// 1~100사이 수 중
	// 입력받은 수의 배수를 뺀 나머지 수의 합을 출력
	public void ex12() {
		
		
		System.out.print("입력 : ");
		int num = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i % num != 0) {
				result += i;
			}			
		}
		
		System.out.println(result);
	}
	
	
	// LoopEx2
	
	// 구구단 2단 출력하기
	// 2 x 1 = 2
	// 2 x 2 = 4
	// 2 x 3 = 6
	// 2 x 4 = 8
	// 2 x 5 = 10
	// 2 x 6 = 12
	// 2 x 7 = 14
	// 2 x 8 = 16
	// 2 x 9 = 18
	public void ex1() {
		
		for(int i = 1; i<= 9; i++) {
			System.out.printf("%d x %d = %d\n", 2, i, 2*i);
		}
		
	}
	
	// (0,0) (0,1) (0,2)
	// (1,0) (1,1) (1,2)	
	public void ex28() {
		
		for(int row = 0; row <=1; row++) {
			
			for(int col = 0; col <= 2; col++) {
				
				System.out.printf("(%d, %d) ", row, col);
			}
			System.out.println();
		}
	}
		
	
	// 구구단 9단부터 2단까지 거꾸로 출력하기
	public void ex210() {
		
		for(int dan = 9; dan >= 2; dan--) {
			
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i );
			}
			System.out.println();
		}
	}
	
	/* count 변수 이용하기 */
	// 1 2 3
	// 4 5 6
	// 7 8 9
	public void ex212() {
		
		int count = 1;
		
		for(int row = 1; row <= 3; row++) {
			
			for(int col = 1; col <= 3; col ++) {
				System.out.print(count + " ");
				count ++;
			}
			
			System.out.println();
		}
	}
	
	// 3 6 9 12
	// 15 18 21 24
	// 27 30 33 36
	public void test() {
		int count = 3;
		
		for(int row = 1; row <= 3; row++) {
			
			for(int col = 1; col <= 4; col ++) {
				System.out.print(count + " ");
				count += 3;
			}
			
			System.out.println();
		}	
	}
		
	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	public void ex13() {
		// 단일 for문 + if문
		
		for(int i = 1; i <= 12; i++) {
			System.out.print(i + " ");
			if (i % 4 == 0) {
				System.out.println();
			}
		}
		
	}
			
	// 행/열의 크기를 입력 받아 출력하기 + count	
	public void ex14() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 : ");
		int row = sc.nextInt();
		
		System.out.print("열 : ");
		int col = sc.nextInt();
		
		int count = 0;
		
		for( ; row >= 1 ; row--) {
			
			for( ; col >= 1 ; col--) {
				
				System.out.print(++count + " ");
				
			}
			
			System.out.println();
		}
	}
	
	
	// 1
	// 12
	// 123
	// 1234
	public void ex15() {
		
		for(int row = 1; row <= 4; row++) {
			
			for(int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
		
	
	// 1 2 3 4
	// 1 2 3 
	// 1 2
	// 1
	public void ex16() {
		
		for(int row = 4; row >= 1; row--) {
			for(int col = 1; col <= row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	// 4 3 2 1
	// 3 2 1
	// 2 1
	// 1
	public void ex17() {
		
		for(int row = 4; row >= 1; row--) {
			
			for(int col = row ; col >= 1; col--) {
				
				System.out.print(col + " ");
				
			}
			
			System.out.println();
			
		}
	}
		
	
	// 4 
	// 4 3
	// 4 3 2
	// 4 3 2 1
	public void ex18() {
		for(int row = 4; row >= 1; row--) {
			for(int col = 4; col >= row; col--) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	
	// LoopEx3
	
	
	// 숫자 0이 입력될때까지 프로그램 종료 x
	// + 0이 입력되기 전까지 입력된 모든 숫자의 합 출력
	public void ex2() {
		
		int input = -1;
		int sum = 0;
		
		while( input != 0 ) {
			
			System.out.print("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
			
		}
		System.out.println("합계 : " + sum);
	}
	
	
	// 분식집 주문 프로그램
	
	public void ex3() {
		
		int menu = 0;
		int sum = 0;
		String total = "";
		
		
		while (menu != 9) {
			
			System.out.println("\n**** 분식점 주문하기 ****");
			
			System.out.println("1. 꼬마김밥 / 1500원");
			System.out.println("2. 야채김밥 / 3000원");
			System.out.println("3. 라볶이 / 6000원");
			System.out.println("4. 만두 / 5000원");
			System.out.println("9. 주문 종료");
			
			System.out.println("----------------------");
			System.out.print("주문 메뉴번호 : ");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1 : total += " 꼬마김밥"; sum += 1500; break;
			case 2 : total += " 야채김밥"; sum += 3000; break;
			case 3 : total += " 라볶이"; sum += 6000;  break;
			case 4 : total += " 만두"; sum += 5000;  break;
			case 9 : System.out.println("주문을 종료합니다."); break;
			default : System.out.println("1~4번의 메뉴 번호를 입력해주세요.");
			}
		}
		System.out.println("\n주문하신 메뉴는"+ total + " 이며");
		System.out.println("가격은 총 " + sum + "원 입니다.");
		
	}
			
	
	// LoopPractice
		
	public void practice3() {
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		int count = 0;
	
		for(int i=1; i <= input; i++) {
			sum += i;
			System.out.print(i);
			
			if(i < input) {
				System.out.print(" + ");
			} else {
				System.out.print(" = ");
			}
		}
		System.out.println(sum);
		
	}
	
	
	public void practice4() {
		
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		if(input1 < 1 || input2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			
			int tmp = 0;
			
			if (input1 > input2) {
				tmp = input1;
				input1 = input2;
				input2 = tmp;
			}
			
			for( ; input1 <= input2; input1++) {
				System.out.print(input1 + " ");
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
