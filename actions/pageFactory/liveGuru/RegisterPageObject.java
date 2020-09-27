package pageFactory.liveGuru;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='field name-firstname']//div[@class='validation-advice']")
	private WebElement MESSAGE_ERROR_UNDER_FIRSTNAME;
	
	@FindBy(how = How.XPATH, using = "//div[@class='field name-lastname']//div[@class='validation-advice']")
	private WebElement MESSAGE_ERROR_UNDER_LASTTNAME;
	
	@FindBy(how = How.XPATH, using = "//label[@for='email_address']/following-sibling::div/div")
	private WebElement MESSAGE_ERROR_UNDER_EMAIL;
	
	@FindBy(how = How.XPATH, using = "//label[@for='password']/following-sibling::div/div")
	private WebElement MESSAGE_ERROR_UNDER_PASSWORD;
	
	@FindBy(how = How.XPATH, using = "//label[@for='confirmation']/following-sibling::div/div")
	private WebElement MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD;
	
	@FindBy(how = How.XPATH, using = "//button[@title='Register']")
	private WebElement REGISTER_BUTTON;
	
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']")
	private WebElement FIRST_NAME_TEXT_FIELD;
	
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']")
	private WebElement LAST_NAME_TEXT_FIELD;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email_address']")
	private WebElement EMAIL_TEXT_FIELD;
	
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement PASSWORD_TEXT_FIELD;
	
	@FindBy(how = How.XPATH, using = "//input[@id='confirmation']")
	private WebElement CONFIRM_PASSWORD_TEXT_FIELD;
	
	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-email-email_address']")
	private WebElement MESSAGE_ERROR_INVALID_EMAIL;
	
	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-password-password']")
	private WebElement MESSAGE_ERROR_PASSWORD_LESS_THAN_6_CHARS;
	
	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-cpassword-confirmation']")
	private WebElement MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD;
	
	public void clickToRegisterButton() {
		waitForElementVisible(driver, REGISTER_BUTTON);
		clickToElement(driver, REGISTER_BUTTON);
		
	}

	public String getErrorTextRequiredOfFirstNameTextField() {
		waitForElementVisible(driver, MESSAGE_ERROR_UNDER_FIRSTNAME);
		return getElementText(driver, MESSAGE_ERROR_UNDER_FIRSTNAME);
	}

	public String getErrorTextRequiredOfLastNameTextField() {
		waitForElementVisible(driver, MESSAGE_ERROR_UNDER_LASTTNAME);
		return getElementText(driver, MESSAGE_ERROR_UNDER_LASTTNAME);
	}

	public String getErrorTextRequiredOfConfirmPasswordTextField() {
		waitForElementVisible(driver, MESSAGE_ERROR_UNDER_PASSWORD);
		return getElementText(driver, MESSAGE_ERROR_UNDER_PASSWORD);
	}

	public String getErrorTextRequiredOfPasswordTextField() {
		waitForElementVisible(driver, MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD);
		return getElementText(driver, MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD);
	}

	public String getErrorTextRequiredOfEmailTextField() {
		waitForElementVisible(driver, MESSAGE_ERROR_UNDER_EMAIL);
		return getElementText(driver, MESSAGE_ERROR_UNDER_EMAIL);
	}

	public void inputTextToFirstNameField(String firstName) {
		waitForElementVisible(driver, FIRST_NAME_TEXT_FIELD);
		sendKeyToField(driver, FIRST_NAME_TEXT_FIELD, firstName);
		
	}

	public void inputTextToLastField(String lastName) {
		waitForElementVisible(driver, LAST_NAME_TEXT_FIELD);
		sendKeyToField(driver, LAST_NAME_TEXT_FIELD, lastName);
		
	}

	public void inputTextToEmailField(String email) {
		waitForElementVisible(driver, EMAIL_TEXT_FIELD);
		sendKeyToField(driver,EMAIL_TEXT_FIELD, randomString() + email);
	}

	public void inputTextToPasswordField(String password) {
		waitForElementVisible(driver, PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, PASSWORD_TEXT_FIELD, password);
	}

	public void inputTextToConfirmPasswordField(String confirmpass) {
		waitForElementVisible(driver, CONFIRM_PASSWORD_TEXT_FIELD);
		sendKeyToField(driver, CONFIRM_PASSWORD_TEXT_FIELD, confirmpass);
	}

	public String getMessageOfInvalidEmail() {
		waitForElementVisible(driver, MESSAGE_ERROR_INVALID_EMAIL);
		return getElementText(driver, MESSAGE_ERROR_INVALID_EMAIL);
	}

	public String getMessageOfPasswordLessThanSixChars() {
		waitForElementVisible(driver, MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD);
		return getElementText(driver, MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD);
	}
	
	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(10000);
	}
	
	private String randomString() {
		StringBuilder sb = new StringBuilder(4); 
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
		for(int i = 0; i < 4; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString.charAt(index)); 
		}
		return sb.toString(); 
	}


}
