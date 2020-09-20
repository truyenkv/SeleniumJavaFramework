package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractTest {
	WebDriver driver;
	
	public WebDriver getWebDriver(String browserName) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
		}
//		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browserDrivers/msedgedriver");
//		driver = new EdgeDriver();
		return driver;
	}
}
