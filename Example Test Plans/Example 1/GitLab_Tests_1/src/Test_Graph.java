import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class Test_Graph {

    @Test
    public void graph_getDevices(){
        Device[] exampleDevices = new Device[]{
                new Device("EWR-1234", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", null, true, true),
                new Device("EWR-1233", new Date("1/1/22"), "Encost Router 360", DeviceType.Router, "WKO-1234", null, true, true),
        };

        DeviceGraph deviceGraph = new DeviceGraph(exampleDevices);//Create GraphDatatype

        Assert.assertEquals(exampleDevices, deviceGraph.getDevices());
    }


}
