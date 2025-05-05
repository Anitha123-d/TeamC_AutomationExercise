package product_test;


	import java.time.Duration;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import excelutility.ReadExcelFile;
import GenericRepository.BaseConfig;
import PageRepository.CartPage;
import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;


	public class Testcase_11 extends BaseConfig{
		@Test
		public  void VerifySubscriptioninCartpage()throws InterruptedException {

				
			ReadPropertyFile propertyfilelibrary = new ReadPropertyFile();

			String email = propertyfilelibrary.readData("email");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

					
					//click cart page
					CartPage cart=new CartPage(driver);
					cart.getcartpage().click();
					//scroll down 
					String jscode="arguments[0].scrollIntoView(true)";
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript(jscode, cart.getsubscribe());
					//Verify text 'SUBSCRIPTION'
					Thread.sleep(2000);
					 boolean data=cart.getsubscribe().isDisplayed();
					 if(data) {
							System.out.println(data+" is displayed");
						}
						else {
							System.out.println(data+"is not displayed");
						}
					 //Enter email address in input and click arrow button
					 cart.getsubemail().sendKeys(email);
						cart.getsubscribe().click();
				//Verify success message 'You have been successfully subscribed!' is visible
							boolean verify_success_message = cart.getsuccessmsg().isDisplayed();
							Thread.sleep(2000);
							if(verify_success_message) {
								System.out.println("Successfull subscribed message is displayed");
							}else {
								System.out.println("Successfull subscribed message is not displayed");
							}
							 //close the browser
					driver.quit();
				}

	}