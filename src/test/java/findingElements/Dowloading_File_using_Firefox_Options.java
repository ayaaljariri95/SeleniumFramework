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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;


public class Dowloading_File_using_Firefox_Options {
	public FirefoxDriver driver;

	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
	//public static String downloadPath = "./Downloads/";
	public static FirefoxOptions firefoxOption() 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}



	@BeforeTest
	public void OpenUrl() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		//i have to put firefoxoptions in brackets to tell him that you to download the file in my path i gave it to you 
		driver = new FirefoxDriver(firefoxOption());
		driver.navigate().to("http://the-internet.herokuapp.com/download");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// for Implicit wait

		Thread.sleep(2000);

	}

	@Test
	public void TestDownloadFile() throws InterruptedException 
	{
		driver.findElement(By.linkText("some-file.txt")).click();
		System.out.println(downloadPath);
		//	Thread.sleep(3000);
		//C:\Users\XJariri\eclipse-workspace\DeeeeeeeeeeeeeeepDiv\Downloads


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
