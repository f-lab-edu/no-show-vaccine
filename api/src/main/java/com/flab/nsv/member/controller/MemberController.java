package com.flab.nsv.member.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flab.nsv.domain.member.Member;
import com.flab.nsv.member.dto.CreateMemberRequestDto;
import com.flab.nsv.member.dto.UpdateMemberRequestDto;
import com.flab.nsv.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/join")
	@ResponseStatus(HttpStatus.CREATED)
	public void joinMember(@Valid @RequestBody final CreateMemberRequestDto createMemberRequestDto) {
		memberService.joinMember(createMemberRequestDto);
	}

	@GetMapping("/{id}")
	public Member getById(@PathVariable("id") final long id) {
		return memberService.getById(id);
	}

	// TO-DO: 자기 자신만 수정할 수 있도록 권한 체크 Logic 추가
	@PutMapping("/{id}")
	public void updateMember(@PathVariable("id") final long id,
		@Valid @RequestBody final UpdateMemberRequestDto updateMemberRequestDto) {
		memberService.updateMember(id, updateMemberRequestDto);
	}
}
