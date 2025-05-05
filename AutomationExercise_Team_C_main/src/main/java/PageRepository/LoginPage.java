package PageRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Click on 'Signup / Login' button
			@FindBy(xpath = "//a[@href='/login']")
			private WebElement login_page;

			public LoginPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			public WebElement getlogin_page() {
				return login_page;
			}


			// Enter name and email address
			@FindBy(xpath = "//input[@data-qa='login-email']")
			private WebElement email;

			public WebElement getemail() {

				return email;
			}

			@FindBy(xpath = "//input[@type='password']")
			private WebElement pwd;

			public WebElement getpwd() {
				return pwd;
			}

			// Click 'Login' button
			@FindBy(xpath = "//button[text()='Login']")
			private WebElement login;

			public WebElement getlogin() {
				return login;
			}

			//verify that login as user name
			@FindBy(xpath = "//a[text()=' Logged in as ']")
			private WebElement logggedas;
			public WebElement getloggedas() {
				return logggedas;
			}
			// click on delete account
			@FindBy(xpath = "//a[@href='/delete_account']")
			private WebElement deleteaccount;

			public WebElement getdeleteaccount() {
				return deleteaccount;
			}

			// verify that account deleted is displayed or not
			@FindBy(xpath = "//b[text()='Account Deleted!']")
			private WebElement account_delete;

			public WebElement getaccount_delete() {
				return account_delete;
			}
			//conti after delete
			@FindBy(xpath = "//a[text()='Continue']")
			private WebElement delecontinue;
			public WebElement getdelecontinue() {
				return delecontinue;
			}
			// click on login or sign up
			@FindBy(xpath = "//a[text()=' Signup / Login']")
			private WebElement signup;
		
			public WebElement getsignup() {
				return signup;
			}
			// Enter name and email address
					@FindBy(xpath = "//input[@data-qa='login-email']")
					private WebElement email1;

					public WebElement getemail1() {

						return email;
					}

					@FindBy(xpath = "//input[@type='password']")
					private WebElement pwd_textfield;

					public WebElement getpwd_textfeeld() {
						return pwd_textfield;
					}
					// Click 'Login' button
					@FindBy(xpath = "//button[text()='Login']")
					private WebElement login1;

					public WebElement getlogin1() {
						return login1;
					}


			// verify that your email or pwd is incorrect
			@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
			private WebElement invalidmail;

			public WebElement getinvalidmail() {
				return invalidmail;
			}

			// click on log out
			@FindBy(xpath = "//a[@href='/logout']")
			private WebElement logout;

			public WebElement getlogout() {
				return logout;
			}

			// verify that user navigated to home page or not
			@FindBy(xpath = "//a[text()=' Signup / Login']")
			private WebElement homepage;

			public WebElement gethomepage() {
					return homepage;
	
					}
			@FindBy(xpath = "//h2[text()='Login to your account']")
			private WebElement loginaccount ;

			public WebElement getloginaccount() {
				return loginaccount;
			}
				}

		

