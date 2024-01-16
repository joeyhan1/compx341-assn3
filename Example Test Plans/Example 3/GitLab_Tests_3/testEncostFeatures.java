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

public class testEncostFeatures {

    @Test
    public void validOptionNumber(){
        Boolean res = communityFeatureSelection("1");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionNumber2(){
        Boolean res = communityFeatureSelection("2");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionNumber3(){
        Boolean res = communityFeatureSelection("3");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionFull(){
        Boolean res = communityFeatureSelection("load custom dataset");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionFullCapital(){
        Boolean res = communityFeatureSelection("LOAD CUSTOM DATASET");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionWord(){
        Boolean res = communityFeatureSelection("load");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionFull2(){
        Boolean res = communityFeatureSelection("data graph visualisation");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionWord2(){
        Boolean res = communityFeatureSelection("graph");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionFull3(){
        Boolean res = communityFeatureSelection("view summary statistics");
        Assertions.assertTrue(res);
    }

    @Test
    public void validOptionWord3(){
        Boolean res = communityFeatureSelection("summary");
        Assertions.assertTrue(res);
    }

    @Test
    public void validHome(){
        Boolean res = communityFeatureSelection("home");
        Assertions.assertTrue(res);
    }

    @Test
    public void validHomeCapital(){
        Boolean res = communityFeatureSelection("HOME");
        Assertions.assertTrue(res);
    }

    @Test
    public void validBack(){
        Boolean res = communityFeatureSelection("back");
        Assertions.assertTrue(res);
    }

    @Test
    public void invalidOptionNumber(){
        Boolean res = communityFeatureSelection("4");
        Assertions.assertFalse(res);
    }

    @Test
    public void invalidOptionWord(){
        Boolean res = communityFeatureSelection("load graph");
        Assertions.assertFalse(res);
    }
}
