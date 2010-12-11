package com.blogspot.diegopacheco.roll.rest.service.contract;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.blogspot.diegopacheco.roll.rest.service.domain.VehiculeType;

/**
 * 
 * @author Diego Pacheco
 * 
 * @since 28/11/2010
 * @version 1.0
 * 
 */
@Path("/toll")
@Produces("application/json")
public interface TollService {

	// Ressource: gate

	// Pricing
	@GET
	@Path("/gate/{vehiculeType}/price")
	public BigDecimal price(@PathParam("vehiculeType") VehiculeType type);

	@GET
	@Path("/gate/truck/price/{axis}")
	public BigDecimal price(@PathParam("axis") Integer axis);

	// Ressource: vehicule
	@POST
	@Path("/vehicule/{immatriculation}/pay/cash/{money}/received/{moneyReceived}")
	public Receipt pay (@PathParam("immatriculation") String id,
					   @PathParam("money") BigDecimal money,
					   @PathParam("moneyReceived") BigDecimal moneyReceived);

	@POST
	@Path("/vehicule/{immatriculation}/pay/cc/{ccNumber}")
	public Receipt pay(@PathParam("immatriculation") String id,
					  @PathParam("ccNumber") String ccNumber);
	
	// Ressource: Receipt
	@GET
	@Path("receipt/{id}")
	public Receipt getReceipt(@PathParam("id") UUID id);

}
