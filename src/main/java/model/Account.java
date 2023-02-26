package model;

import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;
import exception.AccountInsufficientBalance;
import exception.AccountWithdrawLimitException;

public class Account {
    String login;
    String password;
    double balance;

    private static final int DAILY_LIMIT = 5000;

    public Account(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public void withdraw(double amount) throws AccountInsufficientBalance, AccountWithdrawLimitException {
        if (balance < amount) {
            throw new AccountInsufficientBalance("Account balance insufficient");
        }
        if (DAILY_LIMIT < amount) {
            throw new AccountWithdrawLimitException("Account daily limit passed");
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
