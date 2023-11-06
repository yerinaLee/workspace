package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.mapper.EditBoardMapper;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.board.model.service.EditBoardService;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("editBoard")
@SessionAttributes({"loginMember"})
public class EditBoardController {
	
	private final EditBoardService service;
	private final BoardService boardService; // 게시글 수정 시 상세조회 호출용
	
	
	
	/** 게시글 삭제
	 * @param boardCode : 게시판 구분 코드
	 * @param boardNo : 게시글 번호(PK)
	 * @param loginMember : 세션에 저장된 로그인된 회원의 정보(로그인 X면 null) / 자신이 작성한 글이 맞는지 확인용
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @param referer : 요청 헤더에 기록된 요청 이전 페이지 주소
	 * 		(referer == 흔적, 단서)
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}/delete")
	public String deleteBoard(@PathVariable("boardCode") int boardCode, @PathVariable("boardNo") int boardNo,
			@SessionAttribute(value="loginMember", required=false) Member loginMember,
			RedirectAttributes ra
			//,@RequestHeader("referer") String referer
			){
		
		// 로그인 상태가 아닌 경우 삭제 진행 X
		if(loginMember == null) {
			ra.addFlashAttribute("message", "로그인 후 이용해주세요");
			return "redirect:/member/login";
		}
		
		// Map을 이용해서 boardCode, boardNo, memberNo 담기
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("boardCode", boardCode);
		paramMap.put("boardNo", boardNo);
		paramMap.put("memberNo", loginMember.getMemberNo());
		
		
		// 서비스호출 후 결과 반환
		int result = service.deleteBoard(paramMap);

		String path = null;
		String message = null;
		
		if(result > 0) {
			message = "삭제 되었습니다.";
			path = "redirect:/board/" + boardCode;
					
		} else {
			message = "삭제 실패";
			
			// 메인 페이지로 리다이렉트
			path = "redirect:/";
			
			// 이전 요청 페이지로 리다이렉트
			// path = "redirect:" + referer;
		}
		
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	
	
	/** 게시글 작성 화면 전환
	 * @param boardCode
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}/insert")
	public String insertBoard(@PathVariable("boardCode") int boardCode,
			@SessionAttribute(value="loginMember", required = false) Member loginMember) {
		
		// 로그인 정보가 없으면 목록으로 되돌아감
		if(loginMember == null) {
			
			return "redirect:/board/" + boardCode;
		}
		
		return "board/boardWrite";
	}
	
	
	 /** 게시글 작성 (게시글 작성 + 파일 0~5개 업로드)
	 * @param boardCode : 게시판 코드
	 * @param loginMember : 로그인한 회원 정보(세션)
	 * @param board : board DTO / 파라미터가 담긴 커맨드 객체
	 * @param images : 제출된 input type="file" name="images" 파라미터 묶음
	 * 		-> (주의!) 제출된 파일이 없어도 input 수 만큼 List 요소 존재
	 * @param ra : 리다이렉트 시 request로 데이터 전달
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("{boardCode:[0-9]+}/insert")
	public String insertBoard(Board board,
			@PathVariable("boardCode") int boardCode,
			@SessionAttribute("loginMember") Member loginMember,
			@RequestParam("images") List<MultipartFile> images,
			RedirectAttributes ra
			) throws IllegalStateException, IOException {
			
		// 로그인한 회원의 번호, 게시판 코드를
		// 커맨드 객체 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());
		board.setBoardCode(boardCode);
		
		// 서비스 호출 후 결과 반환 받기
		int boardNo = service.insertBoard(board, images);
		
		
		// 게시글 작성 성공 시
		// 지금 작성한 글의 상세 조회 화면으로 리다이렉트
		// /board/{boardCode}/{boardNo}
		if(boardNo > 0) {
			ra.addFlashAttribute("message", "게시글 작성 성공");
			return String.format("redirect:/board/%d/%d", boardCode, boardNo); 
		}
		
		// 실패 시 
		ra.addFlashAttribute("message", "게시글 작성 실패");
		
		return "redirect:insert";
	}
	
	
	
	/** 게시글 수정 화면 전환
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}/update")
	public String updateBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model
			) {
		
		// 게시글 수정 화면에는
		// 수정하려는 게시글의 상세 내용이 작성되어있어야한다!
		// -> 게시글 상세 조회 진행
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		Board board = boardService.boardDetail(map);
		
		model.addAttribute("board", board);
		
		return "board/boardUpdate";
	}
	
	
	
	/** 게시글 수정
	 * @param boardCode  
	 * @param boardNo
	 * @param board : 커맨드 객체
	 * @param querystring : 쿼리스트링 유지용 파라미터
	 * @param deleteOrder : 삭제된 이미지 순서(1,2,3 모양)
	 * @param images : 제출된 file 타입 요소 모음(5개 요소 존재)
	 * @param ra
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}/update")
	public String updateBoard(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Board board, String querystring,
			String deleteOrder,
			@RequestParam("images") List<MultipartFile> images,
			RedirectAttributes ra
			) throws IllegalStateException, IOException {
		
		// 1. 커맨드 객체에 boardCode, boardNo 세팅
		board.setBoardCode(boardCode);
		board.setBoardNo(boardNo);
		
		// 2. 게시글 수정 서비스 호출
		int result = service.updateBoard(board, images, deleteOrder);
		
		// 3. 서비스 결과에 따라 응답 제어
		String message = null;
		String path = null;
		
		if(result > 0) { // 성공
			message = "게시글이 수정되었습니다.";
			path = String.format("redirect:/board/%d/%d%s", boardCode, boardNo, querystring);
			
		} else { // 실패
			message = "게시글 수정 실패";
			path = "redirect:update";
		}
		
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	
	
	
	
	
	
	
	

}
