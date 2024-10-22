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

public class Scrolling_Down_using_js {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.navigate().to("http://www.amazon.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


	}
	@Test

	public void Scrolling_Down() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(3000);
		WebElement logo=driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		//we used the cssSelector , because it does not have any words except the class but we can't use it beacuse it is compound 
		Assert.assertTrue(logo.isDisplayed());
		//System.out.println(logo.getText());


		
	
	
	
		
		
	}




	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
