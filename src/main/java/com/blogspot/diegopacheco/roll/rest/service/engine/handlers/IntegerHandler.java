package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import org.apache.cxf.jaxrs.ext.ParameterHandler;

/**
 * 
 * @author Diego Pacheco
 *
 * @since 28/11/2010
 * @version 1.0
 * 
 */
public class IntegerHandler implements ParameterHandler<Integer>{
	
	@Override
	public Integer fromString(String s) {
		System.out.println("Converting " + s + " to Integer... ");
		return new Integer(s);
	}
	
}
