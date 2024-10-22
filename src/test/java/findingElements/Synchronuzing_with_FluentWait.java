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

public class Synchronuzing_with_FluentWait {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


	}



	@Test(priority = 1)
	public void TestExplicitTime() 
	{
		WebElement search=driver.findElement(By.linkText("Page 4"));
		search.click();

		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(20)).
				pollingEvery(Duration.ofSeconds(2)).
				ignoring(NoSuchElementException.class);
		
		WebElement msg=wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				
				return t.findElement(By.id("page4"));
			}
		});
		 assertTrue(msg.getText().contains("Nunc nibh tortor"));
		
		


	}



	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
