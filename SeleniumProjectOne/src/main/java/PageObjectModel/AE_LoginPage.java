package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_LoginPage {
	
	@FindBy(xpath="(//input[@type='email'])[1]") WebElement userEmail;
	@FindBy(xpath="//input[@type='password']") WebElement userPassword;
	@FindBy(xpath="//button[text()='Login']") WebElement loginBtn;
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']") WebElement errorMessage;
	@FindBy(xpath="//a[text()=' Logout']") WebElement logoutBtn;
	
	
	
	WebDriver driver;

	public AE_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToAccount(String email, String pass) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		//loginBtn.click();
	}
	public void clickOnLoginBtn() 
	{
		loginBtn.click();
	}
	// Method to Verify error 'Your email or password is incorrect!' is visible
		 public String error_Message() {
		        return errorMessage.getText();
		            
		    }
		 public void logout()
			{
				logoutBtn.click();
				
			}
	

}
