package AutomationExercise;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjectModel.AE_ContactUsPage;
import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCasesAutomation {
	public WebDriver driver;
	WebDriverWait wait;
	AE_HomePage homepage;
	AE_LoginPage loginpage;
	AE_ContactUsPage contactuspage;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		homepage = new AE_HomePage(driver);
		loginpage = new AE_LoginPage(driver);
		contactuspage = new AE_ContactUsPage(driver);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void openUrlAndVerifyHomePage() throws InterruptedException {
		homepage.navigateToHomepageUrl();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/");
		Assert.assertTrue(homepage.isHomepageDisplayed(), "Homepage verification failed.");
	}
	@AfterMethod
	public void afterEachTestCase()
	{
		homepage.clickOnLogoImg();
	}

	@Test(priority = 1)
	public void testRegisterUser() throws InterruptedException, AWTException {
		//homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.newUserSignupVisible(), "New User Signup!");
		homepage.newUserSignup("vijayngk", "vijayngk@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayngk"); // Verify 'Logged in as username' is visible
		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
		homepage.clickOnContinueBtn();
	}

	@Test(priority = 2)
	public void testLoginWithCorrectCredentials() throws InterruptedException {
		//homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijaynk@gmail.com", "koona2019");
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijaynk"); // Verify 'Logged in as username' is visible
	}

	@Test(priority = 3)
	public void testLoginWithIncorrectCredentials() throws InterruptedException {
	//	homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("ramyabata@gmail.com", "ramya123");
		// Verify error message 'Your email or password is incorrect!' is visible
		Assert.assertEquals(loginpage.error_Message(), "Your email or password is incorrect!");
	}

	@Test(priority = 4)
	public void testLogoutUser() throws InterruptedException {
	//	homepage.navigateToHomepageUrl();
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijayk@gmail.com", "koona2019");
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayk"); // Verify 'Logged in as username' is visible
		loginpage.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
	}

}
