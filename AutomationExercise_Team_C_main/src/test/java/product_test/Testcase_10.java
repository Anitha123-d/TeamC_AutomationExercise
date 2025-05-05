package product_test;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.HomePage;

public class Testcase_10 extends BaseConfig {
	@Test
	public void Verify_Subscription_in_home_page() throws InterruptedException, IOException {
		ReadExcelFile excelfilelibrary = new ReadExcelFile();

		String email = excelfilelibrary.readData("LoginDetails", 2, 1);

		// Verify that home page is visible successfully
		HomePage homepageobj = new HomePage(driver);
		boolean result = homepageobj.getverifiedhomepage().isDisplayed();
		if (result) {
			System.out.println("Home page is verified");
		} else {
			System.out.println("Home page is not verified");
		}

		// Scroll down to footer
		String jscode1 = "arguments[0].scrollIntoView(true)";
		String jscode2 = "window.scrollBy(0,500)";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(jscode2);
		js.executeScript(jscode1, homepageobj.gettext());

		// Verify text 'SUBSCRIPTION'
		boolean gettextresult = homepageobj.gettext().isDisplayed();
		if (gettextresult) {
			System.out.println("Subscription text is displayed successfully");
		} else {
			System.out.println("Subscription text is not displayed successfully");
		}

		// Enter email address in input and click arrow button
		homepageobj.getsubscribeemail().sendKeys(email);
		Thread.sleep(1000);
		homepageobj.getsubscribedbutton().click();

		// Verify success message 'You have been successfully subscribed!' is visible
		System.out.println(homepageobj.getsubscribedmessage().getText());

		driver.quit();
	}

}