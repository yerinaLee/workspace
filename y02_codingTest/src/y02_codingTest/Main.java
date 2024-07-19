package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();

			for(int j=0; j<M; j++) {
				if(str.charAt(j) == 'W') arr[i][j] = 1; 
				else  arr[i][j] = 0; 
			}
		}
		
		for(int i=0; i<N-i; i++) {
			
			for(int j=0; j<; j++) {
				
			}
		}
		
		
		
		
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}


