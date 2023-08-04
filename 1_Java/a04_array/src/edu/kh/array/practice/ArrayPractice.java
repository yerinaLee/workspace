package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {
	
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
		
//		//문자 검색		
//		System.out.print("문자 : ");
//		char search = sc.next();
//		 
//		// 문자열을 찾는 구문
//		for (int i = 0; i < str.length; );
		
		
		
	 }
	 
	 
	 
	 
	 
	 
	 
	 public void practice6( ) {
		 
	 }
	 
	 public void practice7( ) {
		 
	 }
	 
	 public void practice8( ) {
		 
	 }
	 
	 public void practice9( ) {
		 
	 }
	 
	 public void practice10( ) {
		 
	 }
	 
	 public void practice11( ) {
		 
	 }
	 
}
