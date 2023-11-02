package edu.kh.project.myPage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
@Slf4j
public class MyPageController {
	
	
	@Autowired
	private MyPageService service;
	
	
	// 마이페이지 화면 전환 (forward)
	@GetMapping("info") // myPage/info
	public String info() {
		
		// templates/myPage/myPage-info.html로 포워드!
		return "myPage/myPage-info";
	}
	
	@GetMapping("changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	@GetMapping("profile")
	public String profile() {
		return "myPage/myPage-profile";
	}
	
	@GetMapping("secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	@GetMapping("sideMenu")
	public String sideMenu() {
		return "myPage/myPage-sideMenu";
	}
	

	//-------------------------------------------------
	
	
	/** 회원 정보 수정
	 * @param updateMember : 수정된 회원 정보가 담긴 커맨드 객체
	 * @param memberAddress : 주소 값이 담긴 배열
	 * @param loginMember : 현재 로그인한 회원의 정보가 담긴 객체(session)
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return
	 */
	@PostMapping("info")
	public String info(Member updateMember, String[] memberAddress,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) {
		
		// 1. loginMember에서 회원 번호만 얻어와 updateMember에 세팅
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// 2. 회원 정보 서비스 호출 후 결과 반환 받기
		int result = service.info(updateMember, memberAddress);
		
		// 3. 서비스 처리 결과에 따라 응답 제어
		// [성공]
		// - message = "회원 정보가 수정 되었습니다"
		// - session에 세팅된 이전 회원 정보를
		// 	수정된 회원 정보로 다시 세팅
		
		// [실패]
		// - message = "회원 정보 수정 실패.."
		
		String message = null;
		
		if(result > 0) {
			message = "회원 정보가 수정 되었습니다";
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			
		} else {
			message = "회원 정보 수정 실패..";
		}

		ra.addFlashAttribute("message", message);
		
		return "redirect:info";
	}
	
	
	/** 비밀번호 변경
	 * @param currentPw: 현재 비밀번호(@RequestParam 생략)
	 * @param newPw : 새로운 비밀번호(@RequestParam 생략)
	 * @param loginMember : 로그인 회원 (session)
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("changePw")
	public String changPw(String currentPw, String newPw,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
		
		// 회원번호 얻어오기
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 후 결과 반환 받기
		int result = service.chagePw(memberNo, currentPw, newPw);
		
		// 비번 변경 성공
		if(result>0) { 
			ra.addFlashAttribute("message", "비밀번호 변경이 완료되었습니다.");
			loginMember.setMemberPw(newPw);
			return "redirect:info";
			
		} else { // 비번 변경 실패 (현재 비밀번호 틀림)
			ra.addFlashAttribute("message", "현재 비밀번호가 일치하지 않습니다.");
		}

		return "redirect:changePw";
	}
	
	
	
	/** 회원 탈퇴
	 * @param memberPw
	 * @param loginMember
	 * @param status
	 * @param ra
	 * @return
	 */
	@PostMapping("secession")
	public String secession(String memberPw, @SessionAttribute("loginMember") Member loginMember,
			SessionStatus status ,RedirectAttributes ra) {
		// 비밀번호, 회원넘버, 
		// 비밀번호 일치하는지 확인하고, 일치하지 않으면 돌려보냄
		
		// 회원번호 얻어오기
		int memberNo = loginMember.getMemberNo();
		
		// 회원탈퇴(fl=y로 변경)하고 결과 반환받기
		int result = service.secession(memberNo, memberPw);
		
		// 탈퇴 완료시 로그인 세션 만료시키고 메인으로 리다이렉트
		if(result > 0) {
			ra.addFlashAttribute("message", "회원탈퇴가 완료되었습니다.");
			status.setComplete(); // 세션 만료(로그아웃)
			return "redirect:/";
			
		} else { // 탈퇴 불가(비밀번호 불일치)
			ra.addFlashAttribute("message", "현재 비밀번호가 일치하지 않습니다.");
		}

		return "redirect:secession";
	}
	
	
	// -----------------------------------------------------------------
	
	// MultipartFile : multipart/form-data 형식으로 제출된 파라미터 중
	//					file 타입 데이터만 추출해 저장하는 Spring 제공 객체 
	// - 실제 파일
	// - 파일 이름
	// - 파일 크기
	// - 업로드 된 파일을 지정된 경로에 저장하는 메서드
	// (추가 설정 필요!)
	
	/** 프로필 이미지 수정
	 * @param profileImg : 실제 업로드된 프로필 이미지
	 * 					(파일 선택 여부 관련 없이 무조건 객체 생성)
	 * @param loginMember
	 * @param ra
	 * @return result
	 * @throws IOException // 스프링에서 알아서 처리해줌!
	 * @throws IllegalStateException 
	 */ 
	@PostMapping("profile")
	public String profile(
			@RequestParam("profileImg") MultipartFile profileImg,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra) throws IllegalStateException, IOException {
		
		// 프로필 이미지 수정 서비스 호출 후 결과 반환
		int result = service.profile(profileImg, loginMember);
							// 실제 이미지 파일, 세션에 저장된 회원 정보
		
		
		// 서비스 결과에 따라 응답 제어
		String message = null;
		
		if(result > 0) {
			message = "프로필 이미지가 변경 되었습니다.";
			
		} else {
			message = "프로필 변경 실패!";
			
		}
		
		ra.addFlashAttribute("message", message);
		
		// 프로필 페이지로 리다이렉트
		return "redirect:profile";
	}

}
