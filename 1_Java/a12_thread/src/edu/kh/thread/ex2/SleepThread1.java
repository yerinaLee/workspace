package edu.kh.thread.ex2;

// 스레드 생성 (Runnable 인터페이스 상속) - 이게 더 많이쓰임!
public class SleepThread1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 실행");
		
		for(int i = 1; i <= 10; i++) {
			// Thread.sleep(long millis)
			// - 현재 스레드를 지정된 시간만큼 일시정지
			// - 시간은 1/1000 초 단위(ms밀리세컨드)로 지정
			// - InterruptedException 예외 처리 필요
			
			try {
				Thread.sleep(1000); // 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println(i + "초");
		}
	}
}
