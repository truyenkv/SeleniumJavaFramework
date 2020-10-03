package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.DashboardPageUI;

public class AdvanceSearchPageObject extends AbstractPage{
	WebDriver driver;
	
	public AdvanceSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
