package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	private Alert alert;
	WebDriverWait explicitWait;
	private WebElement element;
	Select select;

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
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String keyword) {
		alert = driver.switchTo().alert();
		alert.sendKeys(keyword);
	}

	public void waitAlertPresence(WebDriver driver, int time) {
		explicitWait = new WebDriverWait(driver, time);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchWindowByID(WebDriver driver, String idswitch) {
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids) {
			if(id.equals(idswitch)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids) {
				driver.switchTo().window(id);
				if(driver.getTitle().equals(title)) {
					break;
				}
		}
	}
	
	public void closeAllWindowWithoutParent(WebDriver driver, String parentId) {
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids) {
			if(!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
	}
	
	//return element
	public WebElement find(WebDriver driver, String xpathElement) {
		return driver.findElement(byXpath(xpathElement));
	}
	
	//return list element
	public List<WebElement> finds(WebDriver driver, String xpathElement){
		return driver.findElements(byXpath(xpathElement));
	}
	
	//return by with xpath
	public By byXpath(String xpathElement) {
		return By.xpath(xpathElement);
	}
	
	public void clickToElement(WebDriver driver, String xpathElement) {
		find(driver, xpathElement).click();;
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
	
	
	
}
