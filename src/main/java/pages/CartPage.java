package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import helper.Utility;

public class CartPage
{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By items=By.xpath("//div[@class='cart_item']"); 
	
	By prices=By.xpath("//div[contains(@class,'inventory_item_price')]");
	
	By checkout=By.xpath("//a[text()='CHECKOUT']");
	
	
	public int getListOfItemsCountInCartPage()
	{
		 return Utility.findElements(driver, items).size();
	}
	
	public double getTotalPrice()
	{
	 	List<WebElement> listOfPrices= Utility.findElements(driver, prices);
	 	
	 	double totalPrice=0;
	 	for(WebElement ele:listOfPrices)
	 	{
	 		String price=ele.getText();
	 		totalPrice=totalPrice+Double.parseDouble(price);
	 	}
	 	return totalPrice;
	 	
	}
	public CheckOutPage clickCheckOut()
	{
		Utility.clickElement(driver, checkout, 10);
		CheckOutPage checkOutPage=PageFactory.initElements(driver, CheckOutPage.class);
		return checkOutPage;
	}
}
