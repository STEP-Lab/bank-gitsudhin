package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction {
  private Date date;
  private final double amount;
  private final String destinationAcc;

  protected DebitTransaction(Date date, double amount, String destinationAcc) {
    this.date = date;
    this.amount = amount;
    this.destinationAcc = destinationAcc;
  }

  public Date getDate() {
    return date;
  }
}
