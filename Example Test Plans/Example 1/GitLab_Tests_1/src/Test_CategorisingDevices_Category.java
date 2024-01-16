import org.junit.Assert.*;
import org.junit.Test;

import java.util.Date;

public class Test_CategorisingDevices_Category {

    @Test
    @DisplayName("Test router for category")
    public void test_categoryof_router(){
        Device device = new Device("EWR-1234", new Date("1/1/22"), "-", DeviceType.Router, null, null, true, true);
        assertEquals("Encost Wifi Routers", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test extender for category")
    public void test_categoryof_extender(){
        Device device = new Device("EWE-1234", new Date("1/1/22"), "-", DeviceType.Extender, null, null, true, true);
        assertEquals("Encost Wifi Routers", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test lightbulb for category")
    public void test_categoryof_lightbulb(){
        Device device = new Device("ELB-4567", new Date("1/1/22"), "-", DeviceType.LightBulb, null, null, true, true);
        assertEquals("Encost Smart Lighting", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test strip lighting for category ")
    public void test_categoryof_striplighting(){
        Device device = new Device("ESL-4567", new Date("1/1/22"), "-", DeviceType.StripLighting, null, null, true, true);
        assertEquals("Encost Smart Lighting", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test other lighting for category")
    public void test_categoryof_otherlighting(){
        Device device = new Device("EOL-4567", new Date("1/1/22"), "-", DeviceType.OtherLighting, null, null, true, true);
        assertEquals("Encost Smart Lighting", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test hub/controller for category")
    public void test_categoryof_hubcontroller(){
        Device device = new Device("EHC-2468", new Date("1/1/22"), "-", DeviceType.HubController, null, null, true, true);
        assertEquals("Encost Hubs/Controllers", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test kettle for category")
    public void test_categoryof_kettle(){
        Device device = new Device("EK-9876", new Date("1/1/22"), "-", DeviceType.Kettle, null, null, true, true);
        assertEquals("Encost Smart Appliances", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test toaster for category")
    public void test_categoryof_toaster(){
        Device device = new Device("ET-9876", new Date("1/1/22"), "-", DeviceType.Toaster, null, null, true, true);
        assertEquals("Encost Smart Appliances", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test coffeemachine for category")
    public void test_categoryof_coffeemachine(){
        Device device = new Device("ECM-9876", new Date("1/1/22"), "-", DeviceType.CoffeeMachine, null, null, true, true);
        assertEquals("Encost Smart Appliances", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test type of dishwasher for correct category")
    public void test_categoryof_dishwasher(){
        Device device = new Device("ED-1246", new Date("1/1/22"), "-", DeviceType.Dishwasher, null, null, true, true);
        assertEquals("Encost Smart Whiteware", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test type of washing machine/dryer for correct category")
    public void test_categoryof_washingmachine_dryer(){
        Device device = new Device("EWMD-1246", new Date("1/1/22"), "-", DeviceType.WashingMachineDryer, null, null, true, true);
        assertEquals("Encost Smart Whiteware", device.getDeviceCategory());
    }
    @Test
    @DisplayName("Test type of refrigerator/freezer for correct category")
    public void test_categoryof_refrigerator_freezer(){
        Device device = new Device("ERF-1246", new Date("1/1/22"), "-", DeviceType.RefrigeratorFreezer, null, null, true, true);
        assertEquals("Encost Smart Whiteware", device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test invalid device on category")
    public void test_categoryof_invalid(){
        Device device = new Device("IV-0000", new Date("1/1/22"), "-", null, null, null, true, true);
        assertEquals(null, device.getDeviceCategory());
    }

    @Test
    @DisplayName("Test empty device on category")
    public void test_categoryof_invalid_empty(){
        Device device = new Device("", new Date("1/1/22"), "-", null, null, null, true, true);
        assertEquals(null, device.getDeviceCategory());
    }

}
