package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;

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
public class ArrayListProvider  implements MessageBodyWriter<ArrayList<Object>> {
	
	@Override
    public long getSize(ArrayList<Object> a, Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return -1;
    }

	@Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return ArrayList.class.isAssignableFrom(type);
    }

	@Override
    public void writeTo(ArrayList<Object> arrayList, Class<?> clazz, Type type, Annotation[] a, 
                        MediaType mt, MultivaluedMap<String, Object> headers, OutputStream os) 
        throws IOException {
		
		os.write("[".getBytes());
		
		Object[] array = arrayList.toArray();		
		for(int i=0;i<array.length;i++){
			os.write(array[i].toString().getBytes());
			if ((i+1)<array.length)
				os.write(",".getBytes());		
		}
		os.write("]".getBytes());
    }
    
}