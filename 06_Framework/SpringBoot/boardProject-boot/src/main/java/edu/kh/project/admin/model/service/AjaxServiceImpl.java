package edu.kh.project.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;

@Transactional
@Service
public class AjaxServiceImpl implements AjaxService{
	
	
	@Autowired
	private AjaxMapper mapper;
	
	/** 회원 번호가 일치하는 회원 이메일 조회
	 *
	 */
	@Override
	public String selectMemberNo(int memberNo) {
		return mapper.selectMemberNo(memberNo);
	}
	
	
	/** 이메일이 일치하는 회원의 전화번호 조회
	 *
	 */
	@Override
	public String selectEmail(String inputEmail) {
		return mapper.selectEmail(inputEmail);
	}

	
	
	/** 회원 번호로 회원 정보 조회
	 * @param no
	 * @return Member
	 */
	@Override
	public Member selectMember(int no) {
		return mapper.selectMember(no);
	}

	/** 입력된 문자열을 포함하는 모든 이메일 조회
	 * @param keyword
	 * @return emailList
	 */
	@Override
	public List<String> selectEmailList(String keyword) {
		return mapper.selectEmailList(keyword);
	}
	
	
}
