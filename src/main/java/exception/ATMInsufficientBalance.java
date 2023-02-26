package exception;

public class ATMInsufficientBalance extends Exception{

    public ATMInsufficientBalance(String message){
        super(message);
    }
}
