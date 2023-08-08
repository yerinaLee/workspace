package edu.kh.poly.model.dto;

public class Person extends Animal{
	
	private String name;
	private int age;
	
	public Person() {
		super();	
	}

	public Person(String type, String eatType, String name, int age) {
		super(type, eatType);
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + name + " / " + age;
	}
	
	@Override
	public void breath() {
		System.out.println("사람 : 입과 코로 숨을 쉼");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
