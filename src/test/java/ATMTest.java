import exception.ATMInsufficientBalance;
import exception.ATMWithdrawLimitException;
import model.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ATMTest {

    @Test
    public void givenCorrectAmount_whenWithdraw_thenSucceed() throws ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(2000);

        atm.withdraw(1200);

        Assertions.assertEquals(800, atm.getBalance());

    }

    @Test
    public void givenPassedBalance_whenWithdraw_thenTrowsATMInsufficientBalance() throws  ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(2000);


        Assertions.assertThrows(ATMInsufficientBalance.class, ()-> atm.withdraw(3000));

    }
    @Test
    public void givenPassedLimit_whenWithdraw_thenTrowsATMWithdrawLimitException() throws  ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(15000);


        Assertions.assertThrows(ATMWithdrawLimitException.class, ()-> atm.withdraw(6000));

    }

    @Test
    public void givenAmount_whenDeposit_thenSucceed() throws ATMInsufficientBalance, ATMWithdrawLimitException {

        ATM atm = new ATM(2000);

        atm.deposit(1200);

        Assertions.assertEquals(3200, atm.getBalance());

    }

}
