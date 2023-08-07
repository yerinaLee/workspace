package edu.kh.inheritance.model.dto.복습;

public class Child2 extends Parent {
	
	private String house;
	
	public Child2() {
		super();
		System.out.println("Child2() 기본 생성자로 자식 객체 생성");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자로 자식 객체 생성");
	}
	
	
	public Child2(int money, String lastName, String house) {
		super(money, lastName);
		this.house=house;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / " + house;
	}
	

}
