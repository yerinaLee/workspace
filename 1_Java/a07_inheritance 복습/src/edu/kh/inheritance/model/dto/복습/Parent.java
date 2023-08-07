package edu.kh.inheritance.model.dto.복습;

public class Parent {
	
	private int money = 100_000_000;
	private String lastName = "홍";
	
	
	// 기본생성자
	public Parent() {
		System.out.println("Parent() 기본 생성자로 부모 객체 생성");
	}
	
	
	public Parent(int money, String lastName) {
		System.out.println("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		
		this.money = money;
		this.lastName = lastName;
	}
	
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money=money;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return money + " / " + lastName;
	}
	
	

}
