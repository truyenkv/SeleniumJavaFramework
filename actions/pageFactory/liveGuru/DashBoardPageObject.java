package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class DashBoardPageObject extends AbstractPage{
WebDriver driver;
	
	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//li[@class='success-msg']//span")
	private WebElement MESSAGE_OF_RERISTER_SUCCESSFUL;
	
	public String getMessageofSuccessfulRegister() {
		return getElementText(driver, MESSAGE_OF_RERISTER_SUCCESSFUL);
	}
}
