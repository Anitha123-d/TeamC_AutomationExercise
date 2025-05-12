package product_test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.LoginPage;
import PageRepository.PaymentPage;
import PageRepository.SignUpPage;
import PropertyUtility.ReadPropertyFile;
import excelutility.ReadExcelFile;

public class Testcase_15 extends BaseConfig {
	@Test
	public void VerifyProductquantityinCart() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		String commentbox = excelfilelibrary.readData("PaymentDetails", 1, 0);
		String cardname = excelfilelibrary.readData("PaymentDetails", 1, 1);
		String cardnumber = excelfilelibrary.readData("PaymentDetails", 1, 2);
		String cvcno = excelfilelibrary.readData("PaymentDetails", 1, 3);
		String expirymonth = excelfilelibrary.readData("PaymentDetails", 1, 4);
		String expiryyear = excelfilelibrary.readData("PaymentDetails", 1, 5);
		CartPage cart = new CartPage(driver);
		SignUpPage createacc = new SignUpPage(driver);
		createacc.getsignuplink().click();
		Signup();
		boolean result2 = createacc.getloginas().isDisplayed();
		if (result2) {
			System.out.println("Logged in as is visible");
		} else {
			System.out.println("Logged in as is not visible");
		}
		
		cart.getaddtocart().click();

		cart.getviewcart().click();
		Thread.sleep(2000);
		boolean result1 = cart.getcartpage().isDisplayed();
		if (result1) {
			System.out.println("Shopping cart page is Displayed");
		} else {
			System.out.println("Shopping cart page is not displayed");
		}
		cart.getproceedtocheckout().click();
		boolean result4 = cart.getviewcartverify().isDisplayed();
		if (result4) {
			System.out.println("cart detils are verified");
		} else {
			System.out.println("cart details are not verified");
		}
		System.out.println(cart.getviewcartverify().getText());
		boolean result5 = cart.getverifydetails().isDisplayed();
		if (result5) {
			System.out.println("cart detils are verified");
		} else {
			System.out.println("cart details are not verified");
		}
		System.out.println(cart.getverifydetails().getText());

		cart.getcommentmessage().sendKeys(commentbox);
		cart.getplaceorder().click();
		PaymentPage pay = new PaymentPage(driver);
		pay.getcardname().sendKeys(cardname);
		pay.getcardnumber().sendKeys(cardnumber);
		pay.getcvcno().sendKeys(cvcno);
		pay.getexpirymonth().sendKeys(expirymonth);
		pay.getexpiryyear().sendKeys(expiryyear);
		pay.getpayandconfirmorder().click();
		pay.getcontinueafterorder().click();

		boolean result6 = pay.getoderplacedmsg().isDisplayed();
		if (result6) {
			System.out.println("Your order has been placed successfully! is displayed");
		} else {
			System.out.println("Your order has been not placed successfully! is displayed");
		}
		LoginPage delete = new LoginPage(driver);
		delete.getdeleteaccount().click();
		boolean result7 = delete.getaccount_delete().isDisplayed();
		if (result7) {
			System.out.println("Your account has been deleted successfully! is displayed");
		} else {
			System.out.println("Your account has been not deleted successfully! is displayed");
		}
		System.err.println(delete.getaccount_delete().getText());
		delete.getdelecontinue().click();
		driver.quit();
	}

}