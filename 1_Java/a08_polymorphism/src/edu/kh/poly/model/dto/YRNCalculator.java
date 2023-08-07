package edu.kh.poly.model.dto;

import java.util.Scanner;

// extends : 클래스 간의 상속 또는 인터페이스 간의 상속

// implements(구현하다) : 부모 인터페이스 - 자식 클래스 상속
//				인터페이스는 다중 상속 가능해서 implement's' (인터페이스 여러개 상속 가능)

// 각자 계산기 구현!
public class YRNCalculator implements Calculator{

	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

	@Override
	public int mod(int a, int b) {
		return a%b;
	}

	@Override
	public double areaOfCircle(double r) {
		return r*r*PI;
	}

	@Override
	public int pow(int a, int x) {
		//a를 x-1번만큼 a와 곱해라
		
		int result=1;
		
		for(int i=1; i<=x; i++) {
			
			int sum=0;
			sum += result * a;
			result = sum;
			
		}
		return result;
	}
	
	
	
}
