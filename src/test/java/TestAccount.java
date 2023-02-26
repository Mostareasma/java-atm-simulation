import exception.AccountInsufficientBalance;
import exception.AccountWithdrawLimitException;
import model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestAccount {
    static Account account1;
    static Account account2;
    @BeforeAll
    public static void setUpAccount(){

        account1 = new Account("hicham", "1234", 2000);
        account2 = new Account("hicham", "1234", 200000);

    }

    @Test
    public void givenCorrectAmount_whenWithdraw_thenSucceed() throws AccountInsufficientBalance, AccountWithdrawLimitException {

        account1.withdraw(1200);

        Assertions.assertEquals(800, account1.getBalance());

    }

    @Test
    public void givenPassedBalance_whenWithdraw_thenThrowsAccountInsufficientBalance() throws AccountInsufficientBalance {

        Assertions.assertThrows(AccountInsufficientBalance.class, ()-> account1.withdraw(200000));

    }

    @Test
    public void givenPassedLimit_whenWithdraw_thenThrowsAccountWithdrawLimitException() throws AccountWithdrawLimitException {

        Assertions.assertThrows(AccountWithdrawLimitException.class, ()-> account2.withdraw(30000));

    }


}
