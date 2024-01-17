package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_ContactUsPage {
	
	@FindBy(xpath="//a[text()=' Contact us']") WebElement contactUsBtn;
	@FindBy(xpath="//h2[text()='Get In Touch']") WebElement getInTouchHeader;
	@FindBy(name="name") WebElement name_tb;
	@FindBy(name="email") WebElement email_tb;
	@FindBy(name="subject") WebElement subject_tb;
	@FindBy(name="message") WebElement message_tb;
	@FindBy(name="upload_file") WebElement uploadFile;
	@FindBy(name="submit") WebElement submitBtn;
	@FindBy(xpath="//a[@class='btn btn-success']") WebElement homeSuccessBtn;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement successMsg;
	
	
	WebDriver driver;
	public AE_ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnContactUs()
	{
		contactUsBtn.click();
		
	}
	public void contactUsForm(String name,String email,String subject,String message,String filepath) 
	{
		
		name_tb.sendKeys(name);
		email_tb.sendKeys(email);
		subject_tb.sendKeys(subject);
		message_tb.sendKeys(message);
		uploadFile.sendKeys(filepath);
	}
	public void clickSubmitAndOkButton() {
		submitBtn.click();
		driver.switchTo().alert().accept();
	}
		
//		try {
//			//Verify that 'ENTER ACCOUNT INFORMATION' is visible
//			if (successMsg.getText().equals("Success! Your details have been submitted successfully.")) {
//				System.out.println("Success Message is visible");
//			} else {
//				System.out.println("Success Message is not visible");
//			}
//			}catch(Exception e)
//			{
//				System.out.println(e.getMessage());
//			}
		//homeSuccessBtn.click();
		
	
	public void clickonHomeSuccessBtn()
	{
		homeSuccessBtn.click();
	}
	public boolean isGetInTouchVisible() {
        return getInTouchHeader.isDisplayed();
    }
	public boolean isSuccessMessageVisible()
	{
		return successMsg.isDisplayed();
		
	}
	

}
