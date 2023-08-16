package edu.kh.thread.ex2;

import java.util.Scanner;

public class InterruptTest {
	
	/* interrupt : 일시 정지, 방해하다
	 *  -> 스레드의 동작을 방해해서 멈추게 함
	 *  
	 * void interrupt()
	 * - 현재 스레드의 interrupted 필드값을 true로 변경 (setter같은 역할)
	 *   interrupted 필드 == false -> 작업 진행
	 *   interrupted 필드 == true -> 작업 멈춤
	 *   
	 *   단, Thread.sleep()에 의해서 일시 정지된 스레드에
	 *   interrupt()를 호출하게되면
	 *   스레드의 interrupted 필드값이 true로 변하지 않고(작업 종료 X)
	 *   InterruptedException이 발생한다

	 * 
	 * boolean isInterrupted()
	 * - 현재 스레드의 interrupted 필드값을 반환 (getter)
	 * 
	 * 
	 * boolean Thread.interrupted()
	 * - 현재 스레드의 interrupted 필드값을 반환
	 * 	  + false로 값을 변경 / 많이 사용은 X
	 */
	
	
	public void test() {
		
		Thread sleep2 = new Thread( new SleepThread2() );
		sleep2.start(); // SleepThread2의 run() 메서드 실행
		
		System.out.println("<엔터 입력 시 종료>");
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine(); // 입력 버퍼에서 다음 \n까지 읽어오기
					   // 단, 버퍼가 비어있으면
					   // 다음 \n(엔터) 입력시까지 현재 스레드 무한 대기
		
		// -------------------------무한대기중...... --------------
		
		// 엔터입력시! sleep2 스레드를 멈추게하는 interrupt() 호출
		sleep2.interrupt(); 
		
		System.out.println("<프로그램 종료>");
		
		
		
	}
	
	
	
	
	
	

}
