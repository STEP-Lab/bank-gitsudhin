package com.thoughtworks.bank;

public class Account {
  private final AccountNumber accountNumber;
  private final Transactions transactions;
  private double balance;

  public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
    if (balance < 1000){
      throw new MinimumBalanceException();
    }
    this.balance = balance;
    this.accountNumber = accountNumber;
    this.transactions = new Transactions();
  }

  public double getBalance() {
    return balance;
  }

  public AccountNumber getAccountNumber() {
    return accountNumber;
  }

  public void debitMoney(double amount, String destinationAcc) throws MinimumBalanceException {
    if(this.balance - amount < 1000){
      throw new MinimumBalanceException();
    }
    this.balance -= amount;
    transactions.debit(amount,destinationAcc);
  }

  public Transactions getAllTransactions() {
    return this.transactions;
  }
}
  