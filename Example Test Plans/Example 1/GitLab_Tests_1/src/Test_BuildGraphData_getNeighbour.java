import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class Test_BuildGraphData_getNeighbour {
     Device[] devices = new Device[]{
            new Device("EWR-1234", new Date("1/4/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("EK-9876", new Date("07/05/22"), "Encost Smart Jug", DeviceType.Kettle, "WKO-1234", "EWR-1234", false, true),
            new Device("ELB-4567", new Date("1/4/22"), "Encost Smart Jug", DeviceType.LightBulb, "WKO-1234", "EWR-1234", false, true),
            new Device("EHC-2468", new Date("1/4/22"), "Encost Smart Jug", DeviceType.HubController, "WKO-1234", "EWR-1234", true, true),
            new Device("ED-1246", new Date("1/4/22"), "Encost Smart Jug", DeviceType.Dishwasher, "WKO-1234", "EWR-1234", false, true)
        };

     @Test
     @DisplayName("Test router connection which sends - 4 example devices are visible to router")
    public void test_routerandsender_neighbours(){
        DeviceGraph deviceGraph = new DeviceGraph(devices);
        assertEquals(4, deviceGraph.getNeighbours("EWR-1234").length);
    }

      @Test
      @DisplayName("Test 0 neighbours for device which does NOT send commands")
    public void test_notsender_neighbours(){

        DeviceGraph deviceGraph = new DeviceGraph(devices);
        assertEquals(0, deviceGraph.getNeighbours("ELB-4567").length);

    }

      @Test
      @DisplayName("Test 1 neighbour for device which DOES send commands, but is not router - example devices has 1")
    public void test_senderbutnotrouter_neighbours(){
        DeviceGraph deviceGraph = new DeviceGraph(devices);
        assertEquals(1, deviceGraph.getNeighbours("EHC-2468").length);
    }

   @Test
   @DisplayName("Test 1 device correctly has 0 neighbours - which can send commands")
    public void test_singledevice_neighbours(){
        Device[] singleDevice = new Device[]{
           new Device("EHC-2468", new Date("1/4/22"), "Encost Smart Jug", DeviceType.HubController, "WKO-1234", "EWR-1234", true, true)
        };
        DeviceGraph deviceGraph = new DeviceGraph(singleDevice);
        assertEquals(0, deviceGraph.getNeighbours("EHC-2468").length);
    }

    @Test
    @DisplayName("Test no devices with incorrect id")
    public void test_nodevices_neighbours(){
        Device[] emptyDevices = new Device[0];
        DeviceGraph deviceGraph = new DeviceGraph(emptyDevices);
        assertEquals(null, deviceGraph.getNeighbours("IV-0000"));
    }

}
