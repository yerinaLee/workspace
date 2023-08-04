package edu.kh.oop.calc;

// 계산기
public class Calculator {
	
	private final double PI = 3.141592;
	private final int MAX_VALUE = 1_000_000_000;
	private final int MIN_VALUE = -1_000_000_000;
	
	private double saveValue; // 이전 값들 저장용 필드
	
	// 기본생성자
	public Calculator() { }
	
	// saveValue의 setter
	public void setSaveValue(double saveValue) {
		this.saveValue = saveValue;		
	}
	
	// saveValue의 getter
	public double getSaveValue() {
		return saveValue;
	}
	
	
	// 계산기의 기능
	
	// 더하기
	public double plus(double number) {
		saveValue += number;
		return saveValue;
	}
	
	// 빼기
	public double minus(double number) {
		saveValue -= number;
		return saveValue;
	}
	
	// 곱하기
	public double multi(double number) {
		saveValue *= number;
		return saveValue;
	}
	
	// 나누기
	public double div(double number) {
		
		if (number==0) { // 전달 받은 값이 0일 경우
			saveValue = 0;
			return saveValue;
			
			// 0인 경우 savaValue를 0으로 만든 후
			// 0 return 후 메서드 종료
		}
		// number가 0이 아닌 경우
		// saveValue/number return 후 메서드 종료
		saveValue /= number;
		return saveValue;
	}
	
	
	// 초기화
	public double init() {
		saveValue = 0;
		return saveValue;
	}
	
	
	// 최대값으로 변경
	public double changeMaxValue() {
		saveValue = MAX_VALUE;
		return saveValue;
	}
	
	public double changeMinValue() {
		saveValue = MIN_VALUE;
		return saveValue;
	}
	
	// 원의 넓이 : PI * 반지름의 제곱
	public double theAreaOfACircle(double r) {
		saveValue = PI * r * r;
		return saveValue;
	}
	
	

}
