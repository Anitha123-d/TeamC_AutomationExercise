package GenericRepository;

import java.io.IOException;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageRepository.LoginPage;
import PageRepository.SignUpPage;
import PropertyUtility.ReadPropertyFile;
import excelutility.ReadExcelFile;
import javautility.Randomnumbergeneration;

public class BaseConfig {

	public WebDriver driver;

	public ReadPropertyFile propertyfilelibrary;

	@Parameters({ "Browser", "AuthorName" })
	@BeforeClass
	public void browserSetup(String browser, String username) {


		System.out.println("Username:" + username);

		// Create Object for all library
		createObject();

		// Step 1:Launch the Browser

		if (browser.equals("chrome")) {
			System.out.println("open chrome browser");
			driver = new ChromeDriver();

		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();

		}

		// Fetch Url data from property file

		String URL = propertyfilelibrary.readData("url");

		// Step 2:Maximize the browser
		driver.manage().window().maximize();

		// Step 3:Navigate to the application via URL
		driver.get(URL);

		String expect_url = URL;
		String actual_url = driver.getCurrentUrl();
		System.out.println(actual_url);
		if (expect_url.equals(actual_url)) {
			System.out.println("URL Verified : Test pass");
		} else {
			System.out.println("URL Verified: Test fail");
		}



		Reporter.log("BrowserSetup: " + browser + " Successfull", true);

	}

	public void createObject() {
		propertyfilelibrary = new ReadPropertyFile();

	}

	public void UserCreation() throws IOException {
		{ Randomnumbergeneration ranObj=new Randomnumbergeneration();


		String randomGmail="abc"+ranObj.generaterandomnumber()+"@abcgmail.com";
		String email = randomGmail;

		SignUpPage signuppage_obj=new SignUpPage(driver);
		ReadExcelFile excelfilelibrary = new ReadExcelFile();
		LoginPage l=new LoginPage(driver);
		String username = excelfilelibrary.readData("LoginDetails", 4, 0);
		//String randomGmail = excelfilelibrary.readData("LoginDetails", 4, 1);
		String password = excelfilelibrary.readData("LoginDetails", 4, 2);
		String firstname = excelfilelibrary.readData("LoginDetails", 4, 3);
		String lastname = excelfilelibrary.readData("LoginDetails", 4, 4);
		String company = excelfilelibrary.readData("LoginDetails", 4, 5);
		String address = excelfilelibrary.readData("LoginDetails", 4, 6);
		String address2 = excelfilelibrary.readData("LoginDetails", 4, 7);
		String state = excelfilelibrary.readData("LoginDetails", 4, 8);
		String city = excelfilelibrary.readData("LoginDetails", 4, 9);
		String zipcode = excelfilelibrary.readData("LoginDetails", 4, 10);
		String mobilenumber = excelfilelibrary.readData("LoginDetails", 4, 11);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		signuppage_obj.getsignuplink().click();
		signuppage_obj.getsignup_name().sendKeys(username);
		signuppage_obj.getsignup_mail().sendKeys(email);
		signuppage_obj.getsignup_button().click();
		signuppage_obj.getfgender().click();
		signuppage_obj.getpwd_textfield().sendKeys(password);
		Select obj = new Select(signuppage_obj.getdaysdp());
		obj.selectByIndex(4);
		Select obj1 = new Select(signuppage_obj.getmonthsdp());
		obj1.selectByIndex(6);
		Select obj3 = new Select(signuppage_obj.getyearsdp());
		obj3.selectByIndex(6);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",signuppage_obj.getnewsletter());
		js.executeScript("arguments[0].click();",signuppage_obj.getcheckbox2());
		
	
		signuppage_obj.getfirst_name().sendKeys(firstname);
		signuppage_obj.getlast_name().sendKeys(lastname);
		signuppage_obj.getcompany().sendKeys(company);
		signuppage_obj.getaddress1().sendKeys(address);
		signuppage_obj.getaddress2().sendKeys(address2);
		signuppage_obj.getstate().sendKeys(state);
		signuppage_obj.getcity().sendKeys(city);
		signuppage_obj.getzipcode().sendKeys(zipcode);
		signuppage_obj.getmobile_number().sendKeys(mobilenumber);
		js.executeScript("arguments[0].click();",signuppage_obj.getcreateAccount());
		signuppage_obj.getconti().click();
		
		l.getlogout().click();
		}
	}
	@AfterClass
	public void closebrowser() {
		// close the browser
		driver.quit();
		Reporter.log("Closebrowser Successfull", true);
	}
}