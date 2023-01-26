package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;
import org.util.PropertiesReader;

public class AccountPage extends ActionDriver {
	@FindBy(id = "account-account")
	public WebElement accountImage;
	@FindBy(xpath = "//input[@name='search']")
	public WebElement searchField;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement searchButton;
	public WebDriver driver;
	private static AccountPage accountpage;

	private AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public static AccountPage getInstance(WebDriver driver) {
		if (accountpage == null) {
			accountpage = new AccountPage(driver);
		}
		return accountpage;
	}

	public void clickSearch(String product) {
		ActionDriver.type(searchField, product);}
	public void clickSearchButton() {
        ActionDriver.JSClick(DriverFactory.getDriver(), searchButton);
	}

	public boolean verifyImage() {
		boolean displayed = ActionDriver.isDisplayed(DriverFactory.getDriver(), accountImage);
		return displayed;
	}

}
