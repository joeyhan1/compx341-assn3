import static org.junit.*;
import org.junit.Test;

public class LoadFeaturesTest {

    @ParameterizedTest
    @Test
    @ValueSource(inputs = {"1", "x"})
    @DisplayName("Valid Community Features Test")
    public void communityFeatureTest1(String input) {
        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();

        // Each input will be tested by the parameterized test
        // The result bool indicates success or failure of the input validation
        bool result = project.checkFeatureIsValid(input);

        assertTrue(result);
    }

    @ParameterizedTest
    @Test
    @ValueSource(inputs = {"9", "h", "e", "?"})
    @DisplayName("Invalid Community Features Test")
    public void communityFeatureTest2(String input) {
        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();

        // Each input will be tested by the parameterized test
        // The result bool indicates success or failure of the input validation
        bool result = project.checkFeatureIsValid(input);

        assertFalse(result);
    }

    @ParameterizedTest
    @Test
    @ValueSource(inputs = {"1", "x", "2", "3"})
    @DisplayName("Valid Encost Features Test")
    public void encostFeatureTest1(String input) {
        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();

        // Each input will be tested by the parameterized test
        // The result bool indicates success or failure of the input validation
        bool result = project.checkFeatureIsValid(input);

        assertTrue(result);
    }

    @ParameterizedTest
    @Test
    @ValueSource(inputs = {"s", "5", "p", "!"})
    @DisplayName("Invalid Encost Features Test")
    public void encostFeatureTest2(String input) {
        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();

        // Each input will be tested by the parameterized test
        // The result bool indicates success or failure of the input validation
        bool result = project.checkFeatureIsValid(input);

        assertFalse(result);
    }

}
