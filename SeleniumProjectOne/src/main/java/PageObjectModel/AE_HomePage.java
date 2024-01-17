package PageObjectModel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AE_HomePage {

	@FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
	WebElement logoImg;
	@FindBy(xpath="//a[text()=' Home']") WebElement homeBtn;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li[4]")
	WebElement signup_login;
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement newUserSignupHeading;
	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement loginAccountHeading;
	@FindBy(name = "name")
	WebElement name_tb;
	@FindBy(xpath = "(//input[@name='email'])[2]")
	WebElement email_tb;
	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signup_btn;
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement account_info_text;
	@FindBy(id = "id_gender2")
	WebElement radio_Btn_Mrs;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password_tb;
	@FindBy(xpath = "//select[@id='days']")
	WebElement day;
	@FindBy(xpath = "//select[@id='months']")
	WebElement month;
	@FindBy(xpath = "//select[@id='years']")
	WebElement year;

	@FindBy(xpath = "//input[@name='newsletter']")
	WebElement newsletter_cb;
	@FindBy(xpath = "//input[@name='optin']")
	WebElement specialOffers_cb;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastname;
	@FindBy(xpath = "//input[@name='company']")
	WebElement company;
	@FindBy(xpath = "//input[@name='address1']")
	WebElement address1;
	@FindBy(xpath = "//input[@name='address2']")
	WebElement address2;
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	@FindBy(xpath = "//input[@name='zipcode']")
	WebElement zipcode;
	@FindBy(xpath = "//input[@name='mobile_number']")
	WebElement mobileNumber;
	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement createAccount;
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement account_created_text;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	@FindBy(tagName = "b")
	WebElement loggedInUser;
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement deleteAccount;
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement account_deleted_text;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement clickOnContinue;
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	WebElement emailExist;
	@FindBy(xpath = "//section[@id='slider']")
	WebElement homeSlider;
	
	@FindBy(xpath = "(//a[text()='View Product'])[6]")
	WebElement viewProductHomepage;
	@FindBy(xpath = "(//div[@class='productinfo text-center']/p)[6]")
	WebElement viewproductNameHomepage;
//	@FindBy(xpath = "")
//	WebElement deliveryAddress;
	

	public WebDriver driver;
	String baseUrl = "https://automationexercise.com/";
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

	public AE_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomepageUrl(){
		driver.get("https://automationexercise.com/");
		
	}

	// Verify that home page is visible successfully
	public boolean isHomepageDisplayed() {
		return homeSlider.isDisplayed();

	}

	public String isHomepageVisible() {
		return driver.getCurrentUrl();

	}
	public void clickOnsignup_login() {
		signup_login.click();
		
	}
	
	public void clickOnHomeButton()
	{
		homeBtn.click();
	}

	// Verify that 'Login to your account' is visible
	public String newUserSignupVisible() {
		return newUserSignupHeading.getText();
	}

	// Verify that 'Login to your account' is visible
	public String loginAccountVisible() {
		return loginAccountHeading.getText();
	}

	public void newUserSignup(String name, String email) {
		name_tb.sendKeys(name);
		email_tb.sendKeys(email);
		signup_btn.click();
	}

	// Verify that 'ENTER ACCOUNT INFORMATION' is visible
	public String isEnterAccountInfoVisible() {
		return account_info_text.getText();
	}

	public void enterAccountInformation(String pass, String fname, String lname, String companyname, String addressone,
			String addresstwo, String statename, String cityname, String zip, String phone)
			throws InterruptedException, AWTException {
		Thread.sleep(5000);
		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		radio_Btn_Mrs.click();
		Thread.sleep(5000);
		password_tb.sendKeys(pass);
		Select daySelect = new Select(day);
		daySelect.selectByVisibleText("5");
		Select monthSelect = new Select(month);
		monthSelect.selectByVisibleText("June");
		Select yearSelect = new Select(year);
		yearSelect.selectByVisibleText("1993");
		newsletter_cb.click();
		specialOffers_cb.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(companyname);
		address1.sendKeys(addressone);
		address2.sendKeys(addresstwo);
		state.sendKeys(statename);
		city.sendKeys(cityname);
		zipcode.sendKeys(zip);
		mobileNumber.sendKeys(phone);
		createAccount.click();
		Thread.sleep(2000);
		System.out.println("About to zoom in");
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

	}
	
	
	 public String getDeliveryAddress1() {
	        return address1.getText();
	    }

	    public String getBillingAddress() {
	        return address2.getText();
	    }
	
	
	public void clickOnContinueBtn() throws InterruptedException
	{
		continueBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickOnLogoImg()
	{
		logoImg.click();
	}

	// Verify that 'ACCOUNT CREATED!' is visible
	public String isAccountCreatedVisible() {
		return account_created_text.getText();

	}

	// Method to verify 'Logged in as username' is visible
	public String isLoggedInUsernameVisible() {
		return loggedInUser.getText();

	}

	// verify error 'Email Address already exist!' is visible
	public String emailAlreadyExist() {
		return emailExist.getText();

	}

	public void clickDeleteAccoutBtn() {
		deleteAccount.click();
		
	}
	
	// Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
	public String isAccountDeletedVisible()
	{
		return account_deleted_text.getText();
	}

	public void clickOnViewProductHomepage()
	{
		//driver.switchTo().frame("");
		viewProductHomepage.click();
	}
	public String viewproductNameHomepage() throws InterruptedException
	{
		Thread.sleep(2000);
		return viewproductNameHomepage.getText();
		
	}
	
}
