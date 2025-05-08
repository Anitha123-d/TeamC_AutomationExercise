package product_test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.ProductPage;
import PropertyUtility.ReadPropertyFile;
import excelutility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'

public class Testcase_21 extends BaseConfig {
	//add review on product
	@Test
	public void review() throws InterruptedException, IOException {
		ReadPropertyFile propertyfilelibrary=new ReadPropertyFile();
		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		String username=excelfilelibrary.readData("LoginDetails", 4, 0);
		String email=excelfilelibrary.readData("LoginDetails", 4, 1);
		String reviewmsg = propertyfilelibrary.readData("reviewmsg");
		

		
		driver.manage().timeouts().implicitlyWait(10l,TimeUnit.SECONDS);
		

		ProductPage productpageobj=new ProductPage(driver);
		//Click on 'Products' button
		productpageobj.getproducts_button().click();
		// Verify user is navigated to ALL PRODUCTS page successfully displayed
		System.out.println(productpageobj.getverifyallproductspage().isDisplayed());
		if	(productpageobj.getverifyallproductspage().isDisplayed()) {
			System.out.println("all products page is displayed");
		}
		else 
		{
			System.out.println("all products page is not displayed");
		}

		Thread.sleep(1000);
		//Click on 'View Product' button
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", productpageobj.getviewproduct());
		productpageobj.getviewproduct().click();
//Verify 'Write Your Review' is visible

		System.out.println(productpageobj.getwriteyourreview().isDisplayed());
		if(productpageobj.getwriteyourreview().isDisplayed()) {
			System.out.println("writeyourreview is displayed");
		}
		else 
		{
			System.out.println("writeyourreview is not displayed");
		}
// Enter name, email and review
		productpageobj.getnamereview().sendKeys(username);
		productpageobj.getemailreview().sendKeys(email);
		productpageobj.getreviewmsg().sendKeys(reviewmsg);
		// Click 'Submit' button
		productpageobj.getreviewsubmit().submit();
		//Verify success message 'Thank you for your review.'
		System.out.println(productpageobj.getsuccessmsg().isDisplayed());

		if(productpageobj.getsuccessmsg().isDisplayed()) {
			System.out.println("successmsg is displayed");
		}
		else 
		{
			System.out.println("successmsg is not displayed");
		}
driver.quit();


	}
}