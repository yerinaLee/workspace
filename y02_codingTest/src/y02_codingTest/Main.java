package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][5];
		
		for(int i=0; i<num; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int[] answer = new int[num];

		for(int i=0; i<num; i++) {
			
			for(int col=0; col<5; col++) {
				for(int row=0; row<answer.length; row++) {
					if(arr[i][col] == arr[row][col]) answer[i]++;
				}
			}
		}
		
		int max = answer[0];
		
		for(int i : answer) max = Math.max(max, i);
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == max) {
				bw.write(i+1+"");
				break;
			}
		}
		
		br.close();
		bw.close();
	}
}




