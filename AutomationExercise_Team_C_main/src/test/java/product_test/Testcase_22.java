package product_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'

public class Testcase_22 extends BaseConfig {
	@Test
public void Addtocartfromtherecommendeditems() {
	
		driver.manage().timeouts().implicitlyWait(20l, TimeUnit.SECONDS);
		//Scroll to bottom of page
		String jscode1="arguments[0].scrollIntoView(false)";
		HomePage homepageobj=new HomePage(driver);
		JavascriptExecutor	js=(JavascriptExecutor) driver;
		//Verify 'RECOMMENDED ITEMS' are visible
		js.executeScript(jscode1,homepageobj.getrecommendeditems());
		System.out.println(homepageobj.getrecommendeditems().isDisplayed());
		if(homepageobj.getrecommendeditems().isDisplayed()) {
			System.out.println("recommemnded items are displayed");
		}
		else {
			System.out.println("recommemnded items are not displayed");
		}
		//Click on 'Add To Cart' on Recommended product
		homepageobj.getaddtocart().click();
		//Click on 'View Cart' button
		homepageobj.getviewcart().click();
		//Verify that product is displayed in cart page
	CartPage cartpageobj=new CartPage(driver);
		
		System.out.println(cartpageobj.getdesiredproduct().isDisplayed());
		if(cartpageobj.getdesiredproduct().isDisplayed()) {
			System.out.println("desired product is displayed");
		}
		else {
			System.out.println("desired product is not displayed");
		}
		driver.quit();
	}

}
