package PageRepository;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	// Click on 'Products' button
			@FindBy(xpath = "//a[@href='/products']")
			private WebElement productspage;
			public ProductPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			public WebElement getproductspage() {
				return  productspage;
			}
			
					@FindBy(id = "search_product")
			private WebElement searchproduct;
			public WebElement getsearchproduct() {
				return searchproduct;
			}
			// Enter product name in search input and click search button
			
			@FindBy(id = "submit_search")
			private WebElement search;
			public WebElement getsearch() {
				return search;
			}
			
			@FindBy(xpath = "//a[text()='Write Your Review']")
			private WebElement writeyourreview;
			public WebElement getwriteyourreview() {
				return writeyourreview;
			}
			
			@FindBy(xpath = "//input[@id='name']")
			private WebElement namereview;
			public WebElement getnamereview() {
				return namereview;
			}
			@FindBy(xpath = "//input[@id='email']")
			private WebElement emailreview;
			public WebElement getemailreview() {
				return emailreview;
			}
			@FindBy(xpath = "//textarea[@placeholder='Add Review Here!']")
			private WebElement reviewmsg;
			public WebElement getreviewmsg() {
				return reviewmsg;
			}
			
			@FindBy(xpath = "//button[@id='button-review']")
			private WebElement reviewsubmit;
			public WebElement getreviewsubmit() {
				return reviewsubmit;
			}
			
			@FindBy(xpath = "//tr[@id='product-2']")
			private WebElement details1;
			public WebElement getdetails1() {
				return details1;
			}
			@FindBy(xpath = "//tr[@id='product-2']")
			private WebElement details2;
			public WebElement getdetails2() {
				return details2;
			}
			@FindBy(xpath = "//a[@href='/product_details/1']")
			private WebElement viewpro;
			public WebElement getviewpro() {
				return viewpro;
			}
			@FindBy(xpath = "//div[@class='product-information']")
			private WebElement productdetails;
			public WebElement getproductdetails() {
				return productdetails;
			}
			
			@FindBy(xpath = "//input[@id='quantity']")
			private WebElement quantity;
			public WebElement getquantity() {
				return quantity;
			}
			
			@FindBy(xpath = "//button[@type='button']")
			private WebElement addquantity;
			public WebElement getaddquantity() {
				return addquantity;
			}
			
			@FindBy(xpath = "//button[@type='button']")
			private WebElement viewaddquantity;
			public WebElement getviewaddquantity() {
				return viewaddquantity;
			}
			@FindBy(xpath = "//u[text()='View Cart']")
			private WebElement viewprocart;
			public WebElement getviewprocart() {
				return viewprocart;
			}
			
			
			@FindBy(xpath ="//table[@id='cart_info_table']")
			private WebElement viewdetails;
			public WebElement getviewdetails() {
				return viewdetails;
			}
				
				
		      
				// Verify user is navigated to ALL PRODUCTS page and product list is visible successfully
				@FindBy(xpath = "//h2[text()='All Products']")
				private WebElement verifyallproductspage;

				public WebElement getverifyallproductspage() {
					return verifyallproductspage;
				}

				// Click on 'View Product' of first product
				@FindBy(xpath = "//a[@style='color: brown;']/i")
				private WebElement viewproduct;

				public WebElement getviewproduct() {
					return viewproduct;
				}

				// User is landed to product detail page
				@FindBy(xpath = "//h2[text()='Blue Top']")
				private WebElement productdetailpage;

				public WebElement getproductdetailpage() {
					return productdetailpage;
				}

				// Verify that product detail is visible: product name, category, price,
				// availability, condition, brand
				@FindBy(xpath = "//div[@class='product-information']")
				private WebElement verifydetails;

				public WebElement getverifieddetails() {
					return verifydetails;
				}

				

				

				// Verify 'SEARCHED PRODUCTS' is visible
				@FindBy(xpath = "//h2[text()='Searched Products']")
				private WebElement verifysearchedproduct;

				public WebElement getverifiedsearchedproduct() {
					return verifysearchedproduct;
				}

				// Verify all the products related to search are visible
				@FindBy(xpath = "//div[@class='features_items']")
				private WebElement verifyrelatedproduct;

				public WebElement getverifiedrelatedproduct() {
					return verifyrelatedproduct;
				}
				
				   @FindBy(xpath = "//span[text()='Thank you for your review.']")
					private WebElement successmsg;
					public WebElement getsuccessmsg() {
						return successmsg;
					}
					@FindBy(xpath = "//i[@class='material-icons card_travel']")
					private WebElement products_button;
					public WebElement getproducts_button() {
						return products_button;
					}
					@FindBy(xpath = "//div[contains(@class,'alert-succes')]")
					private WebElement orderplacedsuccess;
					public WebElement getorderplacedsuccess() {
						return orderplacedsuccess;
					}
					
			}