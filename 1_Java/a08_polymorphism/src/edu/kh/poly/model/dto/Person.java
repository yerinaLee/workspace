package edu.kh.poly.model.dto;

// extends : 클래스, 추상클래스
public class Person extends Animal {

	private String name;
	private int age;

	public Person() {
		super(); // Animal 생성자
		// 추상 클래스는 단독 객체 생성은 안되지만
		// 상속 받은 자식의 일부분으로서는 생성 가능
		// -> 미완성 부분은 자식 객체가 오버라이딩을 통해서 완성하기 때문에
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
	
	// 부모(Animal)로 부터 상속 받은 breath 메서드를
	// 오버라이딩(구현, 정의)하라고 강제되고 있음
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
