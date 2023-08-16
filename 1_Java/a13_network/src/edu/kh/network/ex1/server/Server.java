package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

// Server : 클라이언트가 이용할 서비스(코드)를 제공하는 컴퓨터
// ex) 가게 사장/직원

// Socket : 프로세스의 양 끝단
//			-> 서버 - 클라이언트를 연결하는 통로/연결고리
//			-> Input/Output Stream을 이용해 서버 - 클라이언트가 데이터 교환 가능 (Socket 안에 만듦. get으로 가능)
			
// TCP : 서버 - 클라이언트간의 1:1 소켓 통신
//		데이터 신뢰성을 보장(데이터 오류시 재전송) 

public class Server {
	
	public void start() {
		
		// 1. 서버의 포트번호 정하기
		int port = 8500;
		// 포트번호는 0~65535(2byte범위) 사이로 지정 가능
		// 1023번 이하는 OS에서 사용하는 경우가 많으므로 사용 권장 X
		
		
		// 2. 서버용 소켓 객체 생성
		// ServerSocket : 지정된 포트 번호로
		//				클라이언트 연결이 되는 것을 기다리는 소켓 객체
		ServerSocket serverSocket = null; // 입장용 문
		
		Socket clientSocket = null; // 통신용 문
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
		try {
			// 서버 컴퓨터(내 컴퓨터)의 IP 관련 정보를 얻어옴
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
			
			
			// 3. 클라이언트가 연결되길(접속) 기다림....
			serverSocket = new ServerSocket(port);
			
			System.out.println("[Server 입니다]");
			System.out.println("클라이언트의 접속을 기다리고 있습니다...");
			
			// 4. 접속 요청이 오면
			//   해당 클라이언트에 대한 소켓 객체 생성
			clientSocket = serverSocket.accept(); // accept : 허용하다
			
			System.out.println("[클라이언트 접속 성공]");
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성
			is = clientSocket.getInputStream(); // 클라이언트 -> 서버 입력
			os = clientSocket.getOutputStream(); // 서버 -> 클라이언트 출력
			
			// 6. ﻿보조 스트림을 통해 성능 개선
			// InputStreamReader : 바이트 -> 문자 기반 입력 스트림으로 변경
			br = new BufferedReader( new InputStreamReader(is) );
			pw = new PrintWriter(os);
			
			// 7. ﻿ 스트림을 통해 읽고 쓰기
			
			// 7-1 ) 서버 -> 클라이언트 메세지 전달
			Date now = new Date(); // 현재 시간이 객체에 저장됨
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 2023-08-16 17:18:24
			
			String message = sdf.format(now) + "[서버 접속 성공]";
			
			pw.println(message); // 서버 -> 클라이언트로 메세지 출력
			pw.flush(); // 정보가 잘 가라고 밀어주는 역할
			
			
			// 7-2 ) 서버 <- 클라이언트 메시지 받기(입력) 
			String clientMessage = br.readLine(); // 한 줄 읽기
			
			System.out.println("클라이언트로부터 받은 메시지 " +  clientMessage);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}
	

}
