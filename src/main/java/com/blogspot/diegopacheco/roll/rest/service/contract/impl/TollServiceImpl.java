package com.blogspot.diegopacheco.roll.rest.service.contract.impl;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.blogspot.diegopacheco.roll.rest.service.contract.Recipt;
import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;
import com.blogspot.diegopacheco.roll.rest.service.domain.VehiculeType;
import com.blogspot.diegopacheco.roll.rest.service.exception.MissingAxisException;
import com.blogspot.diegopacheco.roll.rest.service.exception.NotEnoughMoneyException;

/**
 * 
 * @author Diego Pacheco
 * 
 * @since 28/11/2010
 * @version 1.0
 * 
 */
public class TollServiceImpl implements TollService {
	
	private Map<UUID, Recipt> cache = new HashMap<UUID, Recipt>();

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
		if ((axis == null) || (axis < 2)) {
			throw new MissingAxisException();
		}
		price = new BigDecimal(3.95f);
		price = price.multiply(new BigDecimal(axis));
		return price;
	}

	@Override
	public URI pay(String id, BigDecimal money, BigDecimal moneyReceived) {
		Recipt r = new Recipt();
		r.setImmatricuation(id);
		r.setDate(new Date());

		if (moneyReceived.compareTo(money) < 0) {
			throw new NotEnoughMoneyException();
		}
		r.setChange(moneyReceived.subtract(money));
		cache.put(r.getId(), r);
		return URI.create("/toll/receipt/" + r.getId());
	}

	@Override
	public Recipt pay(String id, String ccNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipt getReceipt(UUID id) {
		return cache.get(id);
	}

}
