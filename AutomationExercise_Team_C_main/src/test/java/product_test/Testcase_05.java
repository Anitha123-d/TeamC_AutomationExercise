package product_test;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;

import GenericRepository.BaseConfig;
import PageRepository.SignUpPage;
import excelutility.ReadExcelFile;

public class Testcase_05 extends BaseConfig {
	@Test
	public void Register_User_with_existing_email() throws IOException {
		ReadExcelFile excelfilelibrary = new ReadExcelFile();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String username = excelfilelibrary.readData("LoginDetails", 6, 0);
		String email = excelfilelibrary.readData("LoginDetails", 6, 1);

		SignUpPage signuppage_obj = new SignUpPage(driver);
		// stpe4: Click on 'Signup / Login' button
		signuppage_obj.getsignup().click();
		// step5:Verify 'New User Signup!' is visible
		boolean res = signuppage_obj.getnewuser1().isDisplayed();
		if (res) {

			System.out.println(" newuser is displayed");
		} else {
			System.out.println("newuser is  not displayed");
		}

		// step6.1:Enter name and in name text filed
		signuppage_obj.getname().sendKeys(username);
		// step6.2: Enter already registered email address in email text field
		signuppage_obj.getemail().sendKeys(email);
		// step7: Click 'Signup' button
		signuppage_obj.getsignupbutton().click();
		//
		boolean res1 = signuppage_obj.getemailpresent().isDisplayed();
		if (res1) {
			System.out.println(" This Email all reay exit is displayed");
		} else {
			System.out.println("This Email all reay exitis not displayed");
		}

		driver.quit();

	}

}