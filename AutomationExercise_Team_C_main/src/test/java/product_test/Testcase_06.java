package product_test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.ContactUsPage;
import PageRepository.HomePage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_06 extends BaseConfig {
	
		@Test
		public void Contact_Us_Form() throws InterruptedException, IOException { 

			ReadPropertyFile properfilelibrary = new ReadPropertyFile();
			String file = properfilelibrary.readData("file");
			ReadExcelFile excelfilelibrary = new ReadExcelFile();
			String name = excelfilelibrary.readData("ContactUsDetails", 1, 0);
			String email = excelfilelibrary.readData("ContactUsDetails", 1, 2);
			String subject = excelfilelibrary.readData("ContactUsDetails", 1, 3);
			String message = excelfilelibrary.readData("ContactUsDetails", 1, 4);

		// Verify that home page is visible successfully
		HomePage homepageobj = new HomePage(driver);
		boolean result = homepageobj.getverifiedhomepage().isDisplayed();
		if (result) {
			System.out.println("Home page is verified");
		} else {
			System.out.println("Home page is not verified");
		}

		// Click on 'Contact Us' button
		ContactUsPage contactusobj = new ContactUsPage(driver);
		contactusobj.getcontact_button().click();

		// Verify 'GET IN TOUCH' is visible
		boolean result1 = contactusobj.getgetintouch().isDisplayed();
		if (result1) {
			System.out.println("Get in touch is visibled");
		} else {
			System.out.println("Get in touch is not visibled");
		}

		// Enter name, email, subject and message
		contactusobj.getname().sendKeys(name);
		Thread.sleep(2000);
		contactusobj.getemail().sendKeys(email);
		Thread.sleep(2000);
		contactusobj.getsubject().sendKeys(subject);
		Thread.sleep(2000);
		contactusobj.getmessage().sendKeys(message);
		Thread.sleep(2000);

		// Upload the file
		File fileobj = new File(file);
		String absolutepath = fileobj.getAbsolutePath();
		contactusobj.getfileupload().sendKeys(absolutepath);
		
		Thread.sleep(2000);

		// Click 'Submit' button
		contactusobj.getsubmit_button().submit();
		
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Verify success message 'Success! Your details have been submitted
		// successfully.' is visible
		System.out.println(contactusobj.getsuccessmessage().getText());

		// Click 'Home' button and verify that landed to home page successfully
		contactusobj.getclickhomepage().click();
		boolean result2 = contactusobj.getverifiedhomepage().isDisplayed();
		if (result2) {
			System.out.println("Landed to the Home page successfully");
		} else {
			System.out.println("Is not Landed to the Home page successfully");

		}
		driver.quit();

	}

}