package exception;

public class ATMWithdrawLimitException extends Exception {
    public ATMWithdrawLimitException(String message){
        super(message);
    }
}
