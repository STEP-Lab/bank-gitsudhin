package com.thoughtworks.bank;

public class MinimumBalanceException extends Throwable {
  public MinimumBalanceException() {
    super("Insufficient minimum balance");
  }
}
