package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
@Consumes({ "application/json", "plain/text" })
public class ListProvider implements MessageBodyReader<List<?>> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,Annotation[] annotations, MediaType mediaType) {
		return List.class.isAssignableFrom(type);
	}

	@Override
	public List<?> readFrom(Class<List<?>> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		String str = "";
		try {
			str = isToString(entityStream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		List<Object> lista = new ArrayList<Object>();
		
		if (str.contains(";")){
			
			StringTokenizer st = new StringTokenizer(str, ";");
			while(st.hasMoreTokens()){
				if (Double.class.equals(genericType))
				   lista.add((Double)st.nextElement());
				else if(Long.class.equals(genericType))
				   lista.add((Long)st.nextElement());
				else if(String.class.equals(genericType))
					lista.add((String)st.nextElement());
		}
			
		}else{
			lista.add(str);
		}
		
		return lista;
	}

	private String isToString(InputStream entityStream) throws Exception {
		if (entityStream != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(
						entityStream, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				entityStream.close();
			}
			return writer.toString();
		}
		return "";
	}

}