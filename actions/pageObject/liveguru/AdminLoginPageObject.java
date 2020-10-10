package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.AdminLoginPageUI;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.UserLoginPageUI;

public class AdminLoginPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputUserNameToUserNameField(String username) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNANE_FIELD);
		sendKeyToField(driver, AdminLoginPageUI.USERNANE_FIELD, username);
	}

	public void inputPasswordToUserPasswordField(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_FIELD);
		sendKeyToField(driver, AdminLoginPageUI.PASSWORD_FIELD, password);
	}

	public ManageCustomerPageObject clickOnLoginButton() {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return new ManageCustomerPageObject(driver);
	}

	

}
