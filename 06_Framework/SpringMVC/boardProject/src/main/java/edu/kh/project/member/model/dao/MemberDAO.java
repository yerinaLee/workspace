package edu.kh.project.member.model.dao;

import edu.kh.project.member.model.dto.Member;

// Interface 사용 이유 : 결합도 약화, 프로젝트 규칙성 부여

public interface MemberDAO {

	/** 로그인
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);

	
	/** 회원가입
	 * @param inputMember
	 * @return
	 */
	int signup(Member inputMember);

}
