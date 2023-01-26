package org.hooks;

import java.util.Properties;

import org.actions.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.util.DriverFactory;
import org.util.PropertiesReader;
import org.util.Screenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class HooksClass extends DriverFactory{
	
	public static Properties prop;
	public static WebDriver driver;
	@Before(order=0)
	public static void setProperty() {
		 prop = PropertiesReader.initializeProp();
		
	}
	@Before(order=1)
	public static void launch() {
		DriverFactory.launchBrowser(prop.getProperty("browser"));
		 driver = DriverFactory.getDriver();
		 ActionDriver.implicitWait(driver, 10);
		 
		 
		 
		
	}
	@After(order=1)
	public static void takeScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			String ssName = scenario.getName().replace(" ", "_");
			String dateFormat = Screenshot.dateFormat();
			String name=ssName+dateFormat+".png";
		      byte[] source = Screenshot.captureScreenShot();
		      scenario.attach(source, "image/png", name);
			
		}
		
		
	}
	@After(order=0)
	public static void tearDown() {
       driver.close();
	}

}
