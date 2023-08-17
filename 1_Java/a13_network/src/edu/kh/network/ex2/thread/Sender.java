package edu.kh.network.ex2.thread;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 데이터를 송신하는(출력하는) 작업을 처리하는 스레드
public class Sender implements Runnable{
	
	// 필드
	private String name; // 서버 또는 클라이언트의 이름
	private Scanner sc = new Scanner(System.in);
	
	// 보조 스트림 참조변수
	// DataOutputStream : 데이터를 기본자료형 또는
	//					UTF-8 인코딩 형식의 문자열 단위로 출력하는 스트림
	private DataOutputStream out = null;
	
	// 생성자
	public Sender(Socket socket, String name) { 
		
		// socket, name 매개변수
		try {
			
			this.name = name;
			out = new DataOutputStream(socket.getOutputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Thread.start()시 수행되는 코드
	@Override
	public void run() {
		
		while(true) {
			
			try {
				// UTF-8 형식의 문자열을 출력 (자동 flush 처리)
				out.writeUTF( name + " > " + sc.nextLine() );
						//    이름     >   입력한 문자열
				
			} catch(Exception e) {
				// 출력을 받는 대상이 존재하지 않으면 예외 발생
				// -> 채팅 대상이 없으니 채팅을 종료
				break;
			}
		}
	}
}
