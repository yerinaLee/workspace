package edu.kh.practice;


public class Test2 {
	
	
	public static void main(String[] args) {
		
		String my_string = "bus";
		String answer = "";
		
//		answer = my_string.replace("a, e, i, o, u");
		
		int length = my_string.length();
				
		for(int i = length - 1; i >= 0; i--) {
			answer += my_string.charAt(i);
		}
		
		System.out.println(answer);
		
	}
	
	
}
