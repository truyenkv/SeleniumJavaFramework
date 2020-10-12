package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	
	public static UploadPageObject getUploadPage(WebDriver driver) {
		return new UploadPageObject(driver);
	}
}
