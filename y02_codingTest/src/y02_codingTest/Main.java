package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int max = Math.max(a, b);
			int min = Math.min(a, b);
			
			int idx = 1;
			while(true) {
				
				if(max * idx % min == 0) {
					bw.write(max * idx+"\n");
					break;
				}
				
				idx++;
			}
			
		}
		
		br.close();
		bw.close();
	}
}




