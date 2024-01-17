package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_CartPage {
	
	@FindBy(xpath="//table[@class='table table-condensed']/tbody/tr") List<WebElement> cartItems;
	@FindBy(xpath="//td[@class='cart_description']/h4") WebElement product1Name;  ////td[@class='cart_description']
	@FindBy(xpath="//td[@class='cart_price']") WebElement product1Price;
	@FindBy(xpath="//td[@class='cart_quantity']") WebElement product1Quantity; ////*[@id=\"product-1\"]/td[4]/button
	@FindBy(xpath="//td[@class='cart_total']") WebElement product1TotalPrice;
	
	@FindBy(xpath="//*[@id=\"product-2\"]/td[2]/h4/a") WebElement product2Name;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[3]/p") WebElement product2Price;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[4]/button") WebElement product2Quantity;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[5]/p") WebElement product2TotalPrice;
	@FindBy(xpath="(//a[@class='cart_quantity_delete'])[1]")
	WebElement cartQuantityDelete;
	
	@FindBy(xpath="//h2[text()='recommended items']") WebElement recommendedItems;
	@FindBy(xpath="//div[@class='carousel slide']//a[@data-product-id='4']") WebElement recommendedItemToCart;
	@FindBy(xpath="(//div[@class='carousel slide']/descendant::p)[7]") WebElement recomendedItemstylishDress;
	
	WebDriver driver;
   // Actions actions;
	public AE_CartPage(WebDriver driver) {
		this.driver = driver;
//		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	 
	 public int verifyProductItemsInCart()
	 {
		return cartItems.size();
	 }
	 
	    public String getProductPrice() {
	       
	        return product1Price.getText();
	    }

	    public String getProductQuantity() {
	        
	        return product1Quantity.getText();
	    }

	    public String getProductTotalPrice() {
	       
	        return product1TotalPrice.getText();
	    }
	    public String getProductName() {
	      
	        return product1Name.getText();
	    }
	    
	    public String getProduct2Price() {
		       
	        return product2Price.getText();
	    }

	    public String getProduct2Quantity() {
	        
	        return product2Quantity.getText();
	    }

	    public String getProduct2TotalPrice() {
	       
	        return product2TotalPrice.getText();
	    }
	    public String getProduct2Name() {
	      
	        return product2Name.getText();
	    }

	    public void ClickOnCartQuantityDelete() throws InterruptedException
	    {
	    	cartQuantityDelete.click();
	    	Thread.sleep(2000);
	    }
	    
	    
	    public String getRecommendedItemsItemsText() {

	        return recommendedItems.getText();
	    }
	public void addtoCartOnRecommendedItems()
	{
	recommendedItemToCart.click();	
	}
	
	public String getRecomendedItemName() throws InterruptedException
	{
		Thread.sleep(2000);
		return recomendedItemstylishDress.getText();
	}
	
}
