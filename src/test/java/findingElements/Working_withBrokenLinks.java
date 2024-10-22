package findingElements;


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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class Working_withBrokenLinks {
	public FirefoxDriver driver;




	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");


	}

	@Test
	public void testAllBrokenLinks() throws IOException {
		//to get all links from the web page
		List<WebElement> allLinks =driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : "+allLinks.size());
		for(int i =0 ; i<allLinks.size();i++) {
			WebElement ll=allLinks.get(i);
			String url = ll.getAttribute("href");
			Verifylinks(url);
		}




	}
	public static void Verifylinks(String urlLink) throws IOException {
		try {
			URL urlVerify=new URL(urlLink);
			//Create a connection using url object
			HttpURLConnection httpconnection = (HttpURLConnection) urlVerify.openConnection();
			httpconnection.setConnectTimeout(2000);
			httpconnection.connect();
			//use getRsponse code method to get the response code
			if(httpconnection.getResponseCode()==200) {
				

				System.out.println( urlLink+" - " + httpconnection.getResponseMessage());
				//to print the msg(ok,unauthorized ..)
				
			}
			if(httpconnection.getResponseCode()==404) {
				System.out.println(httpconnection.getResponseMessage());
				//to print the msg(ok,unauthorized ..)
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}



	}
















	//  Thread.sleep(2000);//"To make the website running more slowly

	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
