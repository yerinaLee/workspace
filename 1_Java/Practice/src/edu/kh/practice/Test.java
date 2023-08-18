package edu.kh.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	
	// 프로그래밍 언어 응용 시험문제 풀기
	
	public static void main(String[] args) {
		
//		List<String> nameList = new ArrayList<String>(); 
//		
//		while(true) {
//			
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.print("이름을 입력해주세요 : ");
//			String name = sc.next();
//			
//			if(name.equals("exit")) {
//				break;
//			}
//			
//			if(name.equals("clear")) {
//				nameList.clear();
//				continue;
//			}
//			
//			if(nameList.contains(name)) {
//				System.out.println("이미 존재하는 이름입니다");
//			} else {
//				nameList.add(name);
//			}
//		}
//		
//		for ( String name : nameList) {
//			System.out.println(name);
//		}
//		
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for(int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }
        
	}

	
	
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        char[] my = my_string.toCharArray();
        char[] over = overwrite_string.toCharArray();
        
        System.arraycopy(my, s, over, 0, overwrite_string.length());
       
        String str = new String(my);
        
        return str;
    }
	
	
	
	
}
