package com.flab.nsv.common.user.service;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.common.User;
import com.flab.nsv.common.user.dto.UserResponseDto;
import com.flab.nsv.member.exception.DuplicatedUsernameException;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.authentication.EncryptService;
import com.flab.nsv.system.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserMapper userMapper;
	private final EncryptService encryptService;

	public Long createUser(User user) {
		userMapper.getByUsername(user.getUsername()).ifPresent(u -> {
			throw new DuplicatedUsernameException();
		});
		String encryptedPassword = encryptService.encrypt(user.getPassword());
		return userMapper.createUser(user.getUsername(), encryptedPassword);
	}

	public void updatePassword(Long userId, String password) {
		String encryptedPassword = encryptService.encrypt(password);
		userMapper.updateUserPassword(userId, encryptedPassword);
	}

	public UserResponseDto getById(long id) {
		return userMapper.getById(id).orElseThrow(NotFoundMemberException::new);
	}
}
