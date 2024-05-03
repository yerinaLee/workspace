package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer> list = new ArrayList<Integer>();
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
		}
		
		list.sort(Comparator.reverseOrder());
		
		for(int i:list) bw.write(i+"");
		
		br.close();
		bw.close();
	}
}




