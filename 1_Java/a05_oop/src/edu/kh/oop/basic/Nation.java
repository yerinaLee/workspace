package edu.kh.oop.basic;

// 국민 정보를 저장할 객체를 위한 클래스(설계도)
public class Nation {
	
	/* 속성 */
	String pNo; // 주민등록번호
	String name; // 이름
	char gender; // 성별
	String address; // 주소
	String phone; // 전화번호
	int age; // 나이
	
	// 캡슐화 적용 : 불투명하게해서 가리기
	//	-> 외부 직접 접근을 차단해서 존재 유무, 실제 데이터를 모르게 하기
	// 	(정보 은닉)
	private String job;
	
	// private(개인적인, 사적인)
	// -> 현재 클래스에서만 접근 가능
	
	
	/* 기능 */
	public void speakKorean() {
		System.out.println("가나다라 한국어 가능");
	}
	
	public void 납세의의무() {
		System.out.println("세금... 내야지...");
	}
	
	public void introduce() { // 자기소개 기능
		System.out.printf("저의 이름은 %s이고, 직업은 %s 입니다. \n", name, job);
	}
		
	
	// 캡슐화 원칙에 의해서
	// 직접 접근이 차단된 변수(필드)에
	// 값을 세팅하거나 얻어갈 수 있는 간접 접근 기능을 작성
	
	// 전달 받은 값으로 job을 세팅
	public void setJob(String job) { // String job(매개변수)
									// 전달된 값을 저장하는 변수
		this.job = job;
	}
	
	// Nation 객체가 가지고 있는 job의 값을 호출한 곳으로 돌려보내주는 기능
	public String getJob() {
		return job;
	}
	
	
	
	

}
