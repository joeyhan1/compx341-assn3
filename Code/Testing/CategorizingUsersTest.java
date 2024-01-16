import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CategorizingUsersTest {

    private String inputString;
    private boolean expectedResult;
    private Encost encost;

    public CategorizingUsersTest(String inputString, boolean expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
        this.encost = new Encost();
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"1", true},
                {"2", true},
                {"one", false},
                {"two", false},
                {"community", false},
                {"user", false},
                {"encost", false},
                {"Encost", false},
                {"community user", false},
                {"2 Encost", false},
                {"1111111111111111111111111111111111", false},
                {"COMMUNITY", false},
                {"admin", false}
        });
    }

    @Test
    public void evaluatesUser() {
        boolean result = encost.checkUserType(inputString);
        assertTrue(expectedResult == result);
    }
}
