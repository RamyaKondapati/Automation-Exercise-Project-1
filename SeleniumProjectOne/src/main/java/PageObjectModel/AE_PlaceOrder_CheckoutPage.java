package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_PlaceOrder_CheckoutPage {
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	WebElement proceedToCheckoutlink;
	@FindBy(xpath = "//u[text()='Register / Login']")
	WebElement register_loginlink;
	@FindBy(name = "message")
	WebElement commentTextarea;
	@FindBy(xpath="//a[text()='Place Order']")
	WebElement placeOrderBtn;
	@FindBy(xpath="//h2[text()='Address Details']")
	WebElement addressDetails;
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[4]") WebElement deliveryAddress;
	@FindBy(xpath="//h2[text()='Review Your Order']")
	WebElement reviewYourOrder;
	@FindBy(xpath="//table[@class='table table-condensed']")
	List<WebElement> cartItemsTableInOrderSummary;
	@FindBy(name="name_on_card")
	WebElement nameOnCard_tb;
	@FindBy(name="card_number")
	WebElement cardNumber;
	@FindBy(name="cvc")
	WebElement cvc;
	@FindBy(name="expiry_month")
	WebElement expiryMonth;
	@FindBy(name="expiry_year")
	WebElement expiryYear;
	@FindBy(xpath="//button[text()='Pay and Confirm Order']")
	WebElement payAndConfirmOrder;
	@FindBy(xpath="//div[@id='success_message']")
	WebElement orderPlacedSuccessfully;
	@FindBy(xpath="//a[text()='Download Invoice']")
	WebElement downloadInvoice;
	@FindBy(xpath="//p[text()='Congratulations! Your order has been confirmed!']")
	WebElement orderConfirmed;
	
	
	
	
	
	
	WebDriver driver;
	public AE_PlaceOrder_CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProceedToCheckout() throws InterruptedException
	{
		Thread.sleep(3000);
		proceedToCheckoutlink.click();
	}
	public void clickOnRegisterLoginlink() throws InterruptedException
	{
		Thread.sleep(3000);
		register_loginlink.click();
	}
	
	public void commentTextarea(String comment)
	{
		System.out.println("No.of cart Items matched");
		commentTextarea.sendKeys(comment);
	}
	public void clickOnPlaceOrderBtn()
	{
		placeOrderBtn.click();
	}
	public String getAddressDetails()
	{
		return addressDetails.getText();
	}
	
	public String getDeliveryAddress()
	{
		return deliveryAddress.getText();
	}
	public String getReviewYourOrder()
	{
		return reviewYourOrder.getText();
	}
	public int cartItemsTableInOrderSummary()
	{
		return cartItemsTableInOrderSummary.size();
	}
	public void enterPaymentDetails(String nameOnCard, String cardnumber, String cvcNo, String expiryMM,String expiryYY)
	{
		nameOnCard_tb.sendKeys(nameOnCard);
		cardNumber.sendKeys(cardnumber);
		cvc.sendKeys(cvcNo);
		expiryMonth.sendKeys(expiryMM);
		expiryYear.sendKeys(expiryYY);
		
	}
	public void clickOnPayAndConfirmOrder()
	{
		payAndConfirmOrder.click();
	}
	public boolean orderPlacedSuccessfully() throws InterruptedException
	{
		Thread.sleep(2000);
		return orderPlacedSuccessfully.isDisplayed();
	}
	public void downloadInvoice()
	{
		downloadInvoice.click();
	}
	
}
