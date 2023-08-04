package edu.kh.poly.model.dto;

public class Car extends Object {
		// extends Object : 미작성 시 컴파일러가 자동 추가
	
	private int wheel; // 바퀴 갯수
	private int seat; // 좌석 수
	private String fuel; // 연료

	// 기본생성자 자동완성 : ctrl + space bar -> enter
	public Car() {
		// TODO Auto-generated constructor stub
	}

	// 매개변수 생성자 자동완성 : alt + shift + s -> o
	public Car(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seat;
		this.fuel = fuel;
	}
	
	// getter/setter 자동 완성 : alt + shift + s -> r
	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	// Object의 toString() 오버라이딩 자동 완성
	// alt + shift + s -> s
	@Override
	public String toString() {
		return "Car [wheel=" + wheel + ", seat=" + seat + ", fuel=" + fuel + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
