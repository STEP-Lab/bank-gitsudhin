package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() throws Exception {
    transactions = new Transactions();
  }

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

  @Test
  public void shouldRecordCreditAndDebitTrasaction() {
    transactions.credit(1000,"Sudhin");
    transactions.debit(1000,"Sudhin");

    CreditTransaction creditToSudhin = new CreditTransaction(new Date(), 1000, "Sudhin");
    DebitTransaction debitFromSudhin = new DebitTransaction(new Date(), 1000, "Sudhin");
    assertThat(transactions.list,hasItems(creditToSudhin,debitFromSudhin));
  }

  @Test
  public void shoudPrintTransaction() throws FileNotFoundException, UnsupportedEncodingException {
    ArrayList<String> result = new ArrayList<>();
    transactions.credit(1000,"Sudhin");
    transactions.debit(1000,"ATM");

    CreditTransaction creditToSudhin = new CreditTransaction(new Date(), 1000, "Sudhin");
    DebitTransaction debitFromSudhin = new DebitTransaction(new Date(), 1000, "ATM");

    PrintWriter writer = new PrintWriter("transactionSummary.txt","UTF-8"){
      @Override
      public void println(String x) {
        super.println(x);
        System.out.println(x);
        result.add(x);
      }
    };

    transactions.print(writer);
    writer.close();
    assertThat(result,hasItems(creditToSudhin.toString(),debitFromSudhin.toString()));
  }

  @Test
  public void ShouldFilterTransactionsByAmount() {
    Transactions transactions = new Transactions();
    transactions.credit(500.0,"Sudhin");
    transactions.credit(1000.0,"Sudhin");
    transactions.credit(600.0,"ATM");
    Transactions filteredTransactions = transactions.filterByAmountGreaterThan(500);

    CreditTransaction credit1 = new CreditTransaction(1000.0, "Sudhin");
    CreditTransaction credit2 = new CreditTransaction(500.0, "Sudhin");
    CreditTransaction credit3 = new CreditTransaction(600.0, "ATM");
    assertThat(filteredTransactions.list,hasItems(credit1,credit2,credit3));
  }
}
