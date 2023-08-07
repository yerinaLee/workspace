package edu.kh.poly.model.dto;

// 인터페이스 : 접점
// - 상수형 필드(public static final)
// - 추상 메서드 (public abstract)

// 계산기 인터페이스
// -> 모든 계산기가 가지는 공통 상수 필드
// -> 모든 계산기가 가지는 이름만 똑같은 기능(메서드)

public interface Calculator {
	
	// public static final을 명시적으로 작성 하든말든
	// 컴파일 시 모두 public static final이 된다
	public static final double PI = 3.14;
	int MAX_NUM = 2_147_000_000; // 최대값. int의 끝임
	public int MIN_NUM = -2_147_000_000; // 최소값
	
	
	public abstract int plus(int a, int b); // +
	public abstract int minus(int a, int b); // -
	public abstract int multi(int a, int b); // *
	public abstract int div(int a, int b); // /
	public abstract int mod(int a, int b); // %
	
	// public abstract 안써도 자동으로 public abstract
	double areaOfCircle(double r); // 원의 넓이
	
	int pow(int a, int x); // 거듭제곱 a^x
	
	
}
