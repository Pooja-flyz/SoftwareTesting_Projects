package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;



public class Tricentis_HomeTest  extends Tricentis_BaseClass {
	
	
	
	@Test(priority=1)
	public void verifyHomePageHeading() {

	    Assert.assertTrue( hp.isHomePageHeadingDisplayed(), "Home page heading is not displayed");
	}

	@Test(priority = 2)
	public void verifyHomePage() {

	    // Verify page
	    Assert.assertEquals(   driver.getTitle(), "Demo Web Shop");

	    Assert.assertTrue( hp.isLogoDisplayed(), "Logo is not displayed" );

	    // Register
	    Assert.assertTrue( hp.isRegisterDisplayed(), "Register link is not displayed" );

	    Assert.assertTrue( hp.isRegisterEnabled(),"Register link is not enabled" );

	    // Login
	    Assert.assertTrue( hp.isLoginDisplayed(), "Login link is not displayed");

	    Assert.assertTrue( hp.isLoginEnabled(),"Login link is not enabled");

	    // Search
	    Assert.assertTrue(hp.isSearchBoxDisplayed(),"Search box is not displayed" );

	    Assert.assertTrue( hp.isSearchBoxEnabled(),"Search box is not enabled" );

	    // Shopping Cart
	    Assert.assertTrue(hp.isCartDisplayed(),"Shopping Cart is not displayed" );

	    Assert.assertTrue(hp.isCartEnabled(), "Shopping Cart is not enabled" );
	    
	    
		}

	
	@Test(priority = 3)
	public void clickLoginLink()
	{
			hp.clickLogin();
	}
	
}
