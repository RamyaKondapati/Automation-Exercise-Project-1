package AutomationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_ProductsPage;
import PageObjectModel.AE_SearchProduct;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC9_SearchProduct {
	
		WebDriver driver;
		AE_HomePage homepage;
		AE_ProductsPage productspage;
		AE_SearchProduct searchpage;
		
		@Test
		public void  verifyProducts() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			homepage = new AE_HomePage(driver);
			productspage = new AE_ProductsPage(driver);
			searchpage = new AE_SearchProduct(driver);
			 
			homepage.navigateToHomepageUrl();
			Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/"); 
			productspage.clickOnProductsButton();
			Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
			searchpage.enterSearchInput("tshirt");
			Assert.assertTrue(searchpage.isSearchProductsVisible(), "Search products not visible");
			//searchpage.getSearchResults();
			
			String expectedProductName = "tshirt";
			//assert searchpage.getProductName().matches(expectedProductName);
			SoftAssert sassert = new SoftAssert();
			sassert.assertEquals(searchpage.getSearchResults(), "6");
			sassert.assertEquals(searchpage.getProductName(), expectedProductName);
			
		}

}
