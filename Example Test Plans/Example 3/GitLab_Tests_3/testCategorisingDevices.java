public import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.beans.Transient;
import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class testCategorisingDevices {

    @Test
    public void checkingData(){

        // insert FULL filepath of the dataset: testingDataset4.csv
        String filepath = "testingDataset4.csv";

        // set the default data path
        eshDatasetPath = filepath;

        Dictionary<String, String> dict = new Hashtable<>();
        dict.put("EWR-1234", "Encost Wifi Routers");
        dict.put("ELB-4567", "Encost Smart Lighting");
        dict.put("EK-9876", "Encost Smart Appliances");
        dict.put("EHC-2468", "Encost Hubs/Controllers");
        dict.put("ESW-5555", "Encost Smartware");
        dict.put("EWR-2345", "Encost Wifi Routers");
        dict.put("ESW-3333", "Encost Smartware");

        for(int i = 0; i < devices.length; i++)
        {
            String category = dict.get(devices.get(i).device_id());
            Assertions.assertEquals(category, devices.get(i).getCategory());
        }
    }
    
}
