package y02_codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		
		String[] arr = str.split(" ");
		
		if(str.equals(" ")) bw.write(arr.length + "");
		
		else if(arr[0].equals("")) {
			List<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(0);
			bw.write(list.size() +"");
			
		} else {
			bw.write(arr.length + "");
		}
		
		br.close();
		bw.close();
	}
}
