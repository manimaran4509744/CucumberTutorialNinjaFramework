package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;

public class OrderSuccessPage extends ActionDriver {
	private static OrderSuccessPage orderpage;
	@FindBy(xpath = "//h1[text()='Your order has been placed!']")
	public WebElement orderSuccessful;

	private OrderSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static OrderSuccessPage getInstance(WebDriver driver) {
		if (orderpage == null) {
			orderpage = new OrderSuccessPage(driver);
		}
		return orderpage;
	}

	public boolean verifySuccesfulMsg() {
		boolean displayed = ActionDriver.isDisplayed(DriverFactory.getDriver(), orderSuccessful);
		return displayed;
	}

}
