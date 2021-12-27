package com.flab.nsv.member.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class NotFoundInstitutionException extends BaseException{
	public NotFoundInstitutionException() {
			super("존재하는 기관이 없습니다.", HttpStatus.BAD_REQUEST);
		}
}
