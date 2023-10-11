package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // Bean 등록 + 저장소(DB, 파일 등)와 연결하는 역할
public class MemberDAOImpl implements MemberDAO {

	// SqlSessionTemplate bean 의존성 주입 받기
	// (마이바티스 사용 + DB 연결 정보 + 트랜잭션 자동 제어)
	// -> root-context.xml에 bean 등록 구문이 작성되어 있음
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member login(Member inputMember) {
		
		// sqlSession.selectOne( "namespace.id" [, 파라미터] );
		// - selectOne() : 1행 조회
		// - namespace.id : 
		// 		mybatis-config.xml에 등록된 mapper파일 중
		//		namespace와 태그 id가 일치하는 SQL을 수행
		
		// 파라미터 : SQL에서 사용시 필요한 값 전달
		
		return sqlSession.selectOne("memberMapper.login", inputMember);
	}

}
