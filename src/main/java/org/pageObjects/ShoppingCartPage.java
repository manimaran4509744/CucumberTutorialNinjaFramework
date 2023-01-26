package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;

public class ShoppingCartPage extends ActionDriver {
	private static ShoppingCartPage shoppingpage;
	public CheckOutPage checkoutPage;
	@FindBy(xpath = "//div[@class='table-responsive']")
	public WebElement productImage;
	@FindBy(xpath = "//a[text()='Checkout']")
	public WebElement checkout;

	private ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static ShoppingCartPage getInstance(WebDriver driver) {
		if (shoppingpage == null) {
			shoppingpage = new ShoppingCartPage(driver);
		}
		return shoppingpage;
	}

	public CheckOutPage clickCheckout() {
		ActionDriver.JSClick(DriverFactory.getDriver(), checkout);
		checkoutPage = CheckOutPage.getInstance(DriverFactory.getDriver());
		return checkoutPage;
	}

	public void verifyProductImage() {
		ActionDriver.isDisplayed(DriverFactory.getDriver(), productImage);
	}

}
