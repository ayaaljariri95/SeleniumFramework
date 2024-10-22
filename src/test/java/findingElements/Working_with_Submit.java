package findingElements;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_Submit {
	 public FirefoxDriver driver;
	


	  @BeforeTest
	  public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
		
			
	}
	  @Test
	public void FindTheElement() throws InterruptedException {
	/*	InterruptedException
		System.out.println(sub.getTagName());
		System.out.println(sub.getText());
		System.out.println(sub.getClass());*/
		//Select sel= new Select(driver.findElement(By.id("dropdown")));
		//here the select is a class , so we have to make an object from this class<Select>
		WebElement optionList = driver.findElement(By.id("dropdown"));
		Select selectedoption=new Select(optionList);
		//Assert.assertFalse(selectedoption.isMultiple());
		//To make sure that we can't choose more than one option 
		Assert.assertEquals(selectedoption.getOptions().size(), 3);
		selectedoption.selectByValue("1");
		//We can select by:1)SelectByIndex 2)SelectbyVisible/text 3)SelectByValue
		Assert.assertEquals(selectedoption.getFirstSelectedOption().getText(), "Option 1");
		Thread.sleep(2000);//"To make the website running more slowly
		
		
		
		
	
		
	
	
		


	}
	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
