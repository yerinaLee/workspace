package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 세로읽기
		String[] arr = new String[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = br.readLine();
		}
		
		String answer = "";
		
		for(int col = 0; col<5; col++) {
			for(int row = 0; row<5; row++) {
				
				if((arr[row].charAt(col))+"" == "") continue;
				
				answer += arr[row].charAt(col);
			}
		}
		
		bw.write(answer);
				
				
		br.close();
		bw.close();
	}
}



