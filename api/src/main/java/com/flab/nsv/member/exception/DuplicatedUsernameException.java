package com.flab.nsv.member.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class DuplicatedUsernameException extends BaseException {
	public DuplicatedUsernameException() {
		super("이미 존재하는 아이디입니다.", HttpStatus.CONFLICT);
	}
}
