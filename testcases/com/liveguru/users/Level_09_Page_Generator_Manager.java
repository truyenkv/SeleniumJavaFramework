package com.liveguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.LoginPageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;

public class Level_09_Page_Generator_Manager extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
	String email;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
//		homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		//homePage.clickToMyAccountLink();
		//loginPage = new LoginPageObject(driver);
		loginPage = homePage.clickToMyAccountLink();
		//loginPage.clickToCreateAnAccountButton();
//		registerPage = new RegisterPageObject(driver);
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
//		registerPage.clickToRegisterButton();
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		//dashBoardPage.clickOnLogoutLink();
		homePage = dashBoardPage.clickOnLogoutLink();
		
	}
	
	@Test (priority = 2)
	public void TC_02_Login_Page() {
		//homePage.clickToMyAccountLink();
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailToEmailField(email);
		loginPage.inputPasswordToPasswordField("111111");
//		loginPage.clickToLoginButton();
		dashBoardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(dashBoardPage.isTitleLoginSuccessDisplay());
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		//removeDriver();
	}

}
