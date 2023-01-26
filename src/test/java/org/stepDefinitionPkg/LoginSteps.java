package org.stepDefinitionPkg;

import org.hooks.HooksClass;
import org.junit.Assert;
import org.pageObjects.AccountPage;
import org.pageObjects.HomePage;
import org.pageObjects.LoginPage;
import org.util.DriverFactory;
import org.util.PropertiesReader;

import io.cucumber.java.en.*;

public class LoginSteps {
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountPage;

	@Given("User clicks the My Account Tab")
	public void user_clicks_the_my_account_tab() {
		 homepage = HomePage.getInstance(DriverFactory.getDriver());
		homepage.myAccountOptionClick(DriverFactory.getDriver());

	}

	@And("Selects Login option")
	public void selects_login_option() {
		loginpage = homepage.loginOptionClick();

	}

	@When("User enters valid username in username field and valid password in password field")
	public void user_enters_valid_username_in_username_field_and_valid_password_in_password_field() {
		loginpage.enterUsername(PropertiesReader.prop.getProperty("username"));
		loginpage.enterPassword(PropertiesReader.prop.getProperty("password"));
	}

	@And("clicks Login Button")
	public void clicks_login_button() {
		accountPage = loginpage.clickLoginButton();

	}

	@Then("User should see My Account image")
	public void user_should_see_my_account_image() {
		boolean actual = accountPage.verifyImage();
		Assert.assertTrue(actual);

	}

	@When("User enters Invalid username in username field and Invalid password in password field")
	public void user_enters_invalid_username_in_username_field_and_invalid_password_in_password_field() {
		loginpage.enterUsername(PropertiesReader.prop.getProperty("invaliduser"));
		loginpage.enterPassword(PropertiesReader.prop.getProperty("invalidpass"));
		
		
	}

	@Then("User should see this warning msg")
	public void user_should_see_this_warning_msg() {
		String actual = loginpage.verifyMsg();
		String expected= PropertiesReader.prop.getProperty("errormsg");
		Assert.assertEquals(actual, expected);
	}






}
