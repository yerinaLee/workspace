package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // bean 등록 + 비즈니스 로직 처리 역할
		// -> 비즈니스 로직 : 응답에 필요한 데이터를 만드는 과정
		// 		- 데이터 가공, DAO 호출, 트랜잭션 제어 등
public class MemberServiceImpl implements MemberService {
	
	@Autowired // 등록 bean 의존성 주입(DI)
	private MemberDAO dao;
	
	@Autowired // 등록된 bean 의존성 주입(DI)
	private BCryptPasswordEncoder bcrypt;
	
	
	// bcrypt.encode(평문) -> 암호화
	
	@Override
	public Member login(Member inputMember) {
		
		
		// 암호화 확인
//		String temp = bcrypt.encode(inputMember.getMemberPw());
//		System.out.println("입력된 비밀번호 : " + inputMember.getMemberPw());
//		System.out.println("암호화된 비밀번호 : " + temp);
		
		
		// DB - 암호화 된 비밀번호
		// 입력된 비밀번호 - 암호화 안 된 비밀번호(평문)
		
		/* BCrypt 암호화 사용 시 비밀번호 비교 방법! */
		
		// 1) DB에서 아이디가 일치하는 회원의 회원정보 + 비밀번호 조회
		
		// 2) Service에서 bcrypt.matches(평문, 암호문) 메서드를 이용해
		//	  입력된 비밀번호와
		//	  DB에서 조회한 비밀번호를 비교
		//	 	 -> 일치하면 true, 아니면 false
		
		// -------------------------------------------
		
		
		// 현재 클래스가 Bean으로 등록되어 의존성 주입 되었는지 확인
		// System.out.println(inputMember);
		
		// 이제 Connection 따로 얻어올 필요 없음!
		// -> Connection 역할을 하는 SqlSessionTemplate이 Bean으로 등록됨(root-context.xml)
		Member loginMember = dao.login(inputMember);
		
		if(loginMember == null) 	return null;

		// 입력된 비밀번호와 DB에 저장된 암호화된 비밀번호가 일치하지 않으면
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())){
			return null;
		}
		
		// 로그인된 회원 정보에서 비밀번호 제거 후 리턴
		loginMember.setMemberPw(null);
		
		return loginMember;
	}
	
	
	// --------------------------------------------------------
	// @Transactional
	// - 트랜잭션 처리를 수행하라고 지시하는 어노테이션
	//	 (== 선언적 트랜잭션 처리)
	//
	// - 정상 코드 수행 시 COMMIT
	// - Service 내부 코드 수행 중 예외 발생 시 ROLLBACK
	
	// [주의사항]
	// servlet-context.xml에 tx:annotation-driven 태그가 존재해야한다.
	// --------------------------------------------------------
	
	@Transactional
	@Override
	public int signup(Member inputMember, String[] memberAddress) {

		// memberAddress 가공
		
		// 주소를 입력하지 않은 경우
		if( inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
			
		} else { // 입력한 경우
			
			// memberAddress 배열 요소의 값을 하나의 문자열 변환
			// (단, 요소 사이 구분자는 ^^^)
			String addr = String.join("^^^", memberAddress);
			
			inputMember.setMemberAddress(addr);
		}
		
		// -> 주소 입력 X == null
		// -> 주소 입력 O == "A^^^B^^^C"
		
		// -------------------------------------------------------------------------
		
		// 비밀번호 암호화
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// -------------------------------------------------------------------------
		
		// DAO 호출
		return dao.signup(inputMember);
//		return 0; // 가입 실패 연출 ㅋㅋ
	}
	
	
	

}
