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
		
		List<Integer> list = new ArrayList<Integer>();
		Boolean flag = false;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				
				int sum = 0;
				
				for(int x=0; x<8; x++) {
					for(int y=0; y<7; y++) {
						if(arr[x][y] == arr[x][y+1]) {
							sum++;
							y++;
						}
					}
				}
				
				if(sum == 0) {
					flag = true;
					break;
				}
				else list.add(sum);
			}
			
			if(flag) break;
		}
		
		if(flag) bw.write(0+"");
		else {
			Collections.sort(list);
			bw.write(list.get(0));
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}


