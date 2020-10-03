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
import pageObject.liveguru.RegisterPageObject;

public class Level_05_Parallel_Testing extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
	
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
//		driver = getWebDriver(browserName);
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
	
//	@Test
	public void Register_01_Empty_Data() {
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorTextRequiredOfFirstNameTextField(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorTextRequiredOfLastNameTextField(), "This is a required field.");
		Assert.assertEquals(registerPage.getErrorTextRequiredOfEmailTextField(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorTextRequiredOfPasswordTextField(),"This is a required field.");
		Assert.assertEquals(registerPage.getErrorTextRequiredOfConfirmPasswordTextField(),"This is a required field.");
	}
	
//	@Test
	public void Register_02_Invalid_Email() {
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField("ssxxx@ss");
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111111");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getMessageOfInvalidEmail(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
//	@Test
	public void Register_03_Password_Less_Than_6_Chars() {
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField("ssxxx@ss");
		registerPage.inputTextToPasswordField("1111");
		registerPage.inputTextToConfirmPasswordField("1111");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getMessageOfPasswordLessThanSixChars(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
//	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField("ssxxx@ss");
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111112");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getMessageOfPasswordLessThanSixChars(), "Please make sure your passwords match.");
	}
	
	@Test
	public void Register_05_Valid_Data() {
		registerPage.inputTextToFirstNameField("Truyen");
		registerPage.inputTextToLastField("Kieu");
		registerPage.inputTextToEmailField("ssxxx@ss1.com");
		registerPage.inputTextToPasswordField("111111");
		registerPage.inputTextToConfirmPasswordField("111111");
		registerPage.clickToRegisterButton();
		dashBoardPage = new DashboardPageObject(driver);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
	}
	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
		removeDriver();
	}

}
