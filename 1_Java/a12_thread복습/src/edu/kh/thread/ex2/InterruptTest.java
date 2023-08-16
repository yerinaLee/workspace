package edu.kh.thread.ex2;

import java.util.Scanner;

public class InterruptTest {

	public void test() {
		
		
		Thread sleep2 = new Thread( new SleepThread2() );
		sleep2.start();
		
		System.out.println("<엔터 입력 시 종료>");
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		sleep2.interrupt();
	
		System.out.println("<프로그램 종료>");
		
		
		
		
		
	}
	
	
	
	
	

}
