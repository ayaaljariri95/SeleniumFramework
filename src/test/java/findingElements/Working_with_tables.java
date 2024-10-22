package findingElements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_tables {
	 public FirefoxDriver driver;
	


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		
			
	}
	  @Test
	public void CheckboxTest() throws InterruptedException {
	
		 
		  WebElement table=driver.findElement(By.id("table1"));
		  List<WebElement> rows = table.findElements(By.tagName("tr"));
		  System.out.println( rows.size());
		  assertEquals(rows.size(),5);
		  System.out.println("You are Gussed the wright number of rows");
		  for (WebElement rowsP : rows) {
			  List<WebElement> Col = rowsP.findElements(By.tagName("td"));
			  for (WebElement colsP : Col) {
				  System.out.println(colsP.getText()+ "\t" );
	
			}
			  System.out.println();
		}
		 
		//  Thread.sleep(2000);//"To make the website running more slowly
	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
