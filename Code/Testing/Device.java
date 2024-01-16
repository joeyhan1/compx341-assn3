import java.util.*;

/**
 * Device Class
 * 
 * The Device Class holds all the object information and methods about devices.
 * 
 */
public class Device {
    private static Map<String, Device> deviceMap = new HashMap<>();
    private String deviceID;
    private String connectedDate;
    private Device routerConnection;
    private String householdID;
    private String regionCode;
    private String productCategory;
    private String productType;
    private String productName;
    private boolean canSend;
    private boolean canReceive;
    

    //Constructor for the device class
    public Device(String deviceID, String connectedDate, String productName, String productType, String householdID, String routerID, boolean canSend, boolean canReceive) {
        this.deviceID = deviceID;
        this.connectedDate = connectedDate;
        this.routerConnection = getDevice(routerID);
        this.householdID = householdID;
        this.regionCode = extractRegionCode(householdID);
        this.productCategory = extractProductCategory(productType);
        this.productType = productType;
        this.productName = productName;
        this.canSend = canSend;
        this.canReceive = canReceive;
        // Add the device to the deviceMap using its deviceID as the key
        deviceMap.put(deviceID, this);
    }

    //Static method to get a specific Device object by its deviceID
    public static Device getDevice(String deviceID) {
        return deviceMap.get(deviceID);
    }    

    //Getter methods for the constructor stuff

    public String getDeviceID() {
        return deviceID;
    }

    public String getConnectedDate() {
        return connectedDate;
    }

    public Device getRouterConnection() {
        return routerConnection;
    }

    public void setRouterConnection(Device routerConnection) {
        this.routerConnection = routerConnection;
    }

    public String getHouseholdID() {
        return householdID;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public boolean canSend() {
        return canSend;
    }

    public boolean canReceive() {
        return canReceive;
    }

    //Method to extract the product category using the input of the product type
    private String extractProductCategory(String productType) {
        String productCategory;
        //Lookup logic
        if(productType.equals("Router") || productType.equals("Extender")) {
            productCategory = "Encost Wifi Routers";
            return productCategory;
        }
        if(productType.equals("Hub/Controller")) {
            productCategory = "Encost Hubs/Controllers";
            return productCategory;
        }
        if(productType.equals("Light Bulb") || productType.equals("Strip Lighting") || productType.equals("Other Lighting")) {
            productCategory = "Encost Smart Lighting";
            return productCategory;
        }
        if(productType.equals("Kettle") || productType.equals("Toaster") || productType.equals("Coffee Maker")) {
            productCategory = "Encost Smart Appliances";
            return productCategory;
        }
        if(productType.equals("Washing Machine/Dryer") || productType.equals("Refrigerator/Freezer") || productType.equals("Dishwasher")) {
            productCategory = "Encost Smart Whiteware";
            return productCategory;
        }
        return null;
    }

    //Method to extract the region code using the input of the household ID
    private String extractRegionCode(String householdID) {
        //Get the code out of household ID by splitting it into half and getting the first half which has the code
        String[] sentences = householdID.split("-");
        String extracted = sentences[0];
        return extracted;
    }
}