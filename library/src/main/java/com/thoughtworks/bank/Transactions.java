package com.thoughtworks.bank;

import java.util.ArrayList;
import java.util.Objects;

public class Transactions {
  public Transactions() {
     this.list = new ArrayList<>();
  }

  protected ArrayList<Transaction> list;

  public void debit(double amount, String name) {
    this.list.add(new DebitTransaction(amount,name));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transactions that = (Transactions) o;
    return Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {

    return Objects.hash(list);
  }
}
