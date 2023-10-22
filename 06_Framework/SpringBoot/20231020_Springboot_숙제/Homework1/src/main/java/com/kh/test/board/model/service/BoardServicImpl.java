package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
	
	
	/** 글 작성 서비스
	 *
	 */
	@Override
	public int insert(Board board) {
		
		// 비밀번호 암호화
		String encPw = bcrypt.encode(board.getBoardPw());
		board.setBoardPw(encPw);
		
		return mapper.insert(board);
	}
	
	
	/** 게시글 조회
	 *
	 */
	@Override
	public Board selectOne(int no) {
		return mapper.selectOne(no);
	}
	
	
	/** 게시글 삭제 서비스
	 *
	 */
	@Override
	public int deleteBoard(String boardPw, int boardNo) {
		
		// 현재 게시글의 비밀번호(암호화됨) 얻어오기
		String encPw = mapper.findPw(boardNo);
		
		// 비번 안맞으면 0 리턴
		if( !bcrypt.matches(boardPw, encPw) ) {
			return 0;
		}
		
		// 비번 일치시 삭제 진행
		return mapper.deleteBoard(boardNo);
	}
	
	
	/** 비번 일치시 게시글 수정 페이지 이동
	 *
	 */
	@Override
	public int moveUpdate(String boardPw, int boardNo) {
		
		// 현재 게시글의 비밀번호(암호화됨) 얻어오기
		String encPw = mapper.findPw(boardNo);
		
		// 비번 안맞으면 0 리턴
		if( !bcrypt.matches(boardPw, encPw) ) {
			return 0;
		}
		
		// 비번 맞으면 1 리턴
		return 1;
	}
	
	
	/** 글 수정하기
	 *
	 */
	@Override
	public int updateBoard(Board board) {
		
		// 비밀번호 암호화
		String encPw = bcrypt.encode(board.getBoardPw());
		board.setBoardPw(encPw);
		
		return mapper.updateBoard(board);
	}
	
}
