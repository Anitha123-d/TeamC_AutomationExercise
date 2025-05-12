package product_test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.LoginPage;
import PageRepository.ProductPage;
import PageRepository.SignUpPage;

public class Testcase_20 extends BaseConfig {
	@Test
	public void Search_Products_and_Verify_Cart_After_Login() throws IOException {

		ReadExcelFile excelfilelibrary = new ReadExcelFile();

		String email = excelfilelibrary.readData("LoginDetails", 4, 1);
		String password = excelfilelibrary.readData("LoginDetails", 4, 2);
		String searchbox = excelfilelibrary.readData("PaymentDetails", 1, 6);

		// Implicitly wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create object for product page
		ProductPage product2 = new ProductPage(driver);
		// Click on 'Products' button
		product2.getproductspage().click();

		// Verify user is navigated to ALL PRODUCTS page successfully
		boolean result2 = product2.getverifyallproductspage().isDisplayed();
		if (result2) {
			System.out.println("All Products page is displayed");
		} else {
			System.out.println("All Products page is not displayed");
		}

		// Enter product name in search input and click search button
		product2.getsearchproduct().sendKeys(searchbox);

		// Verify 'SEARCHED PRODUCTS' is visible
		product2.getsearch().click();

		// Verify all the products related to search are visible
		boolean result1 = product2.getverifiedrelatedproduct().isDisplayed();
		if (result1) {
			System.out.println("Searched Products are displayed");
		} else {
			System.out.println("Searched Products are not displayed");
		}

		// Create an object for cart page
		CartPage cartpageobj = new CartPage(driver);
		String jscode1 = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode1, cartpageobj.getaddtocartpage());

		// Add those products to cart
		cartpageobj.getaddtocartpage().click();

		// Click 'Cart' button and verify that products are visible in cart
		cartpageobj.getcartpage().click();

		boolean result3 = cartpageobj.getcart().isDisplayed();
		if (result3) {
			System.out.println("Shopping cart products are displayed");
		} else {
			System.out.println("Shopping cart Products are not displayed");
		}

		// Create an object for sign up page
		SignUpPage sign = new SignUpPage(driver);
		sign.getsignuplink().click();

		// create an object for login page
		LoginPage login1 = new LoginPage(driver);

		// Click 'Signup / Login' button and submit login details
		login1.getemail().sendKeys(email);

		login1.getpwd_textfeeld().sendKeys(password);

		login1.getlogin().click();

		cartpageobj.getviewcart1().click();;

		// Again, go to Cart page
		cartpageobj.getcart().click();

		// Verify that those products are visible in cart after login as well
		boolean result6 = cartpageobj.getcart().isDisplayed();
		if (result6) {
			System.out.println("products are visible in cart after login are displayed");
		} else {
			System.out.println("products are visible in cart after login are not displayed");
		}

		// Close the Browser
		driver.quit();

	}

}