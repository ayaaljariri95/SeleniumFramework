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


public class Upload_File_using_RobotClass {
	public FirefoxDriver driver;




	@BeforeTest
	public void OpenUrl() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().
		to("https://www.filestack.com/products/file-upload/?utm_source=Google&utm_medium=PPC&utm_content=Non-Brand-Exact-WW&utm_term=file%20upload%20website&utm_campaign=&utm_source=adwords&utm_medium=ppc&hsa_acc=7530412573&hsa_cam=16705391489&hsa_grp=135376987096&hsa_ad=589868952951&hsa_src=g&hsa_tgt=kwd-308621323858&hsa_kw=file%20upload%20website&hsa_mt=e&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjw-8qVBhANEiwAfjXLrkjRWHyc4u63k6XPeETMJe5gU3HlZdAYgr1QKqrQfFCXYzJcJkTBaBoCd50QAvD_BwE");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// for Implicit wait

		Thread.sleep(2000);

	}
	@Test
	public void FileUploadWithRobot() throws InterruptedException, AWTException 
	{
		String imageName = "Nature.jpg";
		String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;

		WebElement fileUploader = driver.findElement(By.className("fsp-drop-pane__drop-zone")); 
		fileUploader.click();

		// Code using robot class for file upload

		Robot robot = new Robot();

		// CTRL + C copy image path
		StringSelection selection = new StringSelection(imagePath);
		System.out.println(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		
	/*	WebElement uploadedFiles = driver.findElement(By.className("fsp-drop-pane__drop-zone")); 
		System.out.println(uploadedFiles.getText());
		Thread.sleep(3000);
		Assert.assertEquals(imageName, uploadedFiles.getText());*/


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
