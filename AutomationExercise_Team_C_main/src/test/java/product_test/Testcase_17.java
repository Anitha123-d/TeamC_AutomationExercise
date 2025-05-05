package product_test;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.ProductPage;

public class Testcase_17 extends BaseConfig {
	@Test
	public void Remove_Products_From_Cart() {

		// Implicitly wait Statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create an object for product page
		ProductPage page = new ProductPage(driver);
		page.getproductspage().click();

		CartPage page1 = new CartPage(driver);
		String jscode1 = "arguments[0].scrollIntoView(true);";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode1, page1.getaddtocart());
		// Add products to cart
		page1.getaddtocart().click();

		// Click 'Cart' button
		page1.getviewcart().click();

		// Verify that cart page is displayed
		boolean result = page1.getcart().isDisplayed();
		if (result) {
			System.out.println("Cart page is displayed");
		} else {
			System.out.println("Cart page is not displayed");
		}

		// Click 'X' button corresponding to particular product
		page1.getcancle().click();

		// Verify that product is removed from the cart
		boolean result1 = page1.getcartempty().isDisplayed();
		if (result1) {
			System.out.println("Cart is empty! Click here to buy products is Displayed");
		} else {
			System.out.println("Cart is empty! Click here to buy products is not Displayed");

		}
		// Close the browser
		driver.quit();

	}

}