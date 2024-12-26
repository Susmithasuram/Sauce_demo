package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class CheckOutPage
{

	WebDriver driver;
	
	By firstName=By.id("first-name");
	By lastName=By.id("last-name");
	By zipCode=By.id("postal-code");
	
	By cont=By.xpath("//input[@value='CONTINUE']");
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public CheckOut_OverviewPage enterCheckOutDetails(String fName,String lName,String zCode)
	{
		Utility.findElement(driver, firstName, 10).sendKeys(fName);
		Utility.findElement(driver, lastName, 10).sendKeys(lName);
		
		//int code=Integer.parseInt(zCode);
		Utility.findElement(driver, zipCode, 10).sendKeys(zCode);
		
		Utility.clickElement(driver, cont);
		
		return new CheckOut_OverviewPage(driver);
		
		
	}
}
