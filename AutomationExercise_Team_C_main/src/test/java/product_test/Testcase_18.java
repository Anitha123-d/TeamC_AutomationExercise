package product_test;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PageRepository.ProductPage;

public class Testcase_18 extends BaseConfig {
	@Test
	public void View_Category_Products() {

		// Implicitly wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Create an object for product page
		ProductPage product = new ProductPage(driver);
		product.getproductspage().click();

		// Create an object for home page
		HomePage homepage = new HomePage(driver);

		// Verify that categories are visible on left side bar
		boolean result1 = homepage.getcategory().isDisplayed();
		if (result1) {
			System.out.println("Category list is displayed");
		} else {
			System.out.println("Category list is not displayed");

		}
		String jscode1 = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode1, homepage.getwomen());
		// Click on 'Women' category
		homepage.getwomen().click();

		// Click on any category link under 'Women' category, for example: Dress
		homepage.getdress().click();

		// Verify that category page is displayed and confirm text 'WOMEN - TOPS
		// PRODUCTS'
		boolean result2 = homepage.getdresspage().isDisplayed();
		if (result2) {
			System.out.println("Women Dress Products are displayed");
		} else {
			System.out.println("Women Dress Products are not displayed");

		}

		homepage.getwomen().click();

		homepage.gettops().click();

		// On left side bar, click on any sub-category link of 'Men' category
		boolean result3 = homepage.gettops().isDisplayed();
		if (result3) {
			System.out.println("Women Tops Products are displayed");
		} else {
			System.out.println("Women Tops Products are not displayed");

		}

		homepage.getmen().click();

		homepage.getmentshirt().click();

		// Verify that user is navigated to that category page
		boolean result4 = homepage.getmentshirtpage().isDisplayed();
		if (result4) {
			System.out.println("Men Tshirts Products are displayed");
		} else {
			System.out.println("Men Tshirts Products are not displayed");
		}
		// Close the Browser
		driver.quit();

	}

}