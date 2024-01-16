import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AccountLoginTest {

    private String username;
    private String password;
    private boolean expectedResult;

    public AccountLoginTest(String username, String password, boolean expectedResult) {
        this.username = username;
        this.password = password;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection loginData() {
        return Arrays.asList(new Object[][]{
            {"username", "password", false},
            {"admin", "encost", false},
            {"encostUserA", "password901", false},
            {"password890", "encorstUserH", false},
            {"encostUserF", "password456", false},
            {"encostUserA", "password789", true},
            {"encostUserB", "password234", true},
            {"encostUserC", "password456", true},
            {"encostUserD", "password901", true},
            {"encostUserE", "password678", true},
            {"encostUserF", "password567", true},
            {"encostUserG", "password345", true},
            {"encorstUserH", "password890", true},
            {"encostUserI", "password123", true},
            {"encostUserJ", "password012", true}
        });
    }

    @Test
    public void testLogin() {
        Encost project = new Encost();
        boolean result = project.login(username, password);
        assertEquals(expectedResult, result);
    }
}
