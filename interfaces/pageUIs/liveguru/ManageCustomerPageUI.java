package pageUIs.liveguru;

public class ManageCustomerPageUI {
	public static final String IMCOMING_MESSAGE_CLOSE_BUTTON = "//span[text()='close']";
	public static final String DYNAMIC_TEXT_TITLE = "//tr[@class='headings']//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String DYNAMIC_TEXT_FIELD = "//tr[@class='filter']/th[%s]//input";
	public static final String DYNAMIC_SEARCH_BUTTON = "//button//span[text()='%s']";
	public static final String DYNAMIC_RESULT = "//tr[%s]/td[%s][contains(text(),'%s')]";
	
	
}
