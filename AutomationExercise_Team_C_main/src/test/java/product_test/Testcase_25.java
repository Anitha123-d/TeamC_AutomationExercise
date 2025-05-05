package product_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'
public class Testcase_25 extends BaseConfig {
	@Test
public void Verifyscrollupusingarrowbuttonandscrolldownfunctionality() throws InterruptedException {
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		ReadPropertyFile propertyfilelibrary=new ReadPropertyFile();
		String url = propertyfilelibrary.readData("url");
		
	
		//. Scroll down page to bottom
		String jscode1="arguments[0].scrollIntoView(true)";
		HomePage homepageobj=new HomePage(driver);
		//Verify 'SUBSCRIPTION' is visible
		JavascriptExecutor	js=(JavascriptExecutor) driver;
		js.executeScript(jscode1,homepageobj.gettext());
		System.out.println(homepageobj.gettext().isDisplayed());
		if(homepageobj.gettext().isDisplayed()) {
			System.out.println("subscription is displayed");
		}
		else {
			System.out.println("subscription is not displayed");
		}
		
		//Click on arrow at bottom right side to move upward
		homepageobj.getuparrow().click();
		
		//Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		
		System.out.println(homepageobj.getpracticepage().isDisplayed());
		if(homepageobj.getpracticepage().isDisplayed()) {
			System.out.println("Full-Fledged practice website for Automation Engineers  is displayed");
		}
			else 
			{
				System.out.println("Full-Fledged practice website for Automation Engineers is not displayed");
			}
		driver.quit();
		
	}

}
