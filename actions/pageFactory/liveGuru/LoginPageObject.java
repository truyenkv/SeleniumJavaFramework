package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends AbstractPage {
WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Create an Account']")
	private WebElement CREATE_AN_ACCOUNT;
	
	public void clickToCreateAnAccountButton() {
		waitForElementVisible(driver, CREATE_AN_ACCOUNT);
		clickToElement(driver, CREATE_AN_ACCOUNT);
		
	}

}
