import static org.junit.*;
import org.junit.Test;

public class AccountLoginTest {

    @Test
    @ParameterizedTest
    @MethodSource("ValidLoginDetails")
    @DisplayName("Valid Login Test")
    public void validLoginTest(String username, String password){
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        bool result = project.login(username, password);
        assertTrue(result);
    }

    private static Stream<Arguments> ValidLoginDetails() {
        // Every valid login username and password given by Encost must be added to this list
        return Stream.of(
                arguments("username1", "password1"),
                arguments("username2", "password2")
        );
        
    }

    @Test
    @ParameterizedTest
    @MethodSource("InalidLoginDetails")
    @DisplayName("Invalid Login Test")
    public void invalidLoginTest(String username, String password){
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        bool result = project.login(username, password);
        assertFalse(result);
    }

    private static Stream<Arguments> InalidLoginDetails() {
        return Stream.of(
                arguments("username", "password"),
                arguments("admin", "encost"),
                // Each username# and password# denotes the given Encost login credential which must be added
                arguments("username1", "password4"),
                arguments("password8", "username8"),
                arguments("username6", "password3")
        );
        // These need more
    }

}
