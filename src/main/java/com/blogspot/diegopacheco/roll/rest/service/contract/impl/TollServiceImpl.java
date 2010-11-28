package com.blogspot.diegopacheco.roll.rest.service.contract.impl;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.diegopacheco.roll.rest.service.contract.Recipt;
import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;

/**
 * 
 * @author Diego Pacheco
 *
 * @since 28/11/2010
 * @version 1.0
 * 
 */
public class TollServiceImpl implements TollService {

	@Override
	public Recipt payCarToll(Integer value) {
		Recipt r = new Recipt();
		r.setChange(new Integer(value));
		return r;
	}
	
	@Override
	public Integer payMotorcycleToll(Integer money) {
		return money;
	}
	
	@Override
	public Double payTruckToll(Double money) {
		return (10.25D - money);
	}
	
	@Override
	public List<Double> payBicycleToll(Float money) {
		List<Double> result = new ArrayList<Double>();
		result.add(new Double(5D - money));
		result.add(new Double(5D - money));
		result.add(new Double(5D - money));
		result.add(new Double(5D - money));
		return result;
	}
	
	@Override
	public List<Double> payBusToll(List<Double> bunchOfMoney) {
		return bunchOfMoney;
	}

}
