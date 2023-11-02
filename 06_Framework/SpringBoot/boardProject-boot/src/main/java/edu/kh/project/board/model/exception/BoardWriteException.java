package edu.kh.project.board.model.exception;

// 사용자 정의 예외 생성 방법
// == 이미 존재하는 아무 예외나 상속
public class BoardWriteException extends RuntimeException{

	public BoardWriteException() {
		super("게시글 작성 중 예외 발생");
	}
	
	public BoardWriteException(String message) {
		super(message);
	}
	
}
