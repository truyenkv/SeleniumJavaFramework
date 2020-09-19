package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateAnAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREATE_AN_ACCOUNT);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT);
		
	}

}
