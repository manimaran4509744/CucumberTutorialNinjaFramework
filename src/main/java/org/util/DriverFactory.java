package org.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**This method will get the instance of ThreadLocal
	 * 
	 * @return the instance of ThreadLocal
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}
    /** This method will get the browser as an input and initialize the WebDriver accordingly
     * 
     * @param browser
     */
	public static  void launchBrowser(String browser) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());

		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());

		} else {
			System.out.println("Enter the proper browser name");
		}
        
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

	}

}
