package y02_codingTest;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 주어진 일정까지 며칠이 지났는지 파악(일정-1)
		// 메서드하나 만들까. 며칠을 7로 나눠서 나머지에 따라 요일이 나오게
		// 3일 % 7 = 3. 화수'목' , 11일 % 7 = 4. 화수목'금'
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int days = Integer.parseInt(st.nextToken());
		
		int minus = days-1;
		
		if(month != 1) {
			
			switch(month) {
			case 12 : minus += 30;
			case 11 : minus += 31;
			case 10 : minus += 30;
			case 9 : minus += 31;
			case 8 : minus += 31;
			case 7 : minus += 30;
			case 6 : minus += 31;
			case 5 : minus += 30;
			case 4 : minus += 31;
			case 3 : minus += 28;
			case 2 : minus += 31;
			}
			
		}
		
		switch(minus % 7) {
		case 0 : bw.write("MON"); break;
		case 1 : bw.write("TUE"); break;
		case 2 : bw.write("WED"); break;
		case 3 : bw.write("THU"); break;
		case 4 : bw.write("FRI"); break;
		case 5 : bw.write("SAT"); break;
		case 6 : bw.write("SUN"); break;
		}

		
		br.close();
		bw.close();
	}
}




