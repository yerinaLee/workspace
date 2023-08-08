package edu.kh.exception.model.service;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import edu.kh.exception.model.dto.UserException;

public class ExceptionService {
	
	
	public void ex1() {
		
		// Checked Exception 확인
		// 예외처리 구문(try-catch)
		
		// ﻿BufferdReader : 빨리 읽어오는 객체
		
		BufferedReader br
			= new BufferedReader( new InputStreamReader(System.in) ); // 키보드(sysetm.in) 입력(input)구문을 빠르게 읽는 것(reader)
		// 키보드 입력을 효율적으로 읽어오는 객체
		// (Scanner보다 기능은 부족하지만 속도가 매우 빠름)
		
		System.out.print("문자열 입력 : ");
		
		
		try {
		
			String input = br.readLine(); // 한 줄 읽어오기
			
			System.out.println("입력 받은 문자열 : " + input);
			
			//  br.readLine()을 작성하면 빨간줄이 뜬다!
			// 왜? Unhandled exception type IOException
			//  -> IOExeption에 대한 처리가 강제되고 있음
			//	  --> 이렇게 꼭 예외처리 하라는 예외를 묶어
			//		checked Exception이라고 한다!
			//		(문제가 발생할 가능성이 높아서 꼭 대비해라!)
			
		} catch(IOException e) {
			// catch : try 구문에서 던져진 예외 객체를 잡는 구문
			System.out.println("예외 처리함");
		}
	}
	
	
	
	// public : 어디서든 접근(호출) 가능한
	// void : 반환형이 없는 메서드
	// () : 매개변수(전달 받을 값이) 없음
	
	// 여러 catch문 사용
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		
		
		// 두번째 입력된 숫자가 0인 경우
		// "0으로 나눌 수 없습니다" 출력 후 메서드 종료
//		if (input2 == 0) {
//			System.out.println("0으로 나눌 수 없습니다");
//			return;
//		} 
		
		try {

			System.out.print("숫자 1: ");
			int input1 = sc.nextInt();
			// InputMismatchException 발생 가능성 있음
			// (Unchecked Exception)
			
			System.out.print("숫자 2: ");
			int input2 = sc.nextInt();
				
			System.out.println(input1/input2);
		
		} catch(ArithmeticException e) {
			//ArithmeticException : 산술적 예외
			System.out.println("0으로 나눌 수 없습니다");
			
		} catch(InputMismatchException e) { // catch 연달아서 작성 가능!
			System.out.println("잘못 입력");

		}
		
		
		// Unchecked Exception
		// -> 예외 처리가 강제되지 않는 예외
		//	 (개발자, 사용자의 단순 실수)
		
	}
	
	
	// 다형성을 사용한 예외처리
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("숫자 1: ");
			int input1 = sc.nextInt();

			System.out.print("숫자 2: ");
			int input2 = sc.nextInt();
			
			System.out.println(input1/input2);
			
			
		} catch(RuntimeException e) {
			// RuntimeException 은
			// ArithmeticException, InputMismatchException의 부모

			// 부모 타입 예외 참조 변수 e로
			// 자식 타입 예외 객체를 참조한다 (== 다형성 업캐스팅)
			
			// --> 부모 타입으로 모든 자식 예외를 잡아서 처리 가능
			
			System.out.println("예외 발생");
		}
	}
	
	
	
	
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("숫자 1: ");
			int input1 = sc.nextInt();
			
			System.out.print("숫자 2: ");
			int input2 = sc.nextInt();
			
			System.out.println(input1/input2);
			
		} catch(InputMismatchException e) {
			/* catch문 여러 개 작성 시
			 * 자식 타입처리 코드가
			 * 부모 타입 처리 코드보다 먼저 작성되어야 한다 */

			System.out.println("잘못 입력");
			
		} catch(RuntimeException e) { // 부모 타입
			System.out.println("예외 발생");
		}
		
//			catch(InputMismatchException e) {
//			// Unreachable : 도달할 수 없는 -> 이 코드는 실행될 일이 없다
//			// Unreachable catch block for InputMismatchException. It is already handled by the catch block for RuntimeException
//			
//			// RuntimeException (부모 타입)이
//			// InputMismatchException도 먼저 잡아 처리하기때문에
//			// 현재 catch문이 실행될 경우가 절대로 없음
//		}
		
	}
	
	
	
	public void ex5() {
		// try : 예외가 발생할 것 같은 구문을 실행(시도)
		// catch : try에서 발생한 예외를 잡아서 처리
		// finally : 예외 처리가 되든 말든 무조건 실행 
		
		// 강제 예외 발생 : throw new 예외클래스명();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. 정상 동작 / 2. 예외 강제 발생 : ");
		int input = sc.nextInt();
		
		try {
			switch(input) {
			case 1 : System.out.println("<정상 동작>"); break;
			
			case 2 : throw new Exception("<강제 발생>"); 
				// Exception 클래스 : 최상위 예외 (모든 예외의 부모)
				// throw : 예외 객체 던짐 (예외 강제 발생)
			default : System.out.println("잘못 입력");
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage()); // <강제 발생>
		} 
		finally {
			System.out.println("******무조건 실행******");
		}
		
	}
	
	
	public void ex6() {
		// finally 실제 사용 예시 (IO 내용 미리 해봄)
		// IO = Input Output. 이거를 사용할때에는 작업이 복잡하기때문에 처리를 해줘야함
		
		Scanner sc = new Scanner(System.in);
		// Resource leak: 'sc' is never closed
		
		try {
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();

			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d + %d = %d", num1, num2, num1+num2);
			
		} catch (InputMismatchException e) {
			System.err.println("<숫자만 입력해주세요>");
			
		} finally {
			// 예외가 발생 되던 말던
			// 메모리 누수를 막기 위해 스캐너(또는 IO 객체)를 닫아줌
			sc.close();
		}
	}
	
	
	public void ex7() {
		// throws : 메서드에서 발생한 예외를
		//		   호출한 상위 메서드로 전달
		//		  (책임 전가)
		// 장점 : 한 곳에 예외를 몰아서 처리 가능 (코드 길이 감소)

		try {
			methodA();
		} catch (IOException e) { // 던져진 예외를 잡아서 처리
			System.out.println("IOException 예외 처리 완료");
			
			// e : 예외 객체를 참조하는 참조 변수
			e.printStackTrace();
			// -> 예외 발생 메서드까지의 모든 스택 메서드를 출력
			// --> 언제 어떤걸 호출해서 예외가 발생을 했는가 추적
			
		} catch (DataFormatException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 정상 종료");
		
	}
	
	public void methodA() throws IOException, DataFormatException {
		methodB();
	}
	
	public void methodB() throws IOException, DataFormatException {
		methodC();
	}
	
	public void methodC() throws IOException, DataFormatException {
						// 부모 타입 예외 처리
						// IOException 또는 IOException 자식 예외를 모두 던짐
						// (다형성 적용)
		
//		throw new IOException(); 
//		throw new EOFException(); // 자식 타입의 예외 객체
		
		//EOFException == IOException의 자식
		
		throw new DataFormatException();
		// IOException과 관련 없는 예외
		// -> 별도 처리 필요 -> throws가 여러 예외를 던지게 함
		
	}
	
	
	public void ex8() {
		
		try {
			ex9();
		} catch (UserException e) {
			e.printStackTrace();
		}
		
	}
	
	// 숫자를 입력 받아 출력하는 메서드
	// 단, 100 초과 입력 시 예외가 발생
	public void ex9() throws UserException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int input = sc.nextInt();
		
		if(input > 100) { // 입력한 숫자가 100 초과일 때 예외 발생
//			throw new UserException();
			throw new UserException("100을 초과하는 " + input + "이 입력됨");
		}
		
		System.out.println("입력한 숫자 : " + input);
		
	}
	
	
	
	
	
	
	
	
	

}
