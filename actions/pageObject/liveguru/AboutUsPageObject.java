package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.AboutUsPageUI;
import pageUIs.liveguru.ContactUsPageUI;
import pageUIs.liveguru.DashboardPageUI;

public class AboutUsPageObject extends AbstractPage{
	WebDriver driver;
	
	public AboutUsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
}