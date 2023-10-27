package edu.kh.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * @param model : 데이터 전달용 객체
	 * @param cp : 현재 페이지(요청 시 없으면 기본 값 1)
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}")
	public String selectBoardList( @PathVariable("boardCode") int boardCode,
			Model model,
			@RequestParam(value="cp", required = false, defaultValue = "1") int cp ) {
		
		Map<String, Object> map = service.selectBoardList(boardCode, cp);
		
		model.addAttribute("map", map);
		
		return "board/boardList";
	}
	
	
	/** 게시글 상세 조회
	 * @param boardCode : 게시판 코드 번호(한자리 이상 숫자)
	 * @param boardNo : 게시글 번호(한자리 이상 숫자)
	 * @param model : 데이터 전달용 객체
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}") // 한자리 이상의 숫자
	public String boardDetail(@PathVariable("boardCode") int boardCode, @PathVariable("boardNo") int boardNo,
			Model model) {
		
		
		// 1. 상세 조회 서비스 호출
		Map<String, Object> map = new HashMap<>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		Board board = service.boardDetail(map);
		
		
		// 2. 조회 결과가 있을때 / 없을때
		
		model.addAttribute("board", board);
		
		// 3. 있을때 -> 내가 좋아요를 누른적 있으면
						// 하트가 채워져있기
		// 4. 있을때 -> 조회수 증가
		//   (쿠키를 이용해서 한 사용자가 특정 게시글에 하루에 1번만 조회수를 증가하게만들기)
		
		
		return "board/boardDetail";
	}
	
	
	
	
	
	
}
