package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helper.Utility;

public class LoginPage 
{
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	By user_element=By.id("user-name");
	
	By password_elemenet=By.id("password");
	
	By login_button=By.id("login-button");
	
	//Creating new users
	
	By newUser = By.xpath("//a[text()='New user? Signup']");

	
	
	
	
	
	
	public HomePage loginToApp(String uname, String pass) 
	{
		
		Utility.findElement(driver, user_element).sendKeys(uname);
	
		Utility.findElement(driver, password_elemenet).sendKeys(pass);
		
		Utility.clickElement(driver, login_button);
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
	return home;
		
	}

}
