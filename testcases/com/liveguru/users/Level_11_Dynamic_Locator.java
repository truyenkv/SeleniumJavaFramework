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

public class Level_11_Dynamic_Locator extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	UserLoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
	AboutUsPageObject aboutUsPage;
	ContactUsPageObject contactUsPage;
	SearchItemsPageObject searchItemsPage;
	AdvanceSearchPageObject advanceSearchPage;
	
	String email;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
	}

	//@BeforeMethod
	public void beforeMethod() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
	}
	
	@Test(priority = 1)
	public void TC_01_Register_Valid_Data() {
		email = registerPage.randomString() + "@vietnam.com";
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField(email);
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111111");
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		homePage = dashBoardPage.clickOnLogoutLink();
		
	}
	
	@Test (priority = 2)
	public void TC_02_Login_Page() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailToEmailField(email);
		loginPage.inputPasswordToPasswordField("111111");
		dashBoardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(dashBoardPage.isTitleLoginSuccessDisplay());
	}
	
	@Test (priority = 3)
	public void TC_03_Switch_Page() {
		aboutUsPage = dashBoardPage.openAboutUsPage(driver);
		
		contactUsPage = aboutUsPage.openContactUsPage(driver);
		
		searchItemsPage = contactUsPage.openSearchItemsPage(driver);
		
		advanceSearchPage = searchItemsPage.openAdvanceSearchPage(driver);
		
		aboutUsPage = advanceSearchPage.openAboutUsPage(driver);
		
		searchItemsPage = aboutUsPage.openSearchItemsPage(driver);
		
		contactUsPage = searchItemsPage.openContactUsPage(driver);
		
	}
	
	//@Test (priority = 4)
	public void TC_04_Switch_Page_Dynamic() {
		aboutUsPage = (AboutUsPageObject) contactUsPage.openFooterPageName(driver, "About Us");
		
		contactUsPage = (ContactUsPageObject) aboutUsPage.openFooterPageName(driver, "Contact Us");
		
		searchItemsPage = (SearchItemsPageObject) contactUsPage.openFooterPageName(driver, "Search Terms");
		
		
	}
	
	@Test (priority = 5)
	public void TC_05_Switch_Page_Dynamic_Cach2() {
		
		searchItemsPage.openFooterByName(driver, "About Us");
		aboutUsPage = PageGeneratorManager.getAboutUs(driver);
		
		aboutUsPage.openFooterByName(driver, "Search Terms");
		searchItemsPage = PageGeneratorManager.getSeachItems(driver);
		
		searchItemsPage.openFooterByName(driver, "Contact Us");
		contactUsPage = PageGeneratorManager.getContactUs(driver);
		
		contactUsPage.openFooterByName(driver, "Advanced Search");
		advanceSearchPage = PageGeneratorManager.getAdvanceSearch(driver);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
