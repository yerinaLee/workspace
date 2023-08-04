package edu.kh.oop.basic;

/*객체란?
 * 
 * - 현실 : 속성(data)과 기능(method)를 가지고 있는 식별 가능한 것
 * 
 * - Java : 클래스에 작성된 내용을 토대로
 * 			new 연산자에 의해 Heap 메모리에 생성되는 것
 * 
 * 
 * 클래스(class)란?
 * - 객체의 특성(속성, 기능)에 대해 정의를 한 것
 * 	 -> 일종의 설계도로 class에 정의된 내용대로
 * 		Heap 메모리에 생성하면 객체가 된다.
 * 	
 * 	+ 하나의 설계도(class)를 이용해 여러 객체를 만들 수 있다
 * 
 */


public class BasicRun {
	
	public static void main(String[] args) {
		
		
		// Nation 클래스를 이용해서 객체 생성하기
		Nation n1 = new Nation();
		
		// 클래스 == 설계도 == 사용자 정의 자료형
		// Nation n1 : Nation 객체 참조변수 n1을 선언(주소 저장)
		
		// new : Heap 영역에 새롭게 할당(생성)
		// new Nation : Nation클래스를 이용해서 
		// 				Heap 영역에 Nation 객체를 새롭게 생성(공간을 할당)
					//	-> 할당된 메모리의 시작 주소가 반환됨 
		
		// Nation n1 = new Nation();
		// Nation 참조변수 n1에
		// Heap에 새로 생성된 Nation 객체의 주소를 대입
		
		// n1 == Nation 객체를 참조하는 변수
		// == Nation 객체를 다루는 것

		// . (점, 하위접근)연산자 : 객체의 속성 또는 기능에 접근, 실행하는 연산자

		n1.납세의의무();
		n1.speakKorean();
		
		// 객체의 속성에 값 대입
		n1.pNo = "990608-2235456";
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 종로구 kh빌딩";
		n1.phone = "010-1237-6543";
		n1.age = 24;
		
		
		// 객체에 저장된 속성 출력		
		System.out.println(n1.name);
		System.out.println(n1.pNo);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		
		/* 캡슐화 적용 확인 */
		// private String job; 에 값 대입하기
		
//		n1.job = "국정원 비밀요원";
		// The field Nation.job is not visible : job 변수 안보여
		// -> private으로 안보이게 가려놔서 직접 접근 불가능
		
		
		/* 간접 접근 기능 */
		n1.setJob("(돈 많이 버는)웹개발자");
		System.out.println(n1.getJob());
		
		n1.introduce();

		
		
		// 새로운 국민(Nation) 객체 생성
		Nation n2 = new Nation();
		n2.name = "김민희";
		n2.age = 36;
		
		
		Nation n3 = new Nation();
		n3.name = "박수진";
		n3.age = 22;
		
		System.out.printf("%s의 나이는 %d세 입니다.\n", n1.name, n1.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n2.name, n2.age);
		System.out.printf("%s의 나이는 %d세 입니다.\n", n3.name, n3.age);
		
		n1.납세의의무();
		n2.납세의의무();
		n3.납세의의무();
		

		
		
		
		Account account = new Account();
		
		account.예금주 = "이예리나";
		System.out.print(account.예금주 + "님의 ");
		
		account.set계좌번호("654-6354-63514");
		System.out.println("계좌번호 : " + account.get계좌번호());
		
		account.set비밀번호("4567");
		System.out.println("비밀번호 : " + account.get비밀번호());
		
		account.예금주입금(300000);
		account.예금주출금(6540);
		account.잔액조회();
//		System.out.print(account.잔액조회());
		
		
		
		
		
		
	}

}
