package Tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import ConfigReader.ConfigFileReader;
import Hooks.Hooks;
import Pages.LoginPage;
import Pages.ProductPage;
import io.appium.java_client.AppiumDriver;
import utils.Wait;

public class LoginTest
        extends Hooks {
//    private AppiumDriver driver;
    
    @BeforeMethod
    public void initApp() {
    	try {
			Hooks.openApp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
    	Wait.waitFor(2);

    }
    
    @AfterMethod
    public void killApp() {
    	Wait.waitFor(2);
        Hooks.terminateApp();

    }

//    @Test
//    public void openApplication() {
//    	        
//    }
    
    @Test
    public void failLoginMissingUsername(){
    	
    	@SuppressWarnings("static-access")
		LoginPage loginPage = new LoginPage(super.driver);
    	loginPage.submitLogin();
    	Wait.waitFor(1);
    	String ErrorMsg = loginPage.getErrorMsg();
    	assertTrue(ErrorMsg.toLowerCase().contains("username is required"));
    }
    
    @Test
    public void failLoginMissingPassword(){
    	
    	@SuppressWarnings("static-access")
		LoginPage loginPage = new LoginPage(super.driver);
    	loginPage.enterUserName("username");
    	loginPage.submitLogin();
    	Wait.waitFor(1);
    	String ErrorMsg = loginPage.getErrorMsg();
    	assertTrue(ErrorMsg.toLowerCase().contains("password is required"));
    }
    
    @Test
    public void failLoginInvalidUser() {
    	
    	@SuppressWarnings("static-access")
		LoginPage loginPage = new LoginPage(super.driver);
    	loginPage.enterUserName("username");
    	loginPage.enterPassword("P@ssw0rd");
    	loginPage.submitLogin();
    	Wait.waitFor(1);
    	String ErrorMsg = loginPage.getErrorMsg();
    	assertTrue(ErrorMsg.toLowerCase().contains("username and password do not match"));
    }
    
    @Test
    public void successLogin(){
    	
    	ConfigFileReader reader = new ConfigFileReader();
    	
    	
    	@SuppressWarnings("static-access")
		LoginPage loginPage = new LoginPage(super.driver);
    	loginPage.enterUserName(reader.getUsername());
    	loginPage.enterPassword(reader.getPassword());
    	loginPage.submitLogin();
    	Wait.waitFor(1);
    	ProductPage productsPage = new ProductPage(driver);
    	assertTrue(productsPage.isPageLoaded());
    }

    
}
