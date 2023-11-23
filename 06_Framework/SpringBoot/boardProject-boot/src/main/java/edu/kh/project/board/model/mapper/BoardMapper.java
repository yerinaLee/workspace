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

	/** 게시글 좋아요 여부확인
	 * @param map
	 * @return
	 */
	int likeCheck(Map<String, Object> map);

	/** 좋아요 테이블에서 행 삭제
	 * @param paramMap
	 * @return
	 */
	int deleteBoardLike(Map<String, Object> paramMap);

	/** 좋아요 테이블에 행 삽입
	 * @param paramMap
	 * @return
	 */
	int insertBoardLike(Map<String, Object> paramMap);

	/** 좋아요 수 조회
	 * @param integer
	 * @return count
	 */
	int countBoardLike(Integer boardNo);

	/** 조회수 증가
	 * @param boardNo
	 * @return result
	 */
	int updateReadCount(int boardNo);

	/** 검색어 일치 게시글 수 조회
	 * @param paramMap
	 * @return liskCount
	 */
	int searchListCount(Map<String, Object> paramMap);

	/** 검색어 일치 게시글 목록 조회
	 * @param paramMap
	 * @param rowBounds
	 * @return
	 */
	List<Board> searchBoardList(Map<String, Object> paramMap, RowBounds rowBounds);

	/** DB 이미지 파일명 목록 조회
	 * @return
	 */
	List<String> selectDbImageList();
	
	
	

}
