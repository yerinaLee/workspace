package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {
	
	/** 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds 
	 * @param cp
	 * @return
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/** 전체 게시글 수 조회
	 * @param boardCode
	 * @return
	 */
	int getListCount(int boardCode);

	
	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board boardDetail(Map<String, Object> map);

}
