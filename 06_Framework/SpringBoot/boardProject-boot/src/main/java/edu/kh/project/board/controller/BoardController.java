package edu.kh.project.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("board")
@SessionAttributes({"loginMember"})
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
	/* @PathVariable : 주소에서 지정된 부분을 변수 값으로 사용
	 *	1) 주소에서 값을 얻어오려는 부분에 {key} 작성
	 *	2) 컨트롤러 매개변수 앞에
	 *	  @PathVariable("key")를 작성하면
	 *	  매개변수에 주소에서 얻어온 값이 저장된다
	 *
	 *	- 특징 1 : @PathVariable로 얻어온 값은 자동으로 request scope에 추가된다!!
	 *
	 *	- 특징 2 : 정규표현식이 적용된다!
	 *
	 * 	@GetMapping("{boardCode:[0-9]+}")
	 * 	-> /board/{boardCode}
	 * 	-> {boardCode} 자리에는 숫자(0~9) 한자리 이상만 가능
	 */
	
	
	/** 게시글 목록 조회
	 * @param boardCode : 게시판 종류 번호
	 * @param cp
	 * @param model : 데이터 전달용 객체
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}")
	public String selectBoardList( @PathVariable("boardCode") int boardCode,
			Model model) {
		
		Map<String, Object> map = service.selectBoardList(boardCode, 0);
		
		model.addAttribute("map", map);
		
		return "board/boardList";
	}
	
	
	
}
