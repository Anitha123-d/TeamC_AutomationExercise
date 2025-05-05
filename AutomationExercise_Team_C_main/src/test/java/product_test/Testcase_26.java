package product_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'
public class Testcase_26 extends BaseConfig {
	@Test
public void Verifyscrollupwithoutarrowbuttonandscrolldownfunctionality() throws InterruptedException {

	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20l, TimeUnit.SECONDS);
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		ReadPropertyFile propertyfilelibrary=new ReadPropertyFile();
		String url = propertyfilelibrary.readData("url");
		String expect_url=url;
		String actual_url=driver.getCurrentUrl();
		if(expect_url.equals(actual_url)) {
			System.out.println("Test passed:"+actual_url);
		}
		else {
			System.out.println("Test fail");
		}
		HomePage homepageobj=new HomePage(driver);
		//Scroll down page to bottom
		String jscode1="arguments[0].scrollIntoView(true)";
		
		JavascriptExecutor	js=(JavascriptExecutor) driver;
		js.executeScript(jscode1,homepageobj.gettext());
		//Verify 'SUBSCRIPTION' is visible
		System.out.println(homepageobj.gettext().isDisplayed());
		if(homepageobj.gettext().isDisplayed()) {
			System.out.println("subscription is displayed");
		}
		else {
			System.out.println("subscription is not displayed");
		}
		//Scroll up page to top
		
	

		String jscode2="arguments[0].scrollIntoView(true)";
		
		
		JavascriptExecutor	js1=(JavascriptExecutor) driver;
		js.executeScript(jscode2,homepageobj.getscrollingup());
		
		
		String jscode3="arguments[0].scrollIntoView(true)";
		//WebElement scrolleduppage=driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']"));
		js.executeScript(jscode3,homepageobj.getscrolleduppage());
		//// Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		System.out.println(homepageobj.getscrolleduppage().isDisplayed());
		if(homepageobj.getscrolleduppage().isDisplayed()) {
			System.out.println("scrolled up and Full-Fledged practice website for Automation Engineers  is displayed");
		}
			else 
			{
				System.out.println("scrolled up and Full-Fledged practice website for Automation Engineers is not displayed");
			}
		driver.quit();


	}

}
