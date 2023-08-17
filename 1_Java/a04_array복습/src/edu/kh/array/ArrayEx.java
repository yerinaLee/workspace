package edu.kh.array;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx {
	
	// ArrayEx1
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	
	public void ex3() {

		double[] height = new double[3];
		double sum = 0;
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d 번째 키 입력 : ", i+1);
			height[i] = sc.nextDouble();
		}
		
		for (int i = 0; i < height.length; i++) {
			System.out.println((i+1) + "번째 키 : " + height[i] + "cm");
			sum += height[i];
		}
		
		System.out.printf("평균 키 : %.2f", sum/3.0);
	}
	
	
	
	public void ex4() {
		
		String[] menu = { "김밥", "순대", "떡볶이", "국밥", "오징어순대", "감자전", "막걸리" };
		
		int index = random.nextInt(menu.length);
		
		System.out.println("오늘의 메뉴 : " + menu[index]);
	}
	
	
	public void ex5a() {
		
		String[] menus = { "야채김밥", "꼬마김밥", "라면", "라볶이", "갈비만두" };
		int[] prices = {3500, 2000, 4000, 5500, 5000};
		
		int[] counts = new int[menus.length];    // 이거 왜필요함?
		int sum = 0; // 주문한 메뉴의 가격 저장 변수
		
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println("|  Welcome 분식  |");
		System.out.println("~~~~~~~~~~~~~~~~~~\n");
		
		while(true) {
			System.out.println("++ 메뉴들 골라골라 ++");
			
			for(int i = 0; i < menus.length; i++) {
				
				String temp = prices[i] / 1000 + "," + (prices[i] % 1000 != 0 ? prices[i] % 1000 : "000");
				
				System.out.println(i + ". " + menus[i] + " " + temp + "원");
			}
			
			System.out.println("9. 주문 완료");
			System.out.println("------------------------");
			
			System.out.print("주문메뉴번호 : ");
			int select = sc.nextInt();
			
			System.out.println();
			
			if(select == 9) break;
			
			else if (select < 0 || select >= menus.length) {
				System.out.println("잘못 입력");
			}
			
			else {
				counts[select]++;
				sum += prices[select];
			}
		}
		
		System.out.println("==== 주문한 메뉴 ====");
		
		for(int i = 0; i < menus.length; i++) {
			
			if(counts[i] > 0) {
				String temp = prices[i] / 1000 + "," + (prices[i] % 1000 != 0 ? prices[i] % 1000 : "000");
				System.out.printf("%s(%s원) %d개\n", menus[i], temp, counts[i]);
			}
		}
		
		String temp = sum/1000 + "," + (sum % 1000 != 0 ? sum%1000 : "000");
		System.out.println("총 주문금액은 " + temp + "원 입니다.");
		
	}
	
	
	// ArrayEx2
	
	public void ex2() {
		
		char[][] arr = { {'a', 's', 'd'},
						{'z', 'x', 'c'},
						{'f', 'g', 'h'}	};
		
		System.out.print("알파벳 입력 ㄱㄱ : ");
		char input = sc.next().charAt(0);
		
		boolean flag = true;
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr.length; col++) {
				
				if(input == arr[row][col]) {
					System.out.printf("%c와/과 일치하는 알파벳은 %d열, %d행에 있습니다.", input, row, col);
					flag = false;
				} 
			}
		}
		
		if (flag) {
			System.out.println("일치하는 검색결과가 없습니다.");
		}
		
	}
	
	

	
	

}
