package com.LambdaTest.driver;

import java.time.Duration;
import java.util.Objects;

import org.testng.annotations.Parameters;

import com.LambdaTest.enums.ConfigProperties;
import com.LambdaTest.factories.DriverFactory;
import com.LambdaTest.utilities.PropertyFileUtiladv;


public class Driver {
	private Driver() {
	}

	@Parameters(value={"browser","version","platform"})
	public static void initDriver(String browser,String version,String platform) {
		if (Objects.isNull(DriverManager.getDriver()))// driver == null
		{
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version, platform));
			} catch (Exception e) {
				throw new RuntimeException("Please check capabilites of browser");
			}
			DriverManager.getDriver().get(PropertyFileUtiladv.readDataFromPropertyFile(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	/**
	 * Terminates the browser instance. Sets the thread local to default value, i.e
	 * null.
	 * 
	 * @author Sravan Kumar M
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver()))// driver!=null
		{
			DriverManager.getDriver().quit();
			DriverManager.unload(); // getDriver() = null;
		}
	}

}
