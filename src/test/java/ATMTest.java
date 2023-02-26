import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;
import exception.InvalidDepositAmountException;
import model.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import enums.Bills;

public class ATMTest {

    @Test
    public void givenCorrectAmount_whenWithdraw_thenSucceed() throws ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(2000);

        atm.withdraw(1200);

        Assertions.assertEquals(800, atm.getBalance());

    }

    @Test
    public void givenPassedBalance_whenWithdraw_thenTrowsATMInsufficientBalance()
            throws ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(2000);

        Assertions.assertThrows(ATMInsufficientBalance.class, () -> atm.withdraw(3000));

    }

    @Test
    public void givenPassedLimit_whenWithdraw_thenTrowsATMWithdrawLimitException()
            throws ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(15000);

        Assertions.assertThrows(ATMWithdrawLimitException.class, () -> atm.withdraw(6000));

    }

    @Test
    public void givenAmountAndBills_whenDeposit_thenSucceed()
            throws ATMInsufficientBalance, ATMWithdrawLimitException, InvalidDepositAmountException {
        ATM atm = new ATM(2000);
        int num200Bills = 5;
        int num100Bills = 2;
        double amount = num200Bills * Bills.BILL_200.getValue() + num100Bills * Bills.BILL_100.getValue();
        atm.deposit(amount, num200Bills, num100Bills);
        Assertions.assertEquals(3200, atm.getBalance());
    }

    @Test
    public void givenIncorrectAmount_whenDeposit_thenThrowsInvalidDepositAmountException()
            throws InvalidDepositAmountException {
        ATM atm = new ATM(2000);
        int num200Bills = 5;
        int num100Bills = 2;
        double amount = num200Bills * Bills.BILL_200.getValue() + num100Bills * Bills.BILL_100.getValue() - 50;
        Assertions.assertThrows(InvalidDepositAmountException.class,
                () -> atm.deposit(amount, num200Bills, num100Bills));
    }

}
