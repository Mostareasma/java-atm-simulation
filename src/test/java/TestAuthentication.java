import exception.IncorrectCredentials;
import exception.NullCredentialsException;
import model.ATMAuthenticator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestAuthentication {

    static ATMAuthenticator atmAuthenticator;

    @BeforeAll
    public static void setUpAuthenticator(){
        atmAuthenticator = new ATMAuthenticator();
    }

    @Test
    public void givenCorrectCredentials_whenAuthenticate_thenSucceed() throws IncorrectCredentials, NullCredentialsException{

        Assertions.assertTrue(atmAuthenticator.authenticate("Hicham","1233"));

    }

    @Test
    public void givenInvalidLogin_whenAuthenticate_thenThrowsIncorrectCredentials() throws IncorrectCredentials, NullCredentialsException {

        Assertions.assertThrows(IncorrectCredentials.class, ()->atmAuthenticator.authenticate("Hicam","1233"));

    }
    @Test
    public void givenInvalidCredentials_whenAuthenticate_thenThrowsIncorrectCredentials() throws IncorrectCredentials, NullCredentialsException {

        Assertions.assertThrows(IncorrectCredentials.class, ()->atmAuthenticator.authenticate("hicham","null"));

    }
    @Test
    public void givenNullCredentials_whenAuthenticate_thenThrowsIncorrectCredentials() throws IncorrectCredentials, NullCredentialsException {

        Assertions.assertThrows(NullCredentialsException.class, ()->atmAuthenticator.authenticate(null,null));

    }
}
