import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class CategorisingDevicesTest {

    @Test
    public void validCSVTest() {
        Encost project = new Encost();
        Graph testGraph = new Graph();

        // The test CSV which is to be tested with
        File dataset = new File("validTest.csv");

        // The result of readDataset should be a bool informing of the success or failure
        boolean result = project.readDataset(dataset, testGraph);

        assertTrue(result);
    }

    @Test
    public void invalidCSVTest() {
        Encost project = new Encost();
        Graph testGraph = new Graph();

        // The test CSV which is to be tested with
        File dataset = new File("invalidTest.csv");

        // The result of readDataset should be a bool informing of the success or failure
        boolean result = project.readDataset(dataset, testGraph);

        assertFalse(result);
    }
}

