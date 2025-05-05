package product_test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.ProductPage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Testcase_13 extends BaseConfig{
@Test
public void VerifyProductquantityinCart() throws InterruptedException {
	
	
	
	ReadPropertyFile propertyfilelibrary = new ReadPropertyFile();

	String quantity = propertyfilelibrary.readData("quantity");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
	
		// Click 'View Product' for any product on home page
		ProductPage prodobj = new ProductPage(driver);
		// Verify product detail is opened
		prodobj.getviewpro().click();
		boolean result = prodobj.getproductdetails().isDisplayed();
		if (result) {
			System.out.println(result + "details of the product are visible");
		} else {
			System.out.println("details of the product are not visible");
		}
		// add quantity to 4
		prodobj.getquantity().clear();
		prodobj.getquantity().sendKeys(quantity);
		// Click 'Add to cart' button
		prodobj.getaddquantity().click();

		// Click 'View Cart' button
		prodobj.getviewaddquantity().click();
		prodobj.getviewprocart().click();
		// Verify that product is displayed in cart page with exact quantity
		boolean res = prodobj.getviewdetails().isDisplayed();
		if (res) {
			System.out.println(res + "  product is displayed in cart page with exact quantity");
		} else {
			System.out.println("product is not displayed in cart page with exact quantity");
		}
		System.out.println(prodobj.getviewdetails().getText());
		// close the browser
		driver.quit();

	}

}