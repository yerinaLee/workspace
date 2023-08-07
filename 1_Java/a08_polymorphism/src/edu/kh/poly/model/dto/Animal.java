package edu.kh.poly.model.dto;

// 추상 클래스(abstract class)
// - 미완성 부분(추상 메서드)이 포함된 클래스
// - 미완성이다보니 단독 객체로 생성이 불가능하다!

// (단, 추상 메서드가 없어도 추상클래스로 선언 가능)
public abstract class Animal {
	
	private String type; // 종, 류(양서류, 포유류, 어류,,)
	private String eatType; // 식성 (초식, 잡식, 육식)
	
	
	public Animal() {
		super(); // object 클래스 생성자
	}
	
	public Animal(String type, String eatType) {
		this.type=type;
		this.eatType=eatType;
	}
	
	
	// getter/setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	// abstract : 추상적인
	// abstract method(추상 메서드)
	// - 몸체(메서드 정의)가 없는 메서드
	//  -> 상속 받은 자식에 따라 코드가 달라져야되기 때문
	//  -> 자식 클래스에서 오버라이딩이 강제화된다!
	public abstract void breath();
	
	// The abstract method breath in type Animal can only be defined by an abstract class
	
}
