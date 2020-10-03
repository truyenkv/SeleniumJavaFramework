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

	public RegisterPageObject clickToCreateAnAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREATE_AN_ACCOUNT);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputEmailToEmailField(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIl_TEXT_FIELD);
		sendKeyToField(driver, LoginPageUI.EMAIl_TEXT_FIELD, email);
	}

	public void inputPasswordToPasswordField(String pass) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, LoginPageUI.PASSWORD_TEXT_FIELD, pass);		
	}

	public DashboardPageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboard(driver);
	}

}
