import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApp {
    Device[] loadFile(){ return new Device[0];}

    final String ENCOST_DATASET_FILE = "/home/skwangles/fake/path";


    String determineUserVersion(String number){
        return "";
    }

    String determineSelectedFeature(String number, boolean isVerified) {return "";}

    String getUserVersion()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            switch(br.readLine()){
                case "1":
                    return "community";
                case "2":
                    return "unverified-encost";
                default:
                    return "invalid";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
