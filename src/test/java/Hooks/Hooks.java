package Hooks;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import ConfigReader.ConfigFileReader;

public class Hooks {
    public static AppiumDriver driver;

    public static void openApp() throws MalformedURLException {
    	DesiredCapabilities caps = new DesiredCapabilities();
    	ConfigFileReader reader = new ConfigFileReader();
		caps.setCapability("deviceName", reader.getDeviceName());
		caps.setCapability("udid", reader.getUdid());
		caps.setCapability("platformName", reader.getPlatformName());
		caps.setCapability("platformVersion", reader.getPlaftformVersion());

		caps.setCapability("appPackage", reader.getAppPackage());
		caps.setCapability("appActivity", reader.getAppActivity());
		
		caps.setCapability("–session-override",true);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver(url, caps);

		System.out.println("Application Started...");
    }
    
    public static void terminateApp() {
    	driver.quit();
//    	driver.close();
    }

}    