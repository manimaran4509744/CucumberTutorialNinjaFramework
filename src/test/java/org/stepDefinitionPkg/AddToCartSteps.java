package org.stepDefinitionPkg;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.pageObjects.AccountPage;
import org.pageObjects.ProductDisplayPage;
import org.pageObjects.SearchPage;
import org.util.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	public AccountPage accountPage;
	public ProductDisplayPage displayPage;

	@Given("User enters product name")
	public void user_enters_product_name(DataTable dataTable) {
		List<String> list = dataTable.asList(String.class);
		String productName = list.get(0);
		accountPage = AccountPage.getInstance(DriverFactory.getDriver());
		accountPage.clickSearch(productName);
	}

	@Given("clicks search button")
	public void clicks_search_button() {
		accountPage.clickSearchButton();
	}

	@Given("User clicks product image")
	public void user_clicks_product_image() {
		SearchPage searchPage = SearchPage.getInstance(DriverFactory.getDriver());
		displayPage = searchPage.clickProduct();
	}

	@When("User clicks Add to cart button")
	public void user_clicks_add_to_cart_button() {
		displayPage.clickAddToCart();
	}

	@Then("User should see successmsg")
	public void user_should_see_successmsg(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		List<String> list2 = list.get(0);
		String expected = list2.get(0);
		String value = displayPage.verifySucessTxt();
		String actual = value.replace("×", "");
		System.out.println(actual+expected);
		Assert.assertEquals(actual, expected);
	}

}
