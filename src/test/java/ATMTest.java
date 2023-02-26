import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;
import model.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ATMTest {
    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM(20, 50);
    }

    @Test
    public void givenValidAmount_whenWithdraw_thenSucceed() throws ATMInsufficientBalance, ATMWithdrawLimitException {
        double withdrawAmount = 1500;
        double initialBalance = atm.getBalance();

        atm.withdraw(withdrawAmount);

        double expectedBalance = initialBalance - withdrawAmount;
        Assertions.assertEquals(expectedBalance, atm.getBalance());
    }

    @Test
    public void givenInsufficientBalance_whenWithdraw_thenThrowATMInsufficientBalanceException() {
        double withdrawAmount = 15000;

        Assertions.assertThrows(ATMInsufficientBalance.class, () -> atm.withdraw(withdrawAmount));
    }

    @Test
    public void givenWithdrawAmountExceedsLimit_whenWithdraw_thenThrowATMWithdrawLimitException() {
        double withdrawAmount = 6000;

        Assertions.assertThrows(ATMWithdrawLimitException.class, () -> atm.withdraw(withdrawAmount));
    }

    @Test
    public void givenValidDepositAmount_whenDeposit_thenSucceed() {
        double depositAmount = 1200;
        int num200Bills = 3;
        int num100Bills = 6;
        double initialBalance = atm.getBalance();

        atm.deposit( num200Bills, num100Bills);

        double expectedBalance = initialBalance + depositAmount;
        Assertions.assertEquals(expectedBalance, atm.getBalance());
        Assertions.assertEquals(23, atm.getNum200Bills());
        Assertions.assertEquals(56, atm.getNum100Bills());
    }
}
