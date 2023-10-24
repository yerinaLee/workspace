package edu.kh.project.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Transactional // 예외 발생 시 롤백
@Slf4j // 로그
@Service // Service 역할(비즈니스 로직 처리) + bean 등록
public class MemberServiceImpl implements MemberService{

	// 암호화 객체 의존성 주입(DI)
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	// DB 관련 역할 수행 객체 DI
	@Autowired
	private MemberMapper mapper;
	
	/** 로그인 기능
	 *
	 */
	@Override
	public Member login(Member inputMember) {
		
		// 1. 이메일이 일치하는 탈퇴하지 않은 회원 정보 조회(pw 포함)
		Member loginMember = mapper.login(inputMember);
		
		// 2. 조회 결과가 없을 경우 return null;
		if(loginMember == null) return null;
		
		// 3. 입력받은 비밀번호(평문)와 조회한 비밀번호(암호문)가 같지 않으면 return null;
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			
			return null;
		}
		
		// 4. 비밀번호가 일치하면 비밀번호 제거 후 return
		loginMember.setMemberPw(null);
		return loginMember;
	}
	
	
	/** 회원가입 서비스
	 *
	 */
	@Override
	public int signup(Member inputMember, String[] memberAddress) {
		
		// 주소가 입력되지 않은 경우
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null); // null로 변환
		
		} else { // 주소가 입력된 경우
			// 배열 -> 문자열로 합쳐서 inputMember에 추가
			String address = String.join("^^^", memberAddress); //하나의 문자열로 합치기
			inputMember.setMemberAddress(address);
		}
		
		// 비밀번호 암호화(DB에 암호화된 비밀번호 저장)
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// DAO가 아닌 Mapper 메서드 호출
		return mapper.signup(inputMember);
		
	}
	
	
	
	/** 빠른로그인 서비스
	 *
	 */
	@Override
	public Member login(String memberEmail) {
		return mapper.login(memberEmail);
	}
	
	
	/** 이메일 중복 검사
	 * @param email
	 * @return 0 또는 1
	 */
	@Override
	public int checkEmail(String email) {
		return mapper.checkEmail(email);
	}
	
	/** 닉네임 중복 검사
	 * @param nickname
	 * @return 0 또는 1
	 */
	@Override
	public int checkNickname(String nickname) {
		return mapper.checkNickname(nickname);
	}
	

}
