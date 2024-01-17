package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2_Login_withValid_email_Password {
	
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
		
		SoftAssert softAssert = new SoftAssert();
		homepage = new AE_HomePage(driver);
		loginpage=new AE_LoginPage(driver);
		
		homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijaynk@gmail.com", "koona2019");
		softAssert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijaynk"); // Verify 'Logged in as username' is visible
		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
		
	}

}
