package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_LoginPage;
import PageObjectModel.AE_LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4_LogoutUser {
	WebDriver driver;
	AE_HomePage homepage;
	AE_LoginPage loginpage;
	AE_LogoutPage logoutpage;
	
	@Test
	public void  logoutUser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		homepage = new AE_HomePage(driver);
		loginpage=new AE_LoginPage(driver);
        logoutpage = new AE_LogoutPage(driver);
		
		homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijayk@gmail.com", "koona2019");
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayk"); // Verify 'Logged in as username' is visible
		logoutpage.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
		
	}

}
