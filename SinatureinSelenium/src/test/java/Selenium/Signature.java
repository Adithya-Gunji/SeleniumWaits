package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Signature {
  public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.signwell.com/online-signature/draw/");
		WebElement Sign = driver.findElement(By.id("canvas_signature"));
		Actions actions = new Actions(driver);
		//actions.dragAndDropBy(Sign,200,0).build().perform();
	    actions.moveToElement(Sign).perform();
		actions.clickAndHold(Sign).perform();
		actions.moveByOffset(150, 50).perform();
		actions.moveToElement(Sign).perform();
		actions.clickAndHold(Sign).perform();
		actions.moveByOffset(100, 50).perform();
		actions.moveToElement(Sign).perform();
		actions.clickAndHold(Sign).perform();
		actions.moveByOffset(170, 50).perform();
		actions.moveToElement(Sign).perform();
		Thread.sleep(5000);
		//driver.close();     
	}

}
