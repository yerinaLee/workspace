package edu.kh.thread.ex1;

// 스레드 생성 방법 1 : Thread 클래스 상속 (not 추상메서드. 오버라이딩 강제 x)
// 장점 : 해당 스레드를 생성하는 구문이 조금 짧음
// 단점 : Thread 클래스의 run() 메서드가 추상 메서드가 아니여서 강제 오버라이딩 X

public class TestThread1 extends Thread{
	
	
	@Override
	public void run() {
		// run() 메서드 : 
		// -  스레드 생성되어 실행(start())시
		//	  수행될 구문을 작성하는 메서드
		
		// static 필드, 메서드는
		// 클래스명.필드명 / 클래스명.메서드명() 으로 호출
		System.out.println(Thread.currentThread().getName() + " 실행");
		
		
		for(int i = 0; i< 10; i++) {
			System.out.println("0번 스레드 " + i);
		}
	}
}
