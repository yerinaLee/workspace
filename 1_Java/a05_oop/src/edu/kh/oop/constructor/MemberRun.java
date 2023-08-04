package edu.kh.oop.constructor;

public class MemberRun {
	public static void main(String[] args) {
		
		// 회원 객체 생성
		Member member1 = new Member();
		// Member() : 생성자
		// - 객체 생성 시 필드 초기화 + 특정 기능 수행을 위한
		//   생성용 기능
		
		Member member2 = new Member("testMember");
		Member member3 = new Member("다른아이디");
		
		
		System.out.println("종료");
		
		
	}
	
	
}
