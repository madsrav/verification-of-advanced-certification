package com.lambdaTest.Scripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.LambdaTest.Pages.ClickCodelessAutomationPage;
import com.LambdaTest.Pages.ClickCommunityLink3Page;
import com.LambdaTest.Pages.ClickExploreAllIntegrationsPage;
import com.LambdaTest.driver.DriverManager;
import com.LambdaTest.utilities.WebDriverUtilities;


public class LambdaSeleniumAdvancedAssessmentTest extends BaseTest {

	@Test
	public void assessmentTest() throws AWTException, InterruptedException

	{
	
		//Created objects for all the three pages
		ClickExploreAllIntegrationsPage page1= new ClickExploreAllIntegrationsPage();
		ClickCodelessAutomationPage     page2= new ClickCodelessAutomationPage();
		ClickCommunityLink3Page         page3= new ClickCommunityLink3Page();
		WebDriverUtilities              utils= new WebDriverUtilities();

		
		
		// utilize steps 1 to 4 
		page1.loadingAllElementsAndCLickOnExplorelink();	

		// Step-5: Print the window handles	of the opened windows
		utils.printWindowSizesAndHandles();

		String ExpectedURL = "https://www.lambdatest.com/integrations";

		//Switching web-driver focus to new window/tab.
		utils.switchToWindow("https://www.lambdatest.com/integrations");

		//Step-6:Assertion for checking Expected and Actual URLs in the second page.
		Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),ExpectedURL);
		Reporter.log("ACtual and Expected URL are same",true);
		
		System.out.println(DriverManager.getDriver().getTitle());	
		// Step-7: Scroll to the element in the new window (Used page-2)
		page2.ClickCodelessAutomationLink();

		//Step-9: Assertion for title in the child window.
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(DriverManager.getDriver().getTitle(),"TestingWhiz Integration | LambdaTest.","Actual title is different to expected title");		//Step-10: Closing the child window/tab using window handle
		DriverManager.getDriver().close();

		//Step-11:Printing the current windows count
		utils.printWindowSizesAndHandles();

		//Switching back to the previous window(original/parent window)to perform 12th step.
		utils.switchToWindow("https://www.lambdatest.com/");

		//Step-12: On the current window, setting the URL to
		DriverManager.getDriver().navigate().to("https://www.lambdatest.com/blog.");
		System.out.println(DriverManager.getDriver().getTitle()+" --> After setting new URL");

		//Step-13: Click on the ‘Community’ link and verifying whether the URL is same or not.
		page3.CommunityLinkPage();	

		softAssert.assertAll();
	}
}