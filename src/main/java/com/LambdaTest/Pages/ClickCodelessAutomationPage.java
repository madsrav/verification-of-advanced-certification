package com.LambdaTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LambdaTest.driver.DriverManager;
import com.LambdaTest.utilities.WebDriverUtilities;





public class ClickCodelessAutomationPage {
	
	@FindBy(xpath="//div[@id='codeless_row']/*[text()='Codeless Automation']")
	private WebElement codelessAutomationLink;
	
	public ClickCodelessAutomationPage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public WebElement getCodelessAutomationLink() {
		return codelessAutomationLink;
	}

	public void ClickCodelessAutomationLink()
	{	
		WebDriverUtilities utils = new WebDriverUtilities();
		utils.scrollToElement(codelessAutomationLink);		
	}	
}
