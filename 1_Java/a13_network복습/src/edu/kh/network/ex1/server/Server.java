package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public void start() {
		
		
		//1. 서버의 포트넘버 정하기
		int port = 8500;
		
		// 2. 소켓 객체들 생성하기
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			// 3. 클라이언트 응답 기달리기
			serverSocket = new ServerSocket(port);
			System.out.println("waiting for you....^^");
			
			// 4. 클라이언트 요청이 오면 클라이언트 소켓열고 accept하기
			clientSocket = serverSocket.accept();
			System.out.println("*** Welcom my client!!! ***");
			
			// 5. 입출력을 위한 스트림 만들기
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			// 6. 스트림 보강!
			br = new BufferedReader( new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			// 7. 대화시도
			//7-1) 서버 -> 클라이언트 출력
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String message = sdf.format(now) + "[서버 접속 성공]";

			pw.println(message);
			pw.flush();
			
			// 7-2) 서버 <- 클라이언트 입력
			
			String clientMessage = br.readLine();
			System.out.println(clientMessage);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (br != null) br.close();
				if (pw != null) pw.close();

				if (serverSocket != null) serverSocket.close();
				if (clientSocket != null) clientSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}
