package com.flab.nsv.system.exeption;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class UnknownEnumValueException extends BaseException {

	public UnknownEnumValueException(String name, int code) {
		super("알 수 없는 형식의 값을 갖습니다.(" + name + ":" + code + ")", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}