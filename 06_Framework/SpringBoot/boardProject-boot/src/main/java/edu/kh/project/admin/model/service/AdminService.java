package edu.kh.project.admin.model.service;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/** 이메일이 일치하는 회원 정보 조회
	 * @param inputEmail
	 * @return searchMember
	 */
	Member selectMember(String inputEmail);
	
	

}
