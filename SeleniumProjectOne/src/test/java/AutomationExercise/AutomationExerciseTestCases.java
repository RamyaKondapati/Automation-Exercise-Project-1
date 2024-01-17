package AutomationExercise;

import java.awt.AWTException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.AE_CartPage;
import PageObjectModel.AE_CategoryPage;
import PageObjectModel.AE_ContactUsPage;
import PageObjectModel.AE_HomePage;
import PageObjectModel.AE_LoginPage;
import PageObjectModel.AE_PlaceOrder_CheckoutPage;
import PageObjectModel.AE_ProductsPage;
import PageObjectModel.AE_SearchProduct;
import PageObjectModel.AE_Subscription;
import PageObjectModel.AE_TestCasesPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationExerciseTestCases {
	public WebDriver driver;
	WebDriverWait wait;

	AE_HomePage homepage;
	AE_LoginPage loginpage;
	AE_ContactUsPage contactuspage;
	AE_TestCasesPage testcasepage;
	AE_ProductsPage productspage;
	AE_SearchProduct searchpage;
	AE_Subscription subscribe;
	AE_CartPage cartpage;
	AE_PlaceOrder_CheckoutPage checkoutpage;
	AE_CategoryPage categorypage;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();
//		WebDriverManager.firefoxdriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver();
//		driver = new EdgeDriver();
//		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		homepage = new AE_HomePage(driver);
		loginpage = new AE_LoginPage(driver);
		contactuspage = new AE_ContactUsPage(driver);
		testcasepage = new AE_TestCasesPage(driver);
		productspage = new AE_ProductsPage(driver);
		searchpage = new AE_SearchProduct(driver);
		subscribe = new AE_Subscription(driver);
		cartpage = new AE_CartPage(driver);
		checkoutpage = new AE_PlaceOrder_CheckoutPage(driver);
		categorypage = new AE_CategoryPage(driver);
	}

//	@AfterClass
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

	@BeforeMethod
	public void openUrlAndVerifyHomePage() throws InterruptedException {
		homepage.navigateToHomepageUrl();
		Assert.assertEquals(homepage.isHomepageVisible(), "https://automationexercise.com/");
		Assert.assertTrue(homepage.isHomepageDisplayed(), "Homepage verification failed.");
	}

//	@AfterMethod
//	public void afterEachTestCase() {
//		homepage.clickOnLogoImg();
//	}

	@Test(priority = 1)
	public void testRegisterUser() throws InterruptedException, AWTException {

		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.newUserSignupVisible(), "New User Signup!");
		homepage.newUserSignup("Chershitha", "Chershitha@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		Assert.assertEquals(homepage.isAccountCreatedVisible(), "ACCOUNT CREATED!");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "Chershitha"); // Verify 'Logged in as username' is
																					// visible
		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
		homepage.clickOnContinueBtn();
	}

	@Test(priority = 2)
	public void testLoginWithCorrectCredentials() {

		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijayk@gmail.com", "koona2019");
		loginpage.clickOnLoginBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayk");
//		homepage.clickDeleteAccoutBtn();
//		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
	}

	@Test(priority = 3)
	public void testLoginWithIncorrectCredentials() {
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("ramyabata@gmail.com", "ramya123");
		loginpage.clickOnLoginBtn();
		Assert.assertEquals(loginpage.error_Message(), "Your email or password is incorrect!"); // Verify error message
																								// 'Your email or
																								// password is
																								// incorrect!' is
																								// visible
	}

	@Test(priority = 4)
	public void testLogoutUser() {
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.loginAccountVisible(), "Login to your account");
		loginpage.loginToAccount("vijayk@gmail.com", "koona2019");
		loginpage.clickOnLoginBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayk");
		loginpage.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
	}

	@Test(priority = 5)
	public void testRegisterUserWithExistingEmail() {
		homepage.clickOnsignup_login();
		Assert.assertEquals(homepage.newUserSignupVisible(), "New User Signup!");
		homepage.newUserSignup("vijay", "vijayk@gmail.com");
		Assert.assertEquals(homepage.emailAlreadyExist(), "Email Address already exist!"); // verify error 'Email
																							// Address already exist!'
																							// is visible
	}

	@Test(priority = 6)
	public void testContactUsForm() {
		contactuspage.clickOnContactUs();
		Assert.assertTrue(contactuspage.isGetInTouchVisible(), "Get in touch text is not visible");
		// wait.until(ExpectedConditions.visibilityOf(contactuspage.isGetInTouchVisible());
		contactuspage.contactUsForm("ramya", "ramyabattula@gmail.com", "subject for test", "Automation Testing purpose",
				"D:\\Desktop\\Myself.txt");
		contactuspage.clickSubmitAndOkButton();
		Assert.assertTrue(contactuspage.isSuccessMessageVisible(), "Success Message not Displayed");
		homepage.clickOnHomeButton();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");

	}

	@Test(priority = 7)
	public void testVerifyTestCasesPage() throws InterruptedException {
		testcasepage.clickonTestCasesButton();

		// wait.until(ExpectedConditions.textToBePresentInElement(testcasepage.isTestcaseHeaderVisible(),
		// ""));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated((testcasepage.isTestcaseHeaderVisible()));
		Thread.sleep(2000);
		Assert.assertTrue(testcasepage.isTestcaseHeaderVisible(), "Test Cases header not visible");
		Assert.assertEquals(testcasepage.isTestCasespageVisible(), "https://automationexercise.com/test_cases");
	}

	@Test(priority = 8)
	public void testVerifyAllProductsAndProductDetailpage() throws InterruptedException, AWTException {
		productspage.clickOnProductsButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		productspage.allProductsList();
		productspage.viewFirstProduct();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
		Assert.assertTrue(productspage.productInfoDetails(), "Product Details Not Visible");

	}

	@Test(priority = 9)
	public void testSearchProduct() throws UnsupportedEncodingException {
		productspage.clickOnProductsButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		searchpage.enterSearchInput("tops");
		searchpage.clickOnSearchBtn();
		Assert.assertTrue(searchpage.isSearchProductsVisible(), "Search products not visible");
		// Verify all the products related to the search are visible
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> searchedProducts = searchpage.getSearchResults();
		softAssert.assertFalse(searchedProducts.isEmpty(), "No products found for the search");
		softAssert.assertTrue(searchpage.searchedInputText().contains(searchpage.spresult()));
	}

	@Test(priority = 10)
	public void testVerifySubscriptionInHomepage() {
		subscribe.scrollToFooter();
		Assert.assertEquals(subscribe.subcriptionText(), "SUBSCRIPTION");
		subscribe.email_for_subscription("ramyabattula@gmail.com");
		String expSuccessMsg = "You have been successfully subscribed!";
		Assert.assertEquals(subscribe.subscribedSuccessMessage(), expSuccessMsg);

	}

	@Test(priority = 11)
	public void testVerifySubscriptionInCartpage() throws InterruptedException {
		subscribe.clickOnCartButton();
		subscribe.scrollToFooter();
		Assert.assertEquals(subscribe.subcriptionText(), "SUBSCRIPTION");
		subscribe.email_for_subscription("ramyabattula@gmail.com");
		String expSuccessMsg = "You have been successfully subscribed!";
		Assert.assertEquals(subscribe.subscribedSuccessMessage(), expSuccessMsg);

	}

	@Test(priority = 12)
	public void testAddProductsInCart() throws AWTException, InterruptedException {
		productspage.clickOnProductsButton();
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), 2);
		// Verify product 1 details
		Assert.assertEquals(cartpage.getProductName(), productspage.product1Name());
		Assert.assertEquals(cartpage.getProductPrice(), productspage.product1price());
		Assert.assertEquals(cartpage.getProductQuantity(), productspage.product1Quantity());
		Assert.assertEquals(cartpage.getProductTotalPrice(), productspage.product1CartTotal());
		Assert.assertEquals(cartpage.getProduct2Name(), productspage.product2Name());
		Assert.assertEquals(cartpage.getProduct2Price(), productspage.product2price());
		Assert.assertEquals(cartpage.getProduct2Quantity(), productspage.product2Quantity());
		Assert.assertEquals(cartpage.getProduct2TotalPrice(), productspage.product2CartTotal());

	}

	@Test(priority = 13)
	public void testVerifyProductQuantityInCart() throws InterruptedException, AWTException {
		homepage.clickOnViewProductHomepage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/6");
		Assert.assertTrue(productspage.productInfoDetails(), "Product Details Not Visible");
		productspage.increaseQuantity(4);
		productspage.addToCartBtnInProductInfo();
		productspage.clickOnviewCartlink();
		Assert.assertEquals(cartpage.getProductQuantity(), productspage.product1Quantity());

	}

	@Test(priority = 14)
	public void testPlaceOrder_RegisterWhileCheckout() throws InterruptedException, AWTException {

		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();

		checkoutpage.clickOnProceedToCheckout();
		checkoutpage.clickOnRegisterLoginlink();
		homepage.newUserSignup("vijayramya", "vijayramya@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		Assert.assertEquals(homepage.isAccountCreatedVisible(), "ACCOUNT CREATED!");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "vijayramya");
		subscribe.clickOnCartButton();
		checkoutpage.clickOnProceedToCheckout();
		Assert.assertEquals(checkoutpage.getAddressDetails(), "Address Details");
		Assert.assertEquals(checkoutpage.getReviewYourOrder(), "Review Your Order");
		// int noOfItemsInCart = cartpage.verifyProductItemsInCart();
		// Assert.assertEquals(noOfItemsInCart,
		// checkoutpage.cartItemsTableInOrderSummary());
		// checkoutpage.cartItemsTableInOrderSummary();
		checkoutpage.commentTextarea("Coments in textarea Message...");
		checkoutpage.clickOnPlaceOrderBtn();
		checkoutpage.enterPaymentDetails("Minnu", "2021", "313", "04", "24");
		checkoutpage.clickOnPayAndConfirmOrder();
		Assert.assertTrue(checkoutpage.orderPlacedSuccessfully(), "order Failed");

		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");

	}

	@Test(priority = 15)
	public void testPlaceOrder_RegisterBeforeCheckout() throws InterruptedException, AWTException {
		homepage.clickOnsignup_login();
		homepage.newUserSignup("nagendrak", "nagendrak@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		Assert.assertEquals(homepage.isAccountCreatedVisible(), "ACCOUNT CREATED!");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "nagendrak");
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		subscribe.clickOnCartButton();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), "2");
		checkoutpage.clickOnProceedToCheckout();
		Assert.assertEquals(checkoutpage.getAddressDetails(), "Address Details");
		Assert.assertEquals(checkoutpage.getReviewYourOrder(), "Review Your Order");
		int noOfItemsInCart = cartpage.verifyProductItemsInCart();
		Assert.assertEquals(noOfItemsInCart, checkoutpage.cartItemsTableInOrderSummary());
		// checkoutpage.cartItemsTableInOrderSummary();
		checkoutpage.commentTextarea("Coments in textarea Message...");
		checkoutpage.clickOnPlaceOrderBtn();
		checkoutpage.enterPaymentDetails("Minnu", "2021", "313", "04", "24");
		checkoutpage.clickOnPayAndConfirmOrder();
		Assert.assertTrue(checkoutpage.orderPlacedSuccessfully(), "order Failed");

		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");

	}

	@Test(priority = 16)
	public void testPlaceOrder_LoginBeforeCheckout() throws InterruptedException, AWTException {
		homepage.clickOnsignup_login();
		loginpage.loginToAccount("ramyabattula@gmail.com", "koona2019");
		loginpage.clickOnLoginBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "ramya");
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		subscribe.clickOnCartButton();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), "2");
		checkoutpage.clickOnProceedToCheckout();
		Assert.assertEquals(checkoutpage.getAddressDetails(), "Address Details");
		Assert.assertEquals(checkoutpage.getReviewYourOrder(), "Review Your Order");
		int noOfItemsInCart = cartpage.verifyProductItemsInCart();
		Assert.assertEquals(noOfItemsInCart, checkoutpage.cartItemsTableInOrderSummary());
		// checkoutpage.cartItemsTableInOrderSummary();
		checkoutpage.commentTextarea("Coments in textarea Message...");
		checkoutpage.clickOnPlaceOrderBtn();
		checkoutpage.enterPaymentDetails("Minnu", "2021", "313", "04", "24");
		checkoutpage.clickOnPayAndConfirmOrder();
		Assert.assertTrue(checkoutpage.orderPlacedSuccessfully(), "order Failed");

		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");

	}

	@Test(priority = 17)
	public void testRemoveProductsFromCart() throws InterruptedException, AWTException {
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		subscribe.clickOnCartButton();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), 2);
		cartpage.ClickOnCartQuantityDelete();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), 1);

	}

	@Test(priority = 18)
	public void testViewCategoryProducts() throws InterruptedException {
		Assert.assertEquals(categorypage.getCategoryHeader(), "CATEGORY");
		categorypage.clickOnWomenCategory();
		categorypage.clickOnWomenCategoryDress();
		Assert.assertTrue(categorypage.isCategoryPageDisplayed(), "Category page for Women-Dress not displayed");
		Assert.assertEquals(categorypage.womenDressProducts(), "WOMEN - DRESS PRODUCTS");
		categorypage.clickOnMenCategory();
		categorypage.clickOnmenCategoryJeans();
//		String actualcategorynames = categorypage.isCategorypageVisible();
//		Assert.assertEquals(actualcategorynames.contains("Men > Jeans"), "Products Men > Jeans");
		Assert.assertEquals(categorypage.isCategorypageVisible(), "Products Men > Jeans");

	}

	@Test(priority = 19)
	public void testViewCart_BrandProducts() throws InterruptedException {
		productspage.clickOnProductsButton();
		Assert.assertTrue(categorypage.isBrandsOnLeftSidebar(), "Brands name not visible");
		categorypage.clickOnBrandName();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/brand_products/Kookie%20Kids");
		Assert.assertTrue(categorypage.isBrandProductsNameVisible(), "Brand product name not visible");
		categorypage.clickOnPoloBrandName();
		Assert.assertEquals(categorypage.getPoloBrandName(), "Polo");

	}

	@Test(priority = 20)
	public void testSearchProductsAndVerifyCartAfterLogin() throws InterruptedException, AWTException {
		productspage.clickOnProductsButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		searchpage.enterSearchInput("tops");
		searchpage.clickOnSearchBtn();
		Assert.assertTrue(searchpage.isSearchProductsVisible(), "Search products not visible");
		// Verify all the products related to the search are visible
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> searchedProducts = searchpage.getSearchResults();
		softAssert.assertFalse(searchedProducts.isEmpty(), "No products found for the search");
		Assert.assertEquals(searchpage.getProductName(), searchpage.spresult(),
				"products related to the search are visible");
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		subscribe.clickOnCartButton();
		Assert.assertEquals(cartpage.verifyProductItemsInCart(), 2);
		homepage.clickOnsignup_login();
		loginpage.loginToAccount("vijaynagendrk@gmail.com", "koona2019");
		loginpage.clickOnLoginBtn();
		subscribe.clickOnCartButton();
		Assert.assertEquals(cartpage.getProductName(), productspage.product1Name());
		Assert.assertEquals(cartpage.getProductPrice(), productspage.product1price());
		Assert.assertEquals(cartpage.getProductQuantity(), productspage.product1Quantity());
		Assert.assertEquals(cartpage.getProductTotalPrice(), productspage.product1CartTotal());
		Assert.assertEquals(cartpage.getProduct2Name(), productspage.product2Name());
		Assert.assertEquals(cartpage.getProduct2Price(), productspage.product2price());
		Assert.assertEquals(cartpage.getProduct2Quantity(), productspage.product2Quantity());
		Assert.assertEquals(cartpage.getProduct2TotalPrice(), productspage.product2CartTotal());

	}

	@Test(priority = 21)
	public void testAddReviewOnProduct() throws InterruptedException, AWTException {
		productspage.clickOnProductsButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		productspage.viewFirstProduct();
		Assert.assertTrue(productspage.getWriteYourReviewText(), "Write Your Review not visible");
		productspage.writeYourReview("ramya", "ramyabattula@gmail.com", "Review Automation Testing for A.E");
		Assert.assertEquals(productspage.thanksForYourReviewSuccessMsg(), "Thank you for your review.");

	}

	@Test(priority = 22)
	public void testAddtoCartFromRecommendedItems() throws InterruptedException, AWTException {
		subscribe.scrollToFooter();
		Assert.assertEquals(cartpage.getRecommendedItemsItemsText(), "RECOMMENDED ITEMS");
		cartpage.addtoCartOnRecommendedItems();
		productspage.clickOnviewCartlink();
		System.out.println(cartpage.getRecomendedItemName());
		Assert.assertEquals(cartpage.getProductName(), "Stylish Dress");

	}

	@Test(priority = 23)
	public void testVerifyAddressDetailsInCheckoutpage() throws InterruptedException, AWTException {
		homepage.clickOnsignup_login();
		homepage.newUserSignup("minnu6", "minnu6@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		Assert.assertEquals(homepage.isAccountCreatedVisible(), "ACCOUNT CREATED!");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "minnu6");
		productspage.clickOnProductsButton();
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		//subscribe.clickOnCartButton();
		//Assert.assertEquals(cartpage.verifyProductItemsInCart(), "2");
		checkoutpage.clickOnProceedToCheckout();
		Assert.assertEquals(homepage.getDeliveryAddress1(), checkoutpage.getDeliveryAddress());
		
//		homepage.clickDeleteAccoutBtn();
//		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
//		homepage.clickOnContinueBtn();
	}

	@Test(priority = 24)
	public void testDownloadInvoiceafterpurchaseorder() throws InterruptedException, AWTException {
		productspage.hoverOverFirstProduct();
		productspage.clickcOnCtinueShoppingBtn();
		productspage.hoverOverSecondProduct();
		productspage.clickOnviewCartlink();
		subscribe.clickOnCartButton();
	//	Assert.assertEquals(cartpage.verifyProductItemsInCart(), "2");
		checkoutpage.clickOnProceedToCheckout();
		checkoutpage.clickOnRegisterLoginlink();
		homepage.newUserSignup("testing8", "testing8@gmail.com");
		Assert.assertEquals(homepage.isEnterAccountInfoVisible(), "ENTER ACCOUNT INFORMATION");
		homepage.enterAccountInformation("koona2019", "minnu", "Sri", "Automation Project", "Gayatri Nagar",
				"Road no.6", "Telanga", "Hyderabad", "500079", "9000933214");
		Assert.assertEquals(homepage.isAccountCreatedVisible(), "ACCOUNT CREATED!");
		homepage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUsernameVisible(), "testing8");
		subscribe.clickOnCartButton();
		checkoutpage.clickOnProceedToCheckout();
		Assert.assertEquals(checkoutpage.getAddressDetails(), "Address Details");
		Assert.assertEquals(checkoutpage.getReviewYourOrder(), "Review Your Order");
		checkoutpage.commentTextarea("Coments in textarea Message...");
		checkoutpage.clickOnPlaceOrderBtn();
		checkoutpage.enterPaymentDetails("Minnu", "2021", "313", "04", "24");
		checkoutpage.clickOnPayAndConfirmOrder();
		//Assert.assertTrue(checkoutpage.orderPlacedSuccessfully(), "order Failed");
		checkoutpage.downloadInvoice();
		try {
			Thread.sleep(10000); // 5 seconds wait (adjust as needed)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String expectedFileName = "invoice.txt";
		String downloadDirectory = "Downloads";
		// Verify that the file is downloaded successfully
		File downloadedFile = new File(downloadDirectory + File.separator + expectedFileName);
		Assert.assertTrue(downloadedFile.exists(), "Invoice file was not downloaded successfully.");
		homepage.clickOnContinueBtn();
		homepage.clickDeleteAccoutBtn();
		Assert.assertEquals(homepage.isAccountDeletedVisible(), "ACCOUNT DELETED!");
		homepage.clickOnContinueBtn();

	}
	
	@Test(priority = 25)
	public void testVerifyScrollUpusingArrowbuttonandScrollDownfunctionality()
	{
	subscribe.scrollToFooter();
	Assert.assertEquals(subscribe.subcriptionText(), "SUBSCRIPTION");
	subscribe.clickOnArrowBtnScrollUp();
	subscribe.scrollingTextVisible();
	Assert.assertEquals(subscribe.scrollingTextVisible(), "Full-Fledged practice website for Automation Engineers");
	
    }
	@Test(priority = 26)
	public void testVerifyScrollUpwithoutArrowbuttonandScrollDownfunctionality()
	{
	subscribe.scrollToFooter();
	Assert.assertEquals(subscribe.subcriptionText(), "SUBSCRIPTION");
	
	subscribe.scrollUpAndVerifyText();
	Assert.assertEquals(subscribe.scrollingTextVisible(), "Full-Fledged practice website for Automation Engineers");
	
    }
}
