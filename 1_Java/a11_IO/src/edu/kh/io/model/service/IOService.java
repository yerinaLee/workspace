package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class IOService {
	
	/* Stream(스트림) : 데이터가 이동하는 통로
	 * 					(기본적으로 단(한쪽) 방향)
	 * 					
	 * 바이트 기반 스트림
	 * - InputStream, OutputStream 최상위 인터페이스
	 * 
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * 
	 * - 1byte 범위 문자열(아스키코드 (영어, 숫자, 특수문자))
	 *   또는 이미지, 영상, 오디오 등 문자가 아닌 파일/데이터
	 *   
	 * 
	 * 문자 기반 스트림
	 * - Reader, Writer 최상위 인터페이스
	 * 
	 * - 2byte 단위로 데이터(문자)를 입/출력 하는 스트림
	 * 
	 * - 2byte 범위 문자열, 문자만 저장된 파일
	 * 	채팅, 인터넷 요청 시 데이터 전달 등에 이용
	 * 
	 */
	
	
	/**
	 * 바이트 기반 파일 출력
	 */
	public void byteOutput() {
		
		// IO 관련 코드는 IOException 발생 시킬 가능성이 높음
		
		// 절대 경로 : 절대적인 기준으로부터 목표까지의 경로
		// 서울 기준 -> 서울시 중구 남대문로 120 2층 KH정보교육원
		// C드라이브 기준 -> C:/workspace/01_java/a11_io/byte
		
		// 상대 경로 : 임의의 기준(보통 현재위치)으로부터 목표까지의 경로
		// KH정보교육원 기준 우리은행 본점까지의 경로 : 옆건물
		// 현재 프로젝트(a11_io) 폴더가 현재 위치(기준)

		FileOutputStream fos = null;
		
		try {
			// byte 기반 파일 출력 스트림 생성
			fos = new FileOutputStream("byte/byteTest.txt");
			// byte 폴더 내부에 byteTest.txt 파일이 있으면 출력을 위해 연결하고
			// 없으면 파일을 만들어서 연결해라
			

			// - 현재 위치에서 byte폴더까지의 경로 : byte
			// 원래 늘 현재위치를 찾는게 어렵다!
			
			String content = "Hello world!!!!!!!!!\n"
							+ "123456789\n"
							+ "@#E%^%^&*&%^&#\n"
							+ "와 자바 재밌다 재밌어미치겠다";
			
			
			for(int i = 0; i<content.length(); i++) { // 글자수만큼 반복
				
				char ch = content.charAt(i); // i번째 문자 하나
				fos.write(ch); // 한 글자씩 연결된 파일로 출력
			}
			
			System.out.println("출력 완료");
			
					
		} catch(IOException e) {
			e.printStackTrace(); // 예외가 발생한 메서드까지의 모든 내용 출력
			
		} finally { // 무조건 실행
			
			// 사용 완료된 스트림을 메모리에 반환하는 코드 작성
			// (close() 코드)
			try {
				if(fos != null) { fos.close(); }

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 문자 기반 파일 출력
	 */
	public void charOutput() {
		
		// 프로그램 -> 파일에 씀
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("char/charTest.txt");
			// char 폴더의 charTest.txt가 있으면 문자 출력 스트림 연결
			// 없으면 만들어서 연결
			
			String content = "안녕하세요\n"
							+ "저는 누구일까요\n"
							+ "지금은 자바를 공부중이에요\n"
							+ "밖은 태풍이 오고있어요\n"
							+ "모두 무사하시기를\n"
							+ "덮어쓰기가 되나요?";
			
			fw.write(content); // 문자열을 통째로 내보낼 수 있는 코드
			
			System.out.println("char 기반 출력 완료");
			
			
		} catch(IOException e) {
			e.printStackTrace();

		} finally {

			try {
				// fw 스트림 객체가 있을 때에만 닫기(메모리 반환)
				if(fw != null) {
					fw.close();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * 바이트 기반 파일 입력
	 */
	public void byteInput() {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("노래가사/Super.txt");
			
			// * 읽어올 땐 한 글자씩 *
			
			// 읽어온 한 글자를 저장할 변수 선언
			int value = 0; // 왜 int? byte(정수형)으로 읽어오는데
						  // byte를 다루기 어려워서 int로 저장
			
			// 글자를 읽어오다가, 언젠간 끝나겠지,,,
			while(true) {
				value = fis.read(); // 1byte를 읽어와 int로 저장
									// 읽어올 내용이 없으면 -1 반환
				
				if(value == -1) { // 다 읽었으면
					break;
				}
				
				System.out.print( (char)value ); // value는 int 숫자로 반환되기에 char로 강제형변환
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch ( IOException e) {
			e.printStackTrace();
			
		} finally {
			
				try {
					if(fis != null) { fis.close(); }
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
	}
	
	
	/**
	 * 문자 기반 파일 입력
	 */
	public void charInput() {
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("노래가사/Super.txt");
			
			int value = 0; // 왜 int? byte(정수형)으로 읽어오는데
						  // byte를 다루기 어려워서 int로 저장
			
			while(true) {
				value = fr.read(); // 1byte를 읽어와 int로 저장
									// 읽어올 내용이 없으면 -1 반환
				
				if(value == -1) { // 다 읽었으면
					break;
				}
				
				System.out.print( (char)value ); // value는 int 숫자로 반환되기에 char로 강제형변환
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch ( IOException e) {
			e.printStackTrace();
			
		} finally {
			
				try {
					if(fr != null) { fr.close(); }
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
	}
	
	
	

}
