package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class OrderConfirmationPage
{

	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By thankyou=By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']");
	
	public String getThankYouMsg()
	{
		return Utility.findElement(driver, thankyou,10).getText();
	}
}
