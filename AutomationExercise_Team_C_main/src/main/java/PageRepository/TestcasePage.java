package PageRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestcasePage {
	// Click on 'Test Cases' button
		@FindBy(xpath = "//a[text()=' Test Cases']")

		private WebElement testcase_button;

		public TestcasePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public WebElement gettestcasebutton() {
			return testcase_button;
		}

		// Verify user is navigated to test cases page successfully
		@FindBy(xpath = "//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']")
		private WebElement verifytestcase;

		public WebElement getverifytestcase() {
			return verifytestcase;
		}

	}

