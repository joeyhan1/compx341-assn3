import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Test_LoadingEncostDataset_loadFile {
    @Test
    public void loadencost_containsDevices(){

        ConsoleApp consoleApp = new ConsoleApp();

        String[] knownDeviceIds = new String[]{"EWR-1234", "ELB-4567", "EK-9876", "EHC-2468"};
        Device[] encostDatasetDevices = consoleApp.loadFile();
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
        ConsoleApp consoleApp = new ConsoleApp();

        Device[] encostDatasetDevices = consoleApp.loadFile();
        assertTrue(encostDatasetDevices != null);
        assertTrue(encostDatasetDevices.length > 0);
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
