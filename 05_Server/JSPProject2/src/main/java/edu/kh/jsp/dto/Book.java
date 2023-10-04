package edu.kh.jsp.dto;

public class Book {
	
	private String title;
	private String writer;
	private int price;
	
	public Book() {	} // 기본 생성자

	public Book(String title, String writer, int price) { // 매개변수 생성자
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	
	// getter / setter
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPreice(int price) {
		this.price = price;
	}

	
	// toString 오버라이딩
	@Override // 오버라이딩 메서드 잘 작성되었나 확인
	public String toString() {
		return String.format("%s / %s / %d", title, writer, price);
	}
	
}
