package product_test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.LoginPage;
import excelutility.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_04 extends BaseConfig {
	@Test
	public  void Logout_User() throws IOException {
		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		
				
		driver.manage().timeouts().implicitlyWait(20l, TimeUnit.SECONDS);

		String email = excelfilelibrary.readData("LoginDetails", 1, 0);
		String password = excelfilelibrary.readData("LoginDetails", 1, 2);
		LoginPage loginpage_obj=new LoginPage(driver);
		//step4: Click on 'Signup / Login' button
		loginpage_obj.getsignup().click();
		//step5:Verify 'Login to your account' is visible
		boolean result = loginpage_obj.getloginaccount().isDisplayed();
		if (result) {
			System.out.println(" Login to your accountis displayed");
		} else {
			System.out.println(" Login to your accountis not displayed");
		}
		//step6.1:Enter correct email address  in email text filed
		loginpage_obj.getemail().sendKeys(email);
		//step6.2:Enter correct password in password text filed
		loginpage_obj.getpwd().sendKeys(password);
		//step7:Click 'login' button
		loginpage_obj.getlogin().click();
		//step8:Verify that 'Logged in as username' is visible
		 boolean res=loginpage_obj.getloggedas().isDisplayed();
		 if (res) {
				System.out.println(" login as user is displayed");
			} else {
				System.out.println(" login as user is not displayed");
			}
		 //step9:Click logout button
		 loginpage_obj.getlogout().click();
		 //step10:Verify that 'login page' is visible
		 boolean res1=loginpage_obj.gethomepage().isDisplayed();
		 if (res1) {
				System.out.println(" Home page is displayed");
			} else {
				System.out.println(" Home page is not displayed");
			}
		 driver.quit();
	}

}