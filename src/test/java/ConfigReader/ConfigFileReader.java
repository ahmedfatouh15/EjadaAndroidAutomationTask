package ConfigReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "config//config.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDeviceName() {
        String deviceName = properties.getProperty("deviceName");
        if(deviceName != null) return deviceName;
        else throw new RuntimeException("Please Add the deviceName to the config file.");
    }
    
    public String getUdid() {
        String udid = properties.getProperty("udid");
        if(udid != null) return udid;
        else throw new RuntimeException("Please Add the udid to the config file.");
    }
    
    public String getPlatformName() {
        String platformName = properties.getProperty("platformName");
        if(platformName != null) return platformName;
        else throw new RuntimeException("Please Add the platformName to the config file.");
    }
    
    public String getPlaftformVersion() {
        String platformVersion = properties.getProperty("platformVersion");
        if(platformVersion != null) return platformVersion;
        else throw new RuntimeException("Please Add the platformVersion to the config file.");
    }
    
    public String getAppPackage() {
        String appPackage = properties.getProperty("appPackage");
        if(appPackage != null) return appPackage;
        else throw new RuntimeException("Please Add the appPackage to the config file.");
    }
    
    public String getAppActivity() {
        String appActivity = properties.getProperty("appActivity");
        if(appActivity != null) return appActivity;
        else throw new RuntimeException("Please Add the appActivity to the config file.");
    }
    
    public String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("Please Add the password to the config file.");
    }
    
    public String getUsername() {
        String username = properties.getProperty("username");
        if(username != null) return username;
        else throw new RuntimeException("Please Add the username to the config file.");
    }

    


}
