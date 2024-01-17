package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AE_TestCasesPage {

	@FindBy(xpath = "(//section[@id='slider']/descendant::button)[1]")
	WebElement testCasesBtn;
	@FindBy(xpath = "//section[@id='slider']/descendant::button[text()='Test Cases']")
	List<WebElement> testCases;
	@FindBy(xpath = "//b[text()='Test Cases']")
	WebElement testcasesHeader;

	WebDriver driver;

	public AE_TestCasesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonTestCasesButton(){
		testCasesBtn.click();
		//driver.navigate().back();
		
		//testCases.get(0).click();
	}

	// Verify that Testcases page is visible successfully
	public String isTestCasespageVisible() {
		return driver.getCurrentUrl();

	}

	public boolean isTestcaseHeaderVisible() {
		return testcasesHeader.isDisplayed();
	}
}
