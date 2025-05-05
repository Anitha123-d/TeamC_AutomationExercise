package product_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import GenericRepository.BaseConfig;
import PageRepository.HomePage;
import PageRepository.TestcasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase_07 extends BaseConfig{
	@Test
public void Verify_Test_Cases_Page() {

		// Verify that home page is visible successfully
		HomePage homepageobj = new HomePage(driver);
		boolean result = homepageobj.getverifiedhomepage().isDisplayed();
		if (result) {
			System.out.println("Home page is verified");
		} else {
			System.out.println("Home page is not verified");
		}
		
		//Click on 'Test Cases' button
		TestcasePage testcaseobj = new TestcasePage(driver);
		testcaseobj.gettestcasebutton().click();
		
		//Verify user is navigated to test cases page successfully
		boolean testcaseresult = testcaseobj.getverifytestcase().isDisplayed();
		if(testcaseresult) {
			System.out.println("User is able to navigate to the test case page successfully");
		}else {
			System.out.println("User is not able to navigate to the test case page successfully");

		}
		driver.quit();
	}

}