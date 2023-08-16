package edu.kh.thread.ex1;

public class TestRun {
	
	public static void main(String[] args) {
		
		Thread test2 = new Thread( new TestThread2() );
		
		test2.start();
		
		
		
		
	}
	

}
