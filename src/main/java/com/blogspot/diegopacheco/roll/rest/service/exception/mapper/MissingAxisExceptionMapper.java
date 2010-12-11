package com.blogspot.diegopacheco.roll.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.blogspot.diegopacheco.roll.rest.service.exception.MissingAxisException;

public class MissingAxisExceptionMapper implements ExceptionMapper<MissingAxisException>{

	@Override
	public Response toResponse(MissingAxisException exception) {
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	
}


