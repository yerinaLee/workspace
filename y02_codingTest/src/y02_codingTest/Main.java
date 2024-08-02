package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken()); 
			
			switch(order) {
			case "push_front" : deq.addFirst(num); break;
			case "push_back" : deq.addLast(num); break;
			case "pop_front" : bw.write((deq.size()!=0  ? deq.removeFirst(): -1)+"\n"); break;
			case "pop_back" : bw.write(""+(deq.size()!=0 ? deq.removeLast() : -1)+"\n"); break;
			case "size" : bw.write(deq.size()+""+"\n"); break;
			case "empty" : bw.write(""+(deq.isEmpty() ? 1 : 0)+"\n"); break;
			case "front" : bw.write(""+(deq.isEmpty() ? -1 : deq.getFirst() )+"\n"); break;
			case "back" : bw.write(""+(deq.isEmpty() ? -1 : deq.getLast() )+"\n"); break;
		}
		
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}


