package edu.kh.thread.ex1;

// 스레드 생성 방법 2 : Runnable 인터페이스 상속
						// Run + able : 실행할 수 있는~
// 장점 : run() 메서드 오버라이딩이 강제된다
// 단점 : 해당 스레드를 생성시키는 구문이 조금 더 길어짐

public class TestThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 실행");
		
		for(int i = 0; i < 10; i++) {
			System.out.println("1번 스레드 " + i);
		}
	}
}
