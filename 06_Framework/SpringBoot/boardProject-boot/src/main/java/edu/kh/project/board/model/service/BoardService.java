package edu.kh.project.board.model.service;

import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);
	
	
	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board boardDetail(Map<String, Object> map);

}
