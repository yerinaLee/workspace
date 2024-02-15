package y02_codingTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        
		
		
//			int n=2, m=5;
//	        int[] answer = new int[2];
	        
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
	        
	        
//	        int max = (n>m? n : m);
//	        int min = (n>m? m : n);
//	        
//	        // 최대공약수
//	        for(int i=1; i<=min; i++) {
//	            if(n%i==0 && m%i==0){                
//	                answer[0] = i;
//	            } 
//	        }
//	        
//	        // 최소공배수
//	        for(int i=1; i<=max*min; i++){
//	            for(int j=1; j<=max*min; j++){
//	                
//	                if(max*i==min*j) {
//	                    answer[1] = max*i;
//	                    break;
//	                } 
//	            }
//	            
//	            if(answer[1] != 0) break;
//	        }
//        
//        for(int i : answer) System.out.println(i);
        
        
        
        
        
//        String[] seoul = {"Jane", "Kim"};
//            String answer = "";
//            
//            for(int i=0; i<seoul.length; i++){
//                if(seoul[i].equals("Kim")) answer = "김서방은 " + i + "에 있다";
//            }
            
            
//		String today= "2022.05.02";
//		String[] terms= {"A 6", "B 20", "C 3"};
//		String[] privacies= {"2021.05.02 A", "2021.12.01 B", "2022.02.19 C", "2022.02.20 C"};
//		
//		// 1. 28일이 넘어가면 달이 올라가고, 달이 다 지나면 년이 올라가는 계산하는 메서드
//		
//		// privacies를 일단 나누고
//		// 나눈 날짜를 약관 번호에 따라서 개월수를 더하고
//		// 더해서 나온 날짜가 today랑 비교해서 크면 최종 배열에 인덱스 번호 넣기
//		
//		List<Integer> answer = new ArrayList<Integer>();
//		
//		for(int i=0; i<privacies.length; i++) {
//			
//			int months = 0;
//			
//			String[] devidePri = privacies[i].split(" "); // devidePri[0] : 날짜, [1] : 약관(A)
//			
//			// 약관 기한 데이터 구하기
//			for(String s : terms) {
//				if(s.contains(devidePri[1])) { // 약관번호와 일치한다면
//					
//					// 약관 개월수 구하기
//					String[] monthDevi = s.split(" ");
//					months = Integer.valueOf(monthDevi[1]);
//					
//					// 약관 마감 날짜 구하기
//					String deadline = calDate(devidePri[0], months);
//					
//					System.out.println(deadline);
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//					
//					// 오늘 날짜와 약관날짜 비교하기
//					try {
//						//System.out.println(sdf.parse(deadline)); // Thu May 19 00:00:00 KST 2022
//						
//						if((sdf.parse(today)).after(sdf.parse(deadline))) {
//							answer.add(i+1);
//						}
//						
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println(answer);
//        
//		// int 배열로 바꾸기
//		int[] answerArr = new int[answer.size()];
//		for(int i = 0; i<answer.size(); i++) {
//			answerArr[i] = answer.get(i).intValue();
//		}
		
		
		
		
		// 귤 고르기
		
		// 1. 주어진 배열을 종류+갯수 리스트로 만들기
		
//		int k=4; int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
//		Map<Integer, Integer> kindMap = new HashMap<Integer, Integer>();
//		
//		// key
//		for(int i:tangerine) {
//			if(!kindMap.containsKey(i)) kindMap.put(i, 1);
//			else kindMap.put(i, kindMap.get(i)+1);
//		}
//		
//		// map을 value들의 내림차순으로 정렬하고
//		// value들의 값을 더하다가 k를 넘어가면 stop. 이때 더해진 k의 수가 정답임
//		
//		int[] keys = new int[kindMap.size()];
//		
//		int idx = 0;
//		
//		for(int i:kindMap.values()) {
//			keys[idx] = i;
//			idx++;
//		}
//		
//		Integer[] keys2 = Arrays.stream(keys).boxed().toArray(Integer[]::new);
//		Arrays.sort(keys2, Collections.reverseOrder());
//		
//		for(int i:keys2) System.out.println(i);
//		
//		
//		int count = 0;
//		int answer = 0;
//		
//		for(int i=0; i<keys2.length; i++) {
//			count += keys2[i];
//			if(count > k) {
//				answer = i; break;
//			}
//		}
//		
//		System.out.println(answer);
		
		
		// map.values() -> map의 value들만 출력 가능

		// map에서 k값이 있으면 반환, 없으면 디폴트밸류(0)반환 함수
//		for(int t : tangerine) {
//	         map.put(t, map.getOrDefault(t, 0)+1);
//		}
		
		
		
		// 행렬의 덧셈
		
		int[][] arr1 = {
						{1},
						{2}
						};
		
		int[][] arr2={
					{3},
					{5}
					}; 
		
		int[][] answer = new int[arr1.length][arr1[0].length];
		
		for(int i=0; i<arr1.length; i++) {
			
			for(int j=0; j<arr1[0].length; j++) {
				
				answer[i][j] = arr1[i][j] + arr2[i][j];
				System.out.println(answer[i][j]);
				
			}
		}
		
		
		
		
		
	}
	
	
	
	
	// 날짜 더하는 데이트(12개월 넘어갈때 1년 +)
	private static String calDate(String date, int months) {
		
		String[] dateDevide = date.split("\\.");

		if(Integer.valueOf(dateDevide[1]) + months > 12) {
			
			// 년 수가 2년을 넘어가게된다면?
			if((Integer.valueOf(dateDevide[1]) + months) - 12 > 12) {
				
				if(Integer.valueOf(dateDevide[2])-1 == 0) {
					dateDevide[1] = (Integer.valueOf(dateDevide[1]) + months) -25 + "";
				} else {
					dateDevide[1] = (Integer.valueOf(dateDevide[1]) + months) -24 + "";
				}
				
				dateDevide[0] = Integer.valueOf(dateDevide[0]) + 2 + "";
				
				
			} else {
				dateDevide[1] = (Integer.valueOf(dateDevide[1]) + months) -12 + "";
				dateDevide[0] = Integer.valueOf(dateDevide[0]) + 1 + "";
			}
			
		} else {
			dateDevide[1] = Integer.valueOf(dateDevide[1]) + months + "";
		}
		
		// 일수에서 하루를 빼고, 0이 된다면 28로 바꾸기
		if(Integer.valueOf(dateDevide[2])-1 == 0) {
			dateDevide[2] = "28";
		} else {
			dateDevide[2] = Integer.valueOf(dateDevide[2]) - 1 + "";
		}
		
		return dateDevide[0] + "." + dateDevide[1] + "." + dateDevide[2];
	}
	
	
}
