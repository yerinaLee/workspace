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
		
		int num = Integer.parseInt(st.nextToken()); 
		int times = Integer.parseInt(st.nextToken()); 
		
		int[] arr = new int[num];
		for(int i=0; i<arr.length; i++) arr[i] = i+1;
		
		int tmp=0;
		
		for(int i=0; i<times; i++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			
			for(int j=s-1; j<=e-1; j++) {
				
				tmp = arr[j];
				arr[j] = arr[e-1];
				arr[e-1] = tmp;
				
				e--;
			}
		}
		
		for(int answer : arr) bw.write(answer+" ");
		
		br.close();
		bw.close();
	}
}



