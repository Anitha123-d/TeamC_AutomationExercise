package product_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PageRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_08 extends BaseConfig {
	
		@Test
		public void VerifyAll_Products_and_product_detail_page() throws InterruptedException {


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
		
		// Verify user is navigated to ALL PRODUCTS page and product list is visible successfully
		boolean productresult = productobj.getverifyallproductspage().isDisplayed();
		if(productresult) {
			System.out.println("All products page and product list is displayed succesfully");
		}else {
			System.out.println("All products page and product list is not displayed succesfully");

		}
		Thread.sleep(2000);
		
		//Click on 'View Product' of first product
		String jscode1 = "arguments[0].scrollIntoView(true)";
		String jscode2 = "window.scrollBy(0,500)";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(jscode2);
		js.executeScript(jscode1, productobj.getviewproduct());
		productobj.getviewproduct().click();
		Thread.sleep(2000);
		
		//User is landed to product detail page
		boolean productdetailresult = productobj.getproductdetailpage().isDisplayed();
		if(productdetailresult) {
			System.out.println("User is able to navigate to the product detail page");
		}else {
			System.out.println("User is not able to navigate to the product detail page");
		}
		
		//Verify that product detail is visible: product name, category, price, availability, condition, brand
		System.out.println(productobj.getverifieddetails().getText());
		
		driver.quit();
	}

}