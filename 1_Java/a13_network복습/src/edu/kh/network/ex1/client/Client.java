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
		
		// 1. 서버쪽 포트와 IP에 맞는 소켓객체 생성
		
		String ip = "127.0.0.1";
		int port = 8500;
		
		Socket socket = null;
		
		InputStream is = null; // 클라이언트 <- 서버
		OutputStream os = null; // 클라이언트 -> 서버
		
		// 성능 향상용 보조 스트림
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			socket = new Socket(ip, port);
			
			if(socket != null) {
				
				//2. 스트림 생성
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				//3. 스트림 강화
				br = new BufferedReader ( new InputStreamReader (is));
				pw = new PrintWriter(os);
				
				
				//4. 소통 ㄱ
				
				String serverMessage = br.readLine();
				System.out.println(serverMessage);
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("서버로 전달할 메세지 : ");
				String message = sc.nextLine();
				
				pw.print(message);
				pw.flush();
				
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
