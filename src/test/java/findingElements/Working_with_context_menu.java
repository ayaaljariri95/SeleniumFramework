package findingElements;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Clock;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_context_menu {
	public FirefoxDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


	}
	@Test
public void Test_Context_Menu() throws InterruptedException {
		
		WebElement clickOnMe=driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		WebElement CopyMe=driver.findElement(By.xpath("/html/body/ul/li[3]/span"));
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.contextClick(clickOnMe).moveToElement(CopyMe).click().perform();
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "clicked: copy");
		alert.accept();
		
		Thread.sleep(3000);

		
		
	}




	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
