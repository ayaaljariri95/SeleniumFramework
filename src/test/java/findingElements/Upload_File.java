package findingElements;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;





public class Upload_File {
	public FirefoxDriver driver;




	@BeforeTest
	public void OpenUrl() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		Thread.sleep(2000);
		
	}

	@Test
	public void uploadingFile() throws InterruptedException {
		//Zab6at ba3ed Mo3anaaaaaaaaaat "AlHamdulleleah <3"
		String ImageName="Nature.jpg";
	    File file = new File(System.getProperty("user.dir") + "/Uploads/" + ImageName);
	    Utils.log("file exists: " + file.exists());

	    String imagePath = file.getAbsolutePath();
	    System.out.println(imagePath);
	    WebElement input = driver.findElement(By.name("file"));
	    input.sendKeys(imagePath);
		//String ImagePath=System.getProperty("user.dir")+"/Uploads/Nature.jpg";
		Thread.sleep(3000);
		
		//while the type of the fileupload is "file"=> so i can uploading the photo using sendKeys method 
		//fileUpload.sendKeys(ImagePath);
		//here i sent the photo 
		WebElement SubmitTheFile = driver.findElement(By.id("file-submit"));
		//now i have to click on submit
		SubmitTheFile.click();
		WebElement makingSureFromUploading = driver.findElement(By.id("uploaded-files"));
		Thread.sleep(3000);

		Assert.assertEquals(makingSureFromUploading.getText(), ImageName);
		System.out.println(makingSureFromUploading.getText());
	}

	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
