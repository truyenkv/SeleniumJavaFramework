 package com.jQuery.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pageObject.jQuery.PageGeneratorManager;
import pageObject.jQuery.UploadPageObject;

public class Level_13_UploadFile extends AbstractTest{
	WebDriver driver;	
	UploadPageObject uploadPage;
	String image1 = "image1.jpg";
	String image2 = "image2.jpg";
	String image3 = "image3.jpg";
	
	@Parameters({"browser", "appUrl"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getWebDriver(browserName, appUrl);
		System.out.println("The driver is "+ driver.toString());
		uploadPage = PageGeneratorManager.getUploadPage(driver);
	}
	@Test(priority = 1)
	public void TC_01_Upload_File() {
//		uploadPage.uploadMultipleFile(driver, image1);
//		uploadPage.sleepInSecond(3);
		uploadPage.uploadMultipleFile(driver, image1, image2, image3);
		uploadPage.sleepInSecond(3);
		uploadPage.clickOnAllUploadButton("Start");
		uploadPage.sleepInSecond(3);
		Assert.assertTrue(uploadPage.isAllImageUploadSuccess(image1, image2, image3));
		uploadPage.uploadMultipleFile(driver, image1, image2, image3);
		uploadPage.sleepInSecond(3);
		uploadPage.clickOnAllUploadButton("Cancel");
		uploadPage.sleepInSecond(3);
		;
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
