package com.thoughtworks.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {

  @Test(expected = InvalidAccountNumberException.class)
  public void ShouldThrowInvalidAccountNumberException() throws InvalidAccountNumberException {
    new AccountNumber("1234-678");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void checkAccountNumberIsNotHavingAlphabets() throws InvalidAccountNumberException {
    new AccountNumber("1a2b-6ab8");
  }

  @Test
  public void shouldGiveAccountNumber() throws InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1234");
    assertThat( accountNumber.getAccountNumber(),is("1234-1234"));
  }
}
