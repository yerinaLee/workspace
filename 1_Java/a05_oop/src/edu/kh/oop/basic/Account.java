package edu.kh.oop.basic;

public class Account {
	
	String 예금주;
	private String 계좌번호;
	private String 비밀번호;
	int 은행코드;
	int 잔액;
	
	
	public void 예금주입금(int 입금) {
		this.잔액 += 입금;
	}
	
	public void 예금주출금(int 출금) {
		this.잔액 -= 출금;
	}
	
	public void set계좌번호(String 계좌번호) {
		this.계좌번호 = 계좌번호;
	}
	
	public String get계좌번호() {
		return 계좌번호;
	}
	
	public void set비밀번호(String 비밀번호) {
		this.비밀번호 = 비밀번호;
	}
	
	public String get비밀번호() {
		return 비밀번호;
	}
	
//	public String 잔액조회() {
//		return "현재 잔액은 "+ 잔액 +"원 입니다.";
//	}
	public void 잔액조회() {
		System.out.println("현재 잔액은 "+ 잔액 +"원 입니다."); 
	}
	

}
