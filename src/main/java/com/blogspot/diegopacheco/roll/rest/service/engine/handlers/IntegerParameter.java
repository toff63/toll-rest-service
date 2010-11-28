package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Diego Pacheco
 *
 * @since 28/11/2010
 * @version 1.0
 * 
 */
@Provider
@Consumes({"application/json","plain/text"})
public class IntegerParameter implements MessageBodyReader<Integer> {
	
	@Override
	public boolean isReadable(Class<?> type, Type genericType,Annotation[] annotations, MediaType mediaType) {
		return int.class.isAssignableFrom(type) || Integer.class.isAssignableFrom(type);
	}
	
	@Override
	public Integer readFrom(Class<Integer> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		return new Integer(entityStream.read());
	}
	
}
