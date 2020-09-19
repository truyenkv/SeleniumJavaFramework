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
}
