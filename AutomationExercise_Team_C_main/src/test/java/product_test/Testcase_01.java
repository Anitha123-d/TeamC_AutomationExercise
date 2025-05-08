package product_test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.SignUpPage;
import excelutility.ReadExcelFile;
import javautility.Randomnumbergeneration;

public class Testcase_01 extends BaseConfig {

	@Test
	public void Register_User() throws IOException

	{ Randomnumbergeneration ranObj=new Randomnumbergeneration();
	
		
		String randomGmail="abc"+ranObj.generaterandomnumber()+"@abcgmail.com";
		String email = randomGmail;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String username = excelfilelibrary.readData("LoginDetails", 2, 0);
		String password = excelfilelibrary.readData("LoginDetails", 1, 2);
		String firstname = excelfilelibrary.readData("LoginDetails", 1, 3);
		String lastname = excelfilelibrary.readData("LoginDetails", 1, 4);
		String company = excelfilelibrary.readData("LoginDetails", 1, 5);
		String address = excelfilelibrary.readData("LoginDetails", 1, 6);
		String address2 = excelfilelibrary.readData("LoginDetails", 1, 7);
		String state = excelfilelibrary.readData("LoginDetails", 1, 8);
		String city = excelfilelibrary.readData("LoginDetails", 1, 9);
		String zipcode = excelfilelibrary.readData("LoginDetails", 1, 10);

		String mobilenumber = excelfilelibrary.readData("LoginDetails", 1, 11);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		SignUpPage signuppage_obj = new SignUpPage(driver);

		// Step4:Click on 'Signup / Login' button

		signuppage_obj.getsignuplink().click();
		// signuppage_obj.getnewuser().click();

		// Step5:Verify 'New User Signup!' is visible
		boolean result = signuppage_obj.getnewuser().isDisplayed();
		if (result) {
			System.out.println(" newuser is displayed");
		} else {
			System.out.println("newuser is  not displayed");
		}

		// Step6.1 Enter name in the Name TextField
		signuppage_obj.getsignup_name().sendKeys(username);

		// Step6.2 Enter email address in the EmailTextField
		signuppage_obj.getsignup_mail().sendKeys(email);

		// Step7: Click 'Signup' button
		signuppage_obj.getsignup_button().click();
		// step8:Verify that 'ENTER ACCOUNT INFORMATION' is visible
		boolean a1 = signuppage_obj.getenterinfo().isDisplayed();
		if (a1) {
			System.out.println(" Enter Account Information is displayed");
		} else {
			System.out.println("Enter Account Information   is not displayed");
		}

		/// Step9.1: Fill details Title
		signuppage_obj.getfgender().click();
		/// Step9.2:Fill details enter Password in pwd text field
		signuppage_obj.getpwd_textfield().sendKeys(password);
		/// Step9.3:Fill details select Date
		Select obj = new Select(signuppage_obj.getdaysdp());
		obj.selectByIndex(4);
		// /Step 9.4:Fill details select month
		Select obj1 = new Select(signuppage_obj.getmonthsdp());
		obj1.selectByIndex(6);
		// /Step9.5:Fill detail select year
		Select obj3 = new Select(signuppage_obj.getyearsdp());
		obj3.selectByIndex(6);
		String jscode1="arguments[0].scrollIntoView(false)";
		js.executeScript(jscode1,obj3);
		/// Step 10: Select checkbox 'Sign up for our newsletter!'
		wait.until(ExpectedConditions.elementToBeClickable(signuppage_obj.getnewsletter())).click();
		
		// /Step 11:Select checkbox 'Receive special offers from our partners!'
		signuppage_obj.getcheckbox2().click();
		/// Step 12.1:Fill details: enter First name
		signuppage_obj.getfirst_name().sendKeys(firstname);
		/// Step12.2:Fill details: enter Last name
		signuppage_obj.getlast_name().sendKeys(lastname);
		/// Step 12.3:Fill details: enter Company name
		signuppage_obj.getcompany().sendKeys(company);
		// /Step12.4:Fill details:enter Address
		signuppage_obj.getaddress1().sendKeys(address);
		// /Step12.4:Fill details: enter Address2
		signuppage_obj.getaddress2().sendKeys(address2);
		// /Step 12.6:Fill details: enter State
		signuppage_obj.getstate().sendKeys(state);
		/// Step 12.7:Fill details:enter City
		signuppage_obj.getcity().sendKeys(city);
		// /Step12.8:Fill details: enter Zipcode
		signuppage_obj.getzipcode().sendKeys(zipcode);
		// Step 12.9:Fill details: enter Mobile Number
		signuppage_obj.getmobile_number().sendKeys(mobilenumber);
		// step 13: Click 'Create Account button'
		signuppage_obj.getcreateAccount().click();
		// Step 14:Verify that 'ACCOUNT CREATED!' is visible
		boolean result1 = signuppage_obj.getcreateAccountmsg().isDisplayed();
		if (result1) {
			System.out.println(" Congratulations! Your new account has been successfully created! is displayed");
		} else {
			System.out.println(" Congratulations! Your new account has been successfully created! is not displayed");
		}

		// Step 15: Click 'Continue' button
		signuppage_obj.getconti().click();
		// /Step 16:Verify that 'Logged in as username' is visible
		boolean res = signuppage_obj.getloginas().isDisplayed();
		if (res) {
			System.out.println(" login as user is displayed");
		} else {
			System.out.println(" login as user is not displayed");
		}
		
		
		// Step 17:Click 'Delete Account' button
		signuppage_obj.getdelete_account().click();
		// Step 18.1: Verify that 'ACCOUNT DELETED!' is visible
		boolean res12 = signuppage_obj.getaccount_delete().isDisplayed();
		if (res12) {
			System.out.println(" Account delete is displayed");
		} else {
			System.out.println("  Account delete is not displayed");
		}
		// step 18.2:click 'Continue' button
		signuppage_obj.getcontinueafterdelete().click();

	}

}