package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.RegisterPageUI;

public class HomePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_BUTTON);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
