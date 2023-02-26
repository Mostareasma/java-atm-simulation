package exception;

public class AccountWithdrawLimitException extends Exception {

    public AccountWithdrawLimitException(String message){
        super(message);
    }
}
