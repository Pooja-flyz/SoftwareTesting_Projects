package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_LoginTest  extends Tricentis_BaseClass  {
	
	
//    @Test(priority = 1)
//    public void loginPageFieldsTest() {
//
//        hp.clickLogin();
//
//        // Verify Email field
//        Assert.assertTrue( lp.isEmailDisplayed(), "Email field is not displayed");
//
//        Assert.assertTrue( lp.isEmailEnabled(), "Email field is not enabled");
//
//        // Verify Password field
//        Assert.assertTrue( lp.isPasswordDisplayed(),"Password field is not displayed" );
//
//        Assert.assertTrue(lp.isPasswordEnabled(), "Password field is not enabled");
//
//        // Verify Login button
//        Assert.assertTrue( lp.isLoginButtonDisplayed(), "Login button is not displayed" );
//
//        Assert.assertTrue( lp.isLoginButtonEnabled(),"Login button is not enabled");
//    }

	 @Test(priority = 1)
	    public void validLoginTest() {

	        // From Home Page → Login Page
//	        hp.clickLogin();

	        // Enter valid credentials
	        lp.enterEmail("loop@gmail.com");
	        lp.enterPassword("Testkiki@123");

	        // Click Login
	        lp.clickLogin();

	        // Verify successful login
	        Assert.assertTrue( driver.getPageSource().contains("Log out"),"Login was not successful" );
	    }



	


}
