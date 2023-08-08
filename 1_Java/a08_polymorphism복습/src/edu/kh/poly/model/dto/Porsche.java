package edu.kh.poly.model.dto;

public class Porsche extends Car {

	private boolean openTheDoor;
	
	public Porsche() {
		super();
	}

	public Porsche(int wheel, int seat, String fuel, boolean openTheDoor) {
		super(wheel, seat, fuel);
		this.openTheDoor = openTheDoor;
	}
	
	public boolean isOpenTheDoor() {
		return openTheDoor;
	}
	
	public void setOpenTheDoor(boolean openTheDoor) {
		this.openTheDoor=openTheDoor;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / Porsche [openTheDoor=" + openTheDoor + "]";
	}
	
	@Override
	public void bindingTest() {
		System.out.println("Porsche 자료형 입니다.");
	}
	
	
	
	
	
	
	
}
