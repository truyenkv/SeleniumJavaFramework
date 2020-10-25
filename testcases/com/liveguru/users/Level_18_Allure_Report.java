 package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.CommonTestCase;

import common.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import pageObject.liveguru.AboutUsPageObject;
import pageObject.liveguru.AdvanceSearchPageObject;
import pageObject.liveguru.ContactUsPageObject;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;
import pageObject.liveguru.SearchItemsPageObject;
import pageObject.liveguru.UserLoginPageObject;

@Epic("Login Module")
public class Level_18_Allure_Report extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	UserLoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
	AboutUsPageObject aboutUsPage;
	ContactUsPageObject contactUsPage;
	SearchItemsPageObject searchItemsPage;
	AdvanceSearchPageObject advanceSearchPage;
	 
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Description("Login the system after register successful")
	@Story("Story 01 - Register to system")
	@Test (priority = 1)
	public void TC_01_Login_The_User_Form() {
		log.info("TC - 01: Click to my account link");
		loginPage = homePage.clickToMyAccountLink();
		
		log.info("TC - 02: Input email to Email Field");
		loginPage.inputEmailToEmailField(CommonTestCase.email);
		
		log.info("TC - 03: Input password to password field");
		loginPage.inputPasswordToPasswordField(CommonTestCase.password);
		
		log.info("TC - 04: Click on Login Button" );
		dashBoardPage = loginPage.clickToLoginButton();
		
		log.info("TC - 05: Check the title login display");
		Assert.assertFalse(dashBoardPage.isTitleLoginSuccessDisplay());
	}   
	
//	@Test (priority = 2)
//	public void TC_03_Switch_Page() {
//		log.info("TC - 02: Open the About Page from Dashboard");
//		aboutUsPage = homePage.openAboutUsPage(driver);
//		
//		log.info("TC - 02: Open Contact Us Page from Search Page");
//		contactUsPage = aboutUsPage.openContactUsPage(driver);
//		
//		log.info("TC - 02: Open Search Item Page form Contact Us Page");
//		searchItemsPage = contactUsPage.openSearchItemsPage(driver);
//		
//		log.info("TC - 02: Open Advance Search Page from Search Item Page");
//		advanceSearchPage = searchItemsPage.openAdvanceSearchPage(driver);
//		
//	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		removeDriver();
	}

}
