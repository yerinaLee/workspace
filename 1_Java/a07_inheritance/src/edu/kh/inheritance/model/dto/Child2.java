package edu.kh.inheritance.model.dto;

// Parent를 상속 받겠다
// -> Child2가 Parent의 필드, 메서드를 내부에 포함하게되어 자신의 것처럼 사용
// -> 단, Parent의 필드 메서드 중 private 설정된 것은 자식이 다룰 수 없다
public class Child2 extends Parent {

	private String house;

	
	// 생성자
	public Child2() {
		super(); // 상속 관계 시 부모 객체가 먼저 생성되어야 하기 때문에
				// 자식 생성자 첫번째 줄에 무조건 작성!
				// 단, 미작성시 컴파일러가 추가

		System.out.println("Child2() 기본 생성자로 자식 객체 생성");
	};
	

	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자로 자식 객체 생성");
	}

	
	public Child2(int money, String lastName, String house) {

		// 자식 객체 생성 시
		// 매개변수가 있는 super() 생성자를 이용해서
		// 부모 객체의 필드도 초기화 할 수 있다.

		super(money, lastName);
		this.house=house;
	}
	

	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}
	
	@Override // 오버라이딩 문법 검사 해줘(컴파일러에게 주석 남김)
	public String toString() {
		// 부모로부터 상속받은 멤버(필드, 메서드)를
		// 자식이 자신의 것처럼 사용 가능
//		setLastName(house);
//		setMoney(110);
		
		// 부모의 toString()을 호출하여 반환된 결과를 이용
		return super.toString() + "/ " + house;
				// money + " / " + lastName;		
	}
	
}