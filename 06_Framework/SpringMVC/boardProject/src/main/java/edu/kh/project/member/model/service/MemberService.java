package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Interface 사용 이유
// 1) 프로젝트 규칙성 부여
// 2) 클래스간의 결합도 약화 (객체 지향적 설계)

// Service Interface를 사용하는 이유
// - Spring AOP를 이용한 트랜잭션 처리를 위해서


public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);
	
}
