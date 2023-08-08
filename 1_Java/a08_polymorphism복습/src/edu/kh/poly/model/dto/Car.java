package edu.kh.poly.model.dto;

public class Car {

	private int wheel;
	private int seat;
	private String fuel;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seat;
		this.fuel = fuel;
	}
	
	
	public int getWheel() {
		return wheel;
	}
	
	public void setWheel(int wheel) {
		this.wheel=wheel;
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

	@Override
	public String toString() {
		return "Car [wheel=" + wheel + ", seat=" + seat + ", fuel=" + fuel + "]";
	}
	
	
	public void bindingTest() {
		System.out.println("Car 자료형 입니다.");
	}
	
	
	
	
	
		
}
