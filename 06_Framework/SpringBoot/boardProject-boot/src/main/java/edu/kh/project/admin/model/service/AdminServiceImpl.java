package edu.kh.project.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	/** 이메일이 일치하는 회원 정보 조회
	 *
	 */
	@Override
	public Member selectMember(String inputEmail) {
		return mapper.selectMember(inputEmail);
	}
	
	/** 전체 회원 조회
	 * 
	 */
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	
	/** 전체 회원 조회(+정렬)
	 *
	 */
	@Override
	public List<Member> selectSort(int sort) {
		
		// sort 값에 따라 가공처리
		String query = null;
		
		switch(sort) {
		case 1: query = "MEMBER_NO DESC"; break; // 회원번호 내림차순
		case 2: query = "MEMBER_NO"; break; // 회원번호 오름차순
		case 3: query = "MEMBER_EMAIL DESC"; break; // 이메일 내림차순
		case 4: query = "MEMBER_EMAIL"; break; // 이메일 오름차순
		}
		
		return mapper.selectSort(query);
	}
	
	
	/** 회원 복구
	 *
	 */
	@Override
	public int restoration(int memberNo) {
		return mapper.restoration(memberNo);
	}
	
	
	/** 관리자 권한 변경
	 *
	 */
	@Override
	public int changeAuthority(int memberNo, int authority) {

		// 권한 바꾸기
		if(authority == 1) {
			authority = 2;
		} else {
			authority = 1;
		}
		
		Map<Object, Object> map = new HashMap<>();
		map.put("memberNo", memberNo);
		map.put("authority", authority);
		
		return mapper.changeAuthority(map);
	}
	
	
	/** 비밀번호 "1234"로 초기화
	 *
	 */
	@Override
	public int initPw(int memberNo) {
		
		// 암호화된 1234 만들기
		String encPw = bcrypt.encode("1234");
		
		// 마이바티스 코드에서 파라미터는 one and only! 
		Map<Object, Object> map = new HashMap<>();
		map.put("memberNo", memberNo);
		map.put("encPw", encPw);
		
		return mapper.initPw(map);
	}
	

}
