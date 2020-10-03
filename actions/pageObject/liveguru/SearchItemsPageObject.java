package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.AboutUsPageUI;
import pageUIs.liveguru.SearchItemsPageUI;

public class SearchItemsPageObject extends AbstractPage{
	WebDriver driver;
	
	public SearchItemsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
}