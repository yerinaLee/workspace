package edu.kh.poly.model.dto;

public class YRNCalculatorV2 implements Calculator{

	@Override
	public int plus(int a, int b) {
		return a + b +10;
	}

	@Override
	public int minus(int a, int b) {
		return a - b -10;
	}

	@Override
	public int multi(int a, int b) {
		return a * b * 2;
	}

	@Override
	public int div(int a, int b) {
		return a / b;
	}

	@Override
	public int mod(int a, int b) {
		return a % b;
	}

	@Override
	public double areaOfCircle(double r) {
		return PI*r*r;
	}

	@Override
	public int pow(int a, int x) {
		return 0;
	}
	

}
