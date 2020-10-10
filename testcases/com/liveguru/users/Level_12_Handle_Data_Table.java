 package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.liveguru.AdminLoginPageObject;
import pageObject.liveguru.ManageCustomerPageObject;
import pageObject.liveguru.PageGeneratorManager;

public class Level_12_Handle_Data_Table extends AbstractTest{
	WebDriver driver;
	AdminLoginPageObject adminLoginPage;
	ManageCustomerPageObject manageCustomerPage;
	
	String email;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
	}
	@Test(priority = 1)
	public void TC_01_SearchDataTable() {
		adminLoginPage.inputUserNameToUserNameField("user01");
		adminLoginPage.inputPasswordToUserPasswordField("guru99com");
		manageCustomerPage = adminLoginPage.clickOnLoginButton();
		manageCustomerPage.closeIncomingMessagePopup();
		manageCustomerPage.inputTextToField("Name", "Truyen Kieu");
//		manageCustomerPage.inputTextToField("Email", "truyenkv@yopmail.com");
		manageCustomerPage.sleepInSecond(5);
		manageCustomerPage.clickOnTheButton("Search");
		Assert.assertTrue(manageCustomerPage.isValueDisplayAtRow("4", "3", "Truyen Kieu"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
