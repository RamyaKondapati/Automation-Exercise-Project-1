package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.AE_ContactUsPage;
import PageObjectModel.AE_HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6_ContactUsForm {

	WebDriver driver;
	//String baseUrl = "https://automationexercise.com/";
	AE_HomePage homepage;
	AE_ContactUsPage contactpage;

	@Test
	public void contactUsForm() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		homepage = new AE_HomePage(driver);
		contactpage = new AE_ContactUsPage(driver);
		SoftAssert softAssert = new SoftAssert();

		
		homepage.navigateToHomepageUrl();
		contactpage.clickOnContactUs();
        softAssert.assertTrue(contactpage.isGetInTouchVisible(), "'GET IN TOUCH' header is not visible.");
		assert contactpage.isGetInTouchVisible();
		contactpage.contactUsForm("Ramya", "ramya@gmail.com", "Testing form", "Automation Testing purpose",
				"D:\\Desktop\\Myself.txt");
		softAssert.assertTrue(contactpage.isSuccessMessageVisible(), "Success message is not visible.");
        contactpage.clickonHomeSuccessBtn();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/", "Did not land on the home page.");

		// Collect all the assertion failures
		softAssert.assertAll();
		
	}

}
