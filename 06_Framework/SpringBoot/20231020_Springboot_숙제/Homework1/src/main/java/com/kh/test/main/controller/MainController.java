package com.kh.test.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;


@Controller
public class MainController {
	
	@Autowired
	private BoardService service;

	
	/** <h1>메인 페이지</h1>
	 * 메인 페이지 요청 시 삭제되지 않은 게시글 목록 조회
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String mainPage(Model model) {
		
		// 게시글 목록 조회 서비스
		List<Board> boardList = service.selectBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "main";
	}
}
