package product_test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PageRepository.LoginPage;
import PageRepository.PaymentPage;
import PageRepository.ProductPage;
import PageRepository.SignUpPage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_14 extends BaseConfig{
@Test
public void VerifyProductquantityinCart() throws InterruptedException, IOException {
	
	
	

	
	
	ReadExcelFile excelfilelibrary = new ReadExcelFile();
	
	
	String commentbox = excelfilelibrary.readData("PaymentDetails",1,0);
	String cardname = excelfilelibrary.readData("PaymentDetails",1,1);
	String cardnumber = excelfilelibrary.readData("PaymentDetails",1,2);
	String cvcno = excelfilelibrary.readData("PaymentDetails",1,3);
	String expirymonth = excelfilelibrary.readData("PaymentDetails",1,4);
	String expiryyear = excelfilelibrary.readData("PaymentDetails",1,5);

	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
		ProductPage productsobj = new ProductPage(driver);
		// Add products to cart
		productsobj.getproductspage().click();
		CartPage cart = new CartPage(driver);
		// Click 'Cart' button
		cart.getaddtocart().click();

		cart.getviewcart().click();
		Thread.sleep(2000);
		// Verify that cart page is displayed
		boolean result1 = cart.getcartpage().isDisplayed();
		if (result1) {
			System.out.println("Shopping cart page is Displayed");
		} else {
			System.out.println("Shopping cart page is not displayed");
		}
		// Click Proceed To Checkout
		cart.getproceedtocheckout().click();
		// Click 'Register / Login' button
		cart.getregisterlogin().click();
		SignUpPage createacc = new SignUpPage(driver);
		
		Signup();
		
		// Verify ' Logged in as username' at top
		boolean result2 = createacc.getloginas().isDisplayed();
		if (result2) {
			System.out.println("Logged in as is visible");
		} else {
			System.out.println("Logged in as is not visible");
		}
		cart.getviewcart1().click();
		cart.getproceedtocheckout().click();

		System.out.println(cart.getviewcartverify().getText());

		System.out.println(cart.getverifydetails().getText());

		cart.getcommentmessage().sendKeys(commentbox);
		cart.getplaceorderbutton().click();
		PaymentPage pay = new PaymentPage(driver);
		pay.getcardname().sendKeys(cardname);
		pay.getcardnumber().sendKeys(cardnumber);
		pay.getcvcno().sendKeys(cvcno);
		pay.getexpirymonth().sendKeys(expirymonth);
		pay.getexpiryyear().sendKeys(expiryyear);
		pay.getpayandconfirmorder().click();
		pay.getcontinueafterorder().click();

		boolean result6 = pay.getoderplacedmsg().isDisplayed();
		Thread.sleep(2000);
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