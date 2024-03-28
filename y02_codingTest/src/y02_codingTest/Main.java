package y02_codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "Hello";
		
		String str2 = str;
		
		bw.write("대입된 str2 : " + str2);

		str = "Hello wooooooorld!!!!";
		
		bw.write("\n바뀐 str : " + str);
		bw.write("\nstr바뀐 후 str2 : " + str2);
		
		bw.close();
	}
}
