package edu.kh.poly.model.dto;

// Car를 상속 받은 자식 클래스 Porsche
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
		this.openTheDoor = openTheDoor;
	}

	// Car의 toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / Porsche [openTheDoor=" + openTheDoor + "]";
	}

	
	
	
	
	
	

}
