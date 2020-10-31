package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pageObject.liveguru.AboutUsPageObject;
import pageObject.liveguru.AdvanceSearchPageObject;
import pageObject.liveguru.ContactUsPageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.SearchItemsPageObject;
import pageUIs.liveguru.AbstractPageUI;

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
	protected final Log log;
	
	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public void setImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
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
		try {
			explicitWait = new WebDriverWait(driver, shortimeOut);
			explicitWait.until(ExpectedConditions.alertIsPresent());
		} 
		catch(NoAlertPresentException e) {
			log.debug(e.getMessage());
		}
		
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
	public WebElement find(WebDriver driver, String xpathValue) {
		return driver.findElement(byXpath(xpathValue));
	}

	// return list element
	public List<WebElement> finds(WebDriver driver, String xpathValue) {
		return driver.findElements(byXpath(xpathValue));
	}

	// find with list Element
	public List<WebElement> finds(WebDriver driver, String xpathValue, String value) {
		return driver.findElements(byXpath(getDynamicLocator(xpathValue, value)));
	}

	// return by with xpath
	public By byXpath(String xpathValue) {
		return By.xpath(xpathValue);
	}

	public void clickToElement(WebDriver driver, String xpathValue) {
		find(driver, xpathValue).click();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	// return getDynamicLocator
	public String getDynamicLocator(String xpathValue, String... value) {
		return String.format(xpathValue, (Object[]) value);
	}

	// click generator
	public void clickToElement(WebDriver driver, String xpathValue, String... value) {
		find(driver, getDynamicLocator(xpathValue, value)).click();
	}

	public void sendKeyToField(WebDriver driver, String xpathValue, String text) {
		element = find(driver, xpathValue);
		element.clear();
		element.sendKeys(text);
	}

	// sendkey with dynamic locator
	public void sendKeyToField(WebDriver driver, String text, String xpathValue, String... value) {
		element = find(driver, getDynamicLocator(xpathValue, value));
		element.clear();
		element.sendKeys(text);
	}

	public void selectItemDropdownByText(WebDriver driver, String xpathValue, String valueSelect) {
		select = new Select(find(driver, xpathValue));
		select.selectByVisibleText(valueSelect);
	}

	public String getSelectedItemDropdown(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
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

	public String getElementAttribute(WebDriver driver, String xpathValue, String attribute) {
		return find(driver, xpathValue).getAttribute(attribute);
	}

	public String getElementText(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).getText();
	}

	public int countElementNumber(WebDriver driver, String xpathValue) {
		return finds(driver, xpathValue).size();
	}

	// count with dynamic locator
	public int countElementNumber(WebDriver driver, String xpathValue, String... value) {
		return finds(driver, getDynamicLocator(xpathValue, value)).size();
	}

	public void checkTheCheckBox(WebDriver driver, String xpathValue) {
		if (!find(driver, xpathValue).isSelected()) {
			find(driver, xpathValue).click();
		}
	}

	public void uncheckTheCheckBox(WebDriver driver, String xpathValue) {
		if (find(driver, xpathValue).isSelected()) {
			find(driver, xpathValue).click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isDisplayed();
	}

	// check display with dynamiclocator
	public boolean isElementDisplay(WebDriver driver, String xpathValue, String... value) {
		return find(driver, getDynamicLocator(xpathValue, value)).isDisplayed();
	}

	public boolean isElementSelect(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isSelected();
	}

	public boolean isElementEnable(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String xpathValue) {
		driver.switchTo().frame(find(driver, xpathValue));
	}

	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathValue) {
		action = new Actions(driver);
		action.moveToElement(find(driver, xpathValue)).perform();
	}

	public void sendKeyToElement(WebDriver driver, String xpathValue, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver, xpathValue), key);
	}

	public void highlightElement(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = find(driver, xpathValue);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
	}

	public void scrollToElement(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathValue));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathValue, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathValue));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", find(driver, xpathValue));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
	}

	// wait with dynamic locator
	public void waitForElementVisible(WebDriver driver, String xpathValue, String... value) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(getDynamicLocator(xpathValue, value))));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}

	// wait with dynamic locator
	public void waitForElementClickable(WebDriver driver, String xpathValue, String... value) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(getDynamicLocator(xpathValue, value))));
	}

	public AbstractPage openFooterPageNameAb(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "About Us":
			return PageGeneratorManager.getAboutUs(driver);

		case "Advanced Search":
			return PageGeneratorManager.getAdvanceSearch(driver);

		case "Search Iterms":
			return PageGeneratorManager.getSeachItems(driver);

		case "Contact Us":
			return PageGeneratorManager.getContactUs(driver);
			
		case "My Account":
			return PageGeneratorManager.getLoginPage(driver);

		default:
			return null;
		}
	}

	public void openFooterByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}

	@Step("Open the About Us Page")
	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.ABOUTUS_LINK);
		clickToElement(driver, AbstractPageUI.ABOUTUS_LINK);
		return PageGeneratorManager.getAboutUs(driver);
	}

	@Step("Open the Advance Search Page")
	public AdvanceSearchPageObject openAdvanceSearchPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.ADVANCESEARCH_LINK);
		clickToElement(driver, AbstractPageUI.ADVANCESEARCH_LINK);
		return PageGeneratorManager.getAdvanceSearch(driver);
	}

	@Step("Open the Search Page")
	public SearchItemsPageObject openSearchItemsPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.SEARCHITEMS_LINK);
		clickToElement(driver, AbstractPageUI.SEARCHITEMS_LINK);
		return PageGeneratorManager.getSeachItems(driver);
	}

	@Step("Open the Contact Page")
	public ContactUsPageObject openContactUsPage(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CONTACTUS_LINK);
		clickToElement(driver, AbstractPageUI.CONTACTUS_LINK);
		return PageGeneratorManager.getContactUs(driver);
	}

	public void uploadMultipleFile(WebDriver driver, String... fileName) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFile");
		String fileUpload = "";
		for (String file : fileName) {
			fileUpload = fileUpload + filePath + file + "\n";
		}
		fileUpload = fileUpload.trim();
//		waitForElementVisible(driver, AbstractPageUI.UPLOAD_FILE);
		sendKeyToField(driver, AbstractPageUI.UPLOAD_FILE, fileUpload);

	}

	public String getDirectorySlash(String folderName) {
		if (isOS()) {
			folderName = "/" + folderName + "/";
		} else if (isWin()) {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public boolean isOS() {
		return (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0);
	}

	public boolean isWin() {
		return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);
	}

	public void overrideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}

	public boolean isControlUnDisplay(WebDriver driver, String xpathValue) {
		overrideImplicitWait(driver, shortimeOut);
		elements = finds(driver, xpathValue);
		overrideImplicitWait(driver, longTimeOut);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	
	public boolean isControlUnDisplay(WebDriver driver, String xpathValue, String... value) {
		overrideImplicitWait(driver, shortimeOut);
		elements = finds(driver, getDynamicLocator(xpathValue, value));
		overrideImplicitWait(driver, longTimeOut);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public void inputTextToFieldByID(WebDriver driver, String textID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_INPUT_LOCATOR, textID);
		sendKeyToField(driver, value, AbstractPageUI.DYNAMIC_INPUT_LOCATOR, textID);
	}
	
	public void clickOnButtonByTitle(WebDriver driver, String title) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_BUTTON_LOCATOR, title);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON_LOCATOR, title);
		
	}
	
	public boolean isDataSortedAscending(WebDriver driver, String locator) {
		ArrayList<String>arrayList = new ArrayList<>();
		List<WebElement> elementList = finds(driver, locator);
		for(WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("-----Du Lieu Tren UI-----");
		for(String name: arrayList) {
			System.out.println(name);
		}
		
		ArrayList<String>sortList = new ArrayList<>();
		for(String a: arrayList) {
			sortList.add(a);
		}
		
		Collections.sort(arrayList);
		System.out.println("-----Du Lieu Da Sort-----");
		for(String name: arrayList) {
			System.out.println(name);
		}
		return sortList.equals(arrayList);
	}
	
	public boolean isDataSortedDescending(WebDriver driver, String locator) {
		ArrayList<String>arrayList = new ArrayList<>();
		List<WebElement> elementList = finds(driver, locator);
		for(WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		System.out.println("-----Du Lieu Tren UI-----");
		for(String name: arrayList) {
			System.out.println(name);
		}
		
		ArrayList<String>sortList = new ArrayList<>();
		for(String a: arrayList) {
			sortList.add(a);
		}
		
		Collections.sort(arrayList);
		Collections.reverse(arrayList);
		System.out.println("-----Du Lieu Da Sort-----");
		for(String name: arrayList) {
			System.out.println(name);
		}
		return sortList.equals(arrayList);
	}
	
	public boolean isPriceSortAscending(WebDriver driver, String locator) {
		ArrayList<Float>arrayList = new ArrayList<>();
		List<WebElement> elementList = finds(driver, locator);
		for(WebElement element: elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("-----Du Lieu Tren UI-----");
		for(Float name: arrayList) {
			System.out.println(name);
		}
		ArrayList<Float>sortList = new ArrayList<>();
		for(Float a: arrayList) {
			sortList.add(a);
		}
		
		Collections.sort(arrayList);
		System.out.println("-----Du Lieu Da Sort-----");
		for(Float name: arrayList) {
			System.out.println(name);
		}
		return sortList.equals(arrayList);
		
	}
	public boolean isPriceSortDescending(WebDriver driver, String locator) {
		ArrayList<Float>arrayList = new ArrayList<>();
		List<WebElement> elementList = finds(driver, locator);
		for(WebElement element: elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		System.out.println("-----Du Lieu Tren UI-----");
		for(Float name: arrayList) {
			System.out.println(name);
		}
		ArrayList<Float>sortList = new ArrayList<>();
		for(Float a: arrayList) {
			sortList.add(a);
		}
		
		Collections.sort(arrayList);
		Collections.reverse(arrayList);
		System.out.println("-----Du Lieu Da Sort-----");
		for(Float name: arrayList) {
			System.out.println(name);
		}
		return sortList.equals(arrayList);
		
	}

}
