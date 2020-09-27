package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	private WebDriverWait explicitWait;
	private long longTimeOut = 30;
	private short shortimeOut = 10;
	//clickToElement
	//sendKeyToField
	//waitForElementVisible
	
	public void clickToElement(WebDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		element.click();
	}
	
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void sendKeyToField(WebDriver driver, WebElement element, String text) {
		waitForElementVisible(driver, element);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		waitForElementVisible(driver, element);
		return element.getText();
	}
}
