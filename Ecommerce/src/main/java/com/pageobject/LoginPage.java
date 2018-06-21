package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By email=By.xpath("//*[@id='ap_email']");
	By continueButton  = By.xpath("//*[@id='continue']");
	By password=By.xpath("//*[@id='ap_password']");
	By submit=By.xpath("//*[@id='signInSubmit']");
	By errorText = By.xpath("//*[@id='auth-error-message-box']/div/div/ul/li/span");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submit);
	}
	
	public WebElement getContinueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public WebElement getErrorText()
	{
		return driver.findElement(errorText);
	}
	
	
}
