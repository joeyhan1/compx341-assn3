public class DeviceGraph {
    Device[] devices;
    public DeviceGraph(Device[] devices){
        this.devices = devices;
    }

    Device[] getDevices(){ return devices;}

    Device[] getNeighbours(String deviceId){
        return new Device[0];
    }
}
