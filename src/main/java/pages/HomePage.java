package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class HomePage 
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By products=By.className("product_label");
	
	By sidePannel=By.xpath("//button[text()='Open Menu']/..");
	
	By logOut=By.xpath("//a[@id='logout_sidebar_link']");
	
	By addToCart=By.xpath("//div[(text()='Sauce Labs Bike Light')]//following::button[1]");
	
	By cartItems=By.xpath("//span[contains(@class,'shopping_cart_badge')]");
	
	By cart=By.xpath("//a[contains(@class,'cart')]");
	
	
	
	public String getProductLabel()
	{
	
		return Utility.findElement(driver, products).getText();
	}
	
	public boolean sidePannelIsPresentwithLogOutOption()
	{
		
//		WebElement ele= Utility.findElement(driver, sidePannel, 10);
//		ele.click();
		Utility.clickElement(driver, sidePannel, 10);
		return Utility.findElement(driver, logOut).isDisplayed();
		
	}
	
	public void addProductToCart(String product)
	{
	
		
      Utility.clickElement(driver, By.xpath("//div[(text()='"+product+"')]//following::button[1]"), 10);
      
	}
   
	
	public String getCartCount()
	{
		return Utility.findElement(driver, cartItems).getText();
	}
	
	public CartPage clickCart()
	{
		Utility.clickElement(driver, cart, 10);
		return new CartPage(driver);
	}
}
