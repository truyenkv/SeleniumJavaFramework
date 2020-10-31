package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.liveguru.DataTableSortPageUI;
import pageUIs.liveguru.HomePageUI;
import pageUIs.liveguru.UserLoginPageUI;

public class DataTablePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sortByName(String valueSelect) {
		waitForElementClickable(driver, DataTableSortPageUI.DROP_DOWN_LIST);
//		clickToElement(driver, UserLoginPageUI.DROP_DOWN_LIST);
		selectItemDropdownByText(driver, DataTableSortPageUI.DROP_DOWN_LIST, valueSelect);
		
	}

	public boolean isNameSortAscending() {
		return isDataSortedAscending(driver, DataTableSortPageUI.LIST_OF_PRODUCT_NAME);
	}

	public boolean isNameSortDecending() {
		return isDataSortedDescending(driver, DataTableSortPageUI.LIST_OF_PRODUCT_NAME);
	}

	public boolean isPriceSortAscending() {
		return isPriceSortAscending(driver, DataTableSortPageUI.LIST_OF_PRODUCT_PRICE);
	}

	public boolean isPriceSortDecending() {
		return isPriceSortDescending(driver, DataTableSortPageUI.LIST_OF_PRODUCT_PRICE);
	}


}
