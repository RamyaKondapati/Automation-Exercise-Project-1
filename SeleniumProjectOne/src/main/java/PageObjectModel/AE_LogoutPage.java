package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_LogoutPage {
	
	@FindBy(xpath="//a[text()=' Logout']") WebElement logoutBtn;
	
	WebDriver driver;

	public AE_LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		logoutBtn.click();
		
	
	}

}
