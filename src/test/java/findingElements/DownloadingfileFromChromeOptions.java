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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class DownloadingfileFromChromeOptions {
	public WebDriver driver ; 
	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
	public  static ChromeOptions options ;

	public static ChromeOptions chromeOption() 
	{
		 options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options ; 		
	}
	
	  @BeforeClass
	  public void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriver.exe");
		 driver  = new ChromeDriver(chromeOption());
		//driver = new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/download");
			
	}
	  @Test
	  public void TestChromeOptions() throws InterruptedException {
		  
		  WebElement download=driver.findElement(By.linkText("sample-zip-file.zip"));
		  Thread.sleep(3000);
		  download.click();
		  Thread.sleep(4000);
		  //For here i can download the file to my main pc 
		  //but if i wanna download the file to my workspace i need chromeOptions .

		  
	  }
	  
	  
	  
	  
	  @AfterClass
		public void goOut() {
			driver.quit();
		}
}
