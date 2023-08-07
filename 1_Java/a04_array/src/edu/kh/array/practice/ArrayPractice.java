package edu.kh.array.practice;

import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	 public void practice1(){		 
		 
		 int[] arr = new int[9];
		 int sum=0;
		 
		 for(int i = 0; i < arr.length ; i++) {
			 
			 arr[i] = i+1;
			 System.out.print(arr[i] + " ");
		 
			 if (i % 2 == 0) {
				 sum += arr[i];
			 }
		 }
		 
		 System.out.println();
		 System.out.println("짝수 번째 인덱스 합 : " + sum);
	 }
	
	 
	 public void practice2( ) {
		
		 int[] arr = new int[9];
		 int sum=0;
		 
		 for(int i = arr.length; i > 0 ; i--) {
			 
			 arr[i-1] = i;
			 System.out.print(arr[i-1] + " ");
		 
			 if ((i-1) % 2 == 1) {
				 sum += arr[i-1];
			 }
		 }
		 
		 System.out.println();
		 System.out.println("홀수 번째 인덱스 합 : " + sum);
		 
		 
		 
		 
		 
		 
	 }
		 
	 
	 public void practice3( ) {
		 
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("양의 정수 : ");
		 int input = sc.nextInt();
		 int[] arr = new int[input];
		 
		 for(int i = 0; i < arr.length ; i++) {
			 
			 arr[i] = i+1;
			 System.out.print(arr[i] + " ");
		 
		 }
	
		 
		 
		 
	 }

	 
	 public void practice4( ) {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 int[] arr = new int[5];
		 
		 for (int i = 0; i < arr.length; i++) {
			 
			 System.out.printf("입력 %d : ", i);
			 int input = sc.nextInt();
			 arr[i] = input;			 
			 
		 }
		 
		 System.out.print("검색할 값 : ");
		 int search = sc.nextInt();
		 
		 boolean flag = true;
		 // true : 검색 결과 없음
		 // false : ﻿검색 결과 존재
		 
		 
		 for (int i = 0; i < arr.length; i++) {
			 
			 if (arr[i] == search) {
				 System.out.println("인덱스 : " + i);
				 
				 flag = false;
			 } 
		 }
		 
		 if(flag) {
			 System.out.println("일치하는 값이 존재하지 않습니다.");
		 }
		 
		 
		 
		 
	 }
	 
	 
	 public void practice5( ) {
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.next();
		
		// 문자열 길이만큼 char[] 생성
		char[] arr = new char[(input.length())];
		
		// 문자열을 하나하나씩 char배열에 대입
		for (int i = 0; i < input.length(); i++) {
			arr[i] = (input.charAt(i));
		}
		
		//문자 검색		
		System.out.print("문자 : ");
		char search = sc.next().charAt(0);
		
		int count = 0;
		
		// 문자와 같은 문자 갯수 세기
		for(int i = 0; i < arr.length; i++) {
			
			if (arr[i]==search) {
				count++;
			}
		}
		
		System.out.printf("application에 %c가 존재하는 위치(인덱스) :  ", search);

		for(int i = 0; i < arr.length; i++) {
			if (arr[i]==search) {
				System.out.print(i + " ");
			}
		}
			
		System.out.println("\ni 개수 : " + count);
		
	 }
	 
	 
	 
	 public void practice6( ) {
		 
		 System.out.print("정수 : ");
		 int input = sc.nextInt();
		 
		 int[] arr = new int[input];
		 
		 for(int i = 0; i < arr.length; i++) {
			 
			 System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			 arr[i] = sc.nextInt();
		 }
		 
		 int sum = 0;
		 for (int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i] + " ");
			 sum += arr[i];
		 }
		 
		 System.out.println("\n총 합 : " + sum);
		 
		 
		 
		 
		 
	 }
	 
	 public void practice7( ) {
		 
		 System.out.print("주민등록번호(-포함) : ");
		 String input = sc.next();
		 
		 char[] arr = new char[(input.length())];
		 
		 // 문자열 char배열에 대입
		 for (int i = 0; i < arr.length; i++) {
			 if (i > 7) {
				 arr[i] = '*';
			 } else {	
			 arr[i] = (input.charAt(i));
			 }
		 }

		 for (int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i]);
		 }
	 }
	 
	 public void practice8( ) {
		 
		 int input = 0;
		 
		 while(true) {

			 System.out.print("정수 : ");
			 input = sc.nextInt();
			 
			 if(input % 2 == 0 || input < 3) {
				 System.out.println("다시 입력하세요.");
				 continue;
			 } else {
				 break;
			 }
		 }
		 
		 int[] arr = new int[input];
		 
		 // 배열의 중간까지 오름차순 입력
		 for(int i = 0; i <= (arr.length / 2); i++) {
			 arr[i] = i+1;			 			 
		 }
		 
		 // 배열의 중간 이후부터 내림차순 입력
		 int num = 1;
		 for(int i = input-1 ; i > (arr.length / 2); i--) {
			 
			 arr[i] = num;
			 ++num;
		 }
		 
		 for(int i = 0; i < arr.length; i++) {

			 System.out.print(arr[i]);
			 
			 if (i < arr.length-1) {
				 System.out.print(", ");
			 }
		 }
		 
	 }
	 
	 public void practice9( ) {
		 
		 int[] arr = new int[10];
		 
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = (int)(Math.random() * 10 + 1);
			 
			 System.out.print(arr[i] + " ");
		 }
		 
		 
		 
	 }
	 
	 public void practice10( ) {
		 
		 int[] arr = new int[10];
		 
		 System.out.print("발생한 난수 : ");
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = (int)(Math.random() * 10 + 1);
			 
			 System.out.print(arr[i] + " ");
		 }
		 
		 int max = 0;
		 int min = 10;
		 
		 for (int i = 0; i < arr.length; i++) {
			 
			 if (max < arr[i]) {
				max = arr[i]; 
			 }
			 
			 if (min > arr[i]) {
				min = arr[i]; 
			 }
		 }
				 
		 System.out.println();
		 System.out.println("최대값 : " + max);
		 System.out.println("최소값 : " + min);
		 
	 }

	 
	 public void practice11( ) {
		 
		 int[] arr = new int[10];
		 Random r = new Random();
		 
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = r.nextInt(10)+1; // 1~10까지의 난수 입력
			 
			 for(int j=0; j<i; j++) {
				 if (arr[i] == arr[j]) {
					 i--;
				 }
			 }
		 }
		 
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i] + " ");
		 }
		 
		 
	 }
	 
	 // 풀긴 풀었는데 이해가 안가요;
	 public void practice12( ) {
		 int[] arr = new int[6];
		 Random r = new Random();
		 
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = r.nextInt(45)+1;
			 
			 for(int j=0; j<i; j++) {
				 if(arr[i] == arr[j]) {
					 i--;
				 }
			 }
		 }
		 
 
		 int temp = 0;
		 
		 for(int i = 0; i < arr.length; i++) {
			 
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}				
			}
		 }
		 
		 for(int i = 0; i < arr.length; i++) {
			 System.out.print(arr[i] + " ");
		 }

		 
		 
	 }
	 
	 // 모르겠다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 public void practice13( ) {
		 
		 System.out.print("문자열 : ");
		 String input = sc.next();
		 
		 // 입력받은 문자열의 길이만큼 char[] 생성
		 char[] arr = new char[(input.length())];

		 // 입력받은 문자열을 char[]에 저장
		 int num = 0;// 문자열 인덱스
		 for(int i = 0; i < input.length(); i++) {
			 arr[i] = input.charAt(num);
			 
			 // 문자열의 중복 제거
			 for(int j = 0; j < i; j++) {
				 if (arr[i] == arr[j]) {
					 i--;
				 }
			 }
			 
			 num++;
			 
		 }
		 
		 int count=0;
		
		 System.out.print("문자열에 있는 문자 : ");
		 
		 // 문자열 출력
		 for(int i = 0; i<input.length(); i++) {
			 System.out.print(arr[i]);
			 
			 if (i < (input.length())-1) {
				 System.out.println(", ");
			 }
			count++;
		 }
		 
		 System.out.println("문자 개수 : " + count);
	 }
	 
	 
	 
	 // 다시~~~ 다시~~~~~~~
	 public void practice14( ) {
		 
		 int count = 0;
		 
		 // String 배열 크기 입력 및 선언할당
		 System.out.print("배열의 크기를 입력하세요 : ");
		 int input = sc.nextInt();
		 String[] arr = new String[input];
		 count += input;
		 
		 // 인덱스 값 입력받아 초기화
		 for(int i = 0; i < arr.length; i++) {
			 System.out.printf("%d번째 문자열: ", i+1);
			 arr[i] = sc.next();
		 }
		 
		 
		 
		 while(true) {
			 
			 System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			 char in = sc.next().charAt(0);
			 // -> 입력된 알파벳(char) input에 대입
			 
			 // 입력값이 n 이면 탈출!
			 if ( in == 'n') {
				 break;
			 }
			 			 
			 System.out.print("더 입력하고 싶은 개수 : ");
			 int input2 = sc.nextInt();
			 count += input2;
			 String[] arr2 = new String[input2]; 
			 
			 // 입력갯수만큼 정보 입력 / 배열 추가생성
			 for(int i = 0; i < input2; i++) {
				 System.out.printf("%d번째 문자열: ", input+1+i);
				 arr2[i] = sc.next();
			 }
		 }
		 
		 // 배열 전체 값 출력
		 
		 System.arraycopy(arr, 0, arr, input, count);
			
			// 2. System.arraycopy(원본배열명, 원본 복사 시작 인덱스, 
//								복사배열명, 복사 배열의 삽입 시작 인덱스, 복사 길이); 
			
			
			int[] copyArr2 = new int[arr.length];
			
			System.arraycopy(arr, 0, copyArr2, 0, 0);
		 
		 
		 
		 
		 
	 }
	 
	 public void practice15( ) {
		 
		 String[][] arr = new String[3][3];
		 
		 for(int row = 0; row < arr.length; row++) {
			 
			 for(int col = 0; col < arr.length; col++) {
				 
				 System.out.printf("(%d, %d)", row, col );
			 }
			 System.out.println();
			 
		 }
		 
		 
		 
		 
	 }
	 
	 public void practice16( ) {
		 
		 int[][] arr = new int[4][4];
		 int number = 1;
		
		 // 2차원배열에 값 저장
		 for(int row = 0; row < arr.length; row++) {
			 
			 for(int col = 0; col < arr.length; col++) {
				 
				 arr[row][col] = number;
				 number++;
			 }
		 }
		 
		// 2차원배열 저장값 출력
		 for(int row = 0; row < arr.length; row++) {
			 
			 for(int col = 0; col < arr.length; col++) {
				 
				 System.out.printf("%3d",arr[row][col]);
			 }
			 System.out.println();
		 }
	 }
	 
	 public void practice17( ) {
		 
		 int[][] arr = new int[4][4];
		 int number = 16;
		 
		 // 16~1 거꾸로 배열에 값 저장
		 for(int row = 0; row < arr.length; row++) {
			 
			 for(int col = 0; col < arr.length; col++) {
				 
				 arr[row][col] = number;
				 number--;
			 }
		 }

		// 저장된 값 출력	 
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = 0; col < arr.length; col++) {
				
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
			}
		 
		 
	 }
	 
	 // total이 왜 미리 안되는지 의문이지만 문제는 풀었다
	 public void practice18( ) {
		 
		 int[][] arr = new int[4][4];
		 Random r = new Random();
		 
		 // 2행 3열에 랜덤값 저장
		 for(int row = 0; row <= 2; row++) {
			 for(int col = 0; col < arr.length; col++) {
				 arr[row][col] = r.nextInt(10)+1;
			 }
		 }
		 
		 // 3열에 값 저장
		 for(int row = 0; row < 3; row++) {
			 arr[row][3] = arr[row][0] + arr[row][1] + arr[row][2];
		 }
		 
		 // 3행에 값 저장
		 for(int col = 0; col < 3; col++) {
			 arr[3][col] = arr[0][col] + arr[1][col] + arr[2][col];
		 }
		 
		 // 3행3열 값 저장
		 int total=0;
		 for(int row = 0; row < 3; row++) {
			 for(int col = 0; col < 3; col++) {
				 total += arr[row][col];
			 }
		 }
		 arr[3][3] = total;
		 	 
		 
		 // 배열 출력
		 for(int row=0; row<arr.length; row++) {
			 for(int col=0; col<arr.length; col++) {
				 System.out.printf("%3d", arr[row][col]);
			 }
			 System.out.println();
		 }
	 }
	 
	 
	 public void practice19( ) {
		 
		 int rowIn=0;
		 int colIn=0;
		 
		 do {
			 
			 System.out.print("행 크기 : ");
			 int row = sc.nextInt();

			 if (row < 1 || row > 10 ) {
				 System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				 continue;
			 }
			 
			 rowIn += row;
			 
			 System.out.print("열 크기 : ");
			 int col = sc.nextInt();
			 
			 if (col < 1 || col > 10 ) {
				 System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				 continue;
			 }
			 
			 colIn += col;
			 
			 break;
		 
		 } while (true);
		 
		 
		 // 입력받은 수 만큼 이차원 배열 생성
		 int[][] arr = new int[rowIn][colIn];
		 
		 // 배열에 랜덤 수 입력
		 for(int row = 0; row < rowIn; row++) {
			 
			 for(int col = 0; col < colIn; col++) {
				 
				 arr[row][col] = (int)(Math.random() * 26) + 65;
				 
			 }
		 }
		 

		 
		 for(int row = 0; row<rowIn; row++) {
			 
			 for(int col = 0; col<colIn; col++) {
				 
				 System.out.printf("%-2c", (char)(arr[row][col])); 
				 
			 }
			 
			 System.out.println();
			 
		 }
		 
		 

		 
		 
		 
		 
	 }
	 
	 
	 
	 //가변배열?! 풀다가 멈춤....또록
	 public void practice20( ) {
		 
		 System.out.print("행의 크기 : ");
		 int row = sc.nextInt();
		 
		 char[][] arr;
		 
		 for(int i = 0; i < row; i++) {
			 
			 System.out.printf("%d열의 크기 : ", i);
			 int col = sc.nextInt();
			 arr = new char[i][col]; 
		 }
		 
//		 
//		 for(int i = 0; i < arr.length; i++) {
//			 
//			 for (int j = 0; j < arr.length; j++) {
//				 
//				 
//				 
//			 }
//			 
//			 
//		 }
//		 
//		 
		 
		 
	 }
	 
	 // 헐 내가 이걸 풀다니;
	 public void practice21( ) {
		 
		 String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				 "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		 
		 String[][] str1 = new String[3][2];
		 String[][] str2 = new String[3][2];
		 

		 int count = 0;
		 for(int row = 0; row < str1.length; row++) {
			 
			 for(int col = 0; col < 2; col++) {
				 
				 str1[row][col] = students[count]; 
				 count++;
			 }
		 }
		 
		 for(int row = 0; row < str2.length; row++) {
			 
			 for(int col = 0; col < 2; col++) {
				 
				 str2[row][col] = students[count]; 
				 count++;
			 }
		 }
		 
		 
		 System.out.println("== 1분단 ==");
		 for(int row=0; row<str1.length; row++) {
			 for(int col=0; col<2; col++) {
				 System.out.printf("%s  ", str1[row][col]);
			 }
			 System.out.println();
		 }
		 
		 System.out.println("== 2분단 ==");
		 for(int row=0; row<str2.length; row++) {
			 for(int col=0; col<2; col++) {
				 System.out.printf("%s  ", str2[row][col]);
			 }
			 System.out.println();
		 }
		 
		 
	 }
	 
	 // ㅋㅋㅋㅋㅋㅋㅋ 이걸해냄
	 public void practice22( ) {
		 
		 String[][] str1 = { {"강건강", "남나나"},
							 {"도대담", "류라라"},
							 {"문미미", "박보배"}
		 										};
					 
		 
		 String[][] str2 = { {"송성실", "윤예의"},
							 {"진재주", "차천축"},
							 {"피풍표", "홍하하"}
		 										};
		 
		 System.out.print("검색할 학생 이름을 입력하세요 : ");
		 String name = sc.next();
		 
		 // str1에서 학생 찾기
		 for(int row = 0; row < str1.length; row++) {
			 for(int col = 0; col < 2; col++) {
				 if(str1[row][col].equals(name)) {
					 System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 ", name, row+1);
					 
					 if(col==0) {
						 System.out.print("왼쪽에 있습니다.");
					 } else {
						 System.out.print("오른쪽에 있습니다.");
					 }
				 }
			 }
		 }
		 
		 // str2에서 학생 찾기
		 for(int row = 0; row < str2.length; row++) {
			 for(int col = 0; col < 2; col++) {
				 if(str2[row][col].equals(name)) {
					 System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 ", name, row+1);
					 
					 if(col==0) {
						 System.out.print("왼쪽에 있습니다.");
					 } else {
						 System.out.print("오른쪽에 있습니다.");
					 }
				 }
			 }
		 }
		 
		 
		 
		 
		 
		 
	 }
	 
	 
	 // 이렇게 푸는게 아닌거같긴한데 일단 품ㅋㅋㅋㅋㅋㅋ
     public void practice23( ) {
		 
		 String[][] arr = { {" " ,"0","1","2","3","4"},
				 			{"0"," "," "," "," "," "},
				 			{"1"," "," "," "," "," "},
				 			{"2"," "," "," "," "," "},
				 			{"3"," "," "," "," "," "},
				 			{"4"," "," "," "," "," "},
		 					};
		 
		 System.out.print("행 인덱스 입력 : ");
		 int row = sc.nextInt();
		 
		 System.out.print("열 인덱스 입력 : ");
		 int col = sc.nextInt();
		 
		 arr[row+1][col+1] = "X";
		 
		 for(int i = 0; i < arr.length; i++) {
			 for(int j=0; j < arr.length; j++) {
				 System.out.printf("%2s",arr[i][j]);
			 }
			 System.out.println();
		 }
		 
		 
		 
		 
	 }
	 
	 public void practice24( ) {
		 
		 String[][] arr = { {" " ,"0","1","2","3","4"},
				 			{"0"," "," "," "," "," "},
				 			{"1"," "," "," "," "," "},
				 			{"2"," "," "," "," "," "},
				 			{"3"," "," "," "," "," "},
				 			{"4"," "," "," "," "," "},
							};

		while(true) {
			
			System.out.print("행 인덱스 입력 : ");
			int row = sc.nextInt();
			
			if(row == 99) {
				System.out.print("프로그램 종료");
				break;
			}
			
			System.out.print("열 인덱스 입력 : ");
			int col = sc.nextInt();
			
			arr[row+1][col+1] = "X";
			
			for(int i = 0; i < arr.length; i++) {
				 for(int j=0; j < arr.length; j++) {
					 System.out.printf("%2s",arr[i][j]);
				 }
				 System.out.println();
			}
		}
		 


		 
		 
	 }
	 
}
