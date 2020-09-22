package driverFactory;
import common.Browser;
public class DriverFactory {
	public static DriverManager getBrowserDriver(String browserName) {
		DriverManager driverManager = null;
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if(browser == Browser.CHROME) {
			driverManager = new ChromeDriverManager();
		} 
		else if(browser == Browser.EDGE) {
			driverManager = new MicrosoftEdgeManager();
		}
		else if(browser == Browser.FIREFOX){
			driverManager = new FireFoxDriverManager();
		}
		else {
			throw new RuntimeException("Please select correct Browser");
		}
		
		return driverManager;
	}
}
