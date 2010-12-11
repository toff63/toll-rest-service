package com.blogspot.diegopacheco.roll.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.blogspot.diegopacheco.roll.rest.service.exception.NotEnoughMoneyException;

public class NotEnoughMoneyExceptionMapper implements ExceptionMapper<NotEnoughMoneyException> {

	@Override
	public Response toResponse(NotEnoughMoneyException exception) {
		return Response.status(Response.Status.NOT_ACCEPTABLE).build();
	}

}
