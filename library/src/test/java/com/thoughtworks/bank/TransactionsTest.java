package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() {
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
  public void shouldFilterTransactionsByAmount() {
    Transactions transactions = new Transactions();
    transactions.credit(500.0,"Sudhin");
    transactions.credit(1000.0,"Sudhin");
    transactions.credit(600.0,"ATM");
    Transactions filteredTransactionsByAmount = transactions.getAllTransactionsAbove(500);

    CreditTransaction credit1 = new CreditTransaction(1000.0, "Sudhin");
    CreditTransaction credit2 = new CreditTransaction(500.0, "Sudhin");
    CreditTransaction credit3 = new CreditTransaction(600.0, "ATM");
    assertThat(filteredTransactionsByAmount.list,hasItems(credit1,credit2,credit3));
  }

  @Test
  public void shouldFilterAllCreditTransactions() {
    Transactions transactions = new Transactions();
    transactions.credit(500.0,"Sudhin");
    transactions.credit(1000.0,"Sudhin");
    transactions.debit(600.0,"ATM");
    Transactions  getAllCreditTransactions = transactions.getAllCreditTransactions();

    CreditTransaction credit1 = new CreditTransaction(1000.0, "Sudhin");
    CreditTransaction credit2 = new CreditTransaction(500.0, "Sudhin");
    DebitTransaction debit1 = new DebitTransaction(500.0, "ATM");
    assertThat(getAllCreditTransactions.list,hasItems(credit1,credit2));
  }

  @Test
  @Ignore
  public void shouldFilterAllDebitTransactions() {
    Transactions transactions = new Transactions();
    transactions.debit(500.0,"Sudhin");
    transactions.credit(1000.0,"Sudhin");
    transactions.debit(600.0,"ATM");
    Transactions  getAllDebitTransactions = transactions.getAllDebitTransactions();

    CreditTransaction credit1 = new CreditTransaction(1000.0, "Sudhin");
    DebitTransaction debit1 = new DebitTransaction(600.0, "ATM");
    DebitTransaction debit2 = new DebitTransaction(500.0, "Sudhin");
    assertThat(getAllDebitTransactions.list,hasItems(debit1,debit2));
  }

  @Test
  @Ignore
  public void shouldFilterTransactionsBefore() {

  }

  @Test
  @Ignore
  public void shouldFilterTransactionsAfter() {

  }
}
