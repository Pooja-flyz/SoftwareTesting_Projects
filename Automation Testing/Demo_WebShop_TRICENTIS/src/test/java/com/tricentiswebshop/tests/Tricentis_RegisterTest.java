package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_RegisterTest extends Tricentis_BaseClass{
	
	@Test(priority = 1)
    public void registerPageTest() {

        hp.clickRegister();

        Assert.assertTrue(
            rp.isFirstNameDisplayed(),
            "First Name field is not displayed"
        );

        Assert.assertTrue(
            rp.isLastNameDisplayed(),"Last Name field is not displayed");

        Assert.assertTrue(rp.isEmailDisplayed(),"Email field is not displayed");

        Assert.assertTrue(rp.isPasswordDisplayed(),"Password field is not displayed" );

        Assert.assertTrue(rp.isConfirmPasswordDisplayed(), "Confirm Password field is not displayed" );

        Assert.assertTrue( rp.isRegisterButtonDisplayed(), "Register button is not displayed" );
    }


    @Test(priority = 2)
    public void registrationTest() {

        hp.clickRegister();

        rp.selectMale();

        rp.enterFirstName("Loop");

        rp.enterLastName("Kiki");

        rp.enterEmail("loop" + System.currentTimeMillis() + "@gmail.com");

        rp.enterPassword("Testkiki@123");

        rp.enterConfirmPassword("Testkiki@123");

        rp.clickRegister();

        Assert.assertTrue( driver.getPageSource().contains("Your registration completed"), "Registration was not successful" );
    }

	@Test(priority = 6)
	public void logout()
	{
		rp.clickLogout();
	}
    
//    @Test(priority = 3)
//    public void continueButton()
//    {
//    	rp.clickContinue();
//    }
}
