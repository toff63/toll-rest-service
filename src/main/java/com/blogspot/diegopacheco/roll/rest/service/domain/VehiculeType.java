package com.blogspot.diegopacheco.roll.rest.service.domain;

public enum VehiculeType {

  BIKE, CAR, TRUCK, MOTO, BUS;

  public static VehiculeType fromString(String s){
    if(s == null){
      return null;
    }

    if("bike".equals(s)){
      return BIKE;
    } else if ("car".equals(s)){
      return CAR;
    } else if ("truck".equals(s)){
      return TRUCK;
    } else if ("moto".equals(s)){
      return MOTO;
    } else if ("bus".equals(s)){
      return BUS;
    }

    return null;
  }
}
