package com.ebay.DataDrivenFrameworkPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOnPage {

	private static final Logger log = Logger.getLogger(SignOnPage.class.getName());
	WebDriver driver;
	public SignOnPage(WebDriver driver) {
		this.driver=driver;
	}
	//Page Factory
	
	//Username text box
	@FindBy(xpath = "//input[@name='userName']")
	public WebElement userName;
	
	// password
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordTextBox;
	
	//login button
	@FindBy(xpath = "//input[@name='login']")
	public WebElement loginButton;
	
	public void clickLoginButton() {
		loginButton.click();
		
	}
	
	
	
	
	
	
	
	
}
