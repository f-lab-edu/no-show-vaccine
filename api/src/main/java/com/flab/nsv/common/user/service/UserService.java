package com.flab.nsv.common.user.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.flab.nsv.domain.common.User;
import com.flab.nsv.domain.common.UserRepository;
import com.flab.nsv.member.exception.NotFoundMemberException;
import com.flab.nsv.system.authentication.EncryptService;
import com.flab.nsv.system.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserMapper userMapper;
	private final EncryptService encryptService;
	private final UserRepository userRepository;

	@Transactional
	public void updatePassword(Long userId, String password) {
		String encryptedPassword = encryptService.encrypt(password);
		userMapper.updateUserPassword(userId, encryptedPassword);
	}

	public User getById(long id) {
		return userRepository.findById(id).orElseThrow(NotFoundMemberException::new);
	}
}
