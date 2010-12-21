package com.blogspot.diegopacheco.roll.rest.service.engine.handlers;

import org.apache.abdera.model.Entry;
import org.apache.cxf.jaxrs.ext.atom.AtomElementWriter;

import com.blogspot.diegopacheco.roll.rest.service.contract.Receipt;

public class ReceiptElementWriter implements AtomElementWriter<Entry, Receipt>{

	@Override
	public void writeTo(Entry element, Receipt pojoElement) {
		element.addAuthor("gate id: " + pojoElement.getGateId().toString());
		element.setAttributeValue("title", "Receipt number: " +pojoElement.getId().toString());
		element.setAttributeValue("id", pojoElement.getId().toString());
		element.setAttributeValue("updated", pojoElement.getDate().toString());
		element.setAttributeValue("Vehicule immatriculation", pojoElement.getImmatriculation());
		element.setAttributeValue("change", pojoElement.getChange().toString());
		element.setAttributeValue("approval code", pojoElement.getApprovalCode());
	}

}
