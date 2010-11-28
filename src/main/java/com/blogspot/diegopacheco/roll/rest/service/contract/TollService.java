package com.blogspot.diegopacheco.roll.rest.service.contract;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
@Consumes("application/json")
public interface TollService {
	
	@GET
	@Path("/car/{money}")	
	public Recipt payCarToll(@PathParam("money")Integer money);
	
	@GET
	@Path("/motorcycle/{money}")	
	public Integer payMotorcycleToll(@PathParam("money")Integer money);
	
	@GET
	@Path("/truck/{money}")	
	public Double payTruckToll(@PathParam("money")Double money);
	
	@GET
	@Path("/bicycle/{money}")	
	public List<Double> payBicycleToll(@PathParam("money")Float money);
	
	@GET
	@Path("/bus/{money:[0-9]+(;[0-9]+)*}")	
	public List<Double> payBusToll(@PathParam("money")List<Double> bunchOfMoney);
	
}
