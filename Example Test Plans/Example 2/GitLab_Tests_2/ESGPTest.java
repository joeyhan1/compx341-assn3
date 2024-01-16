import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;

/**
 * Class that performs black box unit tests on elements that make up high priority requirements for the Encost Smart Home Graph Project (ESGP)
 */
public class ESGPTest {
    private ConsoleApp consoleApp;
    private UserVerifier userVerifier;
    private FileParser fileParser;
    private GraphVisualiser graphVisualiser;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ByteArrayInputStream testIn;

    /**
     * Set up objects frequently used
     */
    @BeforeEach
    public void setUp() {
        consoleApp = new ConsoleApp();
        userVerifier = new UserVerifier();
        fileParser = new FileParser();
        graphVisualiser = new GraphVisualiser();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Dispose of objects 
     */
    @AfterEach
    public void tearDown() { 
        consoleApp = null;
        userVerifier = null;
        fileParser = null;        
        graphVisualiser = null;
        System.setOut(standardOut);
        System.setIn(System.in);
    }
    
    //-------- Categorising Users Tests ----------

    /**
     * Checks that when the checkUserVersion method is passed the char '1' it returns the 
     * usertype "community"
     */
    @Test
    public void categorisingCommunityUserTest() {
        String userType = consoleApp.checkUserVersion('1');
        assertEquals(userType, "community");
    }

    /**
     * Checks that when the checkUserVersion method is passed the char '2' it returns the 
     * usertype "encost-unverified"
     */
    @Test
    public void categorisingEncostUserTest() {
        String userType = consoleApp.checkUserVersion('2');
        assertEquals(userType, "encost-unverified");
    }

    /**
     * Checks that when the checkUserVersion method is passed a char that is not '1' or '2' 
     * in this case '0', it returns the usertype "invalid"
     */
    @Test
    public void categorisingUserInvalidUserTypeATest() {
        String userType = consoleApp.checkUserVersion('0');
        assertEquals(userType, "invalid");
    }

    /**
     * Checks that when the checkUserVersion method is passed a char that is not '1' or '2' 
     * in this case '3', it returns the usertype "invalid"
     */
    @Test
    public void categorisingUserInvalidUserTypeBTest() {
        String userType = consoleApp.checkUserVersion('3');
        assertEquals(userType, "invalid");
    }

    /**
     * Checks that when the checkUserVersion method is passed a char that is not '1' or '2' 
     * in this case 'x', it returns the usertype "invalid"
     */
    @Test
    public void categorisingUserInvalidUserTypeCTest() {
        String userType = consoleApp.checkUserVersion('x');
        assertEquals(userType, "invalid");
    }

    //-------- Account Login Tests ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED
    
    /**
     * Checks that when an invalid username and an invalid password are provided to the verifyUser
     * false is returned (credentials are recognised as invalid)
     */
    @Test
    public void accountLoginInvalidUsernameInvalidPassword() {
        String invalidUname = ""; //-------------------------------- NEEDS TO BE POPULATED  
        String invalidPassword = ""; //-------------------------------- NEEDS TO BE POPULATED  
        boolean validCredentials = userVerifier.verifyUser(invalidUname, invalidPassword);
        assertFalse(validCredentials);
    }

    /**
     * Checks that when an invalid username and a valid password are provided to the verifyUser
     * false is returned (credentials are recognised as invalid)
     */
    @Test
    public void accountLoginInvalidUsernameValidPassword() {
        String invalidUname = ""; //-------------------------------- NEEDS TO BE POPULATED  
        String validPassword = ""; //-------------------------------- NEEDS TO BE POPULATED  
        boolean validCredentials = userVerifier.verifyUser(invalidUname, validPassword);
        assertFalse(validCredentials);
    }

    /**
     * Checks that when a valid username and an invalid password are provided to the verifyUser
     * false is returned (credentials are recognised as invalid)
     */
    @Test
    public void accountLoginValidUsernameInvalidPassword() {
        String validUname = ""; //-------------------------------- NEEDS TO BE POPULATED  
        String invalidPassword = ""; //-------------------------------- NEEDS TO BE POPULATED  
        boolean validCredentials = userVerifier.verifyUser(validUname, invalidPassword);
        assertFalse(validCredentials);
    }    

    /**
     * Checks that when a valid username and a valid password (it's corresponding password) are provided 
     * to the verifyUser true is returned (credentials are recognised as valid)
     */
    @Test
    public void accountLoginValidUsernameValidPassword() {
        String validUname = ""; //-------------------------------- NEEDS TO BE POPULATED  
        String validPassword = ""; //-------------------------------- NEEDS TO BE POPULATED  
        boolean validCredentials = userVerifier.verifyUser(validUname, validPassword);
        assertFalse(validCredentials);
    }

    //-------- Loading Encost Dataset Tests ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED

    /**
     * Parses the Encost Dataset file and checks that the returned device array contains the same number
     * of Devices as lines in the Encost Dataset file (each line in the file represents one device)
     * Also checks that each device in the device array is not a null reference
     */
    @Test
    public void loadingEncostDatasetValidFilePath() {
        String encostDatasetFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        int numDevicesEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(encostDatasetFilePath);        
        assertEquals(numDevicesEncostDatasetFile, deviceArray.length)

        foreach(Device dev : deviceArray){
            assertNotNull(dev);
        }
    }

    /**
     * Checks that a null Device array is returned when parseFile is passed an invalid filepath
     */
    @Test
    public void loadingEncostDatasetInvalidFilePath() {
        String invalidEncostDatasetFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(invalidEncostDatasetFilePath);
        assertNull(deviceArray);
    }

    /**
     * Checks that a null Device array is returned when parseFile is passed an empty string as the filepath
     */
    @Test
    public void loadingEncostDatasetEmptyStringFilePath() {
        String emptyString = "";
        Device [] deviceArray = fileParser.parseFile(emptyString);
        assertNull(deviceArray);
    }

    /**
     * Checks that a null Device array is returned when parseFile is passed a null string as the filepath
     */
    @Test
    public void loadingEncostDatasetNullStringFilePath() {
        String nullString = null;
        Device [] deviceArray = fileParser.parseFile(nullString);
        assertNull(deviceArray);
    }


    //-------- Categorising Devices Tests ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED
    
    /**
     * Checks that a null Device array is returned when parseFile is passed an incorrectly formatted file
     */
    @Test
    public void categoriseDevicesInvalidFileFormat() {
        String incorrectFormatFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(incorrectFormatFilePath);
        assertNull(deviceArray);
    }

    /**
     * Checks that the Device array returned when parseFile is passed the Encost Dataset contains the same number
     * of Devices as lines in the Encost Dataset file (each line in the file represents one device)
     * And that devoce array has the same number of routers, whiteware, hubs, appliances and lighting as there are in the 
     * Encost Dataset
     */
    @Test
    public void categoriseDevicesEncostDataset() {
        String encostDatasetFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        int numDevicesEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        int numRouterEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        int numWhitewareEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        int numHubEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        int numApplianceEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        int numLightingEncostDatasetFile = 0; //-------------------------------- NEEDS TO BE POPULATED
        Device [] deviceArray = fileParser.parseFile(encostDatasetFilePath);

        int countRouter, countWhiteware, countHub, countAppliance, countLighting;

        foreach(Device dev : deviceArray){
            if (dev.getDeviceType() == DeviceType.WIFI_ROUTER){
                countRouter++;
            } else if (dev.getDeviceType() == DeviceType.WHITEWARE){
                countWhiteware++;
            } else if(dev.getDeviceType() == DeviceType.HUB_CONTROLLER){
                countHub++;
            } else if(dev.getDeviceType() == DeviceType.APPLIANCE){
                countAppliance++;
            } else if(dev.getDeviceType() == DeviceType.LIGHTING){
                countLighting++;
            }
        }

        assertEquals(numDevicesEncostDatasetFile, deviceArray.length);
        assertEquals(numRouterEncostDatasetFile, countRouter);
        assertEquals(numApplianceEncostDatasetFile, countAppliance);
        assertEquals(numLightingEncostDatasetFile, countLighting);
        assertEquals(numHubEncostDatasetFile, countHub);
        assertEquals(numWhitewareEncostDatasetFile, countWhiteware);
    }


    //-------- Building Graph Data Type Tests ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED
    
    /**
     * Checks to see that when a DeviceGraph is created for a file that has been parsed and is not valid
     * that the number of devices in the DeviceGraph is zero
     */
    @Test
    public void buildGraphEmptyStringFilePath() {
        String emptyString = "";
        Device [] deviceArray = fileParser.parseFile(emptyString);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);

        assertEquals(0, deviceGraph.getDevices().length);
    }


    /**
     * Checks to see that when a DeviceGraph is created for a file that has been parsed and is not valid
     * that the number of devices in the DeviceGraph is zero
     */
    @Test
    public void buildGraphInvalidFilePath() {
        String invalidEncostDatasetFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(invalidEncostDatasetFilePath);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);

        assertEquals(0, deviceGraph.getDevices().length);
    }

    /**
     * Checks to see that when passed a valid file the correct number of devices exist in the DeviceGraph
     * validFilePathVOne in this example contains the following devices:
     * WifiRouter (id: EWR-1234), SmartAppliance (router id: EWR-1234), SmartWhiteware (router id: EWR-1234), 
     * HubController (router id: EWR-1234), WifiRouter (id: EWR-6789), SmartAppliance (router id: EWR-6789)
     * i.e. six devices
     */
    @Test
    public void buildGraphValidFileA() {
        String validFilePathVOne = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathVOne);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);

        assertEquals(6, deviceGraph.getDevices().length);
    }    

    /**
     * Checks to see that when passed a valid file the correct number of devices exist in the DeviceGraph
     * validFilePathVTwo in this example contains the following devices:
     * WifiRouter (id: EWR-1234), WifiRouter (id: EWR-6789) i.e. two devices
     */
    @Test
    public void buildGraphValidFileB() {
        String validFilePathVTwo = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathVTwo);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);

        assertEquals(2, deviceGraph.getDevices().length);
    } 


    //-------- Graph Visualisation Tests ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED
    
    /**
     * Checks that when an invalid file is parsed the number of nodes and edges in the graph is zero
     */
    @Test
    public void graphVisualisationEmptyStringFilePath() {
        String emptyString = "";
        Device [] deviceArray = fileParser.parseFile(emptyString);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        graphVisualiser.convertGraph(deviceGraph);

        assertEquals(0, graphVisualiser.getNumNodes());
        assertEquals(0, graphVisualiser.getNumEdgeCount());
    }

    /**
     * Checks that when an invalid file is parsed the number of nodes and edges in the graph is zero
     */
    @Test
    public void graphVisualisationInvalidFilePath() {
        String invalidFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(invalidFilePath);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        graphVisualiser.convertGraph(deviceGraph);

        assertEquals(0, graphVisualiser.getNumNodes());
        assertEquals(0, graphVisualiser.getNumEdgeCount());
    }

    /**
     * Checks that when a valid file path containing devices and routers is provided the correct number of 
     * nodes and edges are in the graph. 
     * Here validFilePathRoutersAndDevices contains the following devices:
     * WifiRouter (id: EWR-1234), SmartAppliance (router id: EWR-1234), SmartWhiteware (router id: EWR-1234), 
     * HubController (router id: EWR-1234), WifiRouter (id: EWR-6789), SmartAppliance (router id: EWR-6789)
     * In summary, it has a total of six nodes in the graph it will construct. Router EWR-1234 is connected to 
     * three devices, and Router EWR-6789 is connected to one device, so the number of edges in the graph this 
     * file will construct is four.
     */
    @Test
    public void graphVisualisationValidFilePathRoutersAndDevices() {
        String validFilePathRoutersAndDevices = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathRoutersAndDevices);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        graphVisualiser.convertGraph(deviceGraph);

        assertEquals(6, graphVisualiser.getNumNodes());
        assertEquals(4, graphVisualiser.getNumEdgeCount());
    }

    /**
     * Checks that when a valid file path containing devices and routers is provided the correct number of 
     * nodes and edges are in the graph. 
     * Here validFilePathRoutersOnly contains the following devices:
     * WifiRouter (id: EWR-1234), WifiRouter (id: EWR-6789). In summary, it has a total of two nodes in the graph 
     * it will construct. Neither Router is connected to any devices, so the number of edges in the graph this file 
     * will construct is zero.
     */
    @Test
    public void graphVisualisationValidFilePathRoutersOnly() {
        String validFilePathRoutersOnly = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathRoutersOnly);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        graphVisualiser.convertGraph(deviceGraph);

        assertEquals(2, graphVisualiser.getNumNodes());
        assertEquals(0, graphVisualiser.getNumEdgeCount());        
    }

    //-------- Calculating Device Distribution ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED

    /**
     * Checks that when passed an invalid filepath that the null deviceGraph is not processed or said to
     * contain zero of each device for each category
     */
    @Test
    public void calcDeviceDistributionEmptyStringFilePath() {
        String emptyString = "";
        Device [] deviceArray = fileParser.parseFile(emptyString);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        DataSummary dataSummary = new DataSummary(deviceGraph);
        EnumMap<DeviceType, Integer> deviceByCategory = dataSummary.calcNumDevicesByCategory();

        assertNull(deviceByCategory);
    }

    /**
     * Checks that when passed an invalid filepath that the null deviceGraph is not processed or said to
     * contain zero of each device for each category
     */
    @Test
    public void calcDeviceDistributionInvalidFilePath() {
        String invalidFilePath = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(invalidFilePath);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        DataSummary dataSummary = new DataSummary(deviceGraph);
        EnumMap<DeviceType, Integer> deviceByCategory = dataSummary.calcNumDevicesByCategory();

        assertNull(deviceByCategory);
    }

    /**
     * Checks that when passed a valid file name it contains the correct number of devices for each category
     * validFilePathRoutersAndDevices contains the following devices: 
     * WifiRouter (id: EWR-1234), SmartAppliance (router id: EWR-1234), SmartWhiteware (router id: EWR-1234), 
     * Smart Lighting (router id: EWR-1234), HubController (router id: EWR-1234), WifiRouter (id: EWR-6789), 
     * SmartAppliance (router id: EWR-6789), SmartAppliance (router id: EWR-6789), HubController (router id: EWR-6789)
     * i.e. 2 Wifi Routers, 3 Smart Appliances, 1 Smart Lighting, 1 Smart Whiteware, 2 HubController
     */
    @Test
    public void calcDeviceDistributionValidFilePathRoutersAndDevices() {
        String validFilePathRoutersAndDevices = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathRoutersAndDevices);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        DataSummary dataSummary = new DataSummary(deviceGraph);
        EnumMap<DeviceType, Integer> deviceByCategory = dataSummary.calcNumDevicesByCategory();

        assertEquals(deviceByCategory.get(DeviceType.WIFI_ROUTER), 2);
        assertEquals(deviceByCategory.get(DeviceType.WHITEWARE), 1);
        assertEquals(deviceByCategory.get(DeviceType.HUB_CONTROLLER), 2);
        assertEquals(deviceByCategory.get(DeviceType.APPLIANCE), 3);
        assertEquals(deviceByCategory.get(DeviceType.LIGHTING), 1);
    }

    /**
     * Checks that when passed a valid file name it contains the correct number of devices for each category
     * validFilePathRoutersOnly contains the following devices: 
     * WifiRouter (id: EWR-1234), WifiRouter (id: EWR-6789)
     * i.e. 2 Wifi Routers
     */
    @Test
    public void calcDeviceDistributionValidFilePathRoutersOnly() {
        String validFilePathRoutersOnly = ""; //-------------------------------- NEEDS TO BE POPULATED  
        Device [] deviceArray = fileParser.parseFile(validFilePathRoutersOnly);
        DeviceGraph deviceGraph = new DeviceGraph(deviceArray);
        DataSummary dataSummary = new DataSummary(deviceGraph);
        EnumMap<DeviceType, Integer> deviceByCategory = dataSummary.calcNumDevicesByCategory();

        assertEquals(deviceByCategory.get(DeviceType.WIFI_ROUTER), 2);
        assertEquals(deviceByCategory.get(DeviceType.WHITEWARE), 0);
        assertEquals(deviceByCategory.get(DeviceType.HUB_CONTROLLER), 0);
        assertEquals(deviceByCategory.get(DeviceType.APPLIANCE), 0);
        assertEquals(deviceByCategory.get(DeviceType.LIGHTING), 0);
    }

    //-------- ESGP Feature Options ------------
    //NOTE SOME PARAMETERS NEED TO BE UPDATED TO BE ABLE TO BE TESTED

    /**
     * Writes the passed in to console 
     * @param data the string to write to console
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Checks that when an invalid option is provided an error message is printed to console
     */
    @Test
    public void featureOptionsInvalidA() {
        consoleApp.getFeature();
        provideInput("0");
        String actual = outputStreamCaptor.toString().trim();
        String errorMsg = "Please provide a valid Feature Option e.g. ’1’ to visualise a graph representation of the data";
        assertEquals(errorMsg, actual);
    }
    

    /**
     * Checks that when an invalid option is provided an error message is printed to console
     */
    @Test
    public void featureOptionsInvalidB() {
        consoleApp.getFeature();
        provideInput("4");
        String actual = outputStreamCaptor.toString().trim();
        String errorMsg = "Please provide a valid Feature Option e.g. ’1’ to visualise a graph representation of the data";
        assertEquals(errorMsg, actual);
    }

    /**
     * Checks that when an invalid option is provided an error message is printed to console
     */
    @Test
    public void featureOptionsInvalidC() {
        consoleApp.getFeature();
        provideInput("a");
        String actual = outputStreamCaptor.toString().trim();
        String errorMsg = "Please provide a valid Feature Option e.g. ’1’ to visualise a graph representation of the data";
        assertEquals(errorMsg, actual);
    }

    /**
     * Checks that when the User selects to load a custom datset that the prompt asking for the file location is printed to console
     */
    @Test
    public void featureOptionsLoadCustomData() {
        consoleApp.getFeature();
        provideInput("2");
        String actual = outputStreamCaptor.toString().trim();
        String customDataMsg = "Please provide the full filepath of the custom dataset:";
        assertEquals(customDataMsg, actual);
    }

    /**
     * Checks that when the User selects to view summary statistics that the correct message is printed to console
     * Once the stats are calculated they will be printed to console but this message should be printed immediately
     */
    @Test
    public void featureOptionsCalcSummaryStats() {
        consoleApp.getFeature();
        provideInput("3");
        String actual = outputStreamCaptor.toString().trim();
        String summaryStatsMsg = "Summary Statistics calculating...";
        assertEquals(summaryStatsMsg, actual);
    }

    /**
     * Checks that when a community User asks to view the graph visualisation that the feature options for community
     * user are printed to console
     */
    @Test
    public void featureOptionsGraphVisualisationCommunityUser() {
        consoleApp.getUserVersion();
        provideInput("1");
        consoleApp.getFeature();
        provideInput("1");
        String actual = outputStreamCaptor.toString().trim();
        String communityUserFeaturesMsg = "ESGP Feature Options: \n 1. View graph visualisation of data";
        assertEquals(communityUserFeaturesMsg, actual);
    }

    /**
     * Checks that when a community User asks to view the graph visualisation that the feature options for encost
     * user are printed to console
     */
    @Test
    public void featureOptionsGraphVisualisationEncostUser() {
        String validEncostUserName = ""; //-------------------------------- NEEDS TO BE POPULATED  
        String validEncostPassword = ""; //-------------------------------- NEEDS TO BE POPULATED  
        consoleApp.getUserVersion();
        provideInput("2");
        provideInput(validEncostUserName);
        provideInput(validEncostPassword);
        consoleApp.getFeature();
        provideInput("1");
        String actual = outputStreamCaptor.toString().trim();
        String encostUserFeaturesMsg = "ESGP Feature Options: \n 1. View graph visualisation of data \n 2. Load Custom Dataset (Loaded Dataset: Encost Smart Homes Dataset) \n 3. View Summary Statistics";
        assertEquals(encostUserFeaturesMsg, actual);
    }
}