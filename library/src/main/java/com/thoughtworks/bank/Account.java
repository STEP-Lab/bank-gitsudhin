package com.thoughtworks.bank;

import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class Account {
  private final String accountNumber;
  private int balance;

  public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
    if (!Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber))){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
    if (balance < 1000){
      throw new MinimumBalanceException();
    }
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
  