package org.pageObjects;

import org.actions.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.*;

public class HomePage extends ActionDriver {

	@FindBy(xpath = "//input[@name='search']")
	public WebElement search;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement searchButton;
	@FindBy(xpath = "//a[text()='Your Store']")
	public WebElement logo;
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountOption;
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginOption;
	@FindBy(xpath = "//a[text()='Register']")
	public WebElement RegisterOption;
	@FindBy(xpath = "(//div[@id='content']/div[@class='swiper-viewport'])[1]")
	public WebElement masterImage;
	@FindBy(id = "content")
	public WebElement featureImage;
	public WebDriver driver;
	private LoginPage loginpage;
	private static HomePage homepage;

	private HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void initializeWebelement() {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public static HomePage getInstance(WebDriver driver) {
		if (homepage == null) {
			homepage = new HomePage(driver);
		}
		return homepage;

	}

	public void search() {

	}

	public void clickSearch() {
	}

	public void myAccountOptionClick(WebDriver driver) {

		try {
			ActionDriver.JSClick(driver, myAccountOption);
		} catch (Exception e) {
			initializeWebelement();
			ActionDriver.JSClick(driver, myAccountOption);
		}
	
	}

	public LoginPage loginOptionClick() {

		try {
			ActionDriver.click(DriverFactory.getDriver(), loginOption);
		} catch (Exception e) {
			initializeWebelement();
			ActionDriver.click(DriverFactory.getDriver(), loginOption);
		}
		loginpage = LoginPage.getInstance(DriverFactory.getDriver());
		return loginpage;
	}

	public boolean validateLogo() {
		boolean actual=false;
		try {
		actual = ActionDriver.isDisplayed(DriverFactory.getDriver(), logo);
		}
		catch(Exception e) {
			initializeWebelement();
			actual = ActionDriver.isDisplayed(DriverFactory.getDriver(), logo);
			
		}
		return actual;

	}

	public void validateMasterImage() {

	}

	public void clickRegisterOption() {
	}

	public void validateFeatureImage() {
	}

}
