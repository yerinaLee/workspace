package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	/** 회원 번호가 일치하는 회원 이메일 조회
	 * @param memberNo
	 * @return email
	 */
	String selectMemberNo(int memberNo);

	/** 이메일이 일치하는 회원의 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	String selectEmail(String inputEmail);

	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return Member
	 */
	Member selectMember(int no);

	/** 입력된 문자열을 포함하는 모든 이메일 조회
	 * @param keyword
	 * @return emailList
	 */
	List<String> selectEmailList(String keyword);

	/** 모든 회원 정보 조회
	 * @return memberList
	 */
	List<Member> selectAll();


	/** 샘플 계정 삽입
	 * @param member
	 * @return result
	 */
	int insertMember(Member member);
	
	
	/** 회원 탈퇴여부 변경
	 * @param paramMap : flag, targetNo가 담겨있는 Map
	 * @return
	 */
	int updateFlag(Map<String, Object> paramMap);

}
