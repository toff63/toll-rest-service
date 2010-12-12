/**
 * 
 */
package com.blogspot.diegopacheco.roll.rest.service.contract.impl;

import java.net.URI;
import java.util.UUID;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;

/**
 * @author Christophe Marchal
 * @since Dec 12, 2010
 */
public class UriUtils {

	public URI getReceipt(UriInfo ui, UUID id) {
		UriBuilder ub = ui.getBaseUriBuilder().path(TollService.class)
				.path(TollService.class, "getReceipt");
		return ub.build(id);
	}
}
