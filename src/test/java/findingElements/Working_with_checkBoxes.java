package findingElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Working_with_checkBoxes {
	public FirefoxDriver driver;



	@BeforeTest
	public void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//DeepDivResources//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");


	}
	/*private boolean IsPresent(By by) {
		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;	}


	} */
	private boolean IsPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;		}
	}


	@Test
	public void testtheExistingofTheElement() throws InterruptedException {
		if (IsPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))){
			WebElement exist=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if(!exist.isSelected()) {
				Thread.sleep(2000);

				exist.click();
				System.out.println("I have been select the checkbox right now");
			}

		}
		else {
			Assert.fail("The Checkbox doesn't exist");
		}

		Thread.sleep(2000);
	}



	@Test(enabled =false)

	public void CheckboxTest() throws InterruptedException {

		/* WebElement checkTheForm=driver.findElement(By.id("checkboxes"));
		  WebElement CheckMe=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		  System.out.println(CheckMe.isSelected());
		  CheckMe.click();
		  System.out.println(CheckMe.isSelected());
		  CheckMe.click();
		  System.out.println(CheckMe.isSelected());
		  if (CheckMe.isSelected()) {
			  System.out.println("The CheckBox is already selected");

		  }else {
			CheckMe.click();
			  System.out.println("The CheckBox selected Now");}*/

	}



	//  Thread.sleep(2000);//"To make the website running more slowly

	@AfterTest
	public void goOut() {
		driver.quit();
	}

}
