  package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.liveguru.DashboardPageUI;

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
		return PageGeneratorManager.getHomePage(driver);
	}


	@Step("Check the title display on the Dashboard screen")
	public boolean isTitleLoginSuccessDisplay() {
		waitForElementVisible(driver, DashboardPageUI.HELLO_ACCOUNT_LOGIN_SUCCESS);
		return isElementDisplay(driver, DashboardPageUI.HELLO_ACCOUNT_LOGIN_SUCCESS);
	}
	
}
