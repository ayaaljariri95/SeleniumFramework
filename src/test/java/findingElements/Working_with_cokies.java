package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.SetOfIntegerSyntax;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.debugger.Debugger.SetBreakpointByUrlResponse;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_cokies {
	public ChromeDriver driver;


	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//DeepDivResources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.lambdatest.com/");
		//driver.manage().window().fullscreen();
		//get these info from : https://www.lambdatest.com/blog/handling-cookies-in-selenium-webdriver/


	}

	@Test
	public void Testcockies() throws InterruptedException
	{
		//To get all cookies from the web site
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Set<Cookie> cookiesList =  driver.manage().getCookies();
		System.out.println("Number of cookies:"+cookiesList.size());
		//Thread.sleep(2000);
		//to read the cookies i have to iterate them by for
		//for(Cookie getcookies :cookiesList) {
		// System.out.println(getcookies);
		// Thread.sleep(2000);

		//}
		//to read the cookies i have to iterate them by Iterator & while

		Iterator<Cookie> Itr=cookiesList.iterator();
		while(Itr.hasNext())
		{
			Cookie cc=Itr.next();
			System.out.println(cc.getName());
			System.out.println(cc.getPath());
			System.out.println(cc.getValue());
			System.out.println(cc.getDomain());
			System.out.println(cc.getExpiry());

		}
	/*	Cookie cname = new Cookie("myCookie", "12345678999");
		Thread.sleep(2000);

		driver.manage().addCookie(cname);

		//retrieve the cookies to view the newly added cookie
		cookiesList =  driver.manage().getCookies();
		Thread.sleep(2000);

		for(Cookie getcookies :cookiesList) {
			System.out.println(getcookies );}*/
	}		



	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
