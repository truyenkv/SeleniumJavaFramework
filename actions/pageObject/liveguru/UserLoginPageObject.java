package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.UserLoginPageUI;

public class UserLoginPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToCreateAnAccountButton() {
		waitForElementVisible(driver, UserLoginPageUI.CREATE_AN_ACCOUNT);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@Step("Type the email to email field with value: {0}")
	public void inputEmailToEmailField(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIl_TEXT_FIELD);
		sendKeyToField(driver, UserLoginPageUI.EMAIl_TEXT_FIELD, email);
	}

	@Step("Type the email to password field with value: {0}")
	public void inputPasswordToPasswordField(String pass) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, UserLoginPageUI.PASSWORD_TEXT_FIELD, pass);		
	}

	@Step("Click on the Login button to login")
	public DashboardPageObject clickToLoginButton() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboard(driver);
	}

}
