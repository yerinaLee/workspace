package edu.kh.project.admin.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/** 이메일이 일치하는 회원 정보 조회
	 * @param inputEmail
	 * @return searchMember
	 */
	Member selectMember(String inputEmail);

	/** 회원 전체 조회
	 * @return
	 */
	List<Member> selectAll();

	/** 전체 회원 조회(+정렬)
	 * @param sort
	 * @return
	 */
	List<Member> selectSort(int sort);

	/** 회원 복구
	 * @param memberNo
	 * @return result
	 */
	int restoration(int memberNo);

	/** 관리자 권한 변경
	 * @param memberNo
	 * @param authority 
	 * @return
	 */
	int changeAuthority(int memberNo, int authority);

	/** 비밀번호 "1234"로 초기화
	 * @param memberNo
	 * @return result
	 */
	int initPw(int memberNo);
	
	

}
