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
		
		StringTokenizer st;

		int[] arr = new int[9];
		int num = 0;
		int max = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(max < arr[i]) {
				max = arr[i];
				num = i+1;
			}
		}
		
		bw.write(max+"\n");
		bw.write(num+"\n");
		
		br.close();
		bw.close();
	}
}
