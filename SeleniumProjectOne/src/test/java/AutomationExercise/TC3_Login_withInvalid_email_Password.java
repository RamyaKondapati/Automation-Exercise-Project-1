package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC3_Login_withInvalid_email_Password {

	
	WebDriver driver;
	AE_HomePage homepage;
	AE_LoginPage loginpage;
	
	@Test
	public void  login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		homepage = new AE_HomePage(driver);
		loginpage=new AE_LoginPage(driver);
		
		homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("ramyabata@gmail.com", "ramya123");
		// Verify error message 'Your email or password is incorrect!' is visible
		Assert.assertEquals(loginpage.error_Message(), "Your email or password is incorrect!"); 
		
		
	}
}
