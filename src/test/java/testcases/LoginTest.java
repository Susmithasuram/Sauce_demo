package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass
{
	
	/*
	 *  BaseClass > BrowserFactory > ConfigReader > DataProvider > ExcelReader > DataProvider > Test (Pages > Utility) > BaseClass
	 * 
	 */
	
	
	@Test(description = "This test will verify valid login scenario",dataProvider = "login",dataProviderClass = CustomDataProvider.class)
	public void validLoginTest(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		
		HomePage home= login.loginToApp(username, password);
		
		Assert.assertTrue(home.getProductLabel().contains("Produc"));
		
		System.out.println("testing pull request");
		
		Assert.assertTrue(home.sidePannelIsPresentwithLogOutOption());
		
	}

}



