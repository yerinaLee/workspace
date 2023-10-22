package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	/** 글쓰기 포워드
	 * @return
	 */
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	/** 글 작성하기 post
	 * @return
	 */
	@PostMapping("insert")
	public String insert(Board board, RedirectAttributes ra){
		
		int result = service.insert(board);
		
		// 글 작성 성공시
		if(result > 0) {
			ra.addFlashAttribute("message", "삽입 성공");
		}
		
		return "redirect:/";
	}
	
	
	/** 게시글 호출
	 * @param no
	 * @param model
	 * @return
	 */
	@GetMapping("selectOne")
	public String selectOne(int no, Model model){
		
		// 게시글 호출 서비스
		Board board = service.selectOne(no);
		
		// 호출한 게시글이 있음
		if(board != null) {
			model.addAttribute("board", board);
		}
		
		return "board/selectOne";
	}
	
	
	
	/** 게시글 삭제
	 * @param boardPw
	 * @param boardNo
	 * @param ra
	 * @return
	 */
	@PostMapping("deleteBoard")
	public String deleteBoard(String boardPw, int boardNo, RedirectAttributes ra) {
		
		// 게시글의 비밀번호 얻어와
		// 입력된 비밀번호 boardPw와 mathch한 후 삭제하는 서비스 호출
		int result = service.deleteBoard(boardPw, boardNo);
		
		String path = null;

		// 삭제 완료
		if (result > 0) {
			ra.addFlashAttribute("message", "삭제 되었습니다");
			path = "redirect:/";
		}

		else {
			ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
			path = "redirect:selectOne?no=" + boardNo;
		}
			
		return path;
	}
	
	
	/** 비밀번호 일치시 수정페이지로 이동
	 * @param boardPw
	 * @param boardNo
	 * @param ra
	 * @return
	 */
	@PostMapping("moveUpdate")
	public String moveUpdate(String boardPw, int boardNo, RedirectAttributes ra, Model model) {
		
		// 게시글의 비밀번호 얻어와
		// 입력된 비밀번호 boardPw와 match하여 일치여부 확인하는 서비스 호출 (1: 일치, 0:불일치)
		int result = service.moveUpdate(boardPw, boardNo);
		
		String path = null;

		// 비밀번호 일치시 게시글 정보 얻어와 수정 페이지로 포워드
		if (result > 0) {
			
			int no = boardNo;
			
			Board board = service.selectOne(no);
			
			model.addAttribute("board", board);
			path = "board/update";
		}

		else {
			ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
			path = "redirect:selectOne?no=" + boardNo;
		}
			
		return path;
	}
	
	
	
	
	/** 글 수정하기
	 * @param board
	 * @param ra
	 * @return
	 */
	@PostMapping("updateBoard")
	public String updateBoard(Board board, RedirectAttributes ra){
		
		// 글 수정하기 서비스 호출
		int result = service.updateBoard(board);

		if( result > 0) {
			ra.addFlashAttribute("message", "수정 성공");
		}
		
		return "redirect:selectOne?no=" + board.getBoardNo();
	}
	
	
	
}
