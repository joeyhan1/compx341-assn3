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
import java.util.List;

public class testGraphDataType{



    @Test
    public void checkDevices(){
        user = new CommunityUser();
        Graph g = user.getGraph();
        Boolean res = true;

        if(g[0].device_id != "EWR-1357" && g[1].device_id != "EWR-1357")
        {
            res = false;
        }
        if(g[0].device_id != "ELB-3579" && g[1].device_id != "ELB-3579")
        {
            res = false;
        }

        Assertions.assertTrue(res);
    }

    @Test
    public void checkCategories(){

        Boolean passAll = true;

        List<String> allTypes = new ArrayList<>();
        allTypes.add("Router");
        allTypes.add("Extender");
        allTypes.add("Hub/Controller");
        allTypes.add("Light Bulb");
        allTypes.add("Strip Lighting");
        allTypes.add("Other Lighting");
        allTypes.add("Kettle");
        allTypes.add("Toaster");
        allTypes.add("Coffee Maker");
        allTypes.add("Washing Machine/Dryer");
        allTypes.add("Refrigerator/Freezer");
        allTypes.add("Dishwasher");

        List<String> categories = new ArrayList<>();
        categories.add("Encost Wifi Routers");
        categories.add("Encost Wifi Routers");
        categories.add("Encost Hubs/Controllers");
        categories.add("Encost Smart Lighting");
        categories.add("Encost Smart Lighting");
        categories.add("Encost Smart Lighting");
        categories.add("Encost Smart Appliances");
        categories.add("Encost Smart Appliances");
        categories.add("Encost Smart Appliances");
        categories.add("Encost Smart Whiteware");
        categories.add("Encost Smart Whiteware");
        categories.add("Encost Smart Whiteware");

        for(int i = 0; i < allTypes.size(); i++)
        {
            String category = getCategory(allTypes.get(i));
            if(category != categories.get(i))
            {
                passAll = false;
            }

        }

        Assertions.assertTrue(passAll);
    }

}