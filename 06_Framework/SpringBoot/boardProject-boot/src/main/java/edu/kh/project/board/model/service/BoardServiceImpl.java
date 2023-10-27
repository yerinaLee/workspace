package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;
import edu.kh.project.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class) // 모든 예외 발생 시 롤백
@RequiredArgsConstructor // final 필드에 bean DI
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		// 게시글 목록 조회에 페이지네이션(pagination 또는 페이징)처리 시
		// 중요한 값 또는 객체
		// 1. 현재 몇 페이지? (cp)
		// 2. 게시판의 전체 게시글 수 (listCount)
		// 3. RowBounds 마이바티스 객체
		
		/* 전체 게시글 수 조회 */
		int listCount = mapper.getListCount(boardCode);
		
		/* cp, listCount를 이용해서 Pagination 객체 생성 */
		Pagination pagination = new Pagination(cp, listCount);
		
		/* RowBounds 객체 생성
		 * 
		 * - RowBounds란?
		 *  -- Row(행), Bound(도약, 건너뛰기)
		 *  -- 전체 조회 결과 중 지정된 행(offset)만큼 건너뛴 다음
		 *     읽어올 행의 개수(limit) 만큼만 조회
		 * */
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		int limit = pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		/* 마이바티스로 SQL 수행 시 
		 * SQL에 전달할 수 있는 파라미터의 갯수는 1개! (첫번째 매개변수)
		 * 
		 * 두 번째 매개변수는 RowBounds만 가능
		 * */
		
		List<Board> boardList = mapper.selectBoardList(boardCode, rowBounds);
		
		// Map에 담아서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	/** 게시글 상세 조회 + 게시글 댓글 모두 조회
	 * @param map
	 * @return board
	 */
	@Override
	public Board boardDetail(Map<String, Object> map) {
		return mapper.boardDetail(map);
	}
	
	
	
}
