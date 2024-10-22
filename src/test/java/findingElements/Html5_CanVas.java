package findingElements;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Desktop.Action;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;


public class Html5_CanVas {
	public WebDriver driver ; 
//it does not work because my browser does not support the video tag 

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", 
				System.getProperty("user.dir")+"\\DeepDivResources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://cookbook.seleniumacademy.com/html5canvasdraw.html");
		Thread.sleep(3000);
	}


	@Test
	public void testTheCanVas() throws InterruptedException, IOException {
		WebElement dtool=driver.findElement(By.id("dtool"));
		Select selectedoption=new Select(dtool);
		selectedoption.selectByIndex(2);
		Thread.sleep(5000);
		WebElement canvas=driver.findElement(By.id("imageTemp"));
		Actions builder =new Actions (driver);
		builder.clickAndHold(canvas).moveByOffset(10,50).
		moveByOffset(50, 10).moveByOffset(-10, -50).
		moveByOffset(-50,-10).release().perform();
		Thread.sleep(6000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/pause_play.png"));
		
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
