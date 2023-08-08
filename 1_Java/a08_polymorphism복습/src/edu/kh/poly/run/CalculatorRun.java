package edu.kh.poly.run;

import edu.kh.poly.model.dto.YRNCalculator;

public class CalculatorRun {

	public static void main(String[] args) {
		
		
		YRNCalculator yc = new YRNCalculator();
		
		System.out.println(yc.plus(3, 6));
		System.out.println(yc.minus(3, 6));
		System.out.println(yc.div(3, 6));
		System.out.println(yc.multi(3, 6));
		System.out.println(yc.mod(3, 6));
		
		System.out.println(yc.areaOfCircle(3.6));
		System.out.println(yc.pow(2, 4));

		
		
	}
	
	
	
}
