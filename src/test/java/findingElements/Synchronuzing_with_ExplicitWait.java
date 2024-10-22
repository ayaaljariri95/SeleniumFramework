package findingElements;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Synchronuzing_with_ExplicitWait {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com");
		driver.manage().window().fullscreen();


	}
	
	 
	  
	@Test(priority = 1)
	public void TestExplicitTime() 
	{
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
		search.submit();
		//Defining WebDriverWait:
		WebDriverWait waitMe=new WebDriverWait(driver, Duration.ofSeconds(40));
		//Defining The Expected Conditions:
		waitMe.until(ExpectedConditions.titleContains("Selenium"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
		//Assert.assertEquals(driver.getTitle(), "Selenium -");
		
		
		
		
		
		
	}


	
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
