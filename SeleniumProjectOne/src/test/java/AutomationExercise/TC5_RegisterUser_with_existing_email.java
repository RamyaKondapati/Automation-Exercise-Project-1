package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC5_RegisterUser_with_existing_email {

	WebDriver driver;
	AE_HomePage homepage;
	
	@Test
	public void register_withExistingEmail() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		homepage = new AE_HomePage(driver);

		homepage.navigateToHomepageUrl();
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); // Verify that home page is visible successfully
		homepage.clickOnsignup_login();
		homepage.newUserSignup("vijay", "vijayk@gmail.com");
		//verify error 'Email Address already exist!' is visible
		Assert.assertEquals(homepage.emailAlreadyExist(), "Email Address already exist!");
		
		
	}
	
	
}
