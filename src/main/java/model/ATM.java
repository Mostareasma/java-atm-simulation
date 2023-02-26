package model;

import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;

public class ATM {
    private double balance = 0;
    private static final int WITHDRAW_LIMIT = 5000;

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws ATMInsufficientBalance, ATMWithdrawLimitException {
        if (balance < amount) {
            throw new ATMInsufficientBalance("ATM balance insufficient");
        }
        if (WITHDRAW_LIMIT < amount) {
            throw new ATMWithdrawLimitException("ATM withdraw exceeded");
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
