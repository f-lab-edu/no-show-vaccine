package com.flab.nsv.common.user.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class UnknownRoleValueException extends BaseException {

	public UnknownRoleValueException(int value) {
		super("알 수 없는 권한입니다. Role Value " + value, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}