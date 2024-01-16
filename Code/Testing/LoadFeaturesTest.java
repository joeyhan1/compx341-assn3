import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LoadFeaturesTest {

    private String input;
    private boolean expectedResult;
    private String userType;

    public LoadFeaturesTest(String input, boolean expectedResult, String userType) {
        this.input = input;
        this.expectedResult = expectedResult;
        this.userType = userType;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> featureData() {
        return Arrays.asList(new Object[][]{
                // Community feature test cases
                {"1", true, "Community User"},
                {"x", true, "Community User"},
                {"9", false, "Community User"},
                {"h", false, "Community User"},
                {"e", false, "Community User"},
                {"?", false, "Community User"},
                // Encost feature test cases
                {"1", true, "Encost User"},
                {"x", true, "Encost User"},
                {"2", true, "Encost User"},
                {"3", true, "Encost User"},
                {"s", false, "Encost User"},
                {"5", false, "Encost User"},
                {"p", false, "Encost User"},
                {"!", false, "Encost User"}
        });
    }

    @Test
    public void testFeature() {
        Encost project = new Encost();
        boolean result = project.checkFeatureIsValid(input, userType);
        assertEquals(expectedResult, result);
    }
}
