package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to My Account link and navigate to Login Page")
	public UserLoginPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.FOOTER_MY_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.FOOTER_MY_ACCOUNT_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isFooterMyAccountDisplay() {
		waitForElementVisible(driver, HomePageUI.FOOTER_MY_ACCOUNT_BUTTON);
		return isElementDisplay(driver, HomePageUI.FOOTER_MY_ACCOUNT_BUTTON);
	}

	public boolean isHeaderMyAccountUnDisplay() {
		return isControlUnDisplay(driver, HomePageUI.HEADER_MY_ACCOUNT_BUTTON);
	}
	
	

	public boolean isErrorSubscribeTextBoxUnDisplay() {
		return isElementDisplay(driver, HomePageUI.ERROR_SUBSCRIBE_MESSAGE);
	}

	public void clickSubscribeTextBoxButton() {
		waitForElementClickable(driver, HomePageUI.SUBCRIBE_BUTTON);
		clickToElement(driver, HomePageUI.SUBCRIBE_BUTTON);
		
	}

	public boolean isErrorSubscribeTextBoxDisplay() {
		return isElementDisplay(driver, HomePageUI.ERROR_SUBSCRIBE_MESSAGE);
	}

}
