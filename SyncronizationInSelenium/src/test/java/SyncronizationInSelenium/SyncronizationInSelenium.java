package SyncronizationInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SyncronizationInSelenium {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
    	WebDriverManager.edgedriver().setup();// To Avoid version control problem(Browser update)
    	driver=new EdgeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //implicitWait -- is always applied globally i.e available for all the webElements
    	//dynamic in nature
    	//it can be changed anywhere and at any time in your code
    	driver.get("https://www.facebook.com/logoin");
    	
    	WebElement email = driver.findElement(By.xpath("//div/div[2]/div[2]/form/div/div[1]/div[1]/input"));
    	WebElement pwd = driver.findElement(By.xpath("//div/div[2]/div[2]/form/div/div[1]/div[3]/input"));
    	
    	WebElement loginbutton=driver.findElement(By.id("loginbutton"));
    	
    	SendKeys(driver,email,10,"Adithya@techbulls.co.in");
    	SendKeys(driver,pwd,5,"Akhil123@");
    	
    	WebElement forgotAC=driver.findElement(By.xpath("//div/div[1]/div/div[2]/form/table/tbody/tr[3]/td[2]/div/a"));
    	clickOn(driver,forgotAC,5);
	}

	//Explicit Wait:
	//1.no explicit keyword or method
	//2.available with WebDriverWait with some ExpectedConditions
	//3.specific to element
	//4.Dynamic in nature (Thread.sleep is static it wait Entire time what we was given)
	//5.we should never use implicit and ExplicitWait together.
	// Selenium WD will wait for the element first because of IMPLICIT WAIT and EXPLICIT WAIT will be applied
	//Hence total sync wait will be increased for Each element 

	public static void SendKeys(WebDriver driver, WebElement element, int timeout, String value) {
	    new WebDriverWait(driver, timeout).
	    until(ExpectedConditions.visibilityOf(element));
	    element.sendKeys(value);
	}
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
	    new WebDriverWait(driver, timeout).
	    until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
		
	}
}
