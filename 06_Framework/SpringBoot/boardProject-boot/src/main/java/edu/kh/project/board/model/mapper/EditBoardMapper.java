package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImg;

@Mapper
public interface EditBoardMapper {

	/** 게시글 삭제
	 * @param paramMap
	 * @return result
	 */
	int deleteBoard(Map<String, Integer> paramMap);

	/** 게시글 작성
	 * @param board
	 * @return result
	 */
	int insertBoard(Board board);

	/** 게시글 이미지 정보 일괄 삽입
	 * @param uploadList
	 * @return result(insert 성공한 행의 수 == 삽입된 이미지 수)
	 */
	int insertUploadList(List<BoardImg> uploadList);

}
