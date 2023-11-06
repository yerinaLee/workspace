package edu.kh.project.board.model.exception;

// 사용자 정의 예외 생성 방법
// == 이미 존재하는 아무 예외나 상속
public class BoardUpdateException extends RuntimeException{

	public BoardUpdateException() {
		super("게시글 수정 중 예외 발생");
	}
	
	public BoardUpdateException(String message) {
		super(message);
	}
	
}
