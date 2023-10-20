package com.kh.test.user.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.user.model.dto.User;

@Mapper
public interface UserMapper {

	User selectOne(String userId);

}
