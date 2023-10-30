package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	public BoardService service;
	
	
	@GetMapping("select")
	public String select(String boardTitle, Model model) {
		
		// 입력 글자를 포함하는 제목 검색
		List<Board> boardList = service.select(boardTitle);
		
		// 포함된 제목이 있을 경우
		if(boardList.size() != 0) {
			model.addAttribute("boardList", boardList);
			return "searchSuccess";
		}
		
		// 포함된 제목이 없을 경우
		return "searchFail";
	}
	
	
	
	
	

}
