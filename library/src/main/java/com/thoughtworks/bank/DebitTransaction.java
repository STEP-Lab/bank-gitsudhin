package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(Date date, double amount, String destinationAcc) {
    super(date, amount, destinationAcc);
  }

  public DebitTransaction(double amount, String name) {
    this(new Date(),amount, name);
  }
}
