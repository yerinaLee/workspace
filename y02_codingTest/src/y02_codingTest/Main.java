package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<M; i++) {
			
			int card = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(card)) map.put(card, map.get(card)+1);
			else map.put(card , 1);
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}


