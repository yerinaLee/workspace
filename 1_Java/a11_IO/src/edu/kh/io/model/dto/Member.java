package edu.kh.io.model.dto;

import java.io.Serializable;

// Serializable 인터페이스 : 해당 클래스가 객체로 만들어지면
//							직렬화가 가능함을 나타내는 표시(마커 인터페이스)
public class Member implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	private int point;

	public Member() {} // 기본생성자

	// 매개변수 생성자
	public Member(String id, String pw, String name, int point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}
	
	
	// getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", point=" + point + "]";
	}
	
	
	
	
	
	
	
}
