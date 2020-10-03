package com.liveguru.users;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageFactory.liveGuru.DashBoardPageObject;
import pageFactory.liveGuru.HomePageObject;
import pageFactory.liveGuru.LoginPageObject;
import pageFactory.liveGuru.RegisterPageObject;

public class Level_08_PageFactory_Testing extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashBoardPageObject dashBoardPage;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		homePage = new HomePageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToCreateAnAccountButton();
		registerPage = new RegisterPageObject(driver);
	}
	
	
	@Test
	public void Register_01_Valid_Data() throws InterruptedException {
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField("ssxxx@ss1.com");
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111111");
		registerPage.clickToRegisterButton();
		Thread.sleep(4000);
		dashBoardPage = new DashBoardPageObject(driver);
		
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
	}
	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
		removeDriver();
	}

}
