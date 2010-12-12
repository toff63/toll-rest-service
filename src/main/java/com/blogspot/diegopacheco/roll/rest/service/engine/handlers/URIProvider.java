package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URI;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * 
 * @author Christophe Marchal
 * @since Dec 12, 2010
 */
public class URIProvider implements MessageBodyWriter<URI> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
        return URI.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(URI t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return t.toString().length();
	}

	@Override
	public void writeTo(URI t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream os) throws IOException,
			WebApplicationException {
		
		os.write(t.toString().getBytes());
	}


}
