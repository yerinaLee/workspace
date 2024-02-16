package y02_codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest3 {
	
	public static void main(String[] args) {
		
		// 달리기 경주 _ 시간초과. 이해....할수업따...ㅠ
		
//		String[] players= {"mumu", "soe", "poe", "kai", "mine"}; String[] callings = {"kai", "kai", "mine", "mine"};
//		
//		String[] answer = Arrays.copyOf(players, players.length);
//		
//		// players 배열을 복사해 놓음
//		// callings를 순서대로 꺼내면서
//		// callings와 이름이 같은 players의 인덱스 번호를 -1 하고
//		// 추월당한 players의 인덱스 번호는 +1. 아니면 이 둘의 인덱스 번호를 바꿔치기해도 되겠다
//		
//		for(String s:callings) {
//			for(int j=0; j<players.length; j++) {
//				
//				if(answer[j].equals(s)) {
//					
//					String tmp = answer[j];
//					
//					answer[j] = answer[j-1];
//					answer[j-1] = tmp;
//					
//					break;
//				}
//			}
//		}
//		
//		for(String s : answer) System.out.println(s);
		
		
		
		
		
		// 크레인 인형뽑기 게임
		
//		int[][] board = {{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
//		int[] moves = {1,2,3,4};
//		
//		int answer = 0;
//		List<Integer> crain = new ArrayList<Integer>();
//		
//		
//		// moves를 순서대로 돌리면서
//		// board의 전체 행 중 첫번째로 0이 아닌 moves열의 숫자를 0으로 치환함. 해당 숫자는 crain에 저장
//		// crain 저장이 끝나면 앞 순서부터 바로 뒤에와 숫자가 같은지, 0이 아닌지 확인하고, 같으면 둘 다 0로 바꾸고
//		// answer에 +1
//		
//		for(int i=0; i<moves.length; i++) {
//			
//			for(int j=0; j<board.length; j++) {
//				
//				if(board[j][moves[i]-1] != 0) {
//					int tmp = board[j][moves[i]-1];
//					board[j][moves[i]-1] = 0;
//					crain.add(tmp);
//					break;
//					
//				} 
//			}
//		}
//		
//		System.out.println(crain);
//		
//		for(int i=0; i<crain.size(); i++) {
//			
//			for(int j=i+1; j<crain.size(); j++) {
//				
//				if(crain.get(i) == crain.get(j)) {
//					System.out.println(crain.get(i));
//					System.out.println(crain.get(j));
//
//					answer+=2;
//					crain.remove(j);
//					crain.remove(i);
//					
//					i = -1;
//					break;
//					
//				} else break;
//			}
//		}
//		
//		System.out.println(crain);
//		System.out.println(answer);
		
		
		
		// 영어 끝말잇기
		
//		int n=2;
//		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
//		
//		// 같은 단어가 언제 나오는지 확인 -> 없으면 
//        // 앞 단어의 마지막 글자와 다음 단어의 첫번째 글자가 같은지 확인
//		// -> 둘 다 없으면 0.0 리턴
//		// 둘 다 있으면 words에서 어떤 인덱스 번호가 앞에있는지 비교, 더 작은 인덱스 넣기
//        
//		int[] answer = new int[2];
//		List<String> wordsArr = new ArrayList<String>();
//		
//		int idx = -1;
//		
//		// 같은 단어가 언제 나오는지 확인
//		for(int i=0; i<words.length; i++) {
//			if(!wordsArr.contains(words[i])) {
//				wordsArr.add(words[i]);
//			} else {
//				idx = i;
//				break;
//			}
//		}
//		
//		// 앞 단어의 마지막 글자와 다음 단어의 첫번째 글자가 같은지 확인
//		for(int i=0; i<words.length; i++) {
//			for(int j=i+1; j<words.length; j++) {
//				if(words[i].charAt(words[i].length()-1) != words[j].charAt(0)) {
//					if(idx != -1) {
//						idx = j < idx ? j : idx;
//					} else idx = j;
//				} else break;
//			}
//		}
//		
//		if(idx == -1) {
//			answer[0] = 0; answer[1] = 0; 
//		} else idx += 1;
//        
//        // 해당 단어가 있는 곳까지 사람 수대로 잘라서 배열을 만든다
//        // 해당 배열 안에서 단어가 몇번째에 있는지 확인(틀린 사람)
//		
//		if(idx % n == 0) {
//			answer[0] = n; answer[1] = idx / n; 
//		}
//		else {
//			answer[0] = idx%n; answer[1] = idx / n + 1; 
//		}
		
		
		
		// 문자열 나누기
		
//		String s = "abracadabra";
//		int answer = 0;
//		
//		for(int i=0; i<s.length(); i++){
//            
//			int x = 0;
//			int y = 0;
//			
//			for(int j=i; j<s.length(); j++) {
//				if(s.charAt(i) == s.charAt(j)) 	x++;
//				else y++;
//				
//				if(x==y) {
//					answer++;
//					break;
//				} 
//			}
//			
//			if(x!=y && i==s.length()-1) {
//				answer++; break;
//			}
//			i += (x+y)-1;
//        }
//		
//		
//		System.out.println(answer);
		
		
		// 성격 유형 검사하기
		
		String[] survey= {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		// survey for문 돌면서 choices의 선택에 맞게 해당 글자 split해서 점수 부여(map으로 만들기)
		// 
		
		for(int i=0; i<survey.length; i++) {
			
			switch(choices[i]) {
			case 1 :  
			case 2 :  
			case 3 :  
			case 4 : break;  
			case 5 :  
			case 6 :  
			case 7 :  
			}
			
			
		}
		
		
		
		
	}
}

