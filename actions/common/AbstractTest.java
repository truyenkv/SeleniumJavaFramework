package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	// public static WebDriver driver;
	// khai bao driver thread.local
	protected static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

	public WebDriver getWebDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
			System.out.println("The driver is " + getDriver().toString());
		}

		else if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		} else if (browser == Browser.EDGE) {
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());

		}
		getDriver().manage().window().maximize();
		getDriver().get("http://live.demoguru99.com/");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}

	public WebDriver getWebDriver(String browserName, String appUrl) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			setDriver(new ChromeDriver());
		}

		else if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			setDriver(new FirefoxDriver());
		} else if (browser == Browser.EDGE) {
			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
			setDriver(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().get(appUrl);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
	}

	// goi ham remove driver
	protected void removeDriver() {
		getDriver().quit();
		threadLocal.remove();
	}

	private WebDriver getDriver() {
		return threadLocal.get();
	}

	private void setDriver(WebDriver driver) {
		threadLocal.set(driver);
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
