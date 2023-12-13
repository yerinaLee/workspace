package edu.kh.todo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;
import edu.kh.todo.model.service.TodoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TodoController {
	
	@Autowired
	private TodoService service;	
	
	
	/** 아이디 중복 검사
	 * @param id
	 * @return 중복 : 1, 사용 가능 : 0
	 */
	@GetMapping("idCheck")
	public int idCheck(@RequestParam("id") String id) {
		return service.idCheck(id);
	}
	
	/** 회원 가입 
	 * @param member
	 * @return 성공 : 1, 실패 : 0
	 */
	@PostMapping(value="/signup" )
	public int signup(@RequestBody TodoMember member) {
		return service.signup(member);
	}
	
	
	/** 로그인
	 * @param member
	 * @return 성공 : 회원 정보/todoList, 실패 : null
	 */
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody TodoMember member){
		return service.login(member);
	}
	
	
	/** 할 일 추가
	 * @param todo
	 * @return 성공 1 : 실패 0
	 */
	@PostMapping("/todo")
	public int insert(@RequestBody Todo todo) {
		return service.insert(todo);
	}
	
	
	/** 할 일 수정
	 * @param todo
	 * @return 성공 1 : 실패 0
	 */
	@PutMapping("/todo")
	public int update(@RequestBody Todo todo) {
		return service.update(todo);
	}
	
	
	/** 할 일 삭제
	 * @param todoNo
	 * @return 성공 1 : 실패 0
	 */
	@DeleteMapping("/todo")
	public int delete(@RequestBody int todoNo) {
		return service.delete(todoNo);
	}
	
	
	/** RestAPI 테스트
	 * @return 100
	 */
	@GetMapping("/test")
	public int test() {
		return 100;
	}

}
