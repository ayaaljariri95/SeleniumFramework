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

public class Working_with_DragAndDrop {
	 public FirefoxDriver driver;


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
		driver.manage().window().fullscreen();
		
			
	}
	@Test
	public void DoubleClick() throws InterruptedException {
	
		Actions action= new Actions(driver);
		WebElement me = driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement you=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
		action.dragAndDrop(me, you);
		action.perform();
		Thread.sleep(3000);

		WebElement trust=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
		trust.getText();
		Assert.assertEquals(trust.getText(),"Dropped!");
		System.out.println("You are dropped the statment successfully");
		Thread.sleep(3000);
		

	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
