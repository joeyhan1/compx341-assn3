import org.junit.Assert;
import org.junit.Test;

public class Test_BuildGraphData_getDevices {
    Device[] devices = new Device[]{
        new Device("EWR-1234", new Date("1/4/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", null, true, true), 
        new Device("EK-9876", new Date("07/05/22"), "Encost Smart Jug", DeviceType.Kettle, "WKO-1234", "EWR-1234", false, true),
        new Device("ELB-4567", new Date("1/4/22"), "Encost Smart Bulb B22 (multi colour)", DeviceType.LightBulb, "WKO-1234", "EWR-1234", false, true),
        new Device("EHC-2468", new Date("1/4/22"), "Encost Smart Hub 2.0", DeviceType.HubController, "WKO-1234", "EWR-1234", true, true),
        new Device("ED-1246", new Date("1/4/22"), "Encost Dishwasher Pro", DeviceType.Dishwasher, "WKO-1234", "EWR-1234", false, true)
    };

    @Test
    @DisplayName("Test all unique datapoints shown - all example devices in deviceGraph")
    public void test_unique_datapoints(){
     
        DeviceGraph deviceGraph = new DeviceGraph(devices);
        assertEquals(devices, deviceGraph.getDevices());
    }

     @Test
     @DisplayName("Test all households are represented - all example devices have WKO-1234")
    public void test_households_represented(){

        DeviceGraph deviceGraph = new DeviceGraph(devices);
        for (Device device: deviceGraph.getDevices()){
            assertEquals("WKO-1234", device.getHouseholdId());
        }
    }

     @Test
     @DisplayName("Test empty deviceGraph return")
    public void test_zero_devices(){
        Device[] devices = new Device[0];
        DeviceGraph deviceGraph = new DeviceGraph(devices);
        assertEquals(0, deviceGraph.getDevices().length);
    }
}
