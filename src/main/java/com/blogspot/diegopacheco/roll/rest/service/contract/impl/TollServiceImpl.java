package com.blogspot.diegopacheco.roll.rest.service.contract.impl;

import java.math.BigDecimal;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.blogspot.diegopacheco.roll.rest.service.contract.Recipt;
import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;

import com.blogspot.diegopacheco.roll.rest.service.domain.VehiculeType;

import com.blogspot.diegopacheco.roll.rest.service.exception.MissingAxisException;

/**
 * 
 * @author Diego Pacheco
 * 
 * @since 28/11/2010
 * @version 1.0
 * 
 */
public class TollServiceImpl implements TollService {

	private NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
	
	@Override
	public BigDecimal price(VehiculeType type) {
		BigDecimal price = null;
		if (type == null) {
			return null;
		}
		if (VehiculeType.BIKE.equals(type)) {
			price = new BigDecimal(0.45f);
		} else if (VehiculeType.CAR.equals(type)) {
			price = new BigDecimal(2.11f);
		} else if (VehiculeType.BUS.equals(type)) {
			price = new BigDecimal(1.59f);
		} else if (VehiculeType.MOTO.equals(type)) {
			price = new BigDecimal(1.00f);
		} else if (VehiculeType.TRUCK.equals(type)) {
      throw new MissingAxisException();
		}
		return price;
	}

	@Override
	public BigDecimal price(Integer axis) {
		BigDecimal price = null;
		if (axis == null) {
      throw new MissingAxisException();
		}
		price = new BigDecimal(2.11f);
		price = price.multiply(new BigDecimal(axis));
		return price;
	}

	@Override
	public Recipt pay(String id, BigDecimal money, BigDecimal moneyReceived) {
		Recipt r = new Recipt();
		r.setImmatricuation(id);
		
		return null;
	}

	@Override
	public Recipt pay(String id, String ccNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
