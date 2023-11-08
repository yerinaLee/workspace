package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // @Controller + @ResponsBody = 비동기 요청, 응답만 하는 컨트롤러
public class CommentController {

	private final CommentService service;
	
	/* HttpMessageConverter
	 * - 비동기 통신 시 반환되는 값을 JS에 맞는 자료형으로 변환
	 * - String, int, double -> text/plain (글자)
	 * - 객체, 컬렉션 -> application (JSON)
	 */
	
	/* JSON (JavaScript Object Notaion, JS 객체 표기법)
	 * - JS 객체 모양의 "문자열" 
	 */
	
	// produces="application/json"
	// -> 반환되는 값이 단순 문자열(String)이 아니라
	//	 JSON이라고 명시!
	//	 -> JS에서 이를 인식하고 JSON -> Object로 파싱 가능
	
	/** 특정 게시글의 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	@GetMapping(value="comment", produces="application/json")
	public List<Comment> select(int boardNo){
		return service.select(boardNo);
	}
	
	// @RequestBody
	// - 비동기요청 body에 담긴 내용을 얻어와
	//	 옆에 작성된 매개 변수에 대입
	
	/** 댓글 등록
	 * @param comment : 커맨드 객체
	 * @return
	 */
	@PostMapping("comment")
	public int insert(@RequestBody Comment comment) {
		return service.insert(comment);
	}
	
	
	
	/** 댓글 수정
	 * @param comment
	 * @return result
	 */
	@PutMapping("comment")
	public int update(@RequestBody Comment comment) {
		return service.update(comment);
	}
	
	
	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	@DeleteMapping("comment")
	public int delete(@RequestBody int commentNo) {
		return service.delete(commentNo);
	}
	
    
	
	
	
	
	
	
	
	
	
}
