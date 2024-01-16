import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_FeatureOptions {

    @Test
    @DisplayName("Test feature option selection visualise graph when verified")
    public void test_featureoptions_graph(){
        assertEquals("graph", new ConsoleApp().determineSelectedFeature("1", true));
    }

    @Test
    @DisplayName("Test feature option selection load custom dataset when verified")
    public void test_featureoptions_loadcustom(){
        assertEquals("load", new ConsoleApp().determineSelectedFeature("2", true));
    }

    @Test
    @DisplayName("Test view summary statistics selection - when verfieid")
    public void test_featureoptions_summary(){
        assertEquals("summary", new ConsoleApp().determineSelectedFeature("3", true));
    }

    @Test
    @DisplayName("Test graph visualation selection when unverified ")
    public void test_featureoptions_graph_unverified(){
        assertEquals("graph", new ConsoleApp().determineSelectedFeature("1", false));
    }

    @Test
    @DisplayName("Test load custom selection when unverified")
    public void test_featureoptions_loadcustom_unverified(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("2", false));
    }

    @Test
    @DisplayName("Test summary selection when unverified")
    public void test_featureoptions_summary_unverified(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("3", false));
    }

    @Test
    @DisplayName("Test feature option response for invalid input when verified")
    public void test_featureoptions_invalidinput(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("a", true));
    }

    @Test
    @DisplayName("Test feature option response for unverified invalid input")
    public void test_featureoptions_invalidinput_unverified(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("a", false));
    }

    @Test
    @DisplayName("Test empty selection is invalid when unverified")
    public void test_featureoptions_empty(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("", true));
    }

    @Test
    @DisplayName("Test emtpy selection is invalid when unverified")
    public void test_featureoptions_empty_unverified(){
        assertEquals("invalid", new ConsoleApp().determineSelectedFeature("", false));
    }

}
