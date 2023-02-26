package model;

import exception.IncorrectCredentials;
import exception.NullCredentialsException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ATMAuthenticator {

    HashMap<String,String> accounts= new HashMap<String,String>();

    public ATMAuthenticator() {
        accounts.put("Hicham", "1233");
        accounts.put("Maroua", "4567");
        accounts.put("Laila", "8908");
        accounts.put("Kaouthar", "1234");
    }

    public boolean authenticate(String login, String password)throws IncorrectCredentials, NullCredentialsException {

        if (login == null  || password == null) {
            throw new NullCredentialsException("");
        }
        if (!accounts.containsKey(login) || accounts.get(login)!= password) {
            throw new IncorrectCredentials("Invalid credentials");
        }
        return true;
    }

}
