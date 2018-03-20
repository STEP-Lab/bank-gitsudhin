package com.thoughtworks.bank;

import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class Account {
  private final String accountNumber;
  private double balance;

  public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
    if (!Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber))){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
    if (balance < 1000){
      throw new MinimumBalanceException();
    }
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void debitMoney(double amount) throws MinimumBalanceException {
    if(this.balance - amount < 1000){
      throw new MinimumBalanceException();
    }
    this.balance -= amount;
  }
}
  