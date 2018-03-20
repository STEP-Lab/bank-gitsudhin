package com.thoughtworks.bank;

import java.util.Scanner;


public class Application {

  public static void main(String[] args) {
    System.out.println("Enter your name");
    Scanner sc=new Scanner(System.in);
    String name = sc.next();
    System.out.println("Welcome "+name);
    beginATransaction(name,123456);
  }

  private static void beginATransaction(String name, int acc_num) {
    if (name == "sudhin") {
      System.out.println("You want to start a transaction?");
    }else {
      System.out.println("Not a valid user");
    }
  }
}
