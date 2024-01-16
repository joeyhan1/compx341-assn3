import org.junit.Test;
import static org.junit.*;

public class CategorisingDevicesTest {

    @Test
    @DisplayName("Valid Dataset Test")
    public void validCVSTest() {
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        Graph testGraph = new Graph();

        // The test CSV which is to be tested with
        File dataset = new File("validTest.csv");

        // The result of readDataset should be a bool informing of the success or failure
        bool result = projet.readDataset(dataset, testGraph);

        assertTrue(result);
    }

    @Test
    @DisplayName("Invalid Dataset Test")
    public void invalidCVSTest() {
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        Graph testGraph = new Graph();

        // The test CSV which is to be tested with
        File dataset = new File("invalidTest.csv");

        // The result of readDataset should be a bool informing of the success or failure
        bool result = projet.readDataset(dataset, testGraph);
        
        assertFalse(result);
    }
}
