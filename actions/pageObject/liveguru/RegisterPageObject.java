package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorTextRequiredOfFirstNameTextField() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_FIRSTNAME);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_FIRSTNAME);
	}

	public String getErrorTextRequiredOfLastNameTextField() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_LASTTNAME);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_LASTTNAME);
	}

	public String getErrorTextRequiredOfConfirmPasswordTextField() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_PASSWORD);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_PASSWORD);
	}

	public String getErrorTextRequiredOfPasswordTextField() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD);
	}

	public String getErrorTextRequiredOfEmailTextField() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_EMAIL);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_UNDER_EMAIL);
	}

	public void inputTextToFirstNameField(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_FIELD);
		sendKeyToField(driver, RegisterPageUI.FIRST_NAME_TEXT_FIELD, firstName);
		
	}

	public void inputTextToLastField(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_FIELD);
		sendKeyToField(driver, RegisterPageUI.LAST_NAME_TEXT_FIELD, lastName);
		
	}

	public void inputTextToEmailField(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_FIELD);
		sendKeyToField(driver, RegisterPageUI.EMAIL_TEXT_FIELD, email);
	}

	public void inputTextToPasswordField(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, RegisterPageUI.PASSWORD_TEXT_FIELD, password);
	}

	public void inputTextToConfirmPasswordField(String confirmpass) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_FIELD, confirmpass);
	}

	public String getMessageOfInvalidEmail() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_INVALID_EMAIL);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_INVALID_EMAIL);
	}

	public String getMessageOfPasswordLessThanSixChars() {
		waitForElementVisible(driver, RegisterPageUI.MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD);
	}

	
	

}
