package findingElements;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.time.Clock;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Executing_javaScript_Code_with_Selenium {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


	}
	@Test

	public void Testing_The_Title() throws InterruptedException {
		
		//To Get The Title Using JavaScript Not From the HTML cod
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//We Put (String) to convert the javaScript code to string To deal with.
		String Title=(String) js.executeScript("return document.title");
		assertEquals(Title, "Google");
		
		
	}
	@Test
	public void Testing_The_Link() throws InterruptedException {
		
		//To Get The Number of Links Using JavaScript Not From the HTML cod
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		long links=(long) js.executeScript(
				"var inputs = document.getElementsByTagName('A');"+
				 " return inputs.length");
		//here:1)define a variable in jacaScript not in java with Selenium 
		//2)return the length using javaScript
		System.out.println(links);
		assertEquals(links, 17);
		
		
	}




	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
