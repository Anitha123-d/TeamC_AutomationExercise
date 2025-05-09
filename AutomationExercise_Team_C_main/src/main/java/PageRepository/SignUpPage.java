package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signuplink;
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getsignuplink() {
		return  signuplink;
	}
	@FindBy(xpath="//h2[text()='New User Signup!']")
	private WebElement newuser;
	public WebElement getnewuser() {
		return newuser;
	}
	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement verifyhomepage;
	public WebElement getverifiedhomepage() {
		return verifyhomepage;
	}


	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement signup_name;
	public WebElement getsignup_name() {
		return signup_name;
	}
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement signup_mail;
	public WebElement getsignup_mail() {
		return signup_mail;
	}
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement signup_button;
	public WebElement getsignup_button() {
		return signup_button;
	}
	
	@FindBy(xpath = "//input[@value='Mrs']")
	private WebElement fgender;
	public WebElement getfgender() {
		return fgender;
	}
	

	@FindBy(xpath = "//input[@type='password']")
	private WebElement pwd_textfield;
	public WebElement getpwd_textfield() {
		return pwd_textfield;
	}

	@FindBy(name = "days")
	private WebElement daysdp;
	public WebElement getdaysdp() {
		return daysdp;
	}
	@FindBy(name = "months")
	private WebElement monthsdp;
	public WebElement  getmonthsdp() {
		return  monthsdp;
	}
	@FindBy(name = "years")
	private WebElement yearsdp;
	public WebElement  getyearsdp() {
		return  yearsdp;
	}

	
	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement newsletter;
	public WebElement getnewsletter() {
		return newsletter;
	}
	@FindBy(xpath = "//input[@id='optin']")
	private WebElement checkbox2;
	public WebElement getcheckbox2() {
		return checkbox2;
	}
	
	
	
	@FindBy(xpath = "//input[contains(@data-qa,'first_name')]")
	private WebElement first_name;
	public WebElement getfirst_name() {
		return first_name;
	}


	@FindBy(name = "last_name")
	private WebElement last_name;
	public WebElement getlast_name() {
		return last_name;
	}
	@FindBy(id = "company")
	private WebElement company;
	public WebElement getcompany() {
		return company;
	}
	@FindBy(name = "address1")
	private WebElement address1;
	public WebElement getaddress1() {
		return address1;
	}
	@FindBy(name = "address2")
	private WebElement address2;
	public WebElement getaddress2() {
		return address2;
	}
	
	@FindBy(xpath = "//select[@id='country']")
	private WebElement country;
	public WebElement getcountry() {
		return country;
	}
	
	@FindBy(name = "state")
	private WebElement state;
	public WebElement getstate() {
		return state;
	}
	@FindBy(xpath = "//input[@data-qa='city']")
	private WebElement city;
	public WebElement getcity() {
		return city;
	}
	@FindBy(xpath = "//input[@data-qa='zipcode']")
	private WebElement zipcode;
	public WebElement getzipcode() {
		return zipcode;
	}
	@FindBy(xpath = "//input[@data-qa='mobile_number']")
	private WebElement mobile_number;
	public WebElement getmobile_number() {
		return mobile_number;
	}
	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement createAccount;
	public WebElement getcreateAccount() {
		return createAccount;
	}

	@FindBy(xpath = "//b[normalize-space(text())='Account Created!']")
	private WebElement createAccountmsg;
	public WebElement getcreateAccountmsg() {
		return createAccountmsg;
	}
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement conti;
	public WebElement getconti() {
		return conti;
	}
	
	@FindBy(xpath = "//a[text()=' Logged in as ']")
	private WebElement loginas;
	public WebElement getloginas() {
		return loginas;
	}
	//click on delete account
			@FindBy(xpath = "//a[@href='/delete_account']")
			private WebElement delete_account;
			public WebElement getdelete_account() {
				return delete_account ;
			}
			//verify that account deleted is displayed or not
			@FindBy(xpath = "//b[text()='Account Deleted!']")
			private WebElement account_delete;
			public WebElement getaccount_delete() {
				return account_delete ;
			}
			//click on Signup / Login
			@FindBy(xpath="//a[text()=' Signup / Login']")
			private WebElement signup;
			public WebElement getsignup() {
				return signup;
				
			}
			//verify that new user is visible or not

			@FindBy(xpath="//h2[text()='New User Signup!']")
			private WebElement newuser1;
			public WebElement getnewuser1() {
				return newuser;
			}
			//enter user name
			@FindBy(name="name")
			private WebElement name;
			public WebElement getname() {
				return name;
			}
			// enter email
			@FindBy(xpath="//input[@data-qa='signup-email']")
			private WebElement email;
			public WebElement getemail() {
				return email;
			}
			//click on sign up
			@FindBy(xpath="//button[text()='Signup']")
			private WebElement singnupbutton;
			public WebElement getsignupbutton() {
				return singnupbutton ;
			} 
			//verify that Email Address already exist! is displayed or not
			@FindBy(xpath="//p[text()='Email Address already exist!']")
			private WebElement emailpresent ;
			public WebElement getemailpresent () {
				return  emailpresent;
			}
			@FindBy(xpath  = "//a[text()='Continue']")
			private WebElement continueafterdelete;
			public WebElement getcontinueafterdelete() {
				return continueafterdelete;
			}
			@FindBy(xpath="//a[text()=' Signup / Login']")
			private WebElement signup1;
			public WebElement getsignup1() {
				return signup1;
				
			}
			@FindBy(xpath = "//a[text()=' Logged in as ']//b")
			private WebElement loggedinas;
			public WebElement getloggedinas() {
				return loggedinas;
			}
			@FindBy(xpath = "//b[text()='Enter Account Information']")
			private WebElement enterinfo;

			public WebElement getenterinfo() {
				return enterinfo;
			}
			
}