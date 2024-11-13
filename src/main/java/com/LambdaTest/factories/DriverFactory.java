package com.LambdaTest.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import com.LambdaTest.enums.ConfigProperties;
import com.LambdaTest.utilities.PropertyFileUtiladv;

public final class DriverFactory {

	private DriverFactory()
	{
		
	}
	
	@Parameters(value={"browser","version","platform"})
	public static WebDriver  getDriver(String browser, String version, String platform) throws MalformedURLException
	{
		WebDriver driver =null;
		String runMode = PropertyFileUtiladv.readDataFromPropertyFile(ConfigProperties.RUNMODE);
		String userName= "sravan38kumar";
		String accessKey= "P4L6Mz6l4MJv4iG2E9isUd80KIdUUX2Bp0NwvRE3P4w2J1oSU7";
		String gridUrl="@hub.lambdatest.com/wd/hub";
		
		if(runMode.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browsername",browser);
			capabilities.setCapability("version",version);
			capabilities.setCapability("platform",platform);
			capabilities.setCapability("build","LambdaTestAdvancedAssessment");
			capabilities.setCapability("name","LambdaTest_Advanvced_Assessment_1");
			capabilities.setCapability("network",true);
			capabilities.setCapability("video",true);
			capabilities.setCapability("visual",true);
			capabilities.setCapability("console",true);
			driver = new RemoteWebDriver(new URL("https://" + userName + ":"+ accessKey + gridUrl), capabilities);
		}
		else {
			driver = new ChromeDriver();
		}
		return driver;
		
	}
	
}
