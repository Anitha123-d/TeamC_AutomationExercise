package PageRepository_6_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	// Verify that home page is visible successfully
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement verifyhomepage;

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getverifiedhomepage() {
		return verifyhomepage;
	}

	// Scroll down to footer
	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement scrolldown;

	public WebElement getscrolldown() {
		return scrolldown;
	}

	// Verify text 'SUBSCRIPTION'
	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement text;

	public WebElement gettext() {
		return text;
	}

	// Enter email address in input and click arrow button
	@FindBy(id = "susbscribe_email")
	private WebElement subscribeemail;

	public WebElement getsubscribeemail() {
		return subscribeemail;
	}

	@FindBy(id = "subscribe")
	private WebElement subscribebutton;

	public WebElement getsubscribedbutton() {
		return subscribebutton;
	}

	// Verify success message 'You have been successfully subscribed!' is visible
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement subscribedmessage;

	public WebElement getsubscribedmessage() {
		return subscribedmessage;
	}

}
