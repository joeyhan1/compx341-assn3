import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_LoadingEncostDataset_Fileparser {

    @Test
    public void loadencost_canfilefind(){
        FileParser fileParser = new FileParser();
        assertEquals(null, fileParser.parseFile("fake/path/file.txt"));
    }

    @Test
    public void loadencost_containsDevices(){
        FileParser fileParser = new FileParser();
        ConsoleApp consoleApp = new ConsoleApp();
        String[] knownDeviceIds = new String[]{"EWR-1234", "ELB-4567", "EK-9876", "EHC-2468"};
        String encostDatasetFilePath = consoleApp.ENCOST_DATASET_FILE;

        Device[] encostDatasetDevices = fileParser.parseFile(encostDatasetFilePath);

        assertTrue(encostDatasetDevices != null);
        assertTrue(encostDatasetDevices.length > 0);
        //Check all deviceIds we know of exist
        for (String deviceId: knownDeviceIds) {
            assertTrue(Arrays.stream(encostDatasetDevices)
                    .map(Device::getDeviceId) //Extract ID
                    .anyMatch(id -> id.equals(deviceId))); //Check exists
        }
    }

    @Test
    public void loadencost_hundredhouseholds(){
        FileParser fileParser = new FileParser();
        ConsoleApp consoleApp = new ConsoleApp();

        String encostDatasetFilePath = consoleApp.ENCOST_DATASET_FILE;

        Device[] encostDatasetDevices = fileParser.parseFile(encostDatasetFilePath);

        assertTrue(encostDatasetDevices != null);

        //Check 100 unique households exist
        Assert.assertEquals(100, Arrays.stream(encostDatasetDevices)
                .map(Device::getHouseholdId) //Extract householdID
                .distinct().count() //Check number of unique
                );

        //Check WKO-1234 exists
        Assert.assertTrue(Arrays.stream(encostDatasetDevices)
                .map(Device::getHouseholdId)//Extract householdID
                .anyMatch(household -> household.equals("WKO-1234"))); //Check exists
    }

}
