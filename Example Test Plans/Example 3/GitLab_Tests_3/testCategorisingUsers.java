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

public class testCategorisingUsers {

    public CommunityUser communityUser = new CommunityUser();
    public EncostUser encostUser = new EncostUser();

    @Test
    @DisplayName
    public void validCommunityNumber(){
        Boolean res = userSelection("1");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), communityUser.getClass());
    }

    @Test
    @DisplayName
    public void validCommunityLetter(){
        Boolean res = userSelection("c");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), communityUser.getClass());
    }

    @Test
    @DisplayName
    public void validCommunityLetterUppercase(){
        Boolean res = userSelection("C");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), communityUser.getClass());
    }

    @Test
    @DisplayName
    public void validCommunityWord(){
        Boolean res = userSelection("community");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), communityUser.getClass());
    }

    @Test
    @DisplayName
    public void validCommunityWordUppercase(){
        Boolean res = userSelection("COMMUNITY");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), communityUser.getClass());
    }

    @Test
    @DisplayName
    public void validEncostNumber(){
        Boolean res = userSelection("2");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), encostUser.getClass());
    }

    @Test
    @DisplayName
    public void validEncostLetter(){
        Boolean res = userSelection("e");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), encostUser.getClass());
    }

    @Test
    @DisplayName
    public void validEncostLetterUppercase(){
        Boolean res = userSelection("E");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), encostUser.getClass());
    }

    @Test
    @DisplayName
    public void validEncostWord(){
        Boolean res = userSelection("encost");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), encostUser.getClass());
    }

    @Test
    @DisplayName
    public void validEncostWordUppercase(){
        Boolean res = userSelection("ENCOST");
        Assertions.assertTrue(res);
        Assertions.assertEquals(user.getClass(), encostUser.getClass());
    }

    @Test
    @DisplayName
    public void invalidNumber(){
        Boolean res = userSelection("3");
        Assertions.assertFalse(res);
        Assertions.assertEquals(user, null);
    }

    @Test
    @DisplayName
    public void invalidWord(){
        Boolean res = userSelection("user");
        Assertions.assertFalse(res);
        Assertions.assertEquals(user, null);
    }

    @Test
    @DisplayName
    public void invalidEmpty(){
        Boolean res = userSelection("");
        Assertions.assertFalse(res);
        Assertions.assertEquals(user, null);
    }

    @Test
    @DisplayName
    public void invalidHome(){
        Boolean res = userSelection("home");
        Assertions.assertFalse(res);
        Assertions.assertEquals(user, null);
    }

}