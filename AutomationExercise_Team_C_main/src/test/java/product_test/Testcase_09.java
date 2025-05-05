package product_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PageRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_09 extends BaseConfig{
	@Test
		public void  SearchProduct() throws InterruptedException {

		// Verify that home page is visible successfully
		HomePage homepageobj = new HomePage(driver);
		boolean result = homepageobj.getverifiedhomepage().isDisplayed();
		if (result) {
			System.out.println("Home page is verified");
		} else {
			System.out.println("Home page is not verified");
		}

		// Click on 'Products' button
		ProductPage productobj = new ProductPage(driver);
		productobj.getproductspage().click();

		// Verify user is navigated to ALL PRODUCTS page and product list is visible
		// successfully
		boolean productresult = productobj.getverifyallproductspage().isDisplayed();
		if (productresult) {
			System.out.println("All products page and product list is displayed succesfully");
		} else {
			System.out.println("All products page and product list is not displayed succesfully");

		}
		Thread.sleep(2000);

		// Enter product name in search input and click search button
		productobj.getsearchproduct().sendKeys("women");
		productobj.getsearch().click();
		Thread.sleep(2000);

		// Verify 'SEARCHED PRODUCTS' is visible
		boolean searchedproductresult = productobj.getverifiedsearchedproduct().isDisplayed();
		if (searchedproductresult) {
			System.out.println("Searched products is displayed");
		} else {
			System.out.println("Searched products is not displayed");
		}

		// Verify all the products related to search are visible
		boolean relatedproductsresult = productobj.getverifiedrelatedproduct().isDisplayed();
		if (relatedproductsresult) {
			System.out.println("All the related products are displayed");
		} else {
			System.out.println("All the related products are not displayed");
		}
		
		driver.quit();

	}

}