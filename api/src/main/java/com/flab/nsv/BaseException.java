package com.flab.nsv;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

	public final HttpStatus statusCode;

	public BaseException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
}
