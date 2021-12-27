package com.flab.nsv.member.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.member.dto.CreateMemberRequestDto;
import com.flab.nsv.common.user.dto.LoginUserRequestDto;
import com.flab.nsv.member.dto.MemberResponseDto;
import com.flab.nsv.member.dto.UpdateMemberRequestDto;
import com.flab.nsv.common.user.dto.UpdateUserRequestDto;
import com.flab.nsv.common.user.service.UserService;
import com.flab.nsv.member.service.MemberService;
import com.flab.nsv.system.authentication.UserLoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService memberService;
	private final UserService userService;
	private final UserLoginService userLoginService;

	@PostMapping("/")
	public void joinMember(@Valid @RequestBody final CreateMemberRequestDto createMemberRequestDto) {
		Long userId = userService.createUser(createMemberRequestDto.toUserEntity());
		memberService.createMember(createMemberRequestDto.toMemberEntity(userId));
	}

	@GetMapping("/{id}")
	public MemberResponseDto getById(@PathVariable("id") final long userId) {
		return memberService.getById(userId);
	}

	// TO-DO: 자기 자신만 수정할 수 있도록 권한 체크 Logic 추가
	// TO-DO: Member, Institution 권한만 접근 가능 하도록 @LoginCheck 기능 추가
	@PatchMapping("/{id}/password")
	public void updateUserPassword(@PathVariable("id") final long userId,
		@RequestBody @Valid final UpdateUserRequestDto updateUserRequestDto) {
		userService.updatePassword(userId, updateUserRequestDto.getPassword());
	}

	// TO-DO: 자기 자신만 수정할 수 있도록 권한 체크 Logic 추가
	// TO-DO: Member 권한만 접근 가능 하도록 @LoginCheck 기능 추가
	@PatchMapping("/{id}/telephone")
	public void updateMemberTelephone(@PathVariable("id") final long userId,
		@RequestBody @Valid final UpdateMemberRequestDto updateMemberRequestDto) {
		memberService.updateMemberTelephone(userId, updateMemberRequestDto.getTelephone());
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
