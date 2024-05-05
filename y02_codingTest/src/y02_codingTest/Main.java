package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1475- 방번호
		
		String n = br.readLine();
		int answer = 1;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<n.length(); i++) {
			
			boolean exist = false;
			
			if(n.charAt(i)-'0' == 9) {
				if(set.contains(9)) {
					exist = set.add(6);
				} else {
					exist = set.add(9);
				}

			} else if(n.charAt(i)-'0' == 6) {
				if(set.contains(6)) {
					exist = set.add(9);
				} else {
					exist = set.add(6);
				}
			}
			else exist = set.add(n.charAt(i)-'0');
			
			if(!exist) {
				answer++;
				set.clear();
				set.add(n.charAt(i)-'0');
			}
		}
		
		bw.write(answer+"");
		
		br.close();
		bw.close();
	}
}




