package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class CheckOut_OverviewPage 
{

	WebDriver driver;
	
	public CheckOut_OverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By sauceCard=By.xpath("//div[@class='summary_value_label'][1]");
	
	By itemTotal=By.xpath("//div[@class='summary_subtotal_label'][1]");
	
	By finish=By.xpath("//a[normalize-space()='FINISH']");
	
	
	
	
	public String getSauceCard()
	{
		return Utility.findElement(driver, sauceCard, 10).getText();
	}
	
	public double getItemTotal() 
	{
	
	String total=Utility.findElement(driver, itemTotal, 10).getText();
	String[] arr= total.split("\\$");
	System.out.println("array ele is "+arr[1]);
	double total_itemPrice=Double.parseDouble(arr[1]);
	return total_itemPrice;
		
	}
	
	public OrderConfirmationPage clickOnfinish()
	{
		Utility.clickElement(driver, finish);
		
		return new OrderConfirmationPage(driver);
	}
}
