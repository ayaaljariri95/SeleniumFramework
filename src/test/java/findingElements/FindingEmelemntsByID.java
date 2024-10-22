package findingElements;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FindingEmelemntsByID {
	
	 public ChromeDriver driver;

	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriver.exe");
		 driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
			
	}
	@Test
	public void FindTheElement() {
	/*WebElement userElement=driver.findElement(By.id("username"));	
	WebElement passwordElement=driver.findElement(By.id("password"));
	System.out.println(userElement);
	System.out.println(passwordElement);*/
	//List<WebElement> links = driver.findElements(By.tagName("a"));
	
	
		//System.out.println(links.size());
		//Assert.assertEquals(2,links.size());
		//System.out.println("Absoloutly 2 links");
		
		//for (WebElement LK : links) {
			
			//LK.getAttribute("href");
			//System.out.println(LK.getText());
		/*WebElement linkText = driver.findElement(By.linkText("A/B Testing"));
		System.out.println(linkText.getAttribute("href"));
		WebElement linkPartialText = driver.findElement(By.partialLinkText("File "));
		//here it will give me the first match 
		System.out.println(linkPartialText.getAttribute("href"));*/
		//WebElement xPathFindMe0=driver.findElement(By.xpath("//input[//*[@id=\"username\"]]"));

		
		WebElement xPathFindMe1=driver.findElement(By.xpath("//input[@id='username']"));
		System.out.println(xPathFindMe1.getTagName());
		//System.out.println(xPathFindMe0.getTagName());

			
		}
		
		
	
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
