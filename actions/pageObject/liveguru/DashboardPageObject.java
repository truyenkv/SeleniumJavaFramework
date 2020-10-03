  package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.DashboardPageUI;
import pageUIs.liveguru.RegisterPageUI;

public class DashboardPageObject extends AbstractPage{
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getMessageofSuccessfulRegister() {
		waitForElementVisible(driver, DashboardPageUI.MESSAGE_OF_RERISTER_SUCCESSFUL);
		return getElementText(driver, DashboardPageUI.MESSAGE_OF_RERISTER_SUCCESSFUL);
	}

	public HomePageObject clickOnLogoutLink() {
		waitForElementVisible(driver, DashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, DashboardPageUI.ACCOUNT_LINK);
		waitForElementClickable(driver, DashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, DashboardPageUI.LOGOUT_LINK);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isTitleLoginSuccessDisplay() {
		waitForElementVisible(driver, DashboardPageUI.HELLO_ACCOUNT_LOGIN_SUCCESS);
		return isElementDisplay(driver, DashboardPageUI.HELLO_ACCOUNT_LOGIN_SUCCESS);
	}
	
}
