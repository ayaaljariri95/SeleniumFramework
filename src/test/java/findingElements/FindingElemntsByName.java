package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingElemntsByName {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriverneww.exe");
		WebDriver driverr= new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");

	}
	@Test
	public void FindTheElement() {
		WebElement userElement=driver.findElement(By.id("email"));
		userElement.sendKeys("0791558435");
		WebElement passElement=driver.findElement(By.id("passContainer"));

		passElement.sendKeys("Fatimalove");
		WebElement login=driver.findElement(By.xpath("//*[@id=\"u_0_d_lq\"]"));
		login.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*WebElement passwordElement=driver.findElement(By.id("password"));
	WebElement userElementName=driver.findElement(By.name("username"));	
	WebElement passwordElementName=driver.findElement(By.name("password"));
	System.out.println(userElement);
	System.out.println(passwordElement);
	System.out.println(userElementName.getTagName());
	System.out.println(passwordElementName.getTagName());
	WebElement LoginName = driver.findElement(By.name("login"));
	//Assert.assertEquals(LoginName,"LoginMe");
	System.out.println(LoginName);
		WebElement Btm = driver.findElement(By.cssSelector("button.radius"));
		System.out.println(Btm.getTagName());
		System.out.println(Btm.getText());
		WebElement CssSelector = driver.findElement(By.cssSelector("div.row"));
		//we are using cssSelector(tagName.ClassName)//
		System.out.println(CssSelector.getTagName());
		WebElement CssSelector2 = driver.findElement(By.cssSelector("input#username"));
		//we are using cssSelector (tagName#name), because we don't have a Class.
		System.out.println(CssSelector2.getTagName());
		WebElement CssSelector3 = driver.findElement(By.cssSelector("input#password"));
		System.out.println(CssSelector3.getTagName());*/
		
		
		
		
		
		


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
