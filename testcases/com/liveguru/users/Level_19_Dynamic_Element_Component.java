 package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.liveguru.AboutUsPageObject;
import pageObject.liveguru.AdvanceSearchPageObject;
import pageObject.liveguru.ContactUsPageObject;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.UserLoginPageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;
import pageObject.liveguru.SearchItemsPageObject;

public class Level_19_Dynamic_Element_Component extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	UserLoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
	AboutUsPageObject aboutUsPage;
	ContactUsPageObject contactUsPage;
	SearchItemsPageObject searchItemsPage;
	AdvanceSearchPageObject advanceSearchPage;
	
	
	String email, pass;

	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		email = "truyen" + randomString() + "@vietnam.com";
		pass = "111111";
	}

	@Test(priority = 1)
	public void TC_01_Register_Valid_Data() {
		homePage.openFooterByName(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.clickOnButtonByTitle(driver, "Create an Account");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.inputTextToFieldByID(driver, "firstname", "Truyen");
		registerPage.inputTextToFieldByID(driver, "middlename", "");
		registerPage.inputTextToFieldByID(driver, "lastname", "Kieu");
		registerPage.inputTextToFieldByID(driver, "email_address", email);
		registerPage.inputTextToFieldByID(driver, "password", pass);
		registerPage.inputTextToFieldByID(driver, "confirmation", pass);
		registerPage.clickOnButtonByTitle(driver, "Register");
		dashBoardPage = PageGeneratorManager.getDashboard(driver);
		verifyEquals(dashBoardPage.getMessageofSuccessfulRegister(), "Thank you for registering with Main Website Store.");
		homePage = dashBoardPage.clickOnLogoutLink();
	}
	
	@Test(priority = 2)
	public void TC_02_Login() {
		homePage.openFooterByName(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inputTextToFieldByID(driver, "email", email);
		loginPage.inputTextToFieldByID(driver, "pass", pass);
		loginPage.clickToLoginButton();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
