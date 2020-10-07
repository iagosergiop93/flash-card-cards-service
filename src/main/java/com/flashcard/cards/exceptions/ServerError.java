package com.flashcard.cards.exceptions;

public class ServerError extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public ServerError(int code, String msg) {
		super(code, msg);
	}
	
}
