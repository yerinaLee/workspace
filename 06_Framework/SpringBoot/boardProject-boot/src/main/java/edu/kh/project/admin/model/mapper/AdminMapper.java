package edu.kh.project.admin.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	/** 이메일이 일치하는 회원 정보 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectMember(String inputEmail);

	/** 전체 회원 조회
	 * @return memberList
	 */
	// Mapper 메서드의 반환형이 List로 작성되어있으면
	// 마이바티스 수행 시 조회되는 모든 행을
	// 자동으로 List에 저장
	// 단, 조회 결과가 없을 경우 비어있는 List(0칸)가 반환
	List<Member> selectAll();

	/** 전체 회원 조회(+정렬)
	 * @param query
	 * @return
	 */
	List<Member> selectSort(String query);

	/** 회원 탈퇴 복구
	 * @param memberNo
	 * @return result
	 */
	int restoration(int memberNo);
	
	
	/** 관리자 권한 변경
	 * @param map
	 * @return
	 */
	int changeAuthority(Map<Object, Object> map);

	/** 비밀번호 "1234"로 초기화
	 * @param map
	 * @return result
	 */
	int initPw(Map<Object, Object> map);



}
