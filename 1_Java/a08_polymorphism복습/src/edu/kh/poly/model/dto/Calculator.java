package edu.kh.poly.model.dto;

public interface Calculator {
	
	public static final double PI = 3.14;
	int MAX_NUM = 2_147_000_000;
	public int MIN_NUM = -2_147_000_000;
	
	public abstract int plus(int a, int b);
	public abstract int minus(int a, int b);
	public abstract int multi(int a, int b);
	public abstract int div(int a, int b);
	public abstract int mod(int a, int b);
	
	double areaOfCircle(double r);
	
	int pow(int a, int x);

}
