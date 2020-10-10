package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.ManageCustomerPageUI;
import pageUIs.liveguru.UserLoginPageUI;

public class ManageCustomerPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public ManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	public void closeIncomingMessagePopup() {
		waitForElementClickable(driver, ManageCustomerPageUI.IMCOMING_MESSAGE_CLOSE_BUTTON);
		clickToElement(driver, ManageCustomerPageUI.IMCOMING_MESSAGE_CLOSE_BUTTON);
	}


	public void inputTextToField(String title, String value) {
		waitForElementVisible(driver, ManageCustomerPageUI.DYNAMIC_TEXT_TITLE, title);
		String index = String.valueOf(countElementNumber(driver, ManageCustomerPageUI.DYNAMIC_TEXT_TITLE, title) + 1) ;
		sendKeyToField(driver, value, ManageCustomerPageUI.DYNAMIC_TEXT_FIELD, index);	
		System.out.println(String.format(ManageCustomerPageUI.DYNAMIC_TEXT_FIELD, index));
		
	}


	public void clickOnTheButton(String buttonName) {
		waitForElementClickable(driver, ManageCustomerPageUI.DYNAMIC_SEARCH_BUTTON, buttonName);
		clickToElement(driver, ManageCustomerPageUI.DYNAMIC_SEARCH_BUTTON, buttonName);
	}


	public boolean isValueDisplayAtRow(String row, String column, String value) {
		waitForElementVisible(driver, ManageCustomerPageUI.DYNAMIC_RESULT, row, column, value);
		return isElementDisplay(driver, ManageCustomerPageUI.DYNAMIC_RESULT, row, column, value);
	}





}
