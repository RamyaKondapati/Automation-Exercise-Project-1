package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_TestCasesPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC7_VerifyTestCasesPage {

	WebDriver driver;
	AE_HomePage homepage;
	AE_TestCasesPage testcasepage;
	
	@Test
	public void  testcasesButton() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		homepage = new AE_HomePage(driver);
		testcasepage = new AE_TestCasesPage(driver);
		 
		homepage.navigateToHomepageUrl();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/"); 
		testcasepage.clickonTestCasesButton();
		Assert.assertEquals(testcasepage.isTestCasespageVisible(), "https://automationexercise.com/test_cases");
		Assert.assertEquals(testcasepage.isTestcaseHeaderVisible(), "Test Cases header not visible");
		
		
		
	}
}
