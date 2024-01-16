import java.util.Date;

public class Device {
    public Device(String deviceId, Date dateConnected, String deviceName, DeviceType deviceType, String householdId, String routerConnection, boolean sends, boolean receives){

    }

    String getDeviceId(){ return "";}
    Date getDateConnected(){ return new Date();}
    String getDeviceName(){ return "";}
    String getDeviceCategory(){ return "";}
    String getDeviceType(){ return "";}

    String getHouseholdId(){ return "";}
    String getHouseholdRegion(){ return "";}
    String getRouterConnection(){ return "";}

    boolean isSender(){ return true;}
    boolean isReceiver(){ return true;}
}
