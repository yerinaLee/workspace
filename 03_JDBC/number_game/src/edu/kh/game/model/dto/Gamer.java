package edu.kh.game.model.dto;

public class Gamer {
	
	private int gamerNo;
	private String gamerNickname;
	private String gamerPw;
	private String enrollDate;
	private int tryCount;
	private int gamerRecords;
	
	// 기본생성자
	public Gamer() {}
	
	// 매개변수 생성자
	public Gamer(int gamerNo, String gamerNickname, String gamerPw, String enrollDate, int tryCount, int gamerRecords) {
		super();
		this.gamerNo = gamerNo;
		this.gamerNickname = gamerNickname;
		this.gamerPw = gamerPw;
		this.enrollDate = enrollDate;
		this.tryCount = tryCount;
		this.gamerRecords = gamerRecords;
	}
	
	public Gamer(String gamerNickname, String gamerPw) {
		super();
		this.gamerNickname = gamerNickname;
		this.gamerPw = gamerPw;
	}
	
	public Gamer(String gamerNickname, String gamerPw, int gamerRecords) {
		super();
		this.gamerNickname = gamerNickname;
		this.gamerPw = gamerPw;
		this.gamerRecords = gamerRecords;
	}
	
	// getter/setter
	public int getGamerNo() {
		return gamerNo;
	}

	public void setGamerNo(int gamerNo) {
		this.gamerNo = gamerNo;
	}

	public String getGamerNickname() {
		return gamerNickname;
	}

	public void setGamerNickname(String gamerNickname) {
		this.gamerNickname = gamerNickname;
	}

	public String getGamerPw() {
		return gamerPw;
	}

	public void setGamerPw(String gamerPw) {
		this.gamerPw = gamerPw;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getTryCount() {
		return tryCount;
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	public int getGamerRecords() {
		return gamerRecords;
	}

	public void setGamerRecords(int gamerRecords) {
		this.gamerRecords = gamerRecords;
	}

	
	
	
	@Override
	public String toString() {
		return "Gamer [gamerNo=" + gamerNo + ", gamerNickname=" + gamerNickname + ", gamerPw=" + gamerPw
				+ ", enrollDate=" + enrollDate + ", tryCount=" + tryCount + ", gamerRecords=" + gamerRecords + "]";
	}
	
	
	
	
	
	

}
