package AutomationExercise;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class TC1_RegisterUser {

	WebDriver driver;
	AE_HomePage homepage;

	@Test
	public void signUp_Login() throws InterruptedException, AWTException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		homepage = new AE_HomePage(driver);

		homepage.navigateToHomepageUrl();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/");
		homepage.clickOnsignup_login();
	
		Assert.assertEquals(homepage.newUserSignupVisible(), "New User Signup!");
		homepage.newUserSignup("vijayk", "vijayk@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar", "Road no.6",
				"Telanga", "Hyderabad", "500079", "9000933214");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayk"); // Verify 'Logged in as username' is visible
		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
		homepage.clickOnContinueBtn();
		
}	

}
