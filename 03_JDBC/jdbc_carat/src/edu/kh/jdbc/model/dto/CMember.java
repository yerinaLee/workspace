package edu.kh.jdbc.model.dto;

public class CMember {
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String enrollDate;
	private String memberDelFl;
	
	// 기본 생성자
	public CMember() {	}

	// 매개변수 생성자
	public CMember(int memberNo, String memberId, String memberPw, String memberNickname, String enrollDate,
			String memberDelFl) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.enrollDate = enrollDate;
		this.memberDelFl = memberDelFl;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberDelFl() {
		return memberDelFl;
	}

	public void setMemberDelFl(String memberDelFl) {
		this.memberDelFl = memberDelFl;
	}

	@Override
	public String toString() {
		return "CMember [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberNickname=" + memberNickname + ", enrollDate=" + enrollDate + ", memberDelFl=" + memberDelFl
				+ "]";
	}

	
	
	
	
	
	
	
}
