package org.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static WebDriver driver;

	public static byte[] captureScreenShot() {
		driver = DriverFactory.getDriver();
		TakesScreenshot tk = (TakesScreenshot) driver;
		byte[] source = tk.getScreenshotAs(OutputType.BYTES);
//		File destination = new File(System.getProperty("user.dir") + "\\Screenshot\\" + name);
//		try {
//			FileUtils.copyFile(source, destination);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return source;
	}

	public static String dateFormat() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat();
		String format = simple.format(date);
		String replace = format.replace("/", ".");
		String replace2 = replace.replace(" ", "");
		String replace3 = replace2.replace(":", ".");
		return replace3;
	}
}
