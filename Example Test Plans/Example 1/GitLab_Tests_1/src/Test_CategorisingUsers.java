import org.junit.Assert.*;
import org.junit.Test;

public class Test_CategorisingUsers {


    @Test
    @DisplayName("Test correct input is community for userversion")
    public void test_getUserVersion_community(){
        assertEquals("community", new ConsoleApp().determineUserVersion("1"));
    }

    @Test
    @DisplayName("Test correct input is unverified-encost for userversion")
    public void test_getUserVersion_encost(){
        assertEquals("unverified-encost", new ConsoleApp().determineUserVersion("2"));
    }

    @Test
    @DisplayName("Test invalid digit input for userversion")
    public void test_getUserVersion_invaliddigit(){
        assertEquals("invalid", new ConsoleApp().determineUserVersion("3"));
    }

    @Test
    @DisplayName("Test empty useversion input")
    public void test_getUserVersion_emptyselection(){
        assertEquals("invalid", new ConsoleApp().determineUserVersion(""));
    }

    @Test
    @DisplayName("Test non-integer invalid input for userversion")
    public void test_getUserVersion_invalidchar(){
        assertEquals( "invalid", new ConsoleApp().determineUserVersion("a"));
    }

}
