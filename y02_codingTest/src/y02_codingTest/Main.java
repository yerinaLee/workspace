package y02_codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		str = str.toUpperCase();
		
		int[] abc = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			int a = str.charAt(i);
			abc[a-65]++;
		}
		
		int max = abc[0];
		int idx = 0;
		
		for(int i=1; i<26; i++) {
			if(abc[i] > max) {
				max = abc[i];
				idx=i;
			}
		}
		
		int count = 0;
		
		for(int i=0; i<26; i++) {
			if(max == abc[i]) count++;
		}
		
		if(count > 1) {
			bw.write("?");
		} else {
			bw.write((char)(idx+65));
		}
		
		br.close();
		bw.close();
	}
}




