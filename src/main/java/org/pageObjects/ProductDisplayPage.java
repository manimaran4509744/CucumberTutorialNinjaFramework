package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;

public class ProductDisplayPage extends ActionDriver {
	public ShoppingCartPage shopping;
	private static ProductDisplayPage productdisplaypage;
	@FindBy(id = "button-cart")
	public WebElement addToCart;
	@FindBy(xpath = "//a[text()='shopping cart']")
	public WebElement successMsg;
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	public WebElement shoppingPage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement successTxt;
	

	private ProductDisplayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static ProductDisplayPage getInstance(WebDriver driver) {
		if (productdisplaypage == null) {
			productdisplaypage = new ProductDisplayPage(driver);
		}
		return productdisplaypage;
	}

	public void clickAddToCart() {
		ActionDriver.JSClick(DriverFactory.getDriver(), addToCart);

	}

	public boolean verifySucessMsg() {
		ActionDriver.explicitWait(DriverFactory.getDriver(), successMsg, 10);
		boolean displayed = ActionDriver.isDisplayed(DriverFactory.getDriver(), successMsg);
		return displayed;
	}
	public String verifySucessTxt() {
		ActionDriver.implicitWait(DriverFactory.getDriver(), 5);
		String text = successTxt.getText();
		return text;
		
	}

	public ShoppingCartPage clickShoppingCart() {
		ActionDriver.JSClick(DriverFactory.getDriver(), shoppingPage);
		shopping = ShoppingCartPage.getInstance(DriverFactory.getDriver());
		return shopping;

	}

}
