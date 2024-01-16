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

public class testLoadingDefaultDataset {

    @Test
    public void unknownLocation(){

        String filePath = null;
        Boolean res = processFile(filePath);
        Assertions.assertFalse(res);
    }

    @Test
    public void fileNotFound(){

        String filePath = "test.csv";
        Boolean res = processFile(filePath);
        Assertions.assertFalse(res);
    }

    @Test
    public void fileWrongFormat(){

        String filePath = "testingDataset1.txt";
        Boolean res = processFile(filePath);
        Assertions.assertFalse(res);
    }

    @Test
    public void fileAlreadyOpen(){

        // opens the file
        String filePath = "testingDataset1.csv";
        FileReader reader = new FileReader("testringDataset1.csv");
        reader.read();

        Boolean res = processFile(filePath);
        Assertions.assertFalse(res);
        reader.close();
    }

    @Test
    public void correctFile(){

        String filePath = "testingDataset1.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res);        
    }

    @Test
    public void lineNotEnoughArguments(){

        String filePath = "invalidData1.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(2, devices.length());
    }

    @Test
    public void lineTooManyArguments(){

        String filePath = "invalidData2.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(2, devices.length());
    }

    @Test
    public void lineInvalidDataType(){

        String filePath = "invalidData3.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(2, devices.length());
    }

    @Test
    public void lineInvalidDataType2(){

        String filePath = "invalidData4.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(2, devices.length());
    }

    @Test
    public void lineRepeatingID(){

        String filePath = "invalidData5.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(3, devices.length());
    }

    @Test
    public void lineValid(){

        String filePath = "testingDataset1.csv";
        Boolean res = processFile(filePath);
        Assertions.assertTrue(res); 
        Assertions.assertEquals(7, devices.length());
    }    
}
