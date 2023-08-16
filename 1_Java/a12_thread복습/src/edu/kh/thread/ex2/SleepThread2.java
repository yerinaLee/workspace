package edu.kh.thread.ex2;

public class SleepThread2 implements Runnable{
	
	@Override
	public void run() {
		
		int count = 0;
		
		while( !Thread.currentThread().isInterrupted() ) {
			
			try {
				Thread.sleep(10);
				
				System.out.println( ++count );
				
			} catch( InterruptedException e) {
				System.out.println("==== 인터럽트에 의해 종료 ====");
				Thread.currentThread().interrupt();
			}
		}
	}
}
