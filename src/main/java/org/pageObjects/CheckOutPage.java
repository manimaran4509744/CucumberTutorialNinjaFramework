package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;
import org.util.PropertiesReader;

public class CheckOutPage extends ActionDriver {
	@FindBy(xpath = "//a[@class='accordion-toggle']")
	public WebElement billingDetails;

	@FindBy(id = "input-email")
	public WebElement username;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "(//input[@name='payment_address'])[1]")
	public WebElement selectbillingDetails;

	@FindBy(id = "button-payment-address")
	public WebElement continueBilling;

	@FindBy(xpath = "(//a[@class='accordion-toggle collapsed'])[1]")
	public WebElement delieveryDetails;
	@FindBy(xpath = "(//select[@name='address_id'])[2]")
	public WebElement clickdelieveryDetailsButton;

	@FindBy(id = "button-shipping-address")
	public WebElement ContinueDelievery;

	@FindBy(xpath = "//h4[text()='Step 4: Delivery Method']")
	public WebElement deliveryMethod;

	@FindBy(id = "button-shipping-method")
	public WebElement continueDeliveryMethod;

	@FindBy(xpath = "//input[@name='agree']")
	public WebElement ClickPaymentMethodCheckBox;

	@FindBy(id = "button-payment-method")
	public WebElement continuePaymentMethod;

	@FindBy(id = "button-confirm")
	public WebElement clickConfirmOrder;
	private static CheckOutPage checkoutpage;
	public OrderSuccessPage orderSuccessPage;

	private CheckOutPage(WebDriver driver) {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public static CheckOutPage getInstance(WebDriver driver) {
		if (checkoutpage == null) {
			checkoutpage = new CheckOutPage(driver);
		}
		return checkoutpage;
	}

	public OrderSuccessPage clickBilling() {
		ActionDriver.JSClick(DriverFactory.getDriver(), billingDetails);
		ActionDriver.type(username, PropertiesReader.prop.getProperty("username"));
		ActionDriver.type(password, PropertiesReader.prop.getProperty("password"));
		ActionDriver.JSClick(DriverFactory.getDriver(), loginButton);
		ActionDriver.JSClick(DriverFactory.getDriver(), continueBilling);
		ActionDriver.JSClick(DriverFactory.getDriver(), delieveryDetails);
		ActionDriver.selectByVisibleText(
				"manimaran kumar, Beemanthoppu Bus Stop, Eraiyur, Tamil Nadu, Kanchipuram, Anglesey, United Kingdom",
				clickdelieveryDetailsButton);
		ActionDriver.JSClick(DriverFactory.getDriver(), ContinueDelievery);
		ActionDriver.JSClick(DriverFactory.getDriver(), deliveryMethod);
		ActionDriver.JSClick(DriverFactory.getDriver(), continueDeliveryMethod);
		ActionDriver.JSClick(DriverFactory.getDriver(), ClickPaymentMethodCheckBox);
		ActionDriver.JSClick(DriverFactory.getDriver(), continuePaymentMethod);
		ActionDriver.click(DriverFactory.getDriver(), clickConfirmOrder);
		orderSuccessPage = OrderSuccessPage.getInstance(DriverFactory.getDriver());
		return orderSuccessPage;
	}
}
