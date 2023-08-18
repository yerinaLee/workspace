package edu.kh.io.model.dto;

import java.io.Serializable;

public class Member implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	private int point;
	
	public Member() {}

	public Member(String id, String pw, String name, int point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}
	
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
