package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingElemntsMethodAtWhole {
	 public ChromeDriver driver;


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriver.exe");
		 driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
			
	}
	@Test
	public void FindTheElement() {
		/*WebElement btn=driver.findElement(By.tagName("button"));
		btn.click();
		WebElement username=driver.findElement(By.tagName("input"));*/
		//WebElement table=driver.findElement(By.id("table2"));
		


		List<WebElement> rows =driver.findElements(By.tagName("td"));
		System.out.println(rows.size());
		assertEquals(rows.size(), 48);
		//here it will pass, because it will handle the tr and /tr are the same . 
		//so if we have only 5 tr's , he ill calculate them as 10 . 
		
		


	
	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
