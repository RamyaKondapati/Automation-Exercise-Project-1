package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_CategoryPage {
	
	@FindBy(xpath="//div[@class='left-sidebar']/h2") WebElement categoryHeader;
	@FindBy(xpath="//div[@class='brands-name']") WebElement listOfBrandsName;
	@FindBy(xpath="//a[text()='Kookie Kids']") WebElement brandName;
	@FindBy(xpath="//a[text()='Polo']") WebElement poloBrandName;
	
	@FindBy(xpath="//h2[@class='title text-center']") WebElement brandProducts;
	@FindBy(xpath="//li[@class='active']") WebElement poloBrand;
	 
	@FindBy(xpath="(//a[@data-toggle=\"collapse\"])[1]") WebElement womenCategory;
	@FindBy(xpath="(//a[text()='Dress '])[1]") WebElement womenCategoryDress;
	@FindBy(xpath="//h2[text()='Women - Dress Products']") WebElement womenDressProducts;
	@FindBy(xpath="//div[@class='breadcrumbs']") WebElement productWomenDress;
	@FindBy(xpath="(//h4[@class='panel-title'])[2]") WebElement menCategory;
	@FindBy(xpath="//*[@id=\"Men\"]/div/ul/li[2]/a") WebElement menCategoryJeans;
	@FindBy(xpath="//div[@class='breadcrumbs']") WebElement productMenJeans;
	
	

	WebDriver driver;
	
	public AE_CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	 public String getCategoryHeader()
	 {
		return categoryHeader.getText();
	 }
	 public boolean isBrandsOnLeftSidebar()
	 {
		return listOfBrandsName.isDisplayed();
	 }
	 public void clickOnPoloBrandName()
	 {
		 poloBrandName.click();
	 }
	 public String getPoloBrandName()
	 {
		 return poloBrand.getText();
		 
	 }
	 public void clickOnWomenCategory()
	 {
		 womenCategory.click();
	 }
	 public void clickOnWomenCategoryDress()
	 {
		 womenCategoryDress.click();
	 }
	 public String womenDressProducts()
	 {
		return womenDressProducts.getText();
	 }
	 public boolean isCategoryPageDisplayed()
	 {
		 return productWomenDress.isDisplayed(); 
	 }
	 public void clickOnMenCategory() throws InterruptedException
	 {
		 menCategory.click();
		 Thread.sleep(4000);
	 }
	 public void clickOnmenCategoryJeans() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 menCategoryJeans.click(); 
	 }
	 public String isCategorypageVisible()
	 {
		return productMenJeans.getText();
	 }
	 
	 public void clickOnBrandName() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 brandName.click(); 
	 }
	 public boolean isBrandProductsNameVisible()
	 {
		 return brandProducts.isDisplayed();
	 }
	
}
