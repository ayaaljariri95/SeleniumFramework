package findingElements;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;


public class UploadFileUsingRobotForMySelf {
	public FirefoxDriver driver;
    private static String filePath = System.getProperty("user.dir") + "\\Uploads\\my Image.jpeg";




	@BeforeTest
	public void OpenUrl() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().
		to("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// for Implicit wait

		Thread.sleep(2000);

	}
	
	@Test
	public void TestingTheUploadFile() throws InterruptedException {
		 driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
	        uploadFileWithRobot(filePath);
	       
	        //I added sleep to see the result with my eyes. If you want you can remove below line.
	        Thread.sleep(2000);
	}
	  public void uploadFileWithRobot (String imagePath) {
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
