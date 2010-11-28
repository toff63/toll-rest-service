package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
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
@Produces({"application/json","plain/text"})
public class LongProvider implements MessageBodyWriter<Long> {
	
	@Override
    public long getSize(Long l, Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return -1;
    }

	@Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return long.class.isAssignableFrom(type) || Long.class.isAssignableFrom(type);
    }

	@Override
    public void writeTo(Long l, Class<?> clazz, Type type, Annotation[] a, 
                        MediaType mt, MultivaluedMap<String, Object> headers, OutputStream os) 
        throws IOException {
        os.write(l.toString().getBytes());
        
    }
    
}