package edu.kh.exception.model.dto;

public class UserException extends Exception{
	
	public UserException() {
		super("사용자 정의 예외 발생 삐용삐용");
	}
	
	public UserException(String message) {
		super(message);
	}
	
	

}
