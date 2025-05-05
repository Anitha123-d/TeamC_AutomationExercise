package product_test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.PaymentPage;
import PageRepository.ProductPage;
import PageRepository.SignUpPage;
import PropertyUtility.ReadPropertyFile;
import excelutility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
//Launch browser
//2. Navigate to url 'http://automationexercise.com'
public class Testcase_24  extends BaseConfig  {
	
	@Test
	public void Downloadinvoiceafterpurchaseorder() throws IOException, InterruptedException
	{	
		ReadPropertyFile propertyfilelibrary=new ReadPropertyFile();
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
		
		driver.manage().timeouts().implicitlyWait(20l, TimeUnit.SECONDS);
		////Verify that home page is visible successfully
		String url = propertyfilelibrary.readData("url");
		
		CartPage cartpageobj=new CartPage(driver);
		SignUpPage signuppageobj=new SignUpPage(driver);
		Thread.sleep(2000);
		//Add products to cart
JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", cartpageobj.getaddtocart2());
		cartpageobj.getaddtocart2().click();
		//Click 'Cart' button
		cartpageobj.getviewcart().click();
		//Verify that cart page is displayed
	System.out.println(cartpageobj.getproceedtocheckout().isDisplayed());
		if(cartpageobj.getproceedtocheckout().isDisplayed()) {
			System.out.println("cart page is displayed");
		}
		else
		{
			System.out.println("cart page is not displayed");
		}
		//. Click Proceed To Checkout
		cartpageobj.getproceedtocheckout().click();
		// Click 'Register / Login' button
		cartpageobj.getregisterlogin().click();
		//Fill all details in Signup and create account
		

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
		// Verify ' Logged in as username' at top
	String exp_text=username;
	String actual_text=signuppageobj.getloggedinas().getText();
	System.out.println(actual_text);
	if(exp_text.equalsIgnoreCase(actual_text)) {
		
		System.out.println("Account is logged in as username");
	}
		else {
			System.err.println("Account is not logged in as username");
		}
	//Click 'Cart' button
	cartpageobj.getcart().click();
	// Click 'Proceed To Checkout' button
	cartpageobj.getproceedtocheckout2().click();
// Verify Address Details and Review Your Order
	
	System.out.println(cartpageobj.getadressdetails().isDisplayed());
	if(cartpageobj.getadressdetails().isDisplayed()) {
		
		System.out.println("Adress details and review order are displayed");
	}
		else {
			System.err.println("Adress details and review order are not displayed");
			
			
		}
	String commentbox =excelfilelibrary.readData("PaymentDetails", 1, 0);
	String cardname = excelfilelibrary.readData("PaymentDetails", 1, 1);
	String cardnumber = excelfilelibrary.readData("PaymentDetails", 1, 2);
	String cvcno = excelfilelibrary.readData("PaymentDetails", 1, 3);
	String expirymonth = excelfilelibrary.readData("PaymentDetails", 1, 4);
	String expiryyear = excelfilelibrary.readData("PaymentDetails", 1, 5);	
	//Enter description in comment text area and click 'Place Order'
	cartpageobj.getcommentbox().sendKeys(commentbox);
	cartpageobj.getplaceorderbutton().click();
	// Enter payment details: Name on Card, Card Number, CVC, Expiration date
	PaymentPage paymentpageobj=new PaymentPage(driver);
	paymentpageobj.getcardname().sendKeys(cardname);
	paymentpageobj.getcardnumber().sendKeys(cardnumber);
	paymentpageobj.getcvcno().sendKeys(cvcno);
	paymentpageobj.getexpirymonth().sendKeys(expirymonth);
	paymentpageobj.getexpiryyear().sendKeys(expiryyear);
	// Click 'Pay and Confirm Order' button
	paymentpageobj.getpayandconfirmorder().submit();
	// Verify success message 'Your order has been placed successfully!'
	
//System.out.println(signuppageobj.getaccountdelete().isDisplayed());
ProductPage productpageobj=new ProductPage(driver);
	
	if(productpageobj.getorderplacedsuccess().isDisplayed()) {
		System.out.println("success message is displayed");
	}
	else {
		System.out.println("success message is not displayed");
		
	}
	// Click 'Download Invoice' button and verify invoice is downloaded successfully.
	paymentpageobj.getdownloadinvoice().click();
	//Click 'Continue' button
	paymentpageobj.getcontinueafterorder().click();
	//Click 'Delete Account' button
	signuppageobj.getdelete_account().click();
	//Verify 'ACCOUNT DELETED!' and click 'Continue' button
	System.out.println(signuppageobj.getaccount_delete().isDisplayed());
	
	if(signuppageobj.getaccount_delete().isDisplayed()) {
		System.out.println("account deleted is displayed");
	}
	else {
		System.out.println("Account deleted is not displayed");
		
	}
	signuppageobj.getcontinueafterdelete().click();
	driver.quit();
	}

}
