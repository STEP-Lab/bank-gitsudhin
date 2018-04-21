package com.thoughtworks.bank;

public class Account {
  private final AccountNumber accountNumber;
  private final Transactions transactions;
  private Money balance;

  public Account(AccountNumber accountNumber,double balance) throws MinimumBalanceException, InvalidAmountException {

    if (balance < 1000.0){
      throw new MinimumBalanceException();
    }
    this.balance = new Money(balance);
    this.accountNumber = accountNumber;
    this.transactions = new Transactions();
  }

  public Double getBalance() {
    return balance.getMoney();
  }

  public AccountNumber getAccountNumber() {
    return accountNumber;
  }

  public void debitMoney(double amount, String destinationAcc) throws MinimumBalanceException, InvalidAmountException {
    double debitAmount = new Money(amount).getMoney();
    if(this.balance.getMoney() - debitAmount < 1000){
      throw new MinimumBalanceException();
    }
    this.balance.deduceMoney(debitAmount);
    transactions.debit(debitAmount,destinationAcc);
  }

  public Transactions getAllTransactions() {
    return this.transactions;
  }
}
  