import java.util.*;
import java.io.*;
import java.text.*;

/**
 * Encost Class
 * 
 * Encost class is used to make the ESGP(Encost Smart Graph Project)
 * The Encost Class holds all the methods which helps the program run as
 * intended from the SRS, SDS 1 and the functional software test plan 5.
 *  
 */
public class Encost {
    //Variables and Objects
    Scanner scanner = new Scanner(System.in);
    HashMap loginCredentials = new HashMap<>();
    String userType;
    List<String> productTypesList = new ArrayList<>();
    List<String> productNamesList = new ArrayList<>();
    List<String> productCategoriesList = new ArrayList<>();

    //Method to store the valid login credentials
    public void storeLoginCredentials() {
        loginCredentials.put("encostUserA", "password789");
        loginCredentials.put("encostUserB", "password234");
        loginCredentials.put("encostUserC", "password456");
        loginCredentials.put("encostUserD", "password901");
        loginCredentials.put("encostUserE", "password678");
        loginCredentials.put("encostUserF", "password567");
        loginCredentials.put("encostUserG", "password345");
        loginCredentials.put("encorstUserH", "password890");
        loginCredentials.put("encostUserI", "password123");
        loginCredentials.put("encostUserJ", "password012");
    }

    //Asking user methods

    //Method asks user for their type
    public void askUserType(GraphClass graph) {
        System.out.println();
        System.out.println("Enter user (1/2):");
        System.out.println("        (1) Community User");
        System.out.println("        (2) Encost User");
        System.out.print(">> ");
        //Read user input
        String userInput = scanner.nextLine();
        //Testing for valid user inputs
        boolean check = checkUserType(userInput);
        if(check == true) {
            if(userInput.equals("1")) {
                askFeatureOptions(graph);
            } else if(userInput.equals("2")) {
                askUserLogin(graph);
            }
        }
        if(check == false) {
            askUserType(graph);
        }
    }

    //Method asks encost users for their login information
    public void askUserLogin(GraphClass graph) {
        System.out.println();
        System.out.print("Username: ");
        String username = scanner.nextLine();

        //Making the password that user types invisible on the console
        Console console = System.console();
        if (console != null) {
            char[] passwordChars = console.readPassword("Password: ");
            String password = new String(passwordChars);
            //Testing for valid username and password input
            boolean check = login(username, password);
            if(check == true) {
                userType = "Encost User";
                askFeatureOptions(graph);
            }
            if(check == false) {
                askUserLogin(graph);
            }
        }
    }

    //Method asks users for what kind of feature they want to use
    public void askFeatureOptions(GraphClass graph) {
        System.out.println("ESGP Features:");
        //Checking for community user
        if(userType == "Community User") {
            System.out.println("        (1) Graph representation of data");
            System.out.println("        (x) Exit");
            System.out.print("Select option >> ");
            String userInput = scanner.nextLine();
            boolean check = checkFeatureIsValid(userInput, userType);
            if(userInput.equals("1")) {
                graph.display();
            }
            if(userInput.equals("x")) {
                System.exit(0);
            }
            if(check == false) {
                askFeatureOptions(graph);
            }
        } else if(userType == "Encost User") { //Checking for Encost verified user
            System.out.println("        (1) Load custom dataset");
            System.out.println("        (2) Graph representation of data");
            System.out.println("        (3) View summary statistics");
            System.out.println("        (x) Exit");
            System.out.print("Select option >> ");
            String userInput = scanner.nextLine();
            //Testing for valid user input
            boolean check = checkFeatureIsValid(userInput, userType);
            if(userInput.equals("1")) {
                System.out.println("This has not been implemented due to it being not high priority");
                askFeatureOptions(graph);
            }
            if(userInput.equals("2")) {
                graph.display();
            }
            if(userInput.equals("3")) {
                System.out.println(displaySummaryStatistics(graph));
            }
            if(userInput.equals("x")) {
                System.exit(0);
            }
            if(check == false) {
                askFeatureOptions(graph);
            }
        }

    }

    //Method is used for loading the ESHD
    public boolean readDataset(File file, GraphClass graph) {
        //Variables
        int lineNum = 0;
        boolean correctChecker = false;
        String destinationFilePath = "test.csv";
        addProductNameList();
        addProductTypeList();
        System.out.println("Loading dataset...");
        //Checking for a csv file
        if (file.getName().toLowerCase().endsWith(".csv")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    //Variables
                    String[] data = line.split(",");
                    String deviceIDCheck = "[A-Z]{1,3}-\\d{4}";
                    String householdIDCheck = "^(AUK|BOP|CAN|CIT|GIS|WGN|HKB|MWT|MBH|NSN|NTL|OTA|STL|TKI|TAS|WKO|WTC)-\\d{4}$";          
                    String dateFormat = "dd/MM/yyyy";           

                    //Checking for the header line
                    if(data.length >= 8 && lineNum == 0) {
                        String deviceID = data[0].trim();
                        String connectedDate = data[1].trim();
                        String productName = data[2].trim();
                        String productType = data[3].trim();
                        String householdID = data[4].trim();
                        String routerID = data[5].trim();             

                        //Write data to the test CSV file (canSend and canReceive is changed for the testing or else it will just enter TRUE or FALSE instead of what the reader is reading because of boolean)
                        String outputLine = String.format("%s,%s,%s,%s,%s,%s,%s,%s", deviceID, connectedDate, productName, productType, householdID, routerID, data[6].trim(), data[7].trim());
                        writer.write(outputLine);
                        writer.newLine();
                        correctChecker = true;                   
                    } else if (data.length >= 8 && data[0].trim().matches(deviceIDCheck) && //Checking for the correct format
                        (isValidDateFormat(data[1].trim(), dateFormat) == true) &&
                        productNamesList.contains(data[2].trim()) &&
                        productTypesList.contains(data[3].trim()) &&
                        data[4].trim().matches(householdIDCheck) &&
                        (data[5].trim().matches(deviceIDCheck) || data[5].trim().matches("-")) &&
                        (data[6].trim().equalsIgnoreCase("Yes") || data[6].trim().equalsIgnoreCase("No")) &&
                        (data[7].trim().equalsIgnoreCase("Yes") || data[7].trim().equalsIgnoreCase("No"))
                        ) {
                            String deviceID = data[0].trim();
                            String connectedDate = data[1].trim();
                            String productName = data[2].trim();
                            String productType = data[3].trim();
                            String householdID = data[4].trim();
                            String routerID = data[5].trim();
                            boolean canSend = data[6].trim().equalsIgnoreCase("Yes");
                            boolean canReceive = data[7].trim().equalsIgnoreCase("Yes");            
    
                            //Create Device object
                            Device device = new Device(deviceID, connectedDate, productName, productType, householdID, routerID, canSend, canReceive);

                            //Add device to the graph
                            graph.addDevice(device);
    
                            //Write data to the test CSV file (canSend and canReceive is changed for the testing or else it will just enter TRUE or FALSE instead of what the reader is reading because of boolean)
                            String outputLine = String.format("%s,%s,%s,%s,%s,%s,%s,%s", deviceID, connectedDate, productName, productType, householdID, routerID, data[6].trim(), data[7].trim());
                            writer.write(outputLine);
                            writer.newLine();  
                            correctChecker = true;
                    } else {
                        correctChecker = false;
                    }
                    //Increase the line number
                    lineNum++;
                }
                if(correctChecker == true) {
                    System.out.println("Dataset successfully loaded.");
                    return true;
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Method used for checking for valid date format method (Used for the readDataset for connectedDate checking)
    public static boolean isValidDateFormat(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    //Method used for calculating device distribution
    public int[][] DeviceDistribution(GraphClass graph) {
        addProductTypeList();
        addProductCategoriesList();
        addProductNameList();
        //Variables and Arrays
        int[] typeArray = new int[12];
        int[] categoryArray = new int[5];
        int[] productArray = new int[32];
        int productTypeSum = 0;
        int productCategorySum = 0;
        int productNameSum = 0;
        try {
            for(int i = 0; i < productCategoriesList.size(); i++) {
                List<Device> categoryList = graph.getDevicesByCategory(productCategoriesList.get(i));
                categoryArray[i] = categoryList.size();
                productCategorySum += categoryList.size();
            }
            
            for(int j = 0; j < productTypesList.size(); j++) {
                List<Device> typeList = graph.getDevicesByType(productTypesList.get(j));
                typeArray[j] = typeList.size();
                productTypeSum += typeList.size();
            }

            for(int k = 0; k < productNamesList.size(); k++) {
                List<Device> productList = graph.getDevicesByProduct(productNamesList.get(k));
                productArray[k] = productList.size();
                productNameSum += productList.size();
            }

            if(productCategorySum != productTypeSum && productTypeSum != productNameSum && productCategorySum != productNameSum) {
                System.err.println("Device count sums do not match");
            } else {
                return new int[][] {typeArray,categoryArray,productArray};
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method is used to display the device distribution table
    public String displaySummaryStatistics(GraphClass graph) {
        int[][] result = DeviceDistribution(graph);
        int[] typeArray = result[0];
        int[] categoryArray = result[1];
        int[] productArray = result[2];
        String deviceDistribution = "Device Distribution                             \n"
                                + "===============================================================================\n"
                                + "|"+productCategoriesList.get(0)+"                                              | "+categoryArray[0]+"         |\n" //Encost Wifi Routers
                                + "|     "+productTypesList.get(0)+"                                                      | "+typeArray[0]+"         |\n" //Router
                                + "|         "+productNamesList.get(0)+"                                       | "+productArray[0]+"         |\n"
                                + "|         "+productNamesList.get(1)+"                                      | "+productArray[1]+"         |\n"
                                + "|     "+productTypesList.get(1)+"                                                    | "+typeArray[1]+"         |\n" //Extender
                                + "|         "+productNamesList.get(2)+"                          | "+productArray[2]+"         |\n"
                                + "|         "+productNamesList.get(3)+"                          | "+productArray[3]+"         |\n"
                                + "|"+productCategoriesList.get(1)+"                                          | "+categoryArray[1]+"         |\n" //Encost Hubs/Controllers
                                + "|     "+productTypesList.get(2)+"                                              | "+typeArray[2]+"         |\n" //Hub/Controller
                                + "|         "+productNamesList.get(4)+"                                        | "+productArray[4]+"         |\n"
                                + "|         "+productNamesList.get(5)+"                                    | "+productArray[5]+"         |\n"
                                + "|         "+productNamesList.get(6)+"                                   | "+productArray[6]+"         |\n"
                                + "|"+productCategoriesList.get(2)+"                                            | "+categoryArray[2]+"         |\n" //Encost Smart Lighting
                                + "|     "+productTypesList.get(3)+"                                                  | "+typeArray[3]+"         |\n" //Light Bulb
                                + "|         "+productNamesList.get(7)+"                           | "+productArray[7]+"         |\n"
                                + "|         "+productNamesList.get(8)+"                    | "+productArray[8]+"         |\n"
                                + "|         "+productNamesList.get(9)+"                           | "+productArray[9]+"         |\n"
                                + "|         "+productNamesList.get(10)+"                    | "+productArray[10]+"         |\n"
                                + "|     "+productTypesList.get(4)+"                                              | "+typeArray[4]+"         |\n" //Strip Lighting
                                + "|         "+productNamesList.get(11)+"                           | "+productArray[11]+"         |\n"
                                + "|         "+productNamesList.get(12)+"                    | "+productArray[12]+"         |\n"
                                + "|     "+productTypesList.get(5)+"                                              | "+typeArray[5]+"         |\n" //Other Lighting
                                + "|         "+productNamesList.get(13)+"                          | "+productArray[13]+"         |\n"
                                + "|         "+productNamesList.get(14)+"                             | "+productArray[14]+"         |\n"
                                + "|         "+productNamesList.get(15)+"                             | "+productArray[15]+"         |\n"
                                + "|"+productCategoriesList.get(3)+"                                          | "+categoryArray[3]+"         |\n" //Encost Smart Appliances
                                + "|     "+productTypesList.get(6)+"                                                      | "+typeArray[6]+"         |\n" //Kettle
                                + "|         "+productNamesList.get(16)+"                                        | "+productArray[16]+"         |\n"
                                + "|         "+productNamesList.get(17)+"                           | "+productArray[17]+"         |\n"
                                + "|     "+productTypesList.get(7)+"                                                     | "+typeArray[7]+"         |\n" //Toaster
                                + "|         "+productNamesList.get(18)+"                          | "+productArray[18]+"         |\n"
                                + "|         "+productNamesList.get(19)+"                          | "+productArray[19]+"         |\n"
                                + "|     "+productTypesList.get(8)+"                                                | "+typeArray[8]+"         |\n" //Coffee Maker
                                + "|         "+productNamesList.get(20)+"                               | "+productArray[20]+"         |\n"
                                + "|         "+productNamesList.get(21)+"                          | "+productArray[21]+"         |\n"
                                + "|         "+productNamesList.get(22)+"                           | "+productArray[22]+"         |\n"
                                + "|"+productCategoriesList.get(4)+"                                           | "+categoryArray[4]+"         |\n" //Encost Smart Whiteware
                                + "|     "+productTypesList.get(9)+"                                       | "+typeArray[9]+"         |\n" //Washing Machine/Dryer
                                + "|         "+productNamesList.get(23)+"                                     | "+productArray[23]+"         |\n"
                                + "|         "+productNamesList.get(24)+"                                 | "+productArray[24]+"         |\n"
                                + "|         "+productNamesList.get(25)+"                                      | "+productArray[25]+"         |\n"
                                + "|         "+productNamesList.get(26)+"                                  | "+productArray[26]+"         |\n"
                                + "|     "+productTypesList.get(10)+"                                        | "+typeArray[10]+"         |\n" //Refrigerator/Freezer
                                + "|         "+productNamesList.get(27)+"                               | "+productArray[27]+"         |\n"
                                + "|         "+productNamesList.get(28)+"                                    | "+productArray[28]+"         |\n"
                                + "|         "+productNamesList.get(29)+"                 | "+productArray[29]+"         |\n"
                                + "|     "+productTypesList.get(11)+"                                                  | "+typeArray[11]+"         |\n" //Dishwasher
                                + "|         "+productNamesList.get(30)+"                                       | "+productArray[30]+"         |\n"
                                + "|         "+productNamesList.get(31)+"                                   | "+productArray[31]+"         |\n"
                                + "===============================================================================";
        return deviceDistribution;
    }

    //Adding to list methods (Adds all the items given to the list)

    public void addProductTypeList() {
        productTypesList.clear();
        productTypesList.add("Router");
        productTypesList.add("Extender");
        productTypesList.add("Hub/Controller");
        productTypesList.add("Light Bulb");
        productTypesList.add("Strip Lighting");
        productTypesList.add("Other Lighting");
        productTypesList.add("Kettle");
        productTypesList.add("Toaster");
        productTypesList.add("Coffee Maker");
        productTypesList.add("Washing Machine/Dryer");
        productTypesList.add("Refrigerator/Freezer");
        productTypesList.add("Dishwasher");
    }

    public void addProductNameList() {
        productNamesList.clear();
        productNamesList.add("Encost Router 360");
        productNamesList.add("Encost Router Plus");
        productNamesList.add("Encost Wifi Range Extender 1.0");
        productNamesList.add("Encost Wifi Range Extender 2.0");
        productNamesList.add("Encost Smart Hub");
        productNamesList.add("Encost Smart Hub 2.0");
        productNamesList.add("Encost Smart Hub Mini");
        productNamesList.add("Encost Smart Bulb B22 (white)");
        productNamesList.add("Encost Smart Bulb B22 (multi colour)");
        productNamesList.add("Encost Smart Bulb E26 (white)");
        productNamesList.add("Encost Smart Bulb E26 (multi colour)");
        productNamesList.add("Encost Strip Lighting (white)");
        productNamesList.add("Encost Strip Lighting (multi colour)");
        productNamesList.add("Encost Novelty Light (giraffe)");
        productNamesList.add("Encost Novelty Light (lion)");
        productNamesList.add("Encost Novelty Light (bear)");
        productNamesList.add("Encost Smart Jug");
        productNamesList.add("Encost Smart Whistling Kettle");
        productNamesList.add("Encost Smart Toaster (2 slice)");
        productNamesList.add("Encost Smart Toaster (4 slice)");
        productNamesList.add("Encost Smart Coffee Maker");
        productNamesList.add("Encost Smart Coffee Maker Mini");
        productNamesList.add("Encost Smart Coffee Maker Pro");
        productNamesList.add("Encost Smart Washer");
        productNamesList.add("Encost Smart Washer Pro");
        productNamesList.add("Encost Smart Dryer");
        productNamesList.add("Encost Smart Dryer Pro");
        productNamesList.add("Encost Smart Refrigerator");
        productNamesList.add("Encost Smart Freezer");
        productNamesList.add("Encost Smart Refrigerator/Freezer Combo");
        productNamesList.add("Encost Dishwasher");
        productNamesList.add("Encost Dishwasher Pro");
    }

    public void addProductCategoriesList() {
        productCategoriesList.clear();
        productCategoriesList.add("Encost Wifi Routers");
        productCategoriesList.add("Encost Hubs/Controllers");
        productCategoriesList.add("Encost Smart Lighting");
        productCategoriesList.add("Encost Smart Appliances");
        productCategoriesList.add("Encost Smart Whiteware");
    }

    //Testing methods

    //Method checks for valid user inputs for user type
    public boolean checkUserType(String userInput){
        if (userInput.equals("1")) {
            //Valid
            userType = "Community User";
            System.out.println(userType);
            return true;
        }else if(userInput.equals("2")) {
            //Valid
            System.out.println("Encost-unverified User");
            return true;
        } else {
            //Invalid user types
            return false;
        }
    }

    //Method checks for valid user inputs for login credentials
    public boolean login(String username, String password) {
        if(loginCredentials.isEmpty()) {
            storeLoginCredentials();
        }
        if (loginCredentials.containsKey(username) && loginCredentials.get(username).equals(password)) {
            System.out.println("Successful login!");
            System.out.println();
            System.out.println("Welcome " + username + " (Encost-verified User)");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
    
    //Method checks for valid user inputs for feature options
    public boolean checkFeatureIsValid(String input, String userType) {
        if(userType == "Community User") {
            if(input.equals("1")) {
                return true;
            } else if(input.equals("x")) {
                return true;
            }
        } else if(userType == "Encost User") {
            if(input.equals("1")) {
                return true;
            } else if(input.equals("2")) {
                return true;
            } else if(input.equals("3")) {
                return true;
            }  else if(input.equals("x")) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        //Objects
        GraphClass graph = new GraphClass();
        File dataset = new File("Encost_Smart_Homes_Dataset_Small.csv");
        Encost encost = new Encost();
        //Starting application messages
        System.out.println();
        System.out.println("Welcome to the Encost Smart Project");
        System.out.println();
        //Load the ESHD
        encost.readDataset(dataset, graph);
        //Ask user for type
        encost.askUserType(graph);
    }
}