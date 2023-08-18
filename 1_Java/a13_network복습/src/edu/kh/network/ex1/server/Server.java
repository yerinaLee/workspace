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
		
		
		// 1. 포트 넘버 정하기 / 1023~65535 사이로! 
		int port = 8500;
		
		// 2. 소켓 객체들 생성
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			//3. 클라이언트가 오길 기다림
			serverSocket = new ServerSocket(port);
			
			//4. 요청오면 연결!
			clientSocket = serverSocket.accept();
			
			//5. 스트림 생성
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			//6. 스트림 강화
			br = new BufferedReader( new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			//7.소통 ㄱ
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String message = sdf + "접속 성공";
			
			pw.print(sdf);
			pw.flush();
			
			String clientMessage = br.readLine();
			System.out.println(clientMessage);
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (br != null) br.close();
				if(pw != null) pw.close(); // + os.close()
				
				if (clientSocket != null) clientSocket.close();
				if (serverSocket != null) serverSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
