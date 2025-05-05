package PageRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	@FindBy(name = "name_on_card")
	private WebElement cardname;

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getcardname() {
		return cardname;
	}

	@FindBy(name = "card_number")
	private WebElement cardnumber;

	public WebElement getcardnumber() {
		return cardnumber;
	}

	@FindBy(name = "cvc")
	private WebElement cvcno;

	public WebElement getcvcno() {
		return cvcno;
	}

	@FindBy(name = "expiry_month")
	private WebElement expirymonth;

	public WebElement getexpirymonth() {
		return expirymonth;
	}

	@FindBy(name = "expiry_year")
	private WebElement expiryyear;

	public WebElement getexpiryyear() {
		return expiryyear;
	}

	@FindBy(xpath ="//button[text()='Pay and Confirm Order']" )
	private WebElement payandconfirmorder;
	public WebElement getpayandconfirmorder() {
		return payandconfirmorder;
	}
	
	@FindBy(xpath = "(//div[@class='alert-success alert'])[1]")
	private WebElement orderplacedmsg;

	public WebElement getoderplacedmsg() {
		return orderplacedmsg;
	}
	
	@FindBy(xpath ="//a[normalize-space(text())='Download Invoice']" )
	private WebElement downloadinvoice;
	public WebElement getdownloadinvoice() {
		return downloadinvoice;
	}
	@FindBy(xpath ="//a[@class='btn btn-primary']" )
	private WebElement continueafterorder;
	public WebElement getcontinueafterorder() {
		return continueafterorder;
	}



}
