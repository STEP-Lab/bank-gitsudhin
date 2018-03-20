import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
    account = new Account("1234-1234", 1000);
  }

  @Test
  public void checkBalance(){
    assertThat(account.getBalance(),is(1000));
  }

  @Test
  public void checkAccountNumber() {
    assertThat(account.getAccountNumber(),is("1234-1234"));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account("1235-1234", 200);
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void validateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account("1234-678",1200);
  }

}