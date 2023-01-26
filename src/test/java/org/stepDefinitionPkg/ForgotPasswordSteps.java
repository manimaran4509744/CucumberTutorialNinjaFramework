package org.stepDefinitionPkg;

import java.util.List;

import org.junit.Assert;
import org.pageObjects.ForgotPasswordPage;
import org.pageObjects.LoginPage;
import org.util.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {
	public ForgotPasswordPage passwordPage;
	public LoginPage loginPage;

	@When("User clicks Forgot password link")
	public void user_clicks_forgot_password_link() {
		LoginPage loginPage = LoginPage.getInstance(DriverFactory.getDriver());
		loginPage.clickForgotPassword();

	}

	@When("User Enters the email Id")
	public void user_enters_the_email_id(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		List<String> list2 = list.get(0);
		String emailId = list2.get(0);
		passwordPage = ForgotPasswordPage.getInstance(DriverFactory.getDriver());
		passwordPage.enterEmailId(emailId);
	}

	@When("Clicks Continue Button")
	public void clicks_continue_button() {
		loginPage = passwordPage.clickContinue();
	}

	@Then("User should the email succesfully sent message")
	public void user_should_the_email_succesfully_sent_message(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		List<String> list2 = list.get(0);
		String expected = list2.get(0);
		String actual = loginPage.verifyEmailMsg();
		Assert.assertEquals(actual, expected);
	}

}
