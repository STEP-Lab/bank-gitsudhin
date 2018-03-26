package com.thoughtworks.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
  public CreditTransaction(double amount, String destinationAcc) {
    this(new Date(),amount, destinationAcc);
  }

  public CreditTransaction(Date date, double amount, String destinationAcc) {
    super(date, amount, destinationAcc);
  }
}
