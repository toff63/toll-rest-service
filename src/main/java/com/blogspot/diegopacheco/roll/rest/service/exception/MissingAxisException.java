package com.blogspot.diegopacheco.roll.rest.service.exception;

public class MissingAxisException extends RuntimeException{

  public static final long serialVersionUID = -1;

  public MissingAxisException(){
    super("You must specify the number of axis in case of a truck.");
  }

}

