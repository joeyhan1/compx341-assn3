import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.io.File;
import org.junit.Assert;

import org.junit.Test;

public class DeviceDistributionTest {

    //The product array are to show what items in order are in the expected count array
    
    @Test
    public void validDeviceCategoryDistributionTest() {

        String[] productCategoriesArray = {
            "Encost Wifi Routers",
            "Encost Hubs/Controllers",
            "Encost Smart Lighting",
            "Encost Smart Appliances",
            "Encost Smart Whiteware"
    };

    int[] expectedCountArray = {1,1,1,1,1};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("validTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualCategoryArray = new int[5];
        //Category count array
        for(int i = 0; i < actualCategoryArray.length; i++) {
            actualCategoryArray[i] = result[1][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualCategoryArray);
    }

    @Test
    public void validDeviceTypeDistributionTest() {

        String[] productTypesArray = {
            "Router",
            "Extender",
            "Hub/Controller",
            "Light Bulb",
            "Strip Lighting",
            "Other Lighting",
            "Kettle",
            "Toaster",
            "Coffee Maker",
            "Washing Machine/Dryer",
            "Refrigerator/Freezer",
            "Dishwasher"
        };

        int[] expectedCountArray = {1,0,1,1,0,0,1,0,0,1,0,0};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("validTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualTypeArray = new int[12];
        //Type count array
        for(int i = 0; i < actualTypeArray.length; i++) {
            actualTypeArray[i] = result[0][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualTypeArray);
    }

    @Test
    public void validDeviceNameDistributionTest() {

        String[] productNamesArray = {
            "Encost Router 360",
            "Encost Router Plus",
            "Encost Wifi Range Extender 1.0",
            "Encost Wifi Range Extender 2.0",
            "Encost Smart Hub",
            "Encost Smart Hub 2.0",
            "Encost Smart Hub Mini",
            "Encost Smart Bulb B22 (white)",
            "Encost Smart Bulb B22 (multi colour)",
            "Encost Smart Bulb E26 (white)",
            "Encost Smart Bulb E26 (multi colour)",
            "Encost Strip Lighting (white)",
            "Encost Strip Lighting (multi colour)",
            "Encost Novelty Light (giraffe)",
            "Encost Novelty Light (lion)",
            "Encost Novelty Light (bear)",
            "Encost Smart Jug",
            "Encost Smart Whistling Kettle",
            "Encost Smart Toaster (2 slice)",
            "Encost Smart Toaster (4 slice)",
            "Encost Smart Coffee Maker",
            "Encost Smart Coffee Maker Mini",
            "Encost Smart Coffee Maker Pro",
            "Encost Smart Washer",
            "Encost Smart Washer Pro",
            "Encost Smart Dryer",
            "Encost Smart Dryer Pro",
            "Encost Smart Refrigerator",
            "Encost Smart Freezer",
            "Encost Smart Refrigerator/Freezer Combo",
            "Encost Dishwasher",
            "Encost Dishwasher Pro"
        };

        int[] expectedCountArray = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("validTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualProductArray = new int[32];
        //Name count array
        for(int i = 0; i < actualProductArray.length; i++) {
            actualProductArray[i] = result[2][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualProductArray);
    }

    @Test
    public void invalidDeviceCategoryDistributionTest() {

        String[] productCategoriesArray = {
            "Encost Wifi Routers",
            "Encost Hubs/Controllers",
            "Encost Smart Lighting",
            "Encost Smart Appliances",
            "Encost Smart Whiteware"
    };

    int[] expectedCountArray = {0,0,0,0,0};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("invalidTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualCategoryArray = new int[5];
        //Category count array
        for(int i = 0; i < actualCategoryArray.length; i++) {
            actualCategoryArray[i] = result[1][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualCategoryArray);
    }

    @Test
    public void invalidDeviceTypeDistributionTest() {

        String[] productTypesArray = {
            "Router",
            "Extender",
            "Hub/Controller",
            "Light Bulb",
            "Strip Lighting",
            "Other Lighting",
            "Kettle",
            "Toaster",
            "Coffee Maker",
            "Washing Machine/Dryer",
            "Refrigerator/Freezer",
            "Dishwasher"
        };

        int[] expectedCountArray = {0,0,0,0,0,0,0,0,0,0,0,0};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("invalidTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualTypeArray = new int[12];
        //Type count array
        for(int i = 0; i < actualTypeArray.length; i++) {
            actualTypeArray[i] = result[0][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualTypeArray);
    }

    @Test
    public void invalidDeviceNameDistributionTest() {

        String[] productNamesArray = {
            "Encost Router 360",
            "Encost Router Plus",
            "Encost Wifi Range Extender 1.0",
            "Encost Wifi Range Extender 2.0",
            "Encost Smart Hub",
            "Encost Smart Hub 2.0",
            "Encost Smart Hub Mini",
            "Encost Smart Bulb B22 (white)",
            "Encost Smart Bulb B22 (multi colour)",
            "Encost Smart Bulb E26 (white)",
            "Encost Smart Bulb E26 (multi colour)",
            "Encost Strip Lighting (white)",
            "Encost Strip Lighting (multi colour)",
            "Encost Novelty Light (giraffe)",
            "Encost Novelty Light (lion)",
            "Encost Novelty Light (bear)",
            "Encost Smart Jug",
            "Encost Smart Whistling Kettle",
            "Encost Smart Toaster (2 slice)",
            "Encost Smart Toaster (4 slice)",
            "Encost Smart Coffee Maker",
            "Encost Smart Coffee Maker Mini",
            "Encost Smart Coffee Maker Pro",
            "Encost Smart Washer",
            "Encost Smart Washer Pro",
            "Encost Smart Dryer",
            "Encost Smart Dryer Pro",
            "Encost Smart Refrigerator",
            "Encost Smart Freezer",
            "Encost Smart Refrigerator/Freezer Combo",
            "Encost Dishwasher",
            "Encost Dishwasher Pro"
        };

        int[] expectedCountArray = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        // ESGP is a guideline for the ESGP naming conventions and was required to make for testing
        Encost project = new Encost();
        GraphClass testGraph = new GraphClass();
        File dataset = new File("invalidTest.csv");
        project.readDataset(dataset, testGraph);
        int[][] result = project.DeviceDistribution(testGraph);
        int[] actualProductArray = new int[32];
        //Name count array
        for(int i = 0; i < actualProductArray.length; i++) {
            actualProductArray[i] = result[2][i];
        }

        Assert.assertArrayEquals(expectedCountArray, actualProductArray);
    }

    

}