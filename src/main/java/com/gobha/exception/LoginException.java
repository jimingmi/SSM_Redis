package com.gobha.exception;

public class LoginException extends RuntimeException {

	/**
	 * 登陆异常
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();
	}

	public LoginException( String message ) {
		super(message);
	}

}
