package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {

	
	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 글 작성
	 * @param board
	 * @return
	 */
	int insert(Board board);

	/** 게시글 조회
	 * @param boardNo
	 * @return
	 */
	Board selectOne(int no);

	/** 게시글 삭제 서비스
	 * @param boardPw
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(String boardPw, int boardNo);

	/** 게시글 수정 페이지 이동
	 * @param boardPw
	 * @param boardNo
	 * @return
	 */
	int moveUpdate(String boardPw, int boardNo);

	/** 글 수정하기
	 * @param board
	 * @return
	 */
	int updateBoard(Board board);

}
