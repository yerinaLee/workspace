package edu.kh.project.admin.model.service;

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
	
	
	
	

}
