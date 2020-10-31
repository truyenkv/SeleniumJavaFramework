 package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.CommonTestCase;
import com.common.CommonTestCase2;

import common.AbstractTest;
import pageObject.liveguru.AboutUsPageObject;
import pageObject.liveguru.AdvanceSearchPageObject;
import pageObject.liveguru.ContactUsPageObject;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;
import pageObject.liveguru.SearchItemsPageObject;
import pageObject.liveguru.UserLoginPageObject;

public class Level_17_Close_Browser extends AbstractTest{
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
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC - 01: Click to my account link");
		loginPage = homePage.clickToMyAccountLink();
		
		log.info("TC - 02: Input email to Email Field");
		loginPage.inputEmailToEmailField(CommonTestCase2.email);
		
		log.info("TC - 03: Input password to password field");
		loginPage.inputPasswordToPasswordField(CommonTestCase2.password);
		
		log.info("TC - 04: Click on Login Button" );
		dashBoardPage = loginPage.clickToLoginButton();
		
		log.info("TC - 05: Check the title login display");
		Assert.assertFalse(dashBoardPage.isTitleLoginSuccessDisplay());
		
	}

	
	@Test (priority = 1)
	public void TC_01_Switch_Page() {
		log.info("TC - 02: Open the About Page from Dashboard");
		aboutUsPage = dashBoardPage.openAboutUsPage(driver);
		
		log.info("TC - 02: Open Contact Us Page from Search Page");
		contactUsPage = aboutUsPage.openContactUsPage(driver);
		
		log.info("TC - 02: Open Search Item Page form Contact Us Page");
		searchItemsPage = contactUsPage.openSearchItemsPage(driver);
		
		log.info("TC - 02: Open Advance Search Page from Search Item Page");
		advanceSearchPage = searchItemsPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 02: Open the About Page from Search Page");
		aboutUsPage = advanceSearchPage.openAboutUsPage(driver);
		
		log.info("TC - 02: Open the Search page from Search Item Page");
		searchItemsPage = aboutUsPage.openSearchItemsPage(driver);
		
		log.info("TC - 02: Open Contact Us Page from Search page");
		contactUsPage = searchItemsPage.openContactUsPage(driver);
		
		log.info("TC - 02: Open Advance Search page from Contact us page");
		advanceSearchPage = contactUsPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 02: Open About user Page from Advance search page");
		advanceSearchPage.openAboutUsPage(driver);
		log.info("TC - 02: Open the About Page from Search Page");
		
		log.info("TC - 02: Open the Search Item from Search Page");
		advanceSearchPage.openSearchItemsPage(driver);
		
		
		log.info("TC - 02: Open the Advance search from Search Page");
		advanceSearchPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 02: Open the About Page from Contact Page");
		contactUsPage.openAboutUsPage(driver);
	}
	

	@Test (priority = 2)
	public void TC_02_Switch_Page() {
		log.info("TC - 03: Click to my account link");
		loginPage = homePage.clickToMyAccountLink();
		
		log.info("TC - 03: Input email to Email Field");
		loginPage.inputEmailToEmailField(CommonTestCase.email);
		
		log.info("TC - 03: Input password to password field");
		loginPage.inputPasswordToPasswordField(CommonTestCase.password);
		
		log.info("TC - 04: Click on Login Button" );
		dashBoardPage = loginPage.clickToLoginButton();
		
		log.info("TC - 03: Check the title login display");
		Assert.assertTrue(dashBoardPage.isTitleLoginSuccessDisplay());
		
		log.info("TC - 03: Open the About Page from Dashboard");
		aboutUsPage = dashBoardPage.openAboutUsPage(driver);
		
		log.info("TC - 03: Open Contact Us Page from Search Page");
		contactUsPage = aboutUsPage.openContactUsPage(driver);
		
		log.info("TC - 03: Open Search Item Page form Contact Us Page");
		searchItemsPage = contactUsPage.openSearchItemsPage(driver);
		
		log.info("TC - 03: Open Advance Search Page from Search Item Page");
		advanceSearchPage = searchItemsPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 03: Open the About Page from Search Page");
		aboutUsPage = advanceSearchPage.openAboutUsPage(driver);
		
		log.info("TC - 03: Open the Search page from Search Item Page");
		searchItemsPage = aboutUsPage.openSearchItemsPage(driver);
		
		log.info("TC - 03: Open Contact Us Page from Search page");
		contactUsPage = searchItemsPage.openContactUsPage(driver);
		
		log.info("TC - 03: Open Advance Search page from Contact us page");
		advanceSearchPage = contactUsPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 03: Open About user Page from Advance search page");
		advanceSearchPage.openAboutUsPage(driver);
		log.info("TC - 03: Open the About Page from Search Page");
		
		log.info("TC - 03: Open the Search Item from Search Page");
		advanceSearchPage.openSearchItemsPage(driver);
		
		
		log.info("TC - 03: Open the Advance search from Search Page");
		advanceSearchPage.openAdvanceSearchPage(driver);
		
		log.info("TC - 03: Open the About Page from Contact Page");
		contactUsPage.openAboutUsPage(driver);
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		removeDriver();
	}

}
