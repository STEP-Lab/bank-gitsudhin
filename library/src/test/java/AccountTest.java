import com.thoughtworks.bank.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1234");
    account = new Account(accountNumber,1000.50);
  }

  @Test
  public void checkBalance(){
    assertThat(account.getBalance(),is(1000.50));
  }

  @Test
  public void checkAccountNumber() throws InvalidAccountNumberException {
    assertThat(account.getAccountNumber(),is(new AccountNumber("1234-1234")));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1245");
    new Account(accountNumber, 200.0);
  }

  @Test
  public void debitIfAboveMinBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1235");
    Account account = new Account(accountNumber, 5000.0);
    account.debitMoney(1000.0, "ATM");
    assertThat(account.getBalance(),is(4000.0));
  }

  @Test
  public void shouldUpdateTransactionsListOnDebit() throws MinimumBalanceException, InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1235");
    Account account = new Account(accountNumber, 5000.0);
    account.debitMoney(500,"ATM");
    Transactions transactions = new Transactions();
    transactions.debit(500,"ATM");
    assertThat(account.getAllTransactions(),is(transactions));
  }

  @Test(expected = MinimumBalanceException.class)
  public void debitIfBelowMinBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-5678");
    Account account = new Account(accountNumber, 5000.0);
    account.debitMoney(4500.0,"ATM");
  }
}