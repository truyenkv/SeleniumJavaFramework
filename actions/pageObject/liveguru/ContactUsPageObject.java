package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUIs.liveguru.AboutUsPageUI;
import pageUIs.liveguru.ContactUsPageUI;

public class ContactUsPageObject extends AbstractPage{
	WebDriver driver;
	
	public ContactUsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
}