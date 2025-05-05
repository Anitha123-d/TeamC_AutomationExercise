package PageRepository_6_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Us {
	@FindBy(xpath = "//a[text()=' Contact us']")
	private WebElement contact_button;

	public Contact_Us(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getcontact_button() {
		return contact_button;
	}

	// Verify 'GET IN TOUCH' is visible
	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement getintouch;

	public WebElement getgetintouch() {
		return getintouch;
	}

	// Enter name, email, subject and message
	@FindBy(xpath = "//input[@name='name']")
	private WebElement name;

	public WebElement getname() {
		return name;
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;

	public WebElement getemail() {
		return email;
	}

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subject;

	public WebElement getsubject() {
		return subject;
	}

	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement message;

	public WebElement getmessage() {
		return message;
	}

	// Upload the file
	@FindBy(xpath = "//input[@name='upload_file']")
	private WebElement fileupload;

	public WebElement getfileupload() {
		return fileupload;
	}

	// Click 'Submit' button
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit_button;

	public WebElement getsubmit_button() {
		return submit_button;
	}

	// Verify success message 'Success! Your details have been submitted
	// successfully.' is visible
	@FindBy(xpath = "(//div[text()='Success! Your details have been submitted successfully.'])[1]")
	private WebElement successmessage;

	public WebElement getsuccessmessage() {
		return successmessage;
	}

	// Click 'Home' button and verify that landed to home page successfully
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement clickhomepage;

	public WebElement getclickhomepage() {
		return clickhomepage;
	}
	
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement verifyhomepage;
	public WebElement getverifiedhomepage() {
		return verifyhomepage;
	}

}
