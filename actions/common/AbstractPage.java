package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	private Alert alert;
	private WebDriverWait explicitWait;
	private WebElement element;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private long longTimeOut = 30;
	private short shortimeOut = 10;
	private List<WebElement> elements;
	private Actions action;

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String keyword) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(keyword);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, shortimeOut);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchWindowByID(WebDriver driver, String idswitch) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			if (id.equals(idswitch)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentId) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
	}

	// return element
	public WebElement find(WebDriver driver, String xpathElement) {
		return driver.findElement(byXpath(xpathElement));
	}

	// return list element
	public List<WebElement> finds(WebDriver driver, String xpathElement) {
		return driver.findElements(byXpath(xpathElement));
	}

	// return by with xpath
	public By byXpath(String xpathElement) {
		return By.xpath(xpathElement);
	}

	public void clickToElement(WebDriver driver, String xpathElement) {
		find(driver, xpathElement).click();
	}

	public void sendKeyToField(WebDriver driver, String xpathElement, String text) {
		element = find(driver, xpathElement);
		element.clear();
		element.sendKeys(text);
	}

	public void selectItemDropdownByText(WebDriver driver, String xpathElement, String valueSelect) {
		select = new Select(find(driver, xpathElement));
		select.selectByVisibleText(valueSelect);
	}

	public String getSelectedItemDropdown(WebDriver driver, String xpathElement) {
		select = new Select(find(driver, xpathElement));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathElement) {
		select = new Select(find(driver, xpathElement));
		return select.isMultiple();
	}

	public void sleepInSecond(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectItemCustomDropdown(WebDriver driver, String xpathParent, String childLocator, String expectedItem) {
		// click parent
		find(driver, xpathParent).click();
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
		elements = finds(driver, childLocator);
		for (WebElement element : elements) {
			if (element.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
				sleepInSecond(2);
				element.click();
				break;
			}
		}

	}

	public String getElementAttribute(WebDriver driver, String xpathElement, String attribute) {
		return find(driver, xpathElement).getAttribute(attribute);
	}

	public String getElementText(WebDriver driver, String xpathElement) {
		return find(driver, xpathElement).getText();
	}

	public int countElementNumber(WebDriver driver, String xpathElement) {
		return finds(driver, xpathElement).size();
	}

	public void checkTheCheckBox(WebDriver driver, String xpathElement) {
		if(!find(driver, xpathElement).isSelected()) {
			find(driver, xpathElement).click();
		}
	}

	public void uncheckTheCheckBox(WebDriver driver, String xpathElement) {
		if(find(driver, xpathElement).isSelected()) {
			find(driver, xpathElement).click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String xpathElement) {
		return find(driver, xpathElement).isDisplayed();
	}
	
	public boolean isElementSelect(WebDriver driver, String xpathElement) {
		return find(driver, xpathElement).isSelected();
	}
	
	public boolean isElementEnable(WebDriver driver, String xpathElement) {
		return find(driver, xpathElement).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String xpathElement){
		driver.switchTo().frame(find(driver, xpathElement));
	}
	
	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathElement) {
		action = new Actions(driver);
		action.moveToElement(find(driver, xpathElement)).perform();
	}
	
	public void sendKeyToElement(WebDriver driver, String xpathElement, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, xpathElement), key);
	}
	
	public void highlightElement(WebDriver driver, String xpathElement) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = find(driver, xpathElement);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}
	
	public void clickToElementByJS(WebDriver driver, String xpathElement) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, xpathElement));
	}

	public void scrollToElement(WebDriver driver, String xpathElement) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathElement));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String xpathElement, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathElement));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathElement, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathElement));
	}
	
	public boolean isImageLoaded(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", find(driver, xpathValue));
		if(status) {
			return true;
		}
		return false;
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
	}
	public void waitForElementClickable(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}
	
}
