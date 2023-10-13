package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

// 인터페이스 사용 이유 : 규칙성 부여, 결합도 약화
public interface MyPageService {

	
	/** 내 정보 수정 서비스
	 * @param updateMember
	 * @param memberAddress
	 * @return result (1 : 성공, 0:실패)
	 */
	int info(Member updateMember, String[] memberAddress);

	
	/** 비밀번호 변경 서비스
	 * @param memberNo
	 * @param currentPw
	 * @param newPw
	 * @return result (1 : 성공, 0:실패)
	 */
	int changePw(int memberNo, String currentPw, String newPw);


	/** 회원 탈퇴 서비스
	 * @param memberNo
	 * @param memberPw
	 * @return result (1 : 성공, 0:실패)
	 */
	int secession(int memberNo, String memberPw);
	

}
