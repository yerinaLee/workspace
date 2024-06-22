package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		List<Map<Object, Object>> list = new ArrayList<Map<Object,Object>>();
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("age", Integer.parseInt(st.nextToken()));
			map.put("name", st.nextToken());

			list.add(map);
		}
		
		for(int i=0; i<t; i++) {
			for(int j=i+1; j<t; j++) {
				
				
			}
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}




