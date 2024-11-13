package com.LambdaTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LambdaTest.driver.DriverManager;


public class ClickCommunityLink3Page {
	
	
	@FindBy(xpath="//li/a[@rel='noopener noreferrer' and text()='Community']")
	private WebElement ClickCommunitylink;
	
	public ClickCommunityLink3Page()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public WebElement getClickCommunitylink() {
		return ClickCommunitylink;
	}

	public void CommunityLinkPage()
	{
		getClickCommunitylink().click();
	}
}
