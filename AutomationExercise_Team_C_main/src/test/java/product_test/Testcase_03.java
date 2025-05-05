
package product_test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.LoginPage;
import excelutility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_03  extends BaseConfig{
	@Test
	public  void Login_User_with_incorrect_email_and_password() throws IOException
 {
		ReadExcelFile excelfilelibrary = new ReadExcelFile();

	

		String email = excelfilelibrary.readData("LoginDetails", 1, 0);
		String password = excelfilelibrary.readData("LoginDetails", 1, 2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginpage_obj = new LoginPage(driver);
		// step4:Click on 'Signup / Login' button
		loginpage_obj.getsignup().click();
		//step5:Verify 'Login to your account' is visible
		boolean result = loginpage_obj.getloginaccount().isDisplayed();
		if (result) {
			System.out.println(" Login to your accountis displayed");
		} else {
			System.out.println(" Login to your accountis not displayed");
		}
		//step6.1: Enter Incorrect email address in email text filed
		loginpage_obj.getemail().sendKeys(email);
		//step6.2: Enter Incorrect  password in pwd text field
		loginpage_obj.getpwd_textfeeld().sendKeys(password);
		//step7: Click 'login' button
		loginpage_obj.getlogin1().click();
		//step8: Verify error 'Your email or password is incorrect!' is visible
		boolean res = loginpage_obj.getinvalidmail().isDisplayed();
		if (res) {
			System.out.println(" Your email or password is incorrect!is displayed");
		} else {
			System.out.println(" Your email or password is incorrect! is not displayed");
		}
		driver.quit();

	}
}