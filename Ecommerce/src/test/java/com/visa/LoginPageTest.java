package com.visa;

import org.testng.annotations.Test;

import com.pageobject.LandingPage;
import com.pageobject.LoginPage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class LoginPageTest extends base{
  Logger logger = LogManager.getLogger(LoginPageTest.class.getName());
  WebDriver driver;
  LandingPage landingPage;
  LoginPage loginPage;
  
  
  @BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 landingPage = new LandingPage(driver) ;
	     loginPage = new LoginPage(driver);
		 
	}

	@Test 
	public void login_invalidusernameandpassword() {
		driver.get(prop.getProperty("url"));
		Window window = driver.manage().window();
		window.fullscreen();
		landingPage.getSigninButton().click();
		login("rahulrastogi61@gmail.com","12345");
		String errorText = loginPage.getErrorText().getText();
		assertEquals(errorText, "Your password is incorrect");

	}

	@Test 
	public void login_validusernameandpassword() {
		driver.get(prop.getProperty("url"));
		Window window = driver.manage().window();
		window.fullscreen();
		landingPage.getSigninButton().click();
		login("rahulrastogi61@gmail.com","Aaravananya9");

		//driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone 8 64 GB phone");
		landingPage.getSearchTextBox().sendKeys("iphone 8 64 GB phone");
		//driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
		landingPage.getSearchButton().click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//*[@id="result_1"]/div/div/div/div[2]/div[1]/div[1]/a/h2
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2")));

		
		landingPage.getFirstResult().click();

		
		landingPage.getAddToCartButton().click();

		
		String price1 = landingPage.getPrice().getText();
		
		Actions action = new Actions(driver);
		//WebElement element1 = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
		WebElement element1 =  landingPage.getSigninButton();
		action.moveToElement(element1).build().perform();
		//driver.findElement(By.xpath("//*[@id='nav-item-signout-sa']/span")).click(); // Signout
		landingPage.getSignOutMenu().click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// *[@id='rhf-container']/div/div[3]/div[1]/a/span
		try {
			WebElement element3 = driver.findElement(By.xpath("//*[@id='rhf-container']/div/div[3]/div[1]/a/span"));
			if (element3.isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='rhf-container']/div/div[3]/div[1]/a/span")).click();
			}
		} catch (Throwable e) {
			e.printStackTrace();

		}

		login("rahulrastogi61@gmail.com","Aaravananya9");
		//driver.findElement(By.xpath("//*[@id='nav-cart']/span[2]")).click();
		landingPage.getCartButton().click();
		
		//*[@id="activeCartViewForm"]/div[2]/div/div[4]/div/div[2]/p/span
//		String price2 = driver
//				.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[2]/p/span)")).getText();
		String price2 = landingPage.getPriceFromCart().getText();
		assertEquals(price1, price2);

	}


	private void login(String email,String password) {
		loginPage.getEmail().sendKeys(email);
		loginPage.getContinueButton().click();
		loginPage.getPassword().sendKeys(password);
		loginPage.getSubmitButton().click();
	}



	
	
	@AfterTest
	public void teardown()
	{
		
	       driver.close();
	        driver=null;
		
	}

}
