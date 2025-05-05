package product_test;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PageRepository.ProductPage;

public class Testcase_19 extends BaseConfig {
	@Test
	public void View_Cart_Brand_Products() {

		// Implicitly wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create an object for product page
		ProductPage product1 = new ProductPage(driver);

		// Click on 'Products' button
		product1.getproductspage().click();

		// Create an object for home page
		HomePage homepage = new HomePage(driver);

		// Verify that Brands are visible on left side bar
		boolean result1 = homepage.getbrand().isDisplayed();
		if (result1) {
			System.out.println("Brands Products are displayed");
		} else {
			System.out.println("Brands Products are not displayed");
		}
		String jscode1 = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode1, homepage.getpolo());

		// Click on any brand name
		homepage.getpolo().click();

		// Verify that user is navigated to brand page and brand products are displayed
		String expect_url1 = "https://www.automationexercise.com/brand_products/Polo";
		String actual_url1 = driver.getCurrentUrl();
		System.out.println(actual_url1);
		if (expect_url1.equals(actual_url1)) {
			System.out.println("URL Verified : Test pass");
		} else {
			System.out.println("URL Verified: Test fail");
		}

		boolean result2 = homepage.getpolopage().isDisplayed();
		if (result2) {
			System.out.println("Polo Brand Products page is displayed");
		} else {
			System.out.println("Polo Products page is not displayed");
		}
		String jscode11 = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript(jscode11, homepage.getHandM());

		// On left side bar, click on any other brand link
		homepage.getHandM().click();

		// Verify that user is navigated to that brand page and can see products
		String expect_url2 = "https://www.automationexercise.com/brand_products/H&M";
		String actual_url2 = driver.getCurrentUrl();
		System.out.println(actual_url2);
		if (expect_url2.equals(actual_url2)) {
			System.out.println("URL Verified : Test pass");
		} else {
			System.out.println("URL Verified: Test fail");
		}

		boolean result3 = homepage.getHandMpage().isDisplayed();
		if (result3) {
			System.out.println("H&M Products page are displayed");
		} else {
			System.out.println("H&M Products page are not displayed");
		}

		// Close the Browser
		driver.quit();

	}

}