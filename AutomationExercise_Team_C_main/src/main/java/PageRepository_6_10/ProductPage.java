package PageRepository_6_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	// Click on 'Products' button
	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement productpage;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getproductpage() {
		return productpage;
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

	// Enter product name in search input and click search button
	@FindBy(id = "search_product")
	private WebElement search_product;

	public WebElement getsearchproduct() {
		return search_product;
	}

	@FindBy(id = "submit_search")
	private WebElement submitsearch;

	public WebElement getsubmitsearch() {
		return submitsearch;
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

}
