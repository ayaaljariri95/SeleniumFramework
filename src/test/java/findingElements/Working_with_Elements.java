package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_Elements {
	 public FirefoxDriver driver;


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.manage().window().fullscreen();
		
			
	}
	@Test
	public void FindTheElement() {
	
	/*WebElement passwordElement=driver.findElement(By.id("password"));
	WebElement userElementName=driver.findElement(By.name("username"));	
	WebElement passwordElementName=driver.findElement(By.name("password"));
	System.out.println(userElement);
	System.out.println(passwordElement);
	System.out.println(userElementName.getTagName());
	System.out.println(passwordElementName.getTagName());
	WebElement LoginName = driver.findElement(By.name("login"));
	//Assert.assertEquals(LoginName,"LoginMe");
	System.out.println(LoginName);*/
	/*WebElement finding = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
	finding.click();
	WebElement Deleting =driver.findElement(By.className("added-manually"));
	Deleting.click();*/
		WebElement element = driver.findElement(By.id("username"));
		element.sendKeys("tomsmith");
		WebElement element1 = driver.findElement(By.id("password"));
		element1.sendKeys("SuperSecretPassword!");
		WebElement element2 = driver.findElement(By.className("radius"));
		element2.click();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
		System.out.println("You are logged in Successfully");
		WebElement success=driver.findElement(By.tagName("h4"));
		assertEquals(success.getText(),"Welcome to the Secure Area. When you are done click logout below.");
		System.out.println("You are logged in Successfully");
		assertTrue(success.getText().contains("Secure Area"));
		System.out.println("You are passed");





		
		

	
	


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
