package edu.kh.collection.list.model.dto;

import java.util.Objects;

// Comparable<Student> 인터페이스
// -> Student 객체 정렬 기준을 정하기 위한 기능
//    compareTo()를 제공하는 인터페이스
public class Student implements Comparable<Student> {
	
	// 필드
	private int grade;
	private int ban;
	private int number;
	private String name;
	private char gender;
	private int score;
	
	public Student() {	} // 기본 생성자
	
	// 매개변수 생성자
	public Student(int grade, int ban, int number, String name, char gender, int score) {
		super();
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	
	// getter/setter
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
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
		return "Student [grade=" + grade + ", ban=" + ban + ", number=" + number + ", name=" + name + ", gender="
				+ gender + ", score=" + score + "]";
	}
	
	// A.equlas(B) :
	// A 객체와, B 객체가 가지고 있는 필드의 값이 모두 같으면 true, 아님 false
	
	// Object.equals() 오버라이딩
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) { // 같은 객체 참조(주소가 같음)
			return true;
		}
		
		if(obj == null) { // 비교 대상이 null
			return false;
		}
		
		if(!(obj instanceof Student)) { // 비교 대상이 Student가 아니면
			return false;
		}
		
		
		// obj가 참조하는 객체를 Student로 다운캐스팅
		Student other = (Student)obj;
		
		// 현재 객체(this)와 다른 객체(other)의 필드를 비교
		return this.grade == other.grade
			&& this.ban == other.ban
			&& this.number == other.number
			&& this.name.equals(other.name)
			&& this.gender == other.gender
			&& this.score == other.score;
	}
	
	// (중요!) equals()를 오버라이딩 했으면
	// hashCode()도 오버라이딩을 해야한다!!
	// (둘이 짝꿍임~)
	
	// hashCode() : 해시 테이블(객체 주소록)에서
	//				객체를 빨리 찾아가게 하기 위한 번호

	// ****************************************
	// A.equals(B)의 결과가 true이면
	// A.hashCode() == B.hashCode()의 결과도 true여야 한다! (해시코드가 같아야!)
	// ****************************************

	@Override
	public int hashCode() {
		// Objects : Object 관련 유용한 메서드 모음
		return Objects.hash(grade, ban, number, name, gender, score); // 같은 값들이 들어오면 같은 결과가 나온다
	}
	
	// 비교 기준을 제시하는 메서드
	@Override
	public int compareTo(Student o) {
		
		// this : 현재 객체
		// o : 비교 객체
		
		return this.score - o.score;
	}
	
	
	
	
}
