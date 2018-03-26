package com.thoughtworks.bank;

import java.util.Objects;
import java.util.regex.Pattern;

public class AccountNumber {

  private final String accountNumber;

  public AccountNumber(String accNum) throws InvalidAccountNumberException {
    if (!Pattern.matches("[0-9]{4}[-][0-9]{4}",accNum)){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accNum;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountNumber that = (AccountNumber) o;
    return Objects.equals(accountNumber, that.accountNumber);
  }

  @Override
  public int hashCode() {

    return Objects.hash(accountNumber);
  }
}
