package driverFactory;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicrosoftEdgeManager extends DriverManager{

	@Override
	protected void createDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}
	

}
