package com.LambdaTest.utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LambdaTest.driver.DriverManager;



public class WebDriverUtilities {


	// Method for page load wait --> Implicit wait
	public void implicitWait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// Method to maximize the browser window
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}

	// Method to close the browser
	public void closingBrowser(WebDriver driver)
	{

		if (driver != null) 
			driver.quit();
	}

	//Method to scroll to the particular element using "scrollIntoView". 
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", element);

	}
	// Method to print window sizes and handles
	public void printWindowSizesAndHandles() {
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		System.out.println("No.of open windows/tabs are --> "+" "+allWindows.size()+" "+allWindows);
	}
	// Method to switch to a specific window or tab
	public void switchToWindow(String CurrentWindowTitle) {
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		for (String windowHandle : allWindows) {
			DriverManager.getDriver().switchTo().window(windowHandle);
			if(DriverManager.getDriver().getTitle().equals(CurrentWindowTitle))
			{
				return;
			}
		}
	}
}
