package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;
import org.util.PropertiesReader;

public class ForgotPasswordPage extends ActionDriver {
	@FindBy(id = "input-email")
	public WebElement emailId;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButton;
	public LoginPage loginpage;
	private static ForgotPasswordPage forgotpage;

	private ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static ForgotPasswordPage getInstance(WebDriver driver) {
		if (forgotpage == null) {
			forgotpage = new ForgotPasswordPage(driver);
		}
		return forgotpage;
	}

	public void enterEmailId(String emailid2) {
		ActionDriver.type(emailId, emailid2);
	}

	public LoginPage clickContinue() {
		ActionDriver.JSClick(DriverFactory.getDriver(), continueButton);
		loginpage = LoginPage.getInstance(DriverFactory.getDriver());
		return loginpage;

	}

}
