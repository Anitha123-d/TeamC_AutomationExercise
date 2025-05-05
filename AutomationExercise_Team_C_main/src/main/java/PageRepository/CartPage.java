package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement desiredproduct;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getdesiredproduct() {
		return desiredproduct;
		
	}
	@FindBy(xpath ="//h2[text()='All Products']" )
	private WebElement allproducts;
	public WebElement getallproducts() {
		return allproducts;
}
	@FindBy(xpath = "//a[@href='/view_cart']")
	private WebElement cartpage;
	public WebElement getcartpage() {
		return cartpage;
	}
	@FindBy(xpath = "//h3[text()='Your delivery address']")
	private WebElement deliveryaddress;

	public WebElement getdeliveryaddress() {
		return deliveryaddress;
	}

	@FindBy(xpath = "//h3[text()='Your billing address']")
	private WebElement billingaddress;

	public WebElement getbillingaddress() {
		return billingaddress;
	}
	@FindBy(xpath = "//li[text()='Shopping Cart']")
	private WebElement cartreal;
	public WebElement getcartreal() {
		return cartreal;
	}
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement toHome;
	
	public WebElement gettoHome() {
		return toHome;
	}
	@FindBy(xpath = "//input[@id='susbscribe_email']")
	private WebElement subemail;
	public WebElement getsubemail() {
		return subemail;
	}
	
	@FindBy(id = "subscribe")
	private WebElement subscribe;
	public WebElement getsubscribe() {
		return subscribe;
	}
	@FindBy(xpath = "//a[@data-product-id='2']")
	private WebElement addtocart;
	public WebElement getaddtocart() {
		return addtocart;
	}
	@FindBy(xpath = "//a[@data-product-id='2']/i")
	private WebElement addtocart2;
	public WebElement getaddtocart2() {
		return addtocart2;
	}
	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewcart;
	public WebElement getviewcart() {
		return viewcart;
	}
	@FindBy(xpath = "//a[@href='/view_cart']")
	private WebElement viewcart1;
	public WebElement getviewcart1() {
		return viewcart1;
	}
	
	@FindBy(xpath = "//section[@id='cart_items']")
	private WebElement viewcartverify;
	public WebElement getviewcartverify() {
		return viewcartverify;
	}
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement continueshopping;
	public WebElement getcontinueshopping() {
		return continueshopping;
	}
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement proceedtocheckout;
	public WebElement getproceedtocheckout() {
		return proceedtocheckout;
	}
	
	@FindBy(xpath = "//u[text()='Register / Login']")
	private WebElement registerlogin;
	public WebElement getregisterlogin() {
		return registerlogin;
	}

	
	@FindBy(xpath ="//a[normalize-space(text())='Cart']" )
	private WebElement cart;
	public WebElement getcart() {
		return cart;
	}
	@FindBy(xpath ="//a[text()='Proceed To Checkout']" )
	private WebElement proceedtocheckout2;
	public WebElement getproceedtocheckout2() {
		return proceedtocheckout2;
}
	@FindBy(xpath ="//h2[(text())='Address Details']" )
	private WebElement adressdetails;
	public WebElement getadressdetails() {
		return adressdetails;
	}
	@FindBy(xpath ="//textarea[@name='message']" )
	private WebElement commentbox;
	public WebElement getcommentbox() {
		return commentbox;
	}
	@FindBy(xpath ="//a[normalize-space(text())='Place Order']" )
	private WebElement placeorderbutton;
	public WebElement getplaceorderbutton() {
		return placeorderbutton;
	
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
	@FindBy(xpath = "//ul[@id='address_delivery']")
	private WebElement adddetails1;
	public WebElement getadddetails1() {
		return adddetails1;
	}
	@FindBy(xpath = "//ul[@id='address_invoice']")
	private WebElement addinvoice;
	public WebElement getaddinvoice() {
		return addinvoice;
	}
	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement commentmessage;
	public WebElement getcommentmessage() {
		return commentmessage;
	}

	@FindBy(xpath = "//a[@class='cart_quantity_delete']")
	private WebElement cancle;
	public WebElement getcancle() {
		return cancle;
	}
	
	@FindBy(xpath = "//b[contains(text(),'Cart is empty')]")
	private WebElement cartempty;
	public WebElement getcartempty() {
		return cartempty;
	}

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement orderplacedmsg;
	public WebElement getorderolacedmsg() {
		return orderplacedmsg;
	
	}
	@FindBy(xpath = "//a[text()='Download Invoice']")
	private WebElement doownloadinvoice;
	public WebElement getdoownloadinvoice() {
		return doownloadinvoice;
	}
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement successmsg;
	public WebElement getsuccessmsg() {
		return successmsg;
	}
	@FindBy(xpath = "//a[@data-product-id='3']")
	private WebElement addtocartpage;

	public WebElement getaddtocartpage() {
		return addtocartpage;
	}
	@FindBy(xpath = "//div[@data-qa='checkout-info']")
	private WebElement verifydetails;
	public WebElement getverifydetails() {
		return verifydetails;
	}
	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeorder;
	public WebElement getplaceorder() {
		return placeorder;
	}

}
	
	
	


