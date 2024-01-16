import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.beans.Transient;
import java.io.*;

public class testAccountLogin {

    @Test
    @DisplayName
    public void validUsername_validPassword(){
        String username = "encostUserB";
        String password = "password234";
        bool res = validateLogin(username, password);
        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName
    public void invalidUsername_validPassword(){
        String username = "encostUserB";
        String password = "password789";
        Boolean res = validateLogin(username, password);
        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName
    public void validUsername_invalidPassword(){
        String username = "encostUserB";
        String password = "password";
        Boolean res = validateLogin(username, password);
        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName
    public void invalidUsername_validPassword(){
        String username = "encostUser";
        String password = "password";
        Boolean res = validateLogin(username, password);
        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName
    public void encrypt(){
        String password = "";
        String decrypted = "";
        String s = encrypt(password);
        Assertions.assertEquals(decrypted, s);
    }
    
    
}
