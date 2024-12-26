package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.CartPage;
import pages.CheckOutPage;
import pages.CheckOut_OverviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;

public class BuyProductTest extends BaseClass
{

	HomePage home;
	
	@Test(priority = 0,dataProvider = "login",dataProviderClass = CustomDataProvider.class)
	public void validLoginTest(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		
		home= login.loginToApp(username, password);
		
		Assert.assertTrue(home.getProductLabel().contains("Produc"));
		
		//Assert.assertTrue(home.sidePannelIsPresentwithLogOutOption());
		
	}
	
	
	
	
	@Test(dependsOnMethods = "validLoginTest",dataProvider = "product",dataProviderClass = CustomDataProvider.class)
	public void buyProduct(String productName1,String productName2,String firstName,String lastName,String zipCode)
	{
		home.addProductToCart(productName1);
		home.addProductToCart(productName2);
		Assert.assertTrue(home.getCartCount().equalsIgnoreCase("2"));
		CartPage cart= home.clickCart();
		Assert.assertTrue(cart.getListOfItemsCountInCartPage()==2);
		System.out.println("No of items listed in cart page are "+cart.getListOfItemsCountInCartPage());
		double totalPrice=cart.getTotalPrice();
		System.out.println("Total price is "+totalPrice);
		CheckOutPage checkOut=cart.clickCheckOut();
		CheckOut_OverviewPage check_Overview= checkOut.enterCheckOutDetails(firstName, lastName, zipCode);
		Assert.assertFalse(check_Overview.getSauceCard().isEmpty());
		double totalPrice_InOverview=check_Overview.getItemTotal();
		Assert.assertEquals(totalPrice,totalPrice_InOverview);
		OrderConfirmationPage order=check_Overview.clickOnfinish();
		Assert.assertTrue(order.getThankYouMsg().contains("THANK YOU"));
		
		
	}
}
