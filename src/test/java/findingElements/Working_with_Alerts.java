package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class Working_with_Alerts {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().fullscreen();


	}
	@Test(priority = 1)
	public void AlertTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement amsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		amsg.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	@Test(priority = 2)
	public void ConfermTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		WebElement bmsg=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		bmsg.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	
	}
	@Test(priority = 3 )
	public void promptTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		WebElement cmsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		cmsg.click();
		//Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Hello from selenium webdriver");
		String Themsg=alert.getText();
		System.out.println(Themsg);
		//Thread.sleep(3000);
		alert.accept();
		WebElement result=driver.findElement(By.id("result"));
		Assert.assertEquals(result.getText(),"You entered: Hello from selenium webdriver");
		System.out.println("it works");	
		//Thread.sleep(3000);


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
