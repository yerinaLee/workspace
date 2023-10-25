package edu.kh.project.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;

@Transactional
@Service
public class AjaxServiceImpl implements AjaxService{
	
	@Autowired
	private AjaxMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt; // 암호화
	
	@Autowired
	private MemberMapper memberMapper; // 회원 Mapper
	
	
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
	
	/** 모든 회원 정보 조회
	 * @return memberList
	 */
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	/** 샘플 계정 삽입
	 * @param member
	 * @return result
	 */
	@Override
	public int insertMember(Member member) {
		// 비밀번호 "1234"를 암호화해서 member에 추가
		member.setMemberPw( bcrypt.encode("1234") );
		
		return memberMapper.signup(member);
	}
	
	/** 회원 탈퇴여부 변경
	 * @param paramMap : flag, targetNo가 담겨있는 Map
	 * @return
	 */
	@Override
	public int updateFlag(Map<String, Object> paramMap) {
		return mapper.updateFlag(paramMap);
	}
	
	
}
