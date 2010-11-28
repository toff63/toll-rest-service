package com.blogspot.diegopacheco.roll.rest.service.contract;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Diego Pacheco
 *
 * @since 28/11/2010
 * @version 1.0
 * 
 */
@XmlRootElement
@XmlType(name = "", propOrder = {"change"})
public class Recipt {
	
	private Integer change;
	
	public Recipt() {}

	public Integer getChange() {
		return change;
	}

	public void setChange(Integer change) {
		this.change = change;
	}


}
