package pageUIs.liveguru;

public class AbstractPageUI {
	public static final String ABOUTUS_LINK = "//a[contains(text(),'About Us')]";
	public static final String ADVANCESEARCH_LINK = "//a[contains(text(),'Advanced Search')]";
	public static final String SEARCHITEMS_LINK = "//a[contains(text(),'Search Terms')]";
	public static final String CONTACTUS_LINK = "//a[contains(text(),'Contact Us')]";
	public static final String DYNAMIC_LINK = "//div[@class='footer']//a[contains(text(),'%s')]";
	public static final String UPLOAD_FILE = "//input[@type='file']";
	public static final String DYNAMIC_INPUT_LOCATOR = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_LOCATOR = "//*[@class='button' and @title='%s']";
	
	
}
