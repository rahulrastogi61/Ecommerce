package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	By signinButton=By.xpath("//*[@id='nav-link-accountList']/span[1]");
	By searchButton = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");
	By searchTextBox = By.xpath("//*[@id='twotabsearchtextbox']");
	By firstResult = By.xpath("//*[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2");
	By addToCartButton = By.xpath("//*[@id='add-to-cart-button']");
	By cartButton = By.xpath("//*[@id='nav-cart']/span[2]");
	By price = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
	//*[@id="activeCartViewForm"]/div[2]/div/div[4]/div/div[2]/p/span
	By priceFromCart = By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[2]/p/span)");
	
	By signOutMenu = By.xpath("//*[@id='nav-item-signout-sa']/span");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getSigninButton() {
		return driver.findElement(signinButton);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}


	public WebElement getSearchTextBox() {
		return driver.findElement(searchTextBox);
	}

	public WebElement getPriceFromCart() {
		return driver.findElement(priceFromCart);
	}



	public WebElement getFirstResult() {
		return driver.findElement(firstResult);
	}




	public WebElement getAddToCartButton() {
		return driver.findElement(addToCartButton);
	}

	public WebElement getCartButton() {
		return driver.findElement(cartButton);
	}


	public WebElement getPrice() {
		return driver.findElement(price);
	}
	
	public WebElement getSignOutMenu() {
		return driver.findElement(signOutMenu);
	}
	
}


