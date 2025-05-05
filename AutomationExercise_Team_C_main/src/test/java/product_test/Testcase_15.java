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

public class Testcase_15 extends BaseConfig{
@Test
public void VerifyProductquantityinCart() throws InterruptedException, IOException {
	

	ReadPropertyFile propertyfilelibrary = new ReadPropertyFile();

	
	String commentbox = propertyfilelibrary.readData("commentbox");
	String cardname = propertyfilelibrary.readData("cardname");
	String cardnumber = propertyfilelibrary.readData("cardnumber");
	String cvcno = propertyfilelibrary.readData("cvcno");
	String expirymonth = propertyfilelibrary.readData("expirymonth");
	String expiryyear = propertyfilelibrary.readData("expiryyear");

	
	ReadExcelFile excelfilelibrary = new ReadExcelFile();
	String username = excelfilelibrary.readData("LoginDetails", 2, 0);
	String email = excelfilelibrary.readData("LoginDetails", 2, 1);
	String password = excelfilelibrary.readData("LoginDetails", 1, 2);
	String firstname = excelfilelibrary.readData("LoginDetails", 1, 3);
	String lastname = excelfilelibrary.readData("LoginDetails", 1, 4);
	String company = excelfilelibrary.readData("LoginDetails", 1, 5);
	String address = excelfilelibrary.readData("LoginDetails", 1, 6);
	String address2 = excelfilelibrary.readData("LoginDetails", 1, 7);
	String state = excelfilelibrary.readData("LoginDetails", 1, 8);
	String city = excelfilelibrary.readData("LoginDetails", 1, 9);
	String zipcode = excelfilelibrary.readData("LoginDetails", 1, 9);
	String mobilenumber = excelfilelibrary.readData("LoginDetails", 1, 9);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
		SignUpPage createacc = new SignUpPage(driver);
		createacc.getsignuplink().click();
		createacc.getsignup_name().sendKeys(username);
		createacc.getsignup_mail().sendKeys(email);
		createacc.getsignup_button().click();
		createacc.getfgender().click();
		createacc.getpwd_textfield().sendKeys(password);
		Select dpobj = new Select(createacc.getdaysdp());
		dpobj.selectByIndex(4);
		Select dpobj1 = new Select(createacc.getmonthsdp());
		dpobj1.selectByIndex(11);
		Select dpobj2 = new Select(createacc.getyearsdp());
		dpobj2.selectByValue("2001");
		createacc.getnewsletter().click();
		createacc.getcheckbox2().click();
		createacc.getfirst_name().sendKeys(firstname);
		createacc.getlast_name().sendKeys(lastname);
		createacc.getcompany().sendKeys(company);
		createacc.getaddress1().sendKeys(address);
		createacc.getaddress2().sendKeys(address2);
		Select objdp3 = new Select(createacc.getcountry());
		objdp3.selectByValue("India");
		createacc.getstate().sendKeys(state);
		createacc.getcity().sendKeys(city);
		createacc.getzipcode().sendKeys(zipcode);
		createacc.getmobile_number().sendKeys(mobilenumber);
		createacc.getcreateAccount().click();
		System.out.println(createacc.getcreateAccountmsg().getText());
		boolean result = createacc.getcreateAccountmsg().isDisplayed();
		if (result) {
			System.out.println("Account Created!");
		} else {
			System.out.println("Account not created");
		}
		createacc.getconti().click();
		boolean result2 = createacc.getloginas().isDisplayed();
		if (result) {
			System.out.println("Logged in as is visible");
		} else {
			System.out.println("Logged in as is not visible");
		}
		CartPage cart = new CartPage(driver);
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
		if (result4) {
			System.out.println("cart detils are verified");
		} else {
			System.out.println("cart details are not verified");
		}
		System.out.println(cart.getverifydetails().getText());

		cart.getcommentmessage().sendKeys("place order");
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