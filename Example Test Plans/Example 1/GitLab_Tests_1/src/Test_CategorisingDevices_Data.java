import org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class Test_CategorisingDevices_Data {
    @Test
    @DisplayName("Test device id result correct")
    public void test_deviceID(){
        Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
        assertEquals("EWR-1234", device.getDeviceId());
    }

    @Test
    @DisplayName("Test dateconnected result correct")
    public void test_dateconnected(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals(new Date("1/1/2022"), device.getDeviceConnected());
    }

    @Test
    @DisplayName("Test devicename result correct")
    public void test_devicename(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals("Encost Router 360", device.getDeviceName());
    }

    @Test
    @DisplayName("Test devicetype result correct")
    public void test_devicetype(){
          Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals(DeviceType.Router, device.getDeviceType());
    }

    @Test
    @DisplayName("Test householdid result correct")
    public void test_householdid(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals("WKO-1234", device.getHouseholdId());
    }


    @Test
    @DisplayName("Test routerconnection result correct")
    public void test_routerconnection(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals("EWR-1212", device.getRouterConnection());
    }

    @Test
    @DisplayName("Test isSender result correct")
    public void test_sends(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", false, true);
         assertEquals(false, device.isSender());
    }

    @Test
    @DisplayName("Test isReceiver result correct")
    public void test_receives(){
         Device device = new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1212", true, true);
         assertEquals(true, device.isReceiver());
    }
}
