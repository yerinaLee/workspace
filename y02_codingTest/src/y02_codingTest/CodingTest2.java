package y02_codingTest;

import java.util.Arrays;
import java.util.Collections;

public class CodingTest2 {
	
	public static void main(String[] args) {
		
//		int[] emergency= {3, 76, 24};
//        int[] answer = new int[emergency.length];
//        
//        int num = emergency.length;
//        
//        // 인덱스 번호를 왔다갔다...?!!
//        
//        for(int i=0; i<emergency.length; i++) {
//        	
//        	for(int j=i; j<emergency.length; j++) {
//            	if(emergency[i] < emergency[j]) {
//            		answer[i] = num;
//            	}
//        	}
//        	
//        	num--;
//        }
//        
//        for(int i : answer) System.out.println(i);
		
		
		// 비밀지도
//        int n=5; int[] arr1= {9, 20, 28, 18, 11}; int[] arr2 = {30, 1, 21, 17, 28};
//        
//        String[] arr1Binary = new String[arr1.length];
//        String[] arr2Binary = new String[arr2.length];
//        
//        for(int i=0; i<arr1.length; i++) {
//        	arr1Binary[i] = Integer.toBinaryString(arr1[i]);
//        	arr2Binary[i] = Integer.toBinaryString(arr2[i]);
//        	
//        	if(arr1Binary[i].length() < n) {
//        		int minusLength = n - arr1Binary[i].length();
//        		for(int j=0; j < minusLength; j++) arr1Binary[i] = "0"+arr1Binary[i]; 
//        	}
//        	
//        	if(arr2Binary[i].length() < n) {
//        		int minusLength = n - arr2Binary[i].length();
//        		for(int j=0; j < minusLength; j++) arr2Binary[i] = "0"+arr2Binary[i];
//        	}
//        }
//        
////        for(String s : arr1Binary) System.out.println(s);
//        
//        // for문으로 arr1과 arr2를 같이 돌려서
//        // 만약 둘 중 하나라도 1이면 그 인덱스 번호는 '#'인 것으로 하는 배열 생성
//        
//        String[] answer = new String[n];
//        for(int i=0; i<n; i++) {
//        	
//        	answer[i] = "";
//        	
//        	for(int j=0; j<n; j++) {
//        		if(arr1Binary[i].charAt(j) == '1' || arr2Binary[i].charAt(j) == '1' ) {
//            		answer[i]+="#";
//            	} else {
//            		answer[i]+=" ";
//            	}
//        	}
//        }
//        
//        for(int i=0; i<answer.length; i++) {
//        	System.out.println(answer[i]);
//        }
//        
        
		
		// 진료순서 정하기
		// 원 배열을 복사 후 sorting하고
		// sorting한 배열과 원배열의 내용이 같으면 원배열 인덱스 번호를 입력한다.
//		
//		int[] emergency = {1, 2, 3, 4, 5, 6, 7};
//		
//		Integer[] answer = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
//		Arrays.sort(answer, Collections.reverseOrder());
//		
//		for(int i=0; i<emergency.length; i++) {
//			
//			for(int j=0; j<emergency.length; j++) {
//				if(emergency[i] == answer[j]) {
//					emergency[i] = j+1;
//					break;
//				}
//			}
//		}
		
        
//		String s = "1 2 Z 3";
//		int answer = 0;
//		
//		String[] sArr = s.split(" ");
//		
//		for(int i=0; i<sArr.length; i++) {
//			
//			if(sArr[i].equals("Z")) {
//				answer -= Integer.valueOf(sArr[i-1]);
//			} else {
//				answer += Integer.valueOf(sArr[i]);
//			}
//		}
//		
//		System.out.println(answer);
		
		
//		int[] array = {7, 77, 17};
//		int answer = 0;		
//		String arrays = "";
//		
//		for(int i : array) arrays += i+"";
//		
//		for(char c : arrays.toCharArray()) {
//			if(c == '7') answer++;
//		}
//			
//		System.out.println(answer);
		
//		String bin1="10"; String bin2="11";
//		
//		// 2진수 -> 10진수 변환
//		int bin11 = Integer.parseInt(bin1, 2);
//		int bin22 = Integer.parseInt(bin2, 2);
//		
//		String answer = Integer.toBinaryString(bin11+bin22);
//		
//		System.out.println(answer);
        
		
		
		int n=0, m=5;
	        
	        int[] answer = new int[2];
	        
	        // 최대공약수 유클리드 호제법
	        
//	        int gcd(int n, int m) {
//	        	
//	        	int r=0;
//	        	while(m>0) {
//	        		
//	        		r = n % m;
//	        		n = m;
//	        		m = r;
//	        	}
//	        	
//	        	return n;
//	        }
	        
	        
	        int max = (n>m? n : m);
	        int min = (n>m? m : n);
	        
	        // 최대공약수
	        for(int i=1; i<=min; i++) {
	            if(n%i==0 && m%i==0){                
	                answer[0] = i;
	            } 
	        }
	        
	        // 최소공배수
	        for(int i=1; i<=max*min; i++){
	            for(int j=1; j<=max*min; j++){
	                
	                if(max*i==min*j) {
	                    answer[1] = max*i;
	                    break;
	                } 
	            }
	            
	            if(answer[1] != 0) break;
	        }
        
        for(int i : answer) System.out.println(i);
		
	}

}
