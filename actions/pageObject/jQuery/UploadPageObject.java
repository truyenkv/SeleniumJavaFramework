package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.AbstractPage;
import pageUIs.jQuery.UploadPageUI;


public class UploadPageObject extends AbstractPage{
	WebDriver driver;
	
	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAllUploadButton() {
		List<WebElement>listButton = finds(driver, UploadPageUI.LIST_START_UPLOAD_BUTTON);
		for(WebElement button: listButton) {
			clickToElement(driver, button);
		}
		
	}

	public boolean isAllImageUploadSuccess(String... imageName) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		List<WebElement>listName = finds(driver, UploadPageUI.LIST_IMAGE_NAME);
		if(imageName.length != listName.size()) {
			return false;
		} else {
			for(String image: imageName) {
				a.add(image);
			}
			for(WebElement element: listName) {
				b.add(element.getText());
			}
			System.out.print(a);
			System.out.print(b);
			if(a.equals(b)) {
				return true;
			}
		}
		return false;
	}

	
	
	
}