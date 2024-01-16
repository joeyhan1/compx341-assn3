public class Test_calcDeviceDist {
    @Test
    @DisplayName("Test zero devices summary feedback")
    public void test_zero_devices(){
        Device[] devices = new Device[0];
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary DataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 0 
    - Type 'Router' device count: 0
    - Type 'Extender' device count: 0
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

    @Test
    @DisplayName("Test all wifirouters are summarised")
    public void test_all_wifi_routers(){
        Device[] devices = new Device[]{
            new Device("EWR-1234", new Date("1/4/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("EWE-1234", new Date("1/4/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", "EWR-1234", true, true), 
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 2 
    - Type 'Router' device count: 1
    - Type 'Extender' device count: 1
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

    @Test
    @DisplayName("Test all hub types are summarised")
    public void test_all_hubs_controllers(){
        Device[] devices = new Device[]{
             new Device("EHC-1234", new Date("01/04/22"), "Encost Smart Hub 2.0", DeviceType.HubController, "WKO-1234", null, true, true) 
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 0 
    - Type 'Router' device count: 0
    - Type 'Extender' device count: 0
  Category Encost Hub/Controller device count: 1 
    - Type 'Hub/Controller' device count: 1
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

      @Test
      @DisplayName("Test all lighting types are summarised")
    public void test_all_lighting(){
        Device[] devices = new Device[]{
            new Device("ELB-4567", new Date("01/04/22"), "-", DeviceType.LightBulb, "WKO-1234", null, true, true),
            new Device("ESL-4567", new Date("01/04/22"), "-", DeviceType.StripLighting, "WKO-1234", null, true, true),
            new Device("EOL-4567", new Date("01/04/22"), "-", DeviceType.OtherLighting, "WKO-1234", null, true, true)
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices); 

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 0 
    - Type 'Router' device count: 0
    - Type 'Extender' device count: 0
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 3 
    - Type 'Light Bulb' device count: 1
    - Type 'Strip Lighting' device count: 1
    - Type 'Other Lighting' device count: 1
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

      @Test
      @DisplayName("Test all appliances are summarised")
    public void test_all_appliances(){
        Device[] devices = new Device[]{
             new Device("EK-9876", new Date("01/04/22"), "-", DeviceType.Kettle, "WKO-1234", null, true, true),
             new Device("ET-9876", new Date("01/04/22"), "-", DeviceType.Toaster, "WKO-1234", null, true, true),
             new Device("ECM-9876", new Date("01/04/22"), "-", DeviceType.CoffeeMachine, "WKO-1234", null, true, true) 
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 0 
    - Type 'Router' device count: 0
    - Type 'Extender' device count: 0
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 3 
    - Type 'Kettle' device count: 1
    - Type 'Toaster' device count: 1
    - Type 'Coffee Maker' device count: 1
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

      @Test
      @DisplayName("Test all whiteware is summarised")
    public void test_all_whiteware(){
        Device[] devices = new Device[]{
            new Device("ED-1246", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("ERF-1246", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("EWMD-1246", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 0 
    - Type 'Router' device count: 0
    - Type 'Extender' device count: 0
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 3 
    - Type 'Washing Machine/Dryer' device count: 1
    - Type 'Refrigerator/Freezer' device count: 1
    - Type 'Dishwasher' device count: 1
        """, DataSummary.calculateDeviceDistribution())
    }


      @Test
      @DisplayName("Test type counts can proceed past 1 and be counted and summarised")
    public void test_greater_than_1_type(){
        Device[] devices = new Device[]{
            new Device("EWR-1234", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("EWE-1234", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
            new Device("EWE-1233", new Date("1/4/22"), "-", DeviceType.Router, "WKO-1234", null, true, true), 
        };
        DeviceGraph deviceGraph = new DeviceGraph(devices);

        DataSummary dataSummary = new DataSummary(deviceGraph);
        assertEquals("""
        Category Encost Wifi Routers device count: 3 
    - Type 'Router' device count: 1
    - Type 'Extender' device count: 2
  Category Encost Hub/Controller device count: 0 
    - Type 'Hub/Controller' device count: 0
  Category Encost Smart Lighting device count: 0 
    - Type 'Light Bulb' device count: 0
    - Type 'Strip Lighting' device count: 0
    - Type 'Other Lighting' device count: 0
  Category Encost Smart Appliances device count: 0 
    - Type 'Kettle' device count: 0
    - Type 'Toaster' device count: 0
    - Type 'Coffee Maker' device count: 0
  Category Encost Smart Whiteware device count: 0 
    - Type 'Washing Machine/Dryer' device count: 0
    - Type 'Refrigerator/Freezer' device count: 0
    - Type 'Dishwasher' device count: 0
        """, DataSummary.calculateDeviceDistribution())
    }

}
