package com.flab.nsv.member.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class NotFoundMemberException extends BaseException {
	public NotFoundMemberException() {
		super("존재하는 회원이 없습니다.", HttpStatus.BAD_REQUEST);
	}
}
