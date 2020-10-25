package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static DashboardPageObject getDashboard(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static AboutUsPageObject getAboutUs(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	
	public static AdvanceSearchPageObject getAdvanceSearch(WebDriver driver) {
		return new AdvanceSearchPageObject(driver);
	}
	
	public static ContactUsPageObject getContactUs(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}
	
	public static SearchItemsPageObject getSeachItems(WebDriver driver) {
		return new SearchItemsPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static ManageCustomerPageObject getManageCustomerPage(WebDriver driver) {
		return new ManageCustomerPageObject(driver);
	}
	
	
}
