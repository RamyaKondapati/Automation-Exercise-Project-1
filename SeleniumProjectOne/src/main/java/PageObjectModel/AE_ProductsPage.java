package PageObjectModel;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AE_ProductsPage {
	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productsBtn;
	@FindBy(xpath = "//div[@class='product-image-wrapper']")
	List<WebElement> productsList;
	@FindBy(xpath = "(//a[text()='View Product'])[1]")
	WebElement viewFirstProduct;
	@FindBy(xpath = "(//div[@class='choose'])[2]")
	WebElement viewSecondProduct;
	
	@FindBy(xpath="//div[@class='product-information']")
	WebElement product_Info_Details;
	@FindBy(xpath = "//h2[text()='Blue Top']")
	WebElement productName;
	@FindBy(xpath = "//div[@class='product-information']/h2")
	WebElement productNameInDetails;
	
	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	WebElement productCategory;
	@FindBy(xpath = "//span[text()='Rs. 500']")
	WebElement productPrice;
	@FindBy(xpath = "//p[text()=' In Stock']")
	WebElement productAvailability;
	@FindBy(xpath = "//p[text()=' New']")
	WebElement productCondition;
	@FindBy(xpath = "//p[text()=' Polo']")
	WebElement productBrand;

	
	@FindBy(xpath="(//div[@class='product-overlay'])[1]") WebElement hoverFirstProduct;
	@FindBy(xpath="(//div[@class='product-overlay'])[2]") WebElement hoverSecondProduct;
	@FindBy(xpath="(//div[@class='overlay-content']/child::a[text()='Add to cart'])[1]") WebElement firstAddtocartBtn;
	@FindBy(xpath="(//div[@class='overlay-content']/child::a[text()='Add to cart'])[2]") WebElement secondAddtocartBtn;
	@FindBy(xpath="//button[text()='Continue Shopping']") WebElement continueShoppingBtn;
	@FindBy(xpath="(//p[@class='text-center'])[2]")WebElement viewCartlink;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[2]/h4")WebElement product1Name;
	@FindBy(xpath="(//td[@class='cart_price'])[1]")WebElement product1price;
	@FindBy(xpath="(//td[@class='cart_quantity'])[1]")WebElement product1Quantity;
	@FindBy(xpath="(//td[@class='cart_total'])[1]")WebElement product1CartTotal;
	
	@FindBy(xpath="(//td[@class='cart_description']/h4)[2]")WebElement product2Name;
	@FindBy(xpath="(//td[@class='cart_price'])[2]")WebElement product2price;
	@FindBy(xpath="(//td[@class='cart_quantity'])[2]")WebElement product2Quantity;
	@FindBy(xpath="(//td[@class='cart_total'])[2]")WebElement product2CartTotal;
	
	@FindBy(name="quantity") WebElement quantity;		
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button") WebElement addToCartBtnInPInfo;				
							
	@FindBy(xpath="(//div[@class='col-sm-12'])[1]") WebElement writeReview;
	@FindBy(id="name") WebElement addName;
	@FindBy(id="email") WebElement addEmail;
	@FindBy(id="review") WebElement addReview;
	@FindBy(id="button-review") WebElement submitReview;
	@FindBy(xpath="//span[text()='Thank you for your review.']") WebElement reviewSuccessMsg;
	
	
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
//	WebDriver wait = new WebDriverWait(driver, 10);;

	public AE_ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnProductsButton() 
	{
	productsBtn.click();	
	}
	 public void hoverOverFirstProduct() throws InterruptedException, AWTException 
	 {
		 Thread.sleep(5000);
			Robot robot = new Robot();
			System.out.println("About to zoom out");
			for (int i = 0; i < 2; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
       actions.moveToElement(hoverFirstProduct).perform();
       firstAddtocartBtn.click();
       Thread.sleep(4000);
     }

	 public void hoverOverSecondProduct() throws InterruptedException 
	 {
		Thread.sleep(3000);
       actions.moveToElement(hoverSecondProduct).perform();
       secondAddtocartBtn.click();
       Thread.sleep(3000);
     }
	 public void clickcOnCtinueShoppingBtn()
		{
			continueShoppingBtn.click();
		}
		public void clickOnviewCartlink() throws AWTException
		{
			viewCartlink.click();
			Robot robot = new Robot();
			System.out.println("About to zoom out");
			for (int i = 0; i < 2; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_ADD);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
		}
		
		public String product1Name()
		{
			return product1Name.getText();
		}
		public String product1price()
		{
			return product1price.getText();
		}
		public String product1Quantity()
		{
			return product1Quantity.getText();
		}
		public String product1CartTotal()
		{
			return product1CartTotal.getText();
		}
		
		public String product2Name()
		{
			return product2Name.getText();
		}
		public String product2price()
		{
			return product2price.getText();
		}
		public String product2Quantity()
		{
			return product2Quantity.getText();
		}
		public String product2CartTotal()
		{
			return product2CartTotal.getText();
		}

	public List<WebElement> allProductsList() {

		System.out.println(productsList.size());
		System.out.println("Products Text :: ");
		for (WebElement product : productsList) {
			System.out.println(product.getText());
		}

		return productsList;

	}

	public void viewFirstProduct() throws InterruptedException, AWTException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", viewFirstProduct);
	
		viewFirstProduct.click();
		System.out.println("view Product clicked");
		Thread.sleep(3000);
	}
	public void viewSecondProduct() throws InterruptedException, AWTException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", viewSecondProduct);
	
		viewSecondProduct.click();
		System.out.println("view Product clicked");
		Thread.sleep(3000);
	}
	
	public boolean productInfoDetails()
	{
		return product_Info_Details.isDisplayed();
	}
	public String productNameInDetails()
	{
		return productNameInDetails.getText();
	}
	public void allProductDetails()
	{
		
	}
	
	public void increaseQuantity(int quantities)
	{
		quantity.clear();
		quantity.sendKeys(String.valueOf(quantities));
	}
	public void addToCartBtnInProductInfo()
	{
		addToCartBtnInPInfo.click();
	}

	public boolean getProductName() {
		return productName.isDisplayed();
	}

	public boolean getProductCategory() {

		return productCategory.isDisplayed();
	}

	public boolean getProductPrice() {
		return productPrice.isDisplayed();
	}

	public boolean isProductAvailable() {
		return productAvailability.getText().equalsIgnoreCase("Stock");
	}

	public boolean getProductCondition() {
		return productCondition.isDisplayed();
	}

	public boolean getProductBrand() {
		return productBrand.isDisplayed();
	}
	public boolean getWriteYourReviewText()
	{
		return writeReview.isDisplayed();
	}
	public void writeYourReview(String reviewName,String emailAddress,String enterReview)
	{
		addName.sendKeys(reviewName);
		addEmail.sendKeys(emailAddress);
		addReview.sendKeys(enterReview);
		submitReview.click();
	}
	public String thanksForYourReviewSuccessMsg()
	{
		return reviewSuccessMsg.getText();
	}
}
