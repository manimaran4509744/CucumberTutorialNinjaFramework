package org.stepDefinitionPkg;

import org.util.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.actions.*;
import org.hooks.HooksClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.pageObjects.HomePage;

public class HomePageSteps {
	public static WebDriver driver = DriverFactory.getDriver();
	public static HomePage homepage;

	@Given("user is on homepage")
	public void user_is_on_homepage() {

		DriverFactory.getDriver().get(PropertiesReader.prop.getProperty("url"));

	}

	@Then("logo should be displayed")
	public void logo_should_be_displayed() {
		  homepage = HomePage.getInstance(DriverFactory.getDriver());
		 boolean actual = homepage.validateLogo();
		 Assert.assertTrue(actual);
		
	}

}
