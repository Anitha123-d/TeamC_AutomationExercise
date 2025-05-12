package product_test;

import java.io.IOException;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.LoginPage;
import PageRepository.PaymentPage;
import PageRepository.SignUpPage;

public class Testcase_16 extends BaseConfig {
	@Test
	public void Login_Before_Checkout() throws InterruptedException, IOException {

		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		UserCreation();
		LoginPage loginobj = new LoginPage(driver);
		//loginobj.getlogout().click();

		String email = excelfilelibrary.readData("LoginDetails", 4, 1);
		String password = excelfilelibrary.readData("LoginDetails", 4, 2);

		String commentbox = excelfilelibrary.readData("PaymentDetails", 1, 0);
		String cardname = excelfilelibrary.readData("PaymentDetails", 1, 1);
		String cardnumber = excelfilelibrary.readData("PaymentDetails", 1, 2);
		String cvcno = excelfilelibrary.readData("PaymentDetails", 1, 3);
		String expirymonth = excelfilelibrary.readData("PaymentDetails", 1, 4);
		String expiryyear = excelfilelibrary.readData("PaymentDetails", 1, 5);

		// Implicitly wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Create object for signup page
		SignUpPage signupobj = new SignUpPage(driver);
		// Click 'Signup / Login' button
		signupobj.getsignuplink().click();

		// Create object for login page
		//LoginPage loginobj = new LoginPage(driver);

		// Fill email, password and click 'Login' button
		loginobj.getemail().sendKeys(email);

		loginobj.getpwd().sendKeys(password);

		loginobj.getlogin().click();

		// Verify 'Logged in as username' at top
		boolean result = signupobj.getloggedinas().isDisplayed();
		if (result) {
			System.out.println("logged in an user is Visible");
		} else {
			System.out.println("logged in an user is not Visible");
		}

		Thread.sleep(3000);

		// Create object for cart page
		CartPage cartpageobj = new CartPage(driver);
		String jscode1 = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode1, cartpageobj.getaddtocartpage());
		// add products to cart
		cartpageobj.getaddtocartpage().click();

		// Click 'Cart' button
		cartpageobj.getviewcart().click();

		// Verify that cart page is displayed
		boolean result1 = cartpageobj.getcartreal().isDisplayed();
		if (result1) {
			System.out.println("Shopping cart page is Displayed");
		} else {
			System.out.println("Shopping cart page is not displayed");
		}

		// Click Proceed To Checkout
		cartpageobj.getproceedtocheckout().click();

		// Verify Address Details and Review Your Order
		boolean result2 = cartpageobj.getdeliveryaddress().isDisplayed();
		if (result2) {
			System.out.println("Address details are visble");
		} else {
			System.out.println("Address details are not visible");
		}

		boolean result3 = cartpageobj.getbillingaddress().isDisplayed();
		if (result3) {
			System.out.println("Review order details are visble");
		} else {
			System.out.println("Review order are not visible");
		}

		// Enter description in comment text area and click 'Place Order'
		cartpageobj.getcommentmessage().sendKeys(commentbox);

		cartpageobj.getplaceorderbutton().click();

		// Create object for payment page
		PaymentPage paymentobj = new PaymentPage(driver);

		// Enter payment details: Name on Card, Card Number, CVC, Expiration date
		paymentobj.getcardname().sendKeys(cardname);

		paymentobj.getcardnumber().sendKeys(cardnumber);

		paymentobj.getcvcno().sendKeys(cvcno);

		paymentobj.getexpirymonth().sendKeys(expirymonth);

		paymentobj.getexpiryyear().sendKeys(expiryyear);

		// Click 'Pay and Confirm Order' button
		paymentobj.getpayandconfirmorder().click();
		Thread.sleep(1000);

		// Verify success message 'Your order has been placed successfully!'
		boolean result4 = paymentobj.getoderplacedmsg().isDisplayed();
		if (result4) {
			System.out.println("Your order has been placed successfully! is displayed");
		} else {
			System.out.println("Your order has been placed successfully! is not displayed");
		}

		// Click 'Delete Account' button
		loginobj.getdeleteaccount().click();

		// Verify 'ACCOUNT DELETED!' and click 'Continue' button
		boolean result5 = loginobj.getaccount_delete().isDisplayed();
		if (result5) {
			System.out.println("Your account has been permanently deleted! is displayed");
		} else {
			System.out.println("Your account has been permanently deleted! is not displayed");

		}

		paymentobj.getcontinueafterorder().click();
	}

}