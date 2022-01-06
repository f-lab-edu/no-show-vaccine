package com.flab.nsv.member.exception;

import org.springframework.http.HttpStatus;

import com.flab.nsv.BaseException;

public class NotFoundStockException extends BaseException {
	public NotFoundStockException() {
		super("재고가 없습니다.", HttpStatus.BAD_REQUEST);
	}
}
