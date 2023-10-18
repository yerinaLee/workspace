package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param updateMember
	 * @param memberAddress
	 * @return result
	 */
	int info(Member updateMember, String[] memberAddress);

	/** 비밀번호 변경
	 * @param memberNo
	 * @param currentPw
	 * @param newPw
	 * @return result
	 */
	int chagePw(int memberNo, String currentPw, String newPw);

	/** 회원 탈퇴
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 */
	int secession(int memberNo, String memberPw);

}
