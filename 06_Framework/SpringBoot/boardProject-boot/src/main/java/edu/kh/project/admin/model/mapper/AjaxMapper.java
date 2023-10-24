package edu.kh.project.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {

	/** 회원 번호가 일치하는 회원 이메일 조회
	 * @param memberNo
	 * @return
	 */
	public String selectMemberNo(int memberNo);

	/** 이메일이 일치하는 회원의 전화번호 조회
	 * @param inputEmail
	 * @return memberTel
	 */
	public String selectEmail(String inputEmail);

	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return Member
	 */
	public Member selectMember(int no);
	
	/** 입력된 문자열을 포함하는 모든 이메일 조회
	 * @param keyword
	 * @return emailList
	 */
	public List<String> selectEmailList(String keyword);


}
