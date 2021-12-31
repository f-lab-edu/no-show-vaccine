package com.flab.nsv.common.user.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.common.user.dto.LoginUserRequestDto;
import com.flab.nsv.common.user.dto.UpdateUserRequestDto;
import com.flab.nsv.common.user.service.UserService;
import com.flab.nsv.domain.common.User;
import com.flab.nsv.system.authentication.UserLoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	private final UserLoginService userLoginService;

	@GetMapping("/{id}")
	public User getById(@PathVariable("id") final long userId) {
		return userService.getById(userId);
	}

	// TO-DO: 자기 자신만 수정할 수 있도록 권한 체크 Logic 추가
	// TO-DO: Member, Institution 권한만 접근 가능 하도록 @LoginCheck 기능 추가
	@PatchMapping("/{id}/password")
	public void updateUserPassword(@PathVariable("id") final long userId,
		@RequestBody @Valid final UpdateUserRequestDto updateUserRequestDto) {
		userService.updatePassword(userId, updateUserRequestDto.getPassword());
	}

	@PostMapping("/login")
	public void login(@Valid @RequestBody final LoginUserRequestDto loginUserRequestDto) {
		userLoginService.login(loginUserRequestDto);
	}

	@DeleteMapping("/logout")
	public void logout() {
		userLoginService.logout();
	}
}
