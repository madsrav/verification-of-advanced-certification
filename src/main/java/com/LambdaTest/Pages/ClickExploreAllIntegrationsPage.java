package com.LambdaTest.Pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LambdaTest.driver.DriverManager;
import com.LambdaTest.utilities.WebDriverUtilities;



public class ClickExploreAllIntegrationsPage {

	@FindBy(xpath="//div[@id='__next']")
	private WebElement allElementsLocated;
	
	@FindBy(xpath="//div/p/a[@href='https://www.lambdatest.com/integrations']")
	private WebElement exploreAllIntegrationslink;
	
	public ClickExploreAllIntegrationsPage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public WebElement getCheckAllElementsLocated() 
	{
		return allElementsLocated;
	}
	
	public WebElement getClickExploreAllIntegrations() 
	{
		return exploreAllIntegrationslink;
	}

	public void loadingAllElementsAndCLickOnExplorelink() throws AWTException, InterruptedException
	{
		//Step-2: Performing an explicit wait till the time all the elements in the DOM are available.
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(getCheckAllElementsLocated()));
		
		//Step -3: Using Scroll to the view method scrolling to the particular element.
		WebDriverUtilities utils = new WebDriverUtilities();
		utils.scrollToElement(exploreAllIntegrationslink);
		
		 // Get the link from exploreAllIntegrationslink.
        String linkUrl = exploreAllIntegrationslink.getAttribute("href");

        // STep-4:Using JavaScriptExecutor to open the link in a new tab(Click on the link and ensure that it opens in a new Tab)
        JavascriptExecutor js1 = (JavascriptExecutor) DriverManager.getDriver();
        js1.executeScript("window.open(arguments[0], '_blank');", linkUrl);

        // Optionally,using wait to observe the actual result
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	
	}
}
