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

public class Working_with_Frames {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


	}
	@Test

	public void TestTheFrames() throws InterruptedException {
		driver.switchTo().frame(2) ;
		WebElement twitter=driver.findElement(By.tagName("p"));
		Assert.assertEquals(twitter.getText(),"This is Right Frame");
		System.out.println(twitter.getText());
		Thread.sleep(3000);
		
		
		
		
		
	}




	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
