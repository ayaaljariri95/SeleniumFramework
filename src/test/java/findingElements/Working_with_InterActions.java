package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_InterActions {
	 public FirefoxDriver driver;


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		driver.manage().window().fullscreen();
		
			
	}
	@Test
	public void DoubleClick() throws InterruptedException {
	
		Actions action= new Actions(driver);
		WebElement me = driver.findElement(By.id("message"));
		//System.out.println(me.getCssValue("background-color"));
		//rgb(0, 0, 255)=>blue
		Assert.assertEquals(me.getCssValue("background-color"),"rgb(0, 0, 255)");
		action.doubleClick(me).perform();
		//System.out.println(me.getCssValue("background-color"));
		//rgb(255, 255, 0)=>yellow
		Assert.assertEquals(me.getCssValue("background-color"),"rgb(255, 255, 0)");

		Thread.sleep(3000);
		

	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
