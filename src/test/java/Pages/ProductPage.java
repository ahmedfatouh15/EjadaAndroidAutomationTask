package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;


public class ProductPage {
	
    public static AppiumDriver driver;
	
	public ProductPage(AppiumDriver driver){
        this.driver = driver;
    }
	
	//Selectors
	private String pageTitleXpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView";
	private String sideMenuXpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView";
	private String appLogoXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]";
	
	//Functions
	@SuppressWarnings("deprecation")
	public String getPageTitle() {
		
		return driver.findElement(By.xpath(pageTitleXpath)).getText();
	}
	
	public boolean isPageLoaded() {
		
		return driver.findElement(By.xpath(pageTitleXpath)).isDisplayed()
				&& driver.findElement(By.xpath(sideMenuXpath)).isDisplayed()
				&& driver.findElement(By.xpath(appLogoXpath)).isDisplayed();
	}
}
