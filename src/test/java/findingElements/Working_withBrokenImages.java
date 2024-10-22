package findingElements;


import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class Working_withBrokenImages {
	public FirefoxDriver driver;
	public 	int iBrokenImageCount;




	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");


	}
	
	@Test
	public void TestBrokenImages() {
		iBrokenImageCount=0;
		
		List<WebElement> image_list = driver.findElements(By.tagName("img"));
		for (WebElement imgElement:image_list) {
			if(imgElement != null) {
				Verify(imgElement);
			}
			
			
		}
		System.out.println("Total no. of inavalid images are: "+ iBrokenImageCount);
		
		
		
		
	}
	
	public void Verify(WebElement image) {
		HttpClient client =HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(image.getAttribute("src"));

		try {		
			HttpResponse response = ((org.apache.http.client.HttpClient) client).execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
			{
				System.out.println(image.getAttribute("outerHTML") + " is broken.");
				iBrokenImageCount++;
			}
			
		} catch (Exception e) {
		}

		
		
	}

			
		


		


	





	//  Thread.sleep(2000);//"To make the website running more slowly

	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
