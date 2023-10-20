package com.kh.test.user.model.service;

import com.kh.test.user.model.dto.User;

public interface UserService {

	/** 회원 찾기 서비스(아이디로)
	 * @param userId
	 * @return
	 */
	User selectOne(String userId);

}
