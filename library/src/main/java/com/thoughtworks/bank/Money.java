package com.thoughtworks.bank;

public class Money {
  private double amount;

  public Money(double amount) throws InvalidAmountException {
    if (amount < 0){
      throw new InvalidAmountException();
    }
    this.amount = amount;
  }

  public Double getMoney() {
    return amount;
  }

  public void deduceMoney(double amount) {
    this.amount -= amount;
  }
}
