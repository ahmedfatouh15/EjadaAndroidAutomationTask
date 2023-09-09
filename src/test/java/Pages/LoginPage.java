package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;


public class LoginPage {
	
    public static AppiumDriver driver;
	
	public LoginPage(AppiumDriver driver){
        this.driver = driver;
    }
	
	//Selectors
	private String userNameInputId = "test-Username";
	private String passwordInputId = "test-Password";
	private String loginButtonId = "test-LOGIN";
	private String biometryButtonId = "test-LOGIN";
	private String ErrorMsgXpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView";

	//Functions
	@SuppressWarnings("deprecation")
	public void enterUserName(String username) {
		
		driver.findElement(MobileBy.accessibilityId(userNameInputId)).sendKeys(username);
	}
	
	@SuppressWarnings("deprecation")
	public void enterPassword(String password) {
		
		driver.findElement(MobileBy.accessibilityId(passwordInputId)).sendKeys(password);
	}
	
	@SuppressWarnings("deprecation")
	public void submitLogin() {
		
		driver.findElement(MobileBy.accessibilityId(loginButtonId)).click();;
	}
	
	public String getErrorMsg() {
		
		return driver.findElement(By.xpath(ErrorMsgXpath)).getText();
	}
}
