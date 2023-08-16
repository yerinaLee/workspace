package edu.kh.network.ex1.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public void start() {
		
		// 1. 서버의 포트 정하기 // 1023 이후~65535
		
		int port = 3500;
		
		// 2. 서버 소켓 객체 생성
		ServerSocket serverSocket = null;

		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
			
			// 3. 클라이언트가 연결되길(접속) 기다림
			serverSocket = new ServerSocket(port);
			
			System.out.println("it's Server");
			System.out.println("waiting for connection");
			
			// 4. 클라이언트가 연결되면 해당 클라이언트에 대한 소켓 객체 생성
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트 접속 성공");
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			// 6. 보조스트림을 통해 개선
			// Input 바이트 -> 문자기반으로 ㄱㄱ
			br = new BufferedReader( new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			// 7. 스트림을 통해 읽고 쓰기
			
			// 7-1) 서버 -> 클라이언트 메세지 전달
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String message = sdf.format(now);
			
			pw.println(message);
			pw.flush();
			
			// 7-2) 서버 <- 클라이언트 메시지 받기(입력)
			String clientMessage = br.readLine();
			
			System.out.println("클라이언트로부터 받은 메시지 " + clientMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
