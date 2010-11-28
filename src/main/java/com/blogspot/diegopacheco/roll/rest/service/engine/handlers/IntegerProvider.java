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
public class IntegerProvider implements MessageBodyWriter<Integer> {
	
	@Override
    public long getSize(Integer l, Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return -1;
    }

	@Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return int.class.isAssignableFrom(type) || Integer.class.isAssignableFrom(type);
    }

	@Override
    public void writeTo(Integer i, Class<?> clazz, Type type, Annotation[] a, 
                        MediaType mt, MultivaluedMap<String, Object> headers, OutputStream os) 
        throws IOException {
        os.write(i.toString().getBytes());
        
    }
    
}