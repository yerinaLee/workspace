package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);

	/** 검색 목록 조회
	 * @param paramMap
	 * @param cp
	 * @return boardList
	 */
	Map<String, Object> searchBoardList(Map<String, Object> paramMap, int cp);
	
	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board boardDetail(Map<String, Object> map);


	/** 게시글 좋아요 여부 확인
	 * @param map
	 * @return likeCheck
	 */
	int likeCheck(Map<String, Object> map);


	/** 좋아요 처리
	 * @param paramMap
	 * @return result
	 */
	int like(Map<String, Object> paramMap);


	/** 조회수 증가
	 * @param boardNo
	 * @return result
	 */
	int updateReadCount(int boardNo);

	/** DB 이미지 파일명 목록 조회
	 * @return list
	 */
	List<String> selectDbImageList();

	/** 게시판 종류 조회
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();



}
