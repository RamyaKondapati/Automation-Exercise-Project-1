package AutomationExercise;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC8_VerifyAllProducts_detailPage {
	WebDriver driver;
	AE_HomePage homepage;
	AE_ProductsPage productspage;
	
	@Test
	public void  verifyProducts() throws InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		homepage = new AE_HomePage(driver);
		productspage = new AE_ProductsPage(driver);
		 
		homepage.navigateToHomepageUrl();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/"); 
		productspage.clickOnProductsButton();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		productspage.allProductsList();
		productspage.viewFirstProduct();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
		
		String expectedProductName = "Blue Top"; 
	    String expectedProductCategory = "Category: Women > Tops";
	    String expectedProductPrice = "Rs. 500"; 
	   
	    String expectedProductCondition = "Condition: New";
	    String expectedProductBrand = "Brand: Polo";

//	    assert productspage.getProductName().equals(expectedProductName);
//	    assert productspage.getProductCategory().equalsIgnoreCase(expectedProductCategory);	
//	    assert productspage.getProductPrice().equalsIgnoreCase(expectedProductPrice);
//	   
//	    assert productspage.getProductCondition().equalsIgnoreCase(expectedProductCondition);	
//	    assert productspage.getProductBrand().equalsIgnoreCase(expectedProductBrand);
//	    assert productspage.isProductAvailable();
	}
}
