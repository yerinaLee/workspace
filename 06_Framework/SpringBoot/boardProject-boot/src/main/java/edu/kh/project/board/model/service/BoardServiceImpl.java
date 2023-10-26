package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Board;
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
		
		List<Board> boardList = mapper.selectBoardList(boardCode);
		
		// Map에 담아서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		
		return map;
	}
}
