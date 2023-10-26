package edu.kh.project.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {
	
	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	List<Board> selectBoardList(int boardCode);

}
