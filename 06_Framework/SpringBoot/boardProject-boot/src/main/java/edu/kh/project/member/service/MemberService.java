package edu.kh.project.member.service;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);


	/** 회원가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int signup(Member inputMember, String[] memberAddress);


	/** 빠른 로그인 서비스
	 * @param memberEmail
	 * @return loginMember
	 */
	Member login(String memberEmail);

}
