import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test_AccountLogin {

    @Test
    @DisplayName("Test user value and pwd valid 1")
    public void test_validpair1(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user1"));
        assertTrue(uv.verifyPassword("valid1"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 2")
    public void test_validpair2(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user2"));
        assertTrue(uv.verifyPassword("valid2"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 3")
    public void test_validpair3(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user3"));
        assertTrue(uv.verifyPassword("valid3"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 4")
    public void test_validpair4(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user4"));
        assertTrue(uv.verifyPassword("valid4"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 5")
    public void test_validpair5(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user5"));
        assertTrue(uv.verifyPassword("valid5"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 6")
    public void test_validpair6(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user6"));
        assertTrue(uv.verifyPassword("valid6"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 7")
    public void test_validpair7(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user7"));
        assertTrue(uv.verifyPassword("valid7"));
    }

    @Test
    @DisplayName("Test user value and pwd valid 8 - with special password characters")
    public void test_validpair8_specialpwdcharacters(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user8"));
        assertTrue(uv.verifyPassword("valid-8+&!."));
    }
    @Test
    @DisplayName("Test user value and pwd valid 9 - with special username characters")
    public void test_validpair9_specialusernamecharacters(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user_9.-"));
        assertTrue(uv.verifyPassword("valid9"));
    }
    @Test
    @DisplayName("Test user value and pwd valid 10 - with empty password")
    public void test_validpair10_emptyvalidpassword(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user10"));
        assertTrue(uv.verifyPassword(""));
    }

    @Test
    @DisplayName("Test user valid and invalid pwd")
    public void test_invalidpassword(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user1"));
        assertFalse(uv.verifyPassword("invalid"));
    }
    @Test
    @DisplayName("Test user valid and valid pwd for a different pair")
    public void test_rightdetailswrongpairing(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user1"));
        assertTrue(uv.verifyPassword("valid2"));
    }
    @Test
    @DisplayName("Test capitalised username")
    public void test_captialisedusername(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("USER1"));
        assertTrue(uv.verifyPassword("valid1"));
    }
    @Test
    @DisplayName("Test username and captialised pwd")
    public void test_capitalisedpassword(){
        UserVerifier uv = new UserVerifier();
        assertTrue(uv.verifyUsername("user1"));
        assertFalse(uv.verifyPassword("VALID1"));
    }


    @Test
    @DisplayName("Test invalid username")
    public void test_invalidusername(){
        UserVerifier uv = new UserVerifier();
        assertFalse(uv.verifyUsername("invalid"));
    }
    @Test
    @DisplayName("Test an empty username")
    public void test_emptyusername(){
        UserVerifier uv = new UserVerifier();
        assertFalse(uv.verifyUsername(""));
    }
}
