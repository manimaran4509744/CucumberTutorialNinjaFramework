package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.DriverFactory;
import org.util.PropertiesReader;

public class RegisterPage extends ActionDriver {
	public RegisterationSuccessPage successpage;
	private static RegisterPage registerpage;
	@FindBy(id = "input-firstname")
	public WebElement firstName;
	@FindBy(id = "input-lastname")
	public WebElement lastName;
	@FindBy(id = "input-email")
	public WebElement emailId;
	@FindBy(id = "input-telephone")
	public WebElement telephone;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(id = "input-confirm")
	public WebElement confirmPassword;
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement checkbox;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement confirmButton;

	private RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static RegisterPage getInstance(WebDriver driver) {
		if (registerpage == null) {
			registerpage = new RegisterPage(driver);
		}
		return registerpage;
	}

	public void enterFirstName() {
		ActionDriver.click(DriverFactory.getDriver(), firstName);
//		ActionDriver.JSClick(driver, firstName);
		ActionDriver.type(firstName, PropertiesReader.prop.getProperty("firstName"));
	}

	public void enterLastName() {
		ActionDriver.click(DriverFactory.getDriver(), lastName);
//		ActionDriver.JSClick(driver, lastName);
		ActionDriver.type(lastName, PropertiesReader.prop.getProperty("lastName"));

	}

	public void enteremailId() {
		ActionDriver.click(DriverFactory.getDriver(), emailId);
//		ActionDriver.JSClick(driver, emailId);
		ActionDriver.type(emailId, PropertiesReader.prop.getProperty("emailId"));
	}

	public void enterTelephone() {
		ActionDriver.click(DriverFactory.getDriver(), telephone);
//		ActionDriver.JSClick(driver, telephone);
		ActionDriver.type(telephone, PropertiesReader.prop.getProperty("telephone"));

	}

	public void enterPassword() {
		ActionDriver.click(DriverFactory.getDriver(), password);
//		ActionDriver.JSClick(driver, password);
		ActionDriver.type(password, PropertiesReader.prop.getProperty("registerpassword"));

	}

	public void confirmPassword() {
		ActionDriver.click(DriverFactory.getDriver(), confirmPassword);
//		ActionDriver.JSClick(driver, confirmPassword);
		ActionDriver.type(confirmPassword, PropertiesReader.prop.getProperty("confirmPassword"));

	}

	public void clickCheckbox() {
		ActionDriver.JSClick(DriverFactory.getDriver(), checkbox);

	}

	public RegisterationSuccessPage clickConfirmButton() {
		ActionDriver.JSClick(DriverFactory.getDriver(), confirmButton);
		successpage = RegisterationSuccessPage.getInstance(DriverFactory.getDriver());
		return successpage;
	}

}
