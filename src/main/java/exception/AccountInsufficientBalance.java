package exception;

public class AccountInsufficientBalance extends Exception {

    public AccountInsufficientBalance (String message){
        super(message);
    }
}
