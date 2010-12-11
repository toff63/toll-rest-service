package com.blogspot.diegopacheco.roll.rest.service.contract.impl;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.diegopacheco.roll.rest.service.contract.Recipt;
import com.blogspot.diegopacheco.roll.rest.service.contract.TollService;

import com.blogspot.diegopacheco.roll.rest.service.domain.VehiculeType;

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
    public BigDecimal price(VehiculeType type){
      BigDecimal price = null;
      if(type == null){
        return null;
      }
      if(VehiculeType.BIKE.equals(type)){
        price = new BigDecimal(0.45f);
      } else if(VehiculeType.CAR.equals(type)){
        price = new BigDecimal(2.11f);
      } else if(VehiculeType.BUS.equals(type)){
        price = new BigDecimal(1.59f);
      } else if(VehiculeType.MOTO.equals(type)){
        price = new BigDecimal(1.00f);
      } else if(VehiculeType.TRUCK.equals(type)){
        //TODO throw exception
      }
      return price;
    }

  @Override
    public BigDecimal price(Integer axis){
      BigDecimal price = null;
      if(axis == null){
        //TODO throw exception
      }
      price = new BigDecimal(2.11f);
      price = price.multiply(new BigDecimal(axis));
      return price;
    }

  @Override
    public Recipt payCarToll(Integer value) {
      Recipt r = new Recipt();
      r.setChange(new BigDecimal(value));
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
