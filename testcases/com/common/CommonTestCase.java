package com.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.UserLoginPageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;

public class CommonTestCase extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	UserLoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
 	public static String email, password = "111111";
	
	@Parameters({"browser", "appUrl"})
	@BeforeTest
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		email = randomString() + "@vietnam.com";
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField(email);
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111111");
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		homePage = dashBoardPage.clickOnLogoutLink();
		removeDriver();
	}

}
