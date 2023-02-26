package model;

import enums.Bills;
import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;
import exception.InvalidDepositAmountException;

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

        // calculate the number of bills needed for withdrawal
        int num200Bills = (int) (amount / Bills.BILL_200.getValue());
        int num100Bills = 0;

        // check if we have enough 200 bills in the ATM, if not, get the maximum number of 200 bills available
        if (num200Bills > getNum200Bills()) {
            num200Bills = getNum200Bills();
        }

        // calculate the remaining amount that needs to be withdrawn after getting the 200 bills
        double remainingAmount = amount - num200Bills * Bills.BILL_200.getValue();

        // if there is still remaining amount, get the required number of 100 bills
        if (remainingAmount > 0) {
            num100Bills = (int) (remainingAmount / Bills.BILL_100.getValue());
        }

        // check if the ATM has enough bills for withdrawal, if not, throw an exception
        if (num200Bills + num100Bills == 0) {
            throw new ATMInsufficientBalance("ATM balance insufficient");
        }

        // update the ATM balance and print the number of bills dispensed
        balance -= num200Bills * Bills.BILL_200.getValue() + num100Bills * Bills.BILL_100.getValue();
        System.out.println("Dispensing " + num200Bills + " " + Bills.BILL_200.name() + " bills and " + num100Bills + " " + Bills.BILL_100.name() + " bills");
    }

    public void deposit(double amount, int num200Bills, int num100Bills) throws InvalidDepositAmountException {
        double depositedAmount = num200Bills * Bills.BILL_200.getValue() + num100Bills * Bills.BILL_100.getValue();
        if (depositedAmount != amount) {
            throw new InvalidDepositAmountException("Deposited amount does not match the value of the deposited bills");
        }
        balance += depositedAmount;
        System.out.println("Depositing " + num200Bills + " " + Bills.BILL_200.name() + " bills and " + num100Bills + " " + Bills.BILL_100.name() + " bills");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNum200Bills() {
        return (int) (balance / Bills.BILL_200.getValue());
    }
}
