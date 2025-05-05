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
		String username=excelfilelibrary.readData("LoginDetails", 4, 0);
		String email=excelfilelibrary.readData("LoginDetails", 4, 1);
		String password=excelfilelibrary.readData("LoginDetails", 4, 2);
		String firstname=excelfilelibrary.readData("LoginDetails", 4, 3);
		String lastname=excelfilelibrary.readData("LoginDetails", 4, 4);
		String company =excelfilelibrary.readData("LoginDetails", 4, 5);
		
		String address=excelfilelibrary.readData("LoginDetails", 4, 6);
		String address2 =excelfilelibrary.readData("LoginDetails", 4, 7);
		String state=excelfilelibrary.readData("LoginDetails", 4, 8);
		String city=excelfilelibrary.readData("LoginDetails", 4, 9);
		String zipcode=excelfilelibrary.readData("LoginDetails", 4, 10);
		String mobilenumber=excelfilelibrary.readData("LoginDetails", 4, 11);
		
		
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		//Verify that home page is visible successfully
		String url = propertyfilelibrary.readData("url");
		
		
		driver.manage().window().maximize();
		SignUpPage signuppageobj=new SignUpPage(driver);
		//Click 'Signup / Login' button
		signuppageobj.getsignup1().click();
		//. Fill all details in Signup and create account
		signuppageobj.getsignup_name().sendKeys(username);
		signuppageobj.getsignup_mail().sendKeys(email);
		signuppageobj.getsignup_button().click();
		signuppageobj.getfgender().click();
		signuppageobj.getpwd_textfield().sendKeys(password);
		signuppageobj.getfirst_name().sendKeys(firstname);
		signuppageobj.getlast_name().sendKeys(lastname);
		signuppageobj.getcompany().sendKeys(company);
		signuppageobj.getaddress1().sendKeys(address);
		signuppageobj.getaddress2().sendKeys(address2);
		signuppageobj.getstate().sendKeys(state);
		signuppageobj.getcity().sendKeys(city);
		signuppageobj.getzipcode().sendKeys(zipcode);
		signuppageobj.getmobile_number().sendKeys(mobilenumber);
		signuppageobj.getcreateAccount().submit();	
		//Verify 'ACCOUNT CREATED!' and click 'Continue' button
System.out.println(signuppageobj.getcreateAccountmsg().isDisplayed());
	if(signuppageobj.getcreateAccountmsg().isDisplayed()) {
		System.out.println("account created is displayed");
	}
	else {
		System.out.println("Account created is not displayed");
	}
	signuppageobj.getconti().click();
	//Verify ' Logged in as username' at top
	String exp_text=username;
	
	String actual_text=signuppageobj.getloggedinas().getText();
	System.out.println(actual_text);
	if(exp_text.equalsIgnoreCase(actual_text)) {
		
		System.out.println("Account is logged in as username");
	}
		else {
			System.err.println("Account is not logged in as username");
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

	
