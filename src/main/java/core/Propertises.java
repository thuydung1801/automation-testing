package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import java.io.*;
import java.util.Properties;

public class Propertises {
    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;

    static String projectPath = System.getProperty("user.dir") + "/";
    private static String propertiesPath = "src/main/resources/data.properties";

    public Propertises() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(projectPath + propertiesPath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + projectPath + propertiesPath);
        }
    }
//    public static <WebElementToJsonConverternt> WebElement getPropValue(String key){
//        String data = properties.getProperty(key);
//      // return data;
//    }

    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            fileIn = new FileInputStream(projectPath + propertiesPath);
            properties.load(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

//    public static String getPropValue(String key){
//        String value = null;
//        try {
//            value = properties.getProperty(key);
//            return value;
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//            e.printStackTrace();
//        }
//        return value;
//    }

    public static void serPropValue(String key, String value) {
        try {
            fileOut = new FileOutputStream(projectPath + propertiesPath);
            properties.setProperty(key, value);
            properties.store(fileOut, "set new value");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
