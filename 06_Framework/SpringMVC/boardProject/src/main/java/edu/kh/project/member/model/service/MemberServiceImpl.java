package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // bean 등록 + 비즈니스 로직 처리 역할
		// -> 비즈니스 로직 : 응답에 필요한 데이터를 만드는 과정
		// 		- 데이터 가공, DAO 호출, 트랜잭션 제어 등
public class MemberServiceImpl implements MemberService {
	
	@Autowired // 등록 bean 의존성 주입(DI)
	private MemberDAO dao;
	
	@Override
	public Member login(Member inputMember) {
		
		// 현재 클래스가 Bean으로 등록되어 의존성 주입 되었는지 확인
		// System.out.println(inputMember);
		
		// 이제 Connection 따로 얻어올 필요 없음!
		// -> Connection 역할을 하는 SqlSessionTemplate이 Bean으로 등록됨(root-context.xml)
		Member loginMember = dao.login(inputMember);
		
		
		
		return loginMember;
	}

}
