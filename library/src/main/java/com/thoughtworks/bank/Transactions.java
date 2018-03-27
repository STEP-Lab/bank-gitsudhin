package com.thoughtworks.bank;

import java.io.PrintWriter;
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

  public void credit(double amount, String name) {
    this.list.add(new CreditTransaction(amount,name));
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

  public Transactions getAllTransactionsAbove(double amount) {

    Transactions transactions = new Transactions();
    for (Transaction transaction : list){
      if (transaction.getAmount() >= amount){
        transactions.list.add(transaction);
        System.out.println(transaction);
      }
    }
    return transactions;
  }

  public void print(PrintWriter writer) {
    for (Transaction transaction : list){
      writer.println(transaction.toString());
    }
  }

  public Transactions getAllCreditTransactions() {
    Transactions transactions = new Transactions();
    for (Transaction transaction: list ) {
      if (transaction instanceof CreditTransaction){
        transactions.list.add(transaction);
        System.out.println(transaction);
      }
    }
    return transactions;
  }

  public Transactions getAllDebitTransactions() {
    Transactions transactions = new Transactions();
    for (Transaction transaction: list ) {
      if (transaction instanceof DebitTransaction){
        transactions.list.add(transaction);
        System.out.println(transaction);
      }
    }
    return transactions;
  }

  public Transactions getAllTransactionsBelow(double amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction : list){
      if (transaction.getAmount() <= amount){
        transactions.list.add(transaction);
        System.out.println(transaction);
      }
    }
    return transactions;
  }
}
