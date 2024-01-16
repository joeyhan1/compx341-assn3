import static org.junit.*;
import org.junit.Test;

public class BuildGraphTest {

    @Test
    @DisplayName("Valid Graph Input Test")
    public void validGraphTest() {
        List<String> expected = new ArrayList<String>();
        // Insert devices into list.
        expected.add("Encost Router 360");
        expected.add("Encost Smart Hub");
        expected.add("Encost Smart Bulb B22 (multi colour)");
        expected.add("Encost Smart Jug");
        expected.add("Encost Smart Washer");

        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        List<String> deviceList = new ArrayList<String>();
        Graph testGraph = new Graph();

        // Collect the devices which are graph this should be the same are the expected list
        actual = testGraph.getDevices();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Graph Input Test")
    public void invalidGraphTest() {
        List<Devices> expected = new ArrayList<Device>();
        // ESGP is a guideline for the ESGP naming conventions adn was required to make for testing
        Encost project = new Encost();
        List<Device> deviceList = new ArrayList<Device>();
        Graph testGraph = new Graph();

        // Collect the devices which are graph this should be the same are the expected list
        actual = testGraph.getDevices();

        assertArrayEquals(expected, actual);
    }
}
