package edu.kh.io.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;

public class IOService {
	
	// 바이트 기반 출력
	public void byteOutput() {
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream("byte/byteTest.txt");
			
			String content = "Hello world";
			
			for(int i = 0; i<content.length(); i++) {
				
				char ch = content.charAt(i);
				fos.write(i);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		
		
	}
	
	// 문자 기반 출력
	public void charOutput() {
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("C:/Users/user1/Desktop/IOTest/Test2.txt");
			
			String content = "마치like된거가타손오공\n뚠뚠뚠\n뚠뚠뚠뚠\n뚠\n뚠뚠뚠"+
					"마치된거가타소노공!";
			
			fw.write(content);
			
			System.out.println("Char 기반 출력 완료");

		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//바이트기반 파일 입력
	public void byteInput() {
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("노래가사/Super.txt");
			
			int value = 0;
			
			while(true) {
				
				value = fis.read();
				
				if(value == -1) {
					break;
				}
				
				System.out.print( (char)value );
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	// 문자 기반 파일 입력
	public void charInput() {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("super");
			
			int value = 0;
			
			while(true) {
				
				value = fr.read();
				
				if(value == -1) {
					break;
				}
				
				System.out.print((char)value);
				
				
				
			}
			
			
			
			
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	// file 복사하기
	public void fileCopy() {
		
		Scanner sc = new Scanner(System.in);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		
		try {
			
			System.out.print("복사할 파일 경로: ");
			String target = sc.nextLine();
			
			System.out.print("복사본이 저장될 경로 + 파일명 : ");
			String copy = sc.nextLine();
			
			bis = new BufferedInputStream( new FileInputStream(target));
			bos = new BufferedOutputStream( new FileOutputStream(copy));
			
			
			int value = 0;
			
			while(true) {
				value = bis.read();
				if ( value == -1) break;
				bos.write(value);
			}
			
			System.out.println("복사 완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("찾는 파일이 없습니다.");

		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// 객체 출력 보조 스트림 이용
	public void objectOutput() {
		
		
		ObjectOutputStream oos = null;
		
		try {
			
			File folder = new File("object");
			
			if (!folder.exists()) {
				folder.mkdir();
			}
			
			oos = new ObjectOutputStream( new FileOutputStream("object/Member.txt"));
			
			Member mem = new Member("adsf", "sdf", "asf", 36);
			
			oos.writeObject(mem);
			
			
			
			
			
			
			
		} catch( IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	// 입력 보조 스트림 사용
	public void objectInput() {
		
		ObjectInputStream ois = null;
		
		try {

			ois = new ObjectInputStream( new FileInputStream("object/Member.txt"));
			
			Member mem = (Member)ois.readObject();
			System.out.println(mem);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
