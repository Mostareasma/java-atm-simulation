package model;

import enums.Bills;
import exception.ATMInsufficientBalance;
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

        double remainingAmount = amount;
        int count200 = 0;
        int count100 = 0;

        // Withdraw 200 DHS bills
        while (remainingAmount >= Bills.BILL_200.getValue() && count200 < 11) {
            remainingAmount -= Bills.BILL_200.getValue();
            count200++;
        }

        // Withdraw 100 DHS bills
        while (remainingAmount > 0 && count100 < 11) {
            remainingAmount -= Bills.BILL_100.getValue();
            count100++;
        }

        if (remainingAmount > 0) {
            throw new AccountInsufficientBalance("Account balance insufficient");
        }

        this.balance -= amount;
    }

    public void deposit(double amount) {
        double remainingAmount = amount;
        int count200 = 0;
        int count100 = 0;

        // Deposit 200 DHS bills
        while (remainingAmount >= Bills.BILL_200.getValue()) {
            remainingAmount -= Bills.BILL_200.getValue();
            count200++;
        }

        // Deposit 100 DHS bills
        while (remainingAmount > 0) {
            remainingAmount -= Bills.BILL_100.getValue();
            count100++;
        }

        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}