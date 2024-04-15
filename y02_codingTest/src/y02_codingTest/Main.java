package y02_codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[i][j];
		
		for(int n=0; n<i; n++) {
			
			String str = br.readLine();
			
			for(int m=0; m<j; m++) {
				if(str.charAt(m) == 'X') {
					arr[n][m]++;
				}
			}
		}
		
		int answer = 0;
		boolean flag = false;
		
		// 행의 빈칸을 파악함
		for(int n=0; n<i; n++) {
			
			flag = false;
			
			for(int m=0; m<j; m++) {
				if(arr[n][m] == 1) {
					flag = true;
				}
			}
			
			if(!flag) answer++; 
		}
		
		// 열의 빈칸을 파악함
		for(int n=0; n<i; n++) {
			flag = false;
			for(int m=0; m<j; m++) {
				if(arr[n][m] == 1) {
					flag = true;
				}
			}
			
			if(!flag) answer++; 
		}
		
		
		
		bw.write(answer+"");
		
		br.close();
		bw.close();
	}
}



