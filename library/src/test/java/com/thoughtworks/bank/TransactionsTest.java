package com.thoughtworks.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  @Test
  public void shouldRecordDebitTransaction() {
    Transactions transactions = new Transactions();
    transactions.debit(1000,"ATM");
    assertThat(transactions.list,hasItem(new DebitTransaction(new Date(),1000,"ATM")));
  }

  @Test
  public void shouldRecordCreditTransaction() {
    Transactions transactions = new Transactions();
    transactions.credit(1000,"Sudhin");
    assertThat(transactions.list,hasItem(new CreditTransaction(new Date(),1000,"Sudhin")));
  }
}
