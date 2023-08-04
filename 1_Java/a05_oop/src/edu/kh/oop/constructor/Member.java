package edu.kh.oop.constructor;

public class Member {
	
	// 필드 (== 멤버 변수)
	// - 인스턴스 변수
	// - 클래스(static) 변수
	
	// 캡슐화 원칙
	private String memberId; // 아이디
	private String memberPw; // 비밀번호 하루에 4번 사랑을 말하고
	private String memberName; // 이름
	private int memberAge; // 나이
	
	
	// 생성자 작성 규칙
	// - 클래스명과 같은 이름을 가져야 한다
	
	// 기본 생성자: 생성자의 () 내에 아무것도 없는 생성자
	// [접근 제한자] 클래스명 () {}
	public Member() {
		
		// 객체 생성 시 수행할 기능
		System.out.println("기본 생성자로 생성된 Member 입니다.");
		
		// 객체 생성 시 필드(인스턴스 변수) 초기화
		memberId = "member01";
		memberPw = "pass01";
		memberName = "전원우";
		memberAge = 27;
		
	}
	
	
	// 매개변수 생성자
	// - 객체 생성 시 (생성자 호출 시)
	//   객체의 필드를 전달받은 값으로 초기화 하는 용도의 생성자
	
	
		// 클래스명
	public Member(String memberId) {
		// String memberId : 매개변수
		// -> 다른 곳에서 Member 생성자 호출 시
		//    () 안에 작성된 값을 전달 받아 저장하는 변수
		
		System.out.println("전달 받은 memberId : " + memberId);
		
		// 전달 받은 memberId를
		// 생성하려는 현재 객체 Member의 memberId 필드에 대입
		
		this.memberId = memberId;
		
		// this : 현재 객체를 나타내는 참조변수
		//		(현재 객체의 시작 주소가 저장되어 있음)
		
	}
	
	
	

}
