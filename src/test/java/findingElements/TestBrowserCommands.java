package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {
	 public ChromeDriver driver;


	  @BeforeTest
	  public void OpenUrl() {
		
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriver.exe");
 		  driver = new ChromeDriver();
 		  driver.navigate().to("https://www.youtube.com");
 		 // System.out.println(driver.getCurrentUrl());
 		  //Browser window command works in a correct way in FireFox WebDriver , but does not work here in chrome 
			
	}
	@Test
	public void TestBrowserCommandss() {


		//driver.navigate().to("https://the-internet.herokuapp.com/login");

	/*	System.out.println(driver.getCurrentUrl());

		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());


		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());*/
		WebElement sub=driver.findElement(By.id("search"));
		System.out.println("You are in search field");
		sub.sendKeys("drivers");
		sub.submit();

	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
