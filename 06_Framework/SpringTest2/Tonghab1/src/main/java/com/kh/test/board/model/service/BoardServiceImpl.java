package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	public BoardMapper mapper;
	
	
	@Override
	public List<Board> select(String boardTitle) {
		return mapper.select(boardTitle);
	}
	
	
	

}
