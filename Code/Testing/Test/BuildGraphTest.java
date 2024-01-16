import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class BuildGraphTest {

    @Test
    public void validGraphTest() {
        List<String> expected = new ArrayList<String>();
        // Insert devices into list.
        expected.add("Encost Router 360");
        expected.add("Encost Smart Hub");
        expected.add("Encost Smart Bulb B22 (multi colour)");
        expected.add("Encost Smart Jug");
        expected.add("Encost Smart Washer");

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();

        // Collect the devices which are graphed, this should be the same as the expected list
        File dataset = new File("validTest.csv");
        project.readDataset(dataset, testGraph);
        List<Device> actualDeviceList = testGraph.getDevices();
        List<String> actual = new ArrayList<String>();
        for(int i = 0; i < actualDeviceList.size(); i++) {
            actual.add(actualDeviceList.get(i).getProductName());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void invalidGraphTest() {
        List<Device> expected = new ArrayList<Device>();
        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();

        // Collect the devices which are graphed, this should be the same as the expected list
        File dataset = new File("invalidTest.csv");
        project.readDataset(dataset, testGraph);
        List<Device> actualDeviceList = testGraph.getDevices();
        List<String> actual = new ArrayList<String>();
        for(int i = 0; i < actualDeviceList.size(); i++) {
            actual.add(actualDeviceList.get(i).getProductName());
        }

        assertEquals(expected, actual);
    }
}
