 package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.liveguru.AboutUsPageObject;
import pageObject.liveguru.AdvanceSearchPageObject;
import pageObject.liveguru.ContactUsPageObject;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.DataTablePageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;
import pageObject.liveguru.SearchItemsPageObject;
import pageObject.liveguru.UserLoginPageObject;

public class Level_20_Sort_Data extends AbstractTest{
	WebDriver driver;
	DataTablePageObject dataTablePage;	
	@Parameters({"browser", "appUrl"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		dataTablePage = PageGeneratorManager.getDataTablePage(driver);
	}

	@Test(priority = 4)
	public void TC_01_Name_A_To_Z() {
		dataTablePage.sortByName("Name (A to Z)");
		verifyTrue(dataTablePage.isNameSortAscending());
	}
	@Test(priority = 1)
	public void TC_02_Name_Z_To_A() {
		dataTablePage.sortByName("Name (Z to A)");
		verifyTrue(dataTablePage.isNameSortDecending());
		
	}
	@Test(priority = 2)
	public void TC_03_Price_Low_To_High() {
		dataTablePage.sortByName("Price (low to high)");
		verifyTrue(dataTablePage.isPriceSortAscending());
	}
	@Test(priority = 3)
	public void TC_04_Price_High() {
		dataTablePage.sortByName("Price (high to low)");
		verifyTrue(dataTablePage.isPriceSortDecending());
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.close();
	}

}
