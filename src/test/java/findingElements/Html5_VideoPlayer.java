package findingElements;


import static org.testng.Assert.assertEquals;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;


public class Html5_VideoPlayer {
	public WebDriver driver ; 
//it does not work because my browser does not support the video tag 

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\DeepDivResources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5video.html");
		Thread.sleep(3000);
	}


	@Test
	public void testHTML5VideoPlayer() throws Exception {
		// Get the HTML5 Video Element
		WebElement videoPlayer = driver.findElement(By.id("vplayer"));

		// We will need a JavaScript Executor for interacting with Video
		// Element's methods and properties for automation
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		Thread.sleep(6000);

		// Get the Source of Video that will be played in Video Player
		String source = (String) jsExecutor.executeScript(
				"return arguments[0].currentSrc;", videoPlayer);
		// Get the Duration of Video
		long duration = (Long) jsExecutor.executeScript(
				"return arguments[0].duration", videoPlayer);

		// Verify Correct Video is loaded and duration
		Assert.assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		Assert.assertEquals(25, duration);

		// Play the Video
		jsExecutor.executeScript("return arguments[0].play()", videoPlayer);
		Thread.sleep(6000);


		Thread.sleep(5000);

		// Pause the video
		//jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

		// Take a screenshot for later verification
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/pause_play.png"));
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
