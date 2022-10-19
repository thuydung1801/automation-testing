package Page_Lib;

import java.io.*;
import java.util.Properties;

public class ReadData {
    private Properties properties;
    private final String propertyFilePath = "D:\\Automation_Glamira\\src\\main\\Data_Test\\data.properties";

    public ReadData() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
    public String getKey(String key) {
        String data = properties.getProperty(key);
        return data;
    }


}

