import static org.junit.*;
import org.junit.Test;

public class CategorizingUsersTest {
    
    @ParameterizedTest
    @Test
    @ValueSource(inputs = {"1", "2"})
    @DisplayName("Valid User Check Test")
    public void evaluatesUser1(String x) {
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();

        // Each user entry will be tested in the paramertised test
        // A bool result should be returned to indicate the success or failure of login
        bool result = project.checkUserType(x);

        assertTrue(result);
    }

    @ParameterizedTest
    @Test
    @DisplayName("Valid User Check Test")
    @ValueSource(inputs = {"one", "two", "community", "user", "encost", "Encost",
        "community user", "2 Encost", "1111111111111111111111111111111111", "COMMUNITY", "admin"})
    public void evaluatesUser2(String x) {
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();

        // Each user entry will be tested in the paramertised test
        // A bool result should be returned to indicate the success or failure of login
        bool result = project.checkUserType(x);

        assertFalse(result);
    }
}
