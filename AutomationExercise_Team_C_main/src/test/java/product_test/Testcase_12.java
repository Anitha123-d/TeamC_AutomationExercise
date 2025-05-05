package product_test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.ProductPage;
public class Testcase_12 extends BaseConfig{
@Test
public void AddProductsinCart() throws InterruptedException {
	
	


	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Click on 'Products' button
		ProductPage productsobj = new ProductPage(driver);
		productsobj.getproductspage().click();
		// click on 1st product addcart
		CartPage cart = new CartPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cart.getaddtocart());
		// click on continue
		cart.getcontinueshopping().click();
		Thread.sleep(2000);
		// click on 2nd product addcart
		
		cart.getaddtocart().click();
		// click on continue
		cart.getcontinueshopping().click();
		Thread.sleep(2000);
		// click on 2nd product addcart
		js.executeScript("arguments[0].click();", cart.getaddtocart2());
		cart.getaddtocart2().click();
		// click on view cart
		cart.getviewcart().click();
		// Verify both products are added to Cart
		boolean result = cart.getviewcartverify().isDisplayed();
		if (result) {
			System.out.println("products are added to cart");
		} else {
			System.out.println("products are not added to cart");
		}
		// Verify their prices, quantity and total price
		String data = productsobj.getdetails1().getText();
		System.out.println(data);
		String data2 = productsobj.getdetails2().getText();
		System.out.println(data2);
		// close the browser
		driver.quit();
}

	}