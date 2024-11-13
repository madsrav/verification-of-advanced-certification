package com.lambdaTest.Scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.LambdaTest.driver.Driver;




//@Listeners(com.LambdaTest.generic.ListenerImplementation.class)
public class BaseTest {
	
	protected BaseTest() {
	}
	
	@Parameters(value={"browser","version","platform"})
	@BeforeMethod
	protected void setUp(String browser,String version,String platform){
		Driver.initDriver(browser, version, platform);
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
