package edu.kh.variable;

public class Practice {
	
	
	public static void main(String[] args) {
		

		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		
		System.out.println(iNum1 / iNum2); // 2
		System.out.println((int)dNum); //2

		System.out.println((double)iNum1); //10.0
		System.out.println(iNum2 * dNum); //10.0
		
		System.out.println((int)fNum ); //3
		System.out.println(iNum1 / (int)fNum ); //3
		System.out.println((int)(iNum1 / fNum )); //3
		
		System.out.println(iNum1 / fNum); // 3.333333
		
		System.out.println((double)(iNum1 / fNum)); // 3.3333332538604736 이거 왜다르지?!!!
		System.out.println(((double)iNum1 / fNum)); // 3.3333333333333335 
		
		System.out.println((int)ch); // 65
		
		System.out.println((char)(iNum1 + ch)); // 75
		
		
		
		
	}
	
	
}
