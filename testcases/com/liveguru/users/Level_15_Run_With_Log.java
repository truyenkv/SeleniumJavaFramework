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

public class Level_15_Run_With_Log extends AbstractTest{
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
		
	}
	
	@Test(priority = 1)
	public void TC_01_Register_Valid_Data() {
		log.info("Step 01 - Check the MyAccount in the Footer");
		verifyTrue(homePage.isFooterMyAccountDisplay());
		
		log.info("Step 02 - Check the MyAccount in the Header");
		verifyTrue(homePage.isHeaderMyAccountUnDisplay());
		
		log.info("Step 03 - Check the Error Text Box Display");
		verifyFalse(homePage.isErrorSubscribeTextBoxUnDisplay());
		
		log.info("Step 04 - Click the Subscribe button");
		homePage.clickSubscribeTextBoxButton();
		
		log.info("Step 04 - Check the Error Text Box Display after click the Subcribece");
		verifyTrue(homePage.isErrorSubscribeTextBoxDisplay());
	}
	
	@Test(priority = 1)
	public void TC_02_Register_Valid_Data() {
		log.info("Step 01 - Check the MyAccount in the Footer");
		verifyTrue(homePage.isFooterMyAccountDisplay());
		
		log.info("Step 02 - Check the MyAccount in the Header");
		verifyTrue(homePage.isHeaderMyAccountUnDisplay());
		
		log.info("Step 03 - Check the Error Text Box Display");
		verifyFalse(homePage.isErrorSubscribeTextBoxUnDisplay());
		
		log.info("Step 04 - Click the Subscribe button");
		homePage.clickSubscribeTextBoxButton();
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
