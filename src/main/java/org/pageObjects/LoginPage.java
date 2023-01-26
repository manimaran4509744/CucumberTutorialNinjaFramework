
package org.pageObjects;

import java.time.Duration;

import org.actions.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.util.DriverFactory;

public class LoginPage extends ActionDriver {
	private static LoginPage loginpage;
	@FindBy(id = "input-email")
	public WebElement username;
	@FindBy(id = "input-password")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;
	@FindBy(xpath = "(//div[@class='form-group'])[2]//a")
	public WebElement forgotPassword;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement confirmMsg;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement emailMsg;
	public WebDriver driver;
	public AccountPage accountpage;

	private LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void initializeWebelement() {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public static LoginPage getInstance(WebDriver driver) {
		if (loginpage == null) {
			loginpage = new LoginPage(driver);
		}
		return loginpage;
	}

	public void enterUsername(String username1) {

		ActionDriver.type(username, username1);
	}

	public void enterPassword(String password1) {
		ActionDriver.type(password, password1);
	}

	public void clickForgotPassword() {
		try {
			ActionDriver.JSClick(DriverFactory.getDriver(), forgotPassword);
		} catch (Exception e) {
			initializeWebelement();
			ActionDriver.JSClick(DriverFactory.getDriver(), forgotPassword);
		}
		

	}

	public AccountPage clickLoginButton() {
		ActionDriver.click(driver, loginButton);
		accountpage = AccountPage.getInstance(DriverFactory.getDriver());
		return accountpage;

	}

	public String verifyEmailMsg() {
		String text = null;
		try {
			text = emailMsg.getText();
		} catch (Exception e) {
			initializeWebelement();
			text = emailMsg.getText();
		}
		
		return text;
	}

	public String verifyMsg() {
		String text = null;
		try {
			text = confirmMsg.getText();
		} catch (Exception e) {
			initializeWebelement();
			text = confirmMsg.getText();
		}


		return text;
	}

}
