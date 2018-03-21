import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Test;

public class AccountNumberTest {

  @Test(expected = InvalidAccountNumberException.class)
  public void validateAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account("1234-678",1200.0);
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberIsNotHavingAlphabets() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account("1a2b-6ab8",1200.0);
  }
}
