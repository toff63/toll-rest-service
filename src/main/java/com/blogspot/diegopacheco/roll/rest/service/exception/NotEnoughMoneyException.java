package com.blogspot.diegopacheco.roll.rest.service.exception;

public class NotEnoughMoneyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException() {
		super("Not enough money received.");
	}
	
	public NotEnoughMoneyException(String m){
		super(m);
	}
}
