package com.blogspot.diegopacheco.roll.rest.service.contract;

import java.math.BigDecimal;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Diego Pacheco
 * 
 * @since 28/11/2010
 * @version 1.0
 * 
 */
@XmlRootElement
@XmlType(name = "", propOrder = { "change" })
public class Recipt {

  private UUID id;

  private BigDecimal change;

  private Date date;

  private String immatricuation;

  private String approvalCode;

  public Recipt() {
    id = UUID.randomUUID();
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public BigDecimal getChange() {
    return change;
  }

  public void setChange(BigDecimal change) {
    this.change = change;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setImmatricuation(String immatricuation) {
    this.immatricuation = immatricuation;
  }

  public String getApprovalCode(){
    return this.approvalCode;
  }

  public void setApprovalCode(String approvalCode){
    this.approvalCode = approvalCode;
  }

  public String getImmatricuation() {
    return immatricuation;
  }

}
