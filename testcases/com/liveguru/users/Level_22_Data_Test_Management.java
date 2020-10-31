package com.liveguru.users;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.liveguru.data.EndUserJson;
import com.liveguru.data.UserData;

import common.AbstractTest;
import common.DataUntil;
import common.GlobalConstant;
import pageObject.liveguru.DashboardPageObject;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.PageGeneratorManager;
import pageObject.liveguru.RegisterPageObject;
import pageObject.liveguru.UserLoginPageObject;

public class Level_22_Data_Test_Management extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	UserLoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashBoardPage;
 	DataUntil data = null;
 	EndUserJson dataJson = null;
 	String firstName, lastName, email, password;
	@Parameters({"browser", "appUrl"})
	
	@BeforeMethod
	public void beforeClass(String browserName, String appUrl) throws JsonParseException, JsonMappingException, IOException {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		homePage = PageGeneratorManager.getHomePage(driver);
		data = DataUntil.getData();
		dataJson = EndUserJson.getDataJson(GlobalConstant.projectPath + "/testdata/EndUser.json");
		firstName = data.getFirstName();
		lastName = data.getFirstName();
		email = data.getEmail();
		password = data.getPassword();
	}
	
	@Test(priority = 1)
	public void TC_01_Data_In_Class() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputTextToFirstNameField(firstName);
		registerPage.inputTextToLastField(lastName);
		registerPage.inputTextToEmailField(email);
		registerPage.inputTextToPasswordField(password);
		registerPage.inputTextToConfirmPasswordField(password);
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		
	}
	
	@Test(priority = 2)
	public void TC_02_Data_Out_Class() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputTextToFirstNameField(UserData.Login.firstName);
		registerPage.inputTextToLastField(UserData.Login.lastName);
		registerPage.inputTextToEmailField(UserData.Login.email + randomString() + "@gmail.com");
		registerPage.inputTextToPasswordField(UserData.Login.password);
		registerPage.inputTextToConfirmPasswordField(UserData.Login.password);
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		
	}
	@Test(priority = 3)
	public void TC_03_Data_JSon() {
		loginPage = homePage.clickToMyAccountLink();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputTextToFirstNameField(dataJson.getFirstName());
		registerPage.inputTextToLastField(dataJson.getLastName());
		registerPage.inputTextToEmailField(dataJson.getEmail() + randomString() + "@gmail.com");
		registerPage.inputTextToPasswordField(dataJson.getPassword());
		registerPage.inputTextToConfirmPasswordField(dataJson.getPassword());
		dashBoardPage = registerPage.clickToRegisterButton();
		System.out.print(email);
		Assert.assertEquals(dashBoardPage.getMessageofSuccessfulRegister(),"Thank you for registering with Main Website Store.");
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void AfterClass() {
		removeDriver();
	}

}
