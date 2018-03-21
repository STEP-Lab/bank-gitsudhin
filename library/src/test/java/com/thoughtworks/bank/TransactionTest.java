package com.thoughtworks.bank;

import com.thoughtworks.bank.DebitTransaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void mustRecordCorrectTransactionDate() {
    Date date = new Date();
    DebitTransaction transaction = new DebitTransaction(date,1000, "Another account");
    assertThat(transaction.getDate(),is(date));
  }
}
