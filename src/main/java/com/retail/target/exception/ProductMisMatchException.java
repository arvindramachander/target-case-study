package com.retail.target.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ProductId mismacth in request header and body.Please check.")
public class ProductMisMatchException extends RuntimeException{
	
	/**
	 * SUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProductMisMatchException() {
		// TODO Auto-generated constructor stub
	}

}
