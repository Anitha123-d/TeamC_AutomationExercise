package GenericRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import PropertyUtility.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

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

		String expect_url = "https://www.automationexercise.com";
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

	@AfterClass
	public void closebrowser() {
		// close the browser
		driver.quit();
		Reporter.log("Closebrowser Successfull", true);
	}
}