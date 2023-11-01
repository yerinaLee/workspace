package edu.kh.project.board.model.service;

import java.util.Map;

public interface EditBoardService {
 
	/** 게시글 삭제
	 * @param paramMap
	 * @return result
	 */
	int deleteBoard(Map<String, Integer> paramMap);

}
