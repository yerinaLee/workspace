package edu.kh.exception.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import edu.kh.exception.model.dto.UserException;

public class ExceptionService {
	
	
	
	public void ex1() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자열 입력 : ");
		
		try {
			
			String input = br.readLine();
			
			System.out.println("입력 받은 문자열 : " + input);
			
			
		} catch(IOException e) {
			System.out.println("예외 처리함");
		}
	}
	
		
	public void ex2() {
			
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("숫자 1 : ");
			int input1 = sc.nextInt();
			
			System.out.print("숫자 2 : ");
			int input2 = sc.nextInt();
			
			System.out.println(input1/input2);

		} catch(ArithmeticException a) {
			System.out.println("0으로 나눌 수 없습니다");
		} catch(InputMismatchException i) {
			System.out.println("잘못 입력");
		}
						
	}
	
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("숫자 1 : ");
			int input1 = sc.nextInt();
			
			System.out.print("숫자 2 : ");
			int input2 = sc.nextInt();
			
			System.out.println(input1/input2);

		} catch(RuntimeException r) {
			System.out.println("예외 발생");
		}
	}
		
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("숫자 1 : ");
			int input1 = sc.nextInt();
			
			System.out.print("숫자 2 : ");
			int input2 = sc.nextInt();
			
			System.out.println(input1/input2);

		} catch(InputMismatchException e) {
			System.out.println("잘못 입력");
		} catch (RuntimeException e) {
			System.out.println("예외 발생");
		}
	}	
	
	
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.정상 동작 / 2. 예외 강제 발생 : ");
		int input = sc.nextInt();
		
		try {
			
			switch(input) {
			case 1 : System.out.println("<정상 동작>"); break;
			case 2 : throw new Exception("<강제 발생>"); 
			default : System.out.println("잘못 입력");
			}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			System.out.println("무ㅜㅜㅜㅜㅜㅜㅜ조ㅗㅗㅗㅗㅗㅗㅗ거너ㅓㅓㅓㄴ너");
		}
		
	}
	
	
	public void ex6() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();

			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d + %d = %d", num1, num2, num1+num2);
		} catch (InputMismatchException i) {
			System.err.println("숫자만 입력해주세요");
		} finally {
			sc.close();
		}
	}
	
	public void ex7() {
		
		try {
			ex8();
		} catch (IOException e) {
			System.out.println("IOException 예외 처리 완료");
			e.printStackTrace();
			
		} catch(DataFormatException d) {
			d.printStackTrace();
		}
		
		System.out.println("프로그램 정상 종료");
	}
	
	
	public void ex8() throws IOException, DataFormatException{
		ex9();
	}
	
	public void ex9() throws IOException, DataFormatException {
		ex10();
	}
	
	public void ex10() throws IOException, DataFormatException {
//		throw new IOException();
		throw new DataFormatException();
	}
	
	
	public void ex11() {
		
		try {
			ex12();
		} catch(UserException u) {
			u.printStackTrace();
		}
		
		
		
	}
	
	public void ex12() throws UserException{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
		if(input > 100) {
//			throw new UserException();
			throw new UserException("100을 초과하는 " + input + "이 입력됨");
		}
		
		System.out.println("입력한 숫자 : " + input);
		
		
	}
	
	
	
	

}
