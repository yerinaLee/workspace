package edu.kh.collection.list.mode.dto;

public class Student {
	
	private int grade;
	private int ban;
	private int number;
	private String name;
	private int gender;
	private int score;
	
	public Student() {}

	public Student(int grade, int ban, int number, String name, int gender, int score) {
		super();
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + " grade=" + grade + ", ban=" + ban + ", number=" + number + ", gender="
				+ gender + ", score=" + score + "]";
	}
	
	
	
	
	
	
	
	

}
