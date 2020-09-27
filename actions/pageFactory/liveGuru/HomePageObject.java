package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends AbstractPage {
	
WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='footer']//a[text()='My Account']")
	private WebElement MY_ACCOUNT_BUTTON;
	
	public void clickToMyAccountLink() {
		waitForElementVisible(driver, MY_ACCOUNT_BUTTON);
		clickToElement(driver, MY_ACCOUNT_BUTTON);
	}

}
