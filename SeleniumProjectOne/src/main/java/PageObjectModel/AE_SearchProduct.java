package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_SearchProduct {

	@FindBy(id = "search_product")
	WebElement searchBar;
	@FindBy(id = "submit_search")
	WebElement searchBtn;
	@FindBy(xpath = "//h2[text()='Searched Products']")
	WebElement searchProductsHeader;
//	@FindBy(xpath="//input[@id='search_product' and @name='search']") WebElement searchedPname;
	@FindBy(xpath = "//div[@class='productinfo text-center']/child::p")
	WebElement searchedProductName;
	@FindBy(xpath = "//div[@class='productinfo text-center']/child::p")
	WebElement sRProductname;
	//// div[@class='features_items']/child::div[@class='col-sm-4']
	@FindBy(xpath = "//div[@class='product-image-wrapper']//p")
	List<WebElement> searchResult;
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchedInput;
	

	WebDriver driver;
	public AE_SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterSearchInput(String productname) {
		productname.equalsIgnoreCase(getProductName());
		searchBar.sendKeys(productname);
		searchBtn.click();
	}
	public void clickOnSearchBtn() 
	{
        searchBtn.click();
	}
	public boolean isSearchProductsVisible() {
		return searchProductsHeader.isDisplayed();
	}
	// Method to get the search product name
	public String getProductName() {
		return searchedProductName.getText();
	}
//	    public boolean isSearchedProductVisible() {
//	        return sProductName.getText().equalsIgnoreCase("Availability: In Stock");
//	    }
	public List<WebElement> getSearchResults() {
		System.out.println(searchResult.size());
		for (WebElement search : searchResult) {
			System.out.println(search.getText());
		}
		return searchResult;
	}
	public String spresult() {
		return sRProductname.getText();
	}
	public String searchedInputText() {
		return searchedInput.getText();
	}
}
