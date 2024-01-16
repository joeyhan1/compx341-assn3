import static org.junit.Assert.assertEquals;
import static org.junit.*;
import java.util.ArrayList;

import org.junit.Test;

public class DeviceDistributionTest {

    // The devices list indicates what is being tested and the order of which the counts sync to
    
    @Test
    @DisplayName("Minimal Distribution Test")
    public void minimumDistributionTest() {

        // Minimum
        List<String> devices = new ArrayList<String>("router", "extender", "hubs", "lightBulb", "stripLighitng",
            "otherLights", "kettle", "toaster", "coffeMaker", "washer", "fridge", "dishwasher");
        List<Int> expectedCount = new ArrayList<Int>(2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();
        actualCount = project.DeviceDistribution(graph);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    @DisplayName("Above Minimal Distribution Test")
    public void aboveMinimumDistributionTest() {

        // Above Minimum
        List<String> devices = new ArrayList<String>("router", "extender", "hubs", "lightBulb", "stripLighitng",
            "otherLights", "kettle", "toaster", "coffeMaker", "washer", "fridge", "dishwasher");
        List<Int> expectedCount = new ArrayList<Int>(3, 3, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1);

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();
        actualCount = project.DeviceDistribution(graph);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    @DisplayName("Nominal Distribution Test")
    public void normalDistributionTest() {

        // normal
        List<String> devices = new ArrayList<String>("router", "extender", "hubs", "lightBulb", "stripLighitng",
            "otherLights", "kettle", "toaster", "coffeMaker", "washer", "fridge", "dishwasher");
        List<Int> expectedCount = new ArrayList<Int>(15, 5, 6, 12, 4, 18, 20, 24, 12, 17, 32, 17);

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();
        actualCount = project.DeviceDistribution(graph);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    @DisplayName("Below Max Distribution Test")
    public void belowMaxDistributionTest() {

        // Below Max
        List<String> devices = new ArrayList<String>("router", "extender", "hubs", "lightBulb", "stripLighitng",
            "otherLights", "kettle", "toaster", "coffeMaker", "washer", "fridge", "dishwasher");
        List<Int> expectedCount = new ArrayList<Int>(80, 0, 80, 80, 80, 0, 80, 80, 80, 80, 0, 80);

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();
        actualCount = project.DeviceDistribution(graph);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    @DisplayName("Max Distribution Test")
    public void maxDistributionTest() {

        // Max
        List<String> devices = new ArrayList<String>("router", "extender", "hubs", "lightBulb", "stripLighitng",
            "otherLights", "kettle", "toaster", "coffeMaker", "washer", "fridge", "dishwasher");
        List<Int> expectedCount = new ArrayList<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100);

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();
        actualCount = project.DeviceDistribution(graph);

        assertEquals(expectedCount, actualCount);
    }
}
