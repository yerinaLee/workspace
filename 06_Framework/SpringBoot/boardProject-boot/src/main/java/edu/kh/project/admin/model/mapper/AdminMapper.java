package edu.kh.project.admin.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	/** 이메일이 일치하는 회원 정보 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectMember(String inputEmail);

}
