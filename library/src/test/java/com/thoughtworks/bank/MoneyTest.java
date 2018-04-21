package com.thoughtworks.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {
  @Test
  public void shouldGiveMoney() throws InvalidAmountException {
    Money money = new Money(5000);
    assertThat(money.getMoney(),is(5000.0));
  }

  @Test (expected = InvalidAmountException.class)
  public void shouldThrowInvalidMoneyExceptionForNegativeAmount() throws InvalidAmountException {
    new Money(-300);
  }
}
