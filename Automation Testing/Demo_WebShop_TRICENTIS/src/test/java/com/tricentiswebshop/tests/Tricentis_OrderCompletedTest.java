package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_OrderCompletedTest extends Tricentis_BaseClass{
	
	@Test(priority = 1)
	public void verifyOrderCompletedTest() {

		// Verify success message
	    Assert.assertTrue( oc.isSuccessMessageDisplayed(), "Order success message is not displayed");
	}
	@Test (priority = 2)
	public void verifyOrderNumber() {
		
	    // Verify order number
	    Assert.assertTrue( oc.isOrderNumberDisplayed(),"Order number is not displayed");
	}

	
	@Test(priority = 3)
	public void verifyOrderDetailLink() {
		
	    // Verify order details link
	    Assert.assertTrue(oc.isOrderDetailsLinkDisplayed(), "Order details link is not displayed" );
	}
	
	@Test (priority = 4)
	public void continueHomepage()
	{
	    // Continue to Home Page
	    oc.isContinueButtonEnabled();
	}
	
	@Test(priority = 5)
	public void clickInvoice()
	{
	    oc.clickOrderDetails();
	}
	

	
}
