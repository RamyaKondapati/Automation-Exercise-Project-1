package PageObjectModel;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_Subscription {
	
	@FindBy(xpath = "//h2[text()='Subscription']") WebElement subscriptionHeader;
	@FindBy(id = "susbscribe_email") WebElement subscribeEmail_tb;
	@FindBy(xpath="//button[@type='submit']") WebElement arrowBtn;
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']") WebElement successMessage;
	@FindBy(id="footer") WebElement footer;
	@FindBy(xpath="//a[text()=' Cart']") WebElement cartBtn;
	@FindBy(id="scrollUp") WebElement  arrowBtnScrollUp;
	@FindBy(xpath="(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]") WebElement scrollingText;
	
	WebDriver driver;
	JavascriptExecutor js;
	public AE_Subscription(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void scrollToFooter()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", footer);
		//((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView();", footer);
	}
	public void clickOnCartButton() throws InterruptedException
	{
		Thread.sleep(5000);
		cartBtn.click();
	}
	
	public String subcriptionText()
	{
		return subscriptionHeader.getText();	
	}
	public void email_for_subscription(String sub_email)
	{
		subscribeEmail_tb.sendKeys(sub_email);
		arrowBtn.click();
		js.executeScript("arguments[0].scrollIntoView();", cartBtn);
	}
	public String subscribedSuccessMessage()
	{
		return successMessage.getText();
		
	}
	public void clickOnArrowBtnScrollUp()
	{
		arrowBtnScrollUp.click();
	}
	public String scrollingTextVisible()
	{
		return scrollingText.getText();
	}
	public void scrollUpAndVerifyText() {
       
        js.executeScript("window.scrollTo(0, 0)");
	}
}
