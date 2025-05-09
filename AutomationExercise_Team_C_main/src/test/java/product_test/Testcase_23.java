package product_test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.SignUpPage;
import PropertyUtility.ReadPropertyFile;
import excelutility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'

public class Testcase_23 extends BaseConfig {
	@Test
public void Verifyaddressdetailsincheckoutpage() throws IOException {
		//ReadPropertyFile propertyfilelibrary=new ReadPropertyFile();
		ReadExcelFile excelfilelibrary = new ReadExcelFile();

		
		
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		//Verify that home page is visible successfully
		String url = propertyfilelibrary.readData("url");
		
		
		driver.manage().window().maximize();
		SignUpPage signuppageobj=new SignUpPage(driver);
		//Click 'Signup / Login' button
		signuppageobj.getsignup1().click();
		//. Fill all details in Signup and create account
		UserCreation();

		//Verify 'ACCOUNT CREATED!' and click 'Continue' button
//		boolean result1 = signuppageobj.getcreateAccountmsg().isDisplayed();
//		if (result1) {
//			System.out.println(" Congratulations! Your new account has been successfully created! is displayed");
//		} else {
//			System.out.println(" Congratulations! Your new account has been successfully created! is not displayed");
//		}
//	signuppageobj.getconti().click();
	//Verify ' Logged in as username' at top
	boolean res = signuppageobj.getloginas().isDisplayed();
	if (res) {
		System.out.println(" login as user is displayed");
	} else {
		System.out.println(" login as user is not displayed");
	}
	CartPage cartpageobj=new CartPage(driver);
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
		//wait.until(ExpectedConditions.elementToBeClickable(cartpageobj.getaddtocart2()));
JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", cartpageobj.getaddtocart2());
		//Add products to cart
		cartpageobj.getaddtocart2().click();
	//	cartpageobj.getaddtocart2().click();
		//. Click 'Cart' button
		cartpageobj.getviewcart().click();	
		// Verify that cart page is displayed
System.out.println(cartpageobj.getproceedtocheckout().isDisplayed());
	if(cartpageobj.getproceedtocheckout().isDisplayed()) {
		System.out.println("cart page is displayed");
	}
	else
	{
		System.out.println("cart page is not displayed");
	}
	// Click Proceed To Checkout

	cartpageobj.getproceedtocheckout().click();
	// Click 'Delete Account' button
	signuppageobj.getdelete_account().click();
	System.out.println(signuppageobj.getaccount_delete().isDisplayed());
	
	if(signuppageobj.getaccount_delete().isDisplayed()) {
		System.out.println("account deleted is displayed");
	}
	else {
		System.out.println("Account deleted is not displayed");
		
	}
	//Verify 'ACCOUNT DELETED!' and click 'Continue' button
	signuppageobj.getcontinueafterdelete().click();
	
	driver.quit();
	}
	}

	
