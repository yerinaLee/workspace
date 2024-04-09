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
		
		int[] arr = new int[5];
		for(int i=0; i<5; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int times = 0;
		int answer = 0;
		
		for(int i=1; ; i++) {
			
			times = 0;
			
			for(int j=0; j<5; j++) {
				if(i % arr[j] == 0) times++; 
			}
			
			if(times >= 3) {
				answer = i; break;
			}
		}
		
		bw.write(answer+"");
		
		br.close();
		bw.close();
	}
}



