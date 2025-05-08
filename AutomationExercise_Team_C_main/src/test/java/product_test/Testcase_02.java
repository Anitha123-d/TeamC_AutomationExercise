package product_test;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.LoginPage;
import excelutility.ReadExcelFile;

public class Testcase_02 extends BaseConfig {
	@Test
	public void LoginUser_with_correct_email_and_password() throws IOException {
		UserCreation();
		ReadExcelFile excelfilelibrary = new ReadExcelFile();

		String email = excelfilelibrary.readData("LoginDetails", 2, 1);
		String password = excelfilelibrary.readData("LoginDetails", 2, 2);
		// wait stmt
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// creating ref variable
		LoginPage loginpageobj = new LoginPage(driver);
		// stpe4: Click on 'Signup / Login' button
		//loginpageobj.getlogin_page().click();
		// step5: Verify 'Login to your account' is visible
		boolean result = loginpageobj.getloginaccount().isDisplayed();
		if (result) {
			System.out.println(" Login to your accountis displayed");
		} else {
			System.out.println(" Login to your accountis not displayed");
		}
		// step6.1:Enter correct email address and password
		loginpageobj.getemail().sendKeys(email);
		// step6.2:Enter correct email address and password
		loginpageobj.getpwd().sendKeys(password);
		// step7:Click 'login' button
		loginpageobj.getlogin().click();
		// step8:Verify that 'Logged in as username' is visible
		boolean res = loginpageobj.getloggedas().isDisplayed();
		if (res) {
			System.out.println(" login as user is displayed");
		} else {
			System.out.println(" login as user is not displayed");
		}
		// step9:Click 'Delete Account' button
		loginpageobj.getdeleteaccount().click();
		boolean res1 = loginpageobj.getaccount_delete().isDisplayed();
		if (res1) {
			System.out.println("  Account delete is displayed");
		} else {
			System.out.println(" Account delete is not displayed");
		}

		// driver.quit();
	}
}