package driverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	WebDriver driver;
	
	protected abstract void createDriver();
	
	public WebDriver getDriver(String url) {
		if(driver==null) {
			createDriver();
		}
		driver.get(url);
		return driver;
	}
	
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
		}
	}
}
