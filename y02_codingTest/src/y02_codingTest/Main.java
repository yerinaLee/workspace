package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		long sum = n-m;
		
		if(sum < 0) sum *= -1;
		
		bw.write(sum+"");
			
			
		bw.flush();
		br.close();
		bw.close();
	}
}




