package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;

public class RegisterationSuccessPage extends ActionDriver {
	private static RegisterationSuccessPage registerationsuccesspage;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement successPage;

	private RegisterationSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static RegisterationSuccessPage getInstance(WebDriver driver) {
		if (registerationsuccesspage == null) {
			registerationsuccesspage = new RegisterationSuccessPage(driver);
		}
		return registerationsuccesspage;
	}

	public boolean verifyMsg() {
		boolean actual = ActionDriver.isDisplayed(DriverFactory.getDriver(), successPage);
		return actual;
	}

}
