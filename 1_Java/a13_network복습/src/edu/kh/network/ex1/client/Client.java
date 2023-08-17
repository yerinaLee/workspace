package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void start() {
		
		// 1. 서버의 IP주소와 포트번호를 매개변수, 소켓 객체 생성
		String ip = "127.0.0.1";
		int port = 8500;
		
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
		try {
			System.out.println("it's your Client!");
			
			socket = new Socket(ip, port);
			
			if (socket != null) {
				
				// 2. 스트림 생성
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				// 3. 보조스트림으로 강화!
				br = new BufferedReader( new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				// 4. 스트림을 통해 입출력
				
				// 4-1) 클라이언트 <- 서버 입력
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
				
				// 4-2) 클라이언트 -> 서버 출력
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메시지 : ");
				String clientMessage = sc.nextLine();
				
				pw.println(clientMessage);
				pw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (pw != null) pw.close();

				if (socket != null) socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}

}
