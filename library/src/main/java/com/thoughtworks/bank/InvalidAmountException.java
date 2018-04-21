package com.thoughtworks.bank;

public class InvalidAmountException extends Throwable {
  public InvalidAmountException() {
    super("Invalid amount");
  }
}
