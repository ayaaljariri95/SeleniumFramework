package findingElements;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Taking_Screenshots {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.navigate().to("https://www.amazon.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


	}
	@Test
	public void Test_Taking_ScreenShots() throws InterruptedException {

		WebElement searchTest=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextboxx\"]"));
		//i wrote the xpath in a wrong way to make the screen shot pass 
		//it was:
		//WebElement searchTest=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

		searchTest.sendKeys("MakeUp");
		searchTest.submit();
		Thread.sleep(2000);
		assertTrue(driver.getTitle().contains("Amazon.com : MakeUp"));
		System.out.println(driver.getTitle());

	}
	
	@AfterMethod
	public void TakeScreenShot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination in my project
			File DestFile=new File("./Screenshots/" + result.getName()+".png");

			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		}
		//after the refresh , the test_taking-screenshots.png is created in the screenshots folder 
		
	}




	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
