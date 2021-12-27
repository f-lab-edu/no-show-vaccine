package com.flab.nsv.member.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class NotFoundVaccineException extends BaseException {
	public NotFoundVaccineException() {
		super("존재하는 백신이 없습니다.", HttpStatus.BAD_REQUEST);
	}
}
