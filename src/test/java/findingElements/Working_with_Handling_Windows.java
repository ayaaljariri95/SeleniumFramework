package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_Handling_Windows {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().fullscreen();


	}
	/*@Test(enabled = false)
	public void TestingWindowUsingTitle() throws InterruptedException {
		//get the window handle and its title  where am already opened 
		String CurrentHandle=driver.getWindowHandle();
		String t=driver.getTitle();
		//print the window handle and the title
		System.out.println(t);
		System.out.println(CurrentHandle);
		//find the element where am going to click on to view the new window 
		driver.findElement(By.id("visitbutton")).click();
		//for iterative to get handling to the window am going to open
		for (String windowID : driver.getWindowHandles()) {
			//varialbe window id with string data type. to get the window handles from both windows 
			String title = driver.switchTo().window(windowID).getTitle();
			//here am going to switch to the second window with its title
			if(title.equals("Visit Us") ) {
				//making sure that the title i have been opened is the same title with what i expected
				assertEquals(driver.getTitle(), "Visit Us");
				//close the window 
				driver.close();
				break;


			}


		}
		//go back to the window i started with 
		driver.switchTo().window(CurrentHandle);

	}*/

	/*@Test(priority=1,enabled=false)

	public void test2 () throws InterruptedException {
		String handling = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		for (String  Hand : driver.getWindowHandles())
		{
		String tit=driver.switchTo().window(Hand).getTitle();

		if(tit.equals("Visit Us")) {

			assertEquals(driver.getTitle(), "Visit Us");
			System.out.println("They are equals");
			break;
		}	
		driver.switchTo().window(handling);}

	}*/
	@Test
	public void testByName() throws InterruptedException {
		String handling = driver.getWindowHandle();
		Thread.sleep(2000);

		driver.findElement(By.id("helpbutton")).click();
		//Thread.sleep(2000);
		//By Its Name:
		driver.switchTo().window("HelpWindow");
		//Thread.sleep(2000);

		assertEquals(driver.getTitle(),"Help");
		//Thread.sleep(2000);

		System.out.println(driver.getTitle());
		//Thread.sleep(2000);

		driver.close();
		//Thread.sleep(2000);

		driver.switchTo().window(handling);

	}
	@Test
	
	public void testVisitByName() throws InterruptedException {
		String handling = driver.getWindowHandle();
		Thread.sleep(2000);

		driver.findElement(By.id("visitbutton")).click();
		//Thread.sleep(2000);
		driver.switchTo().window("VisitUsWindow");
		//Thread.sleep(2000);

		assertEquals(driver.getTitle(),"Visit Us");
		//Thread.sleep(2000);

		System.out.println(driver.getTitle());
		//Thread.sleep(2000);

		driver.close();
		//Thread.sleep(2000);

		driver.switchTo().window(handling);

	}



























	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
