package com.thoughtworks.bank;

import java.util.Date;
import java.util.Objects;

public abstract class Transaction {
  protected final double amount;
  protected final String destinationAcc;
  protected Date date;

  public Transaction(Date date, double amount, String destinationAcc) {
    this.date = date;
    this.amount = amount;
    this.destinationAcc = destinationAcc;
  }

  public Date getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Double.compare(that.amount, amount) == 0 &&
        Objects.equals(destinationAcc, that.destinationAcc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, destinationAcc);
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "amount=" + amount +
        ", destinationAcc='" + destinationAcc + '\'' +
        ", date=" + date +
        '}';
  }
}
