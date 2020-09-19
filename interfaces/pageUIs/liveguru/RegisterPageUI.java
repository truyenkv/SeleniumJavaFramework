package pageUIs.liveguru;

public class RegisterPageUI {
	public static final String MESSAGE_ERROR_UNDER_FIRSTNAME = "//div[@class='field name-firstname']//div[@class='validation-advice']";
	public static final String MESSAGE_ERROR_UNDER_LASTTNAME = "//div[@class='field name-lastname']//div[@class='validation-advice']";
	public static final String MESSAGE_ERROR_UNDER_EMAIL = "//label[@for='email_address']/following-sibling::div/div";
	public static final String MESSAGE_ERROR_UNDER_PASSWORD = "//label[@for='password']/following-sibling::div/div";
	public static final String MESSAGE_ERROR_UNDER_CONFIRM_PASSWORD = "//label[@for='confirmation']/following-sibling::div/div";
	public static final String REGISTER_BUTTON = "//button[@title='Register']";
	public static final String FIRST_NAME_TEXT_FIELD = "//input[@id='firstname']";
	public static final String LAST_NAME_TEXT_FIELD = "//input[@id='lastname']";
	public static final String EMAIL_TEXT_FIELD = "//input[@id='email_address']";
	public static final String PASSWORD_TEXT_FIELD = "//input[@id='password']";
	public static final String CONFIRM_PASSWORD_TEXT_FIELD = "//input[@id='confirmation']";
	public static final String MESSAGE_ERROR_INVALID_EMAIL = "//div[@id='advice-validate-email-email_address']";
	public static final String MESSAGE_ERROR_PASSWORD_LESS_THAN_6_CHARS = "//div[@id='advice-validate-password-password']";
	public static final String MESSAGE_ERROR_PASSWORD_DIFF_CONFIRM_PASSWORD = "//div[@id='advice-validate-cpassword-confirmation']";
}
