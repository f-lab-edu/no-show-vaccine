package com.flab.nsv.system.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.flab.nsv.common.user.dto.UserResponseDto;

@Mapper
public interface UserMapper {
	Optional<UserResponseDto> getById(long userId);

	Optional<UserResponseDto> getByUsername(String username);

	Optional<UserResponseDto> getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	Long createUser(@Param("username") String username, @Param("password") String password);

	void updateUserPassword(@Param("userId") Long userId, @Param("password") String password);
}
