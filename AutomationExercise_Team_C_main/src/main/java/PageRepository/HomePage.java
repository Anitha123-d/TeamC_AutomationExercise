package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Verify that home page is visible successfully
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement verifyhomepage;

	public HomePage(WebDriver driver) {
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

	@FindBy(xpath = "(//h2[@class='title text-center'])[2]")
	private WebElement recommendeditems;

	public WebElement getrecommendeditems() {
		return recommendeditems;
	}

	@FindBy(xpath = "//a[@data-product-id='1']")
	private WebElement addtocart;

	public WebElement getaddtocart() {
		return addtocart;

	}

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewcart;

	public WebElement getviewcart() {
		return viewcart;
	}

	@FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
	private WebElement practicepage;

	public WebElement getpracticepage() {
		return practicepage;
	}

	@FindBy(xpath = "//footer[@id='footer']")
	private WebElement scrollingup;

	public WebElement getscrollingup() {
		return scrollingup;
	}

	@FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
	private WebElement scrolleduppage;

	public WebElement getscrolleduppage() {
		return scrolleduppage;
	}

	@FindBy(xpath = "//h2[text()='Category']")
	private WebElement category;

	public WebElement getcategory() {
		return category;
	}

	@FindBy(xpath = "//footer[@id='footer']")
	private WebElement uparrow;

	public WebElement getuparrow() {
		return uparrow;
	}

	@FindBy(xpath = "//div[@class='panel-heading']/h4/a[@href='#Women']")
	private WebElement women;

	public WebElement getwomen() {
		return women;
	}

	@FindBy(xpath = "//a[text()='Dress ']")
	private WebElement dress;

	public WebElement getdress() {
		return dress;
	}

	@FindBy(xpath = "//a[text()='Dress ']/following::li/a[text()='Tops ']")
	private WebElement tops;

	public WebElement gettops() {
		return tops;
	}

	@FindBy(xpath = "//a[text()='Saree ']")
	private WebElement saree;

	public WebElement getsaree() {
		return saree;
	}

	@FindBy(xpath = "//span[@class='badge pull-right']/i/following::span")
	private WebElement men;

	public WebElement getmen() {
		return men;
	}

	@FindBy(xpath = "//a[text()='Tshirts ']")
	private WebElement mentshirt;

	public WebElement getmentshirt() {
		return mentshirt;
	}

	@FindBy(xpath = "//a[text()='Jeans ']")
	private WebElement menjeans;

	public WebElement getmentjeans() {
		return menjeans;
	}

	@FindBy(xpath = "//span[@class='badge pull-right']/i/following::span/i/following::span")
	private WebElement kids;

	public WebElement getkids() {
		return kids;
	}

	@FindBy(xpath = "//a[text()='Dress ']")
	private WebElement dress1;

	public WebElement getdress1() {
		return dress1;

	}

	@FindBy(xpath = "//a[text()='Tops & Shirts ']")
	private WebElement topsandshirts;

	public WebElement gettopsandshirts() {
		return topsandshirts;
	}

	@FindBy(xpath = "//h2[text()='Brands']")
	private WebElement brand;

	public WebElement getbrand() {
		return brand;
	}

	@FindBy(xpath = "//a[text()='Polo']")
	private WebElement polo;

	public WebElement getpolo() {
		return polo;
	}

	@FindBy(xpath = "//a[text()='H&M']")
	private WebElement HandM;

	public WebElement getHandM() {
		return HandM;
	}

	@FindBy(xpath = "//a[text()='Madame']")
	private WebElement Madame;

	public WebElement getMadame() {
		return Madame;
	}

	@FindBy(xpath = "//a[text()='Mast & Harbour']")
	private WebElement Mastandhar;

	public WebElement getMastandhar() {
		return Mastandhar;
	}

	@FindBy(xpath = "//a[text()='Babyhug']")
	private WebElement Babyhug;

	public WebElement getBabyhug() {
		return Babyhug;
	}

	@FindBy(xpath = "//a[text()='Allen Solly Junior']")
	private WebElement AllenSollyJunior;

	public WebElement getAllenSollyJunior() {
		return AllenSollyJunior;
	}

	@FindBy(xpath = "//a[text()='Kookie Kids']")
	private WebElement KookieKids;

	public WebElement getKookieKids() {
		return KookieKids;
	}

	@FindBy(xpath = "//a[text()='Biba']")
	private WebElement Biba;

	public WebElement getBiba() {
		return Biba;
	}

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement polopage;

	public WebElement getpolopage() {
		return polopage;
	}

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement HandMpage;

	public WebElement getHandMpage() {
		return HandMpage;
	}

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement dresspage;

	public WebElement getdresspage() {
		return dresspage;
	}

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement mentshirtpage;

	public WebElement getmentshirtpage() {
		return mentshirtpage;
	}
}
