package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;

public class SearchPage extends ActionDriver {
	public ProductDisplayPage displayPage;
	private static SearchPage searchpage;
	@FindBy(xpath = "//img[@title='HP LP3065']")
	public WebElement product;

	private SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static SearchPage getInstance(WebDriver driver) {
		if (searchpage == null) {
			searchpage = new SearchPage(driver);
		}
		return searchpage;
	}

	public ProductDisplayPage clickProduct() {
		ActionDriver.JSClick(DriverFactory.getDriver(), product);
		displayPage = ProductDisplayPage.getInstance(DriverFactory.getDriver());
		return displayPage;
	}

	public boolean verifyImage() {
		boolean displayed = ActionDriver.isDisplayed(DriverFactory.getDriver(), product);
		return displayed;
	}

}
