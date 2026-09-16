package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_CheckoutTest extends Tricentis_BaseClass {
	
	 @Test(priority = 1)
	    public void verifyCheckoutPageTest() {

	       

		 	hp.clickShoppingCart();
		 
		   // Accept Terms of Service
		    cp.acceptTermsOfService();
		 
	        // Click Checkout
	        cp.clickCheckout();

	    }
//
//	 @Test(priority = 2)
//	 public void AddBillingAddressTest() {
//
//	     hp.clickShoppingCart();
//
//	     // Accept Terms of Service
////	     cp.acceptTermsOfService();
//
//	     // Click Checkout
////	     cp.clickCheckout();
//
//	     // Enter Billing Address
//
//	        cop.enterBillingDetails(
//	        		"Loop",
//	                "Kikiunni",
//	                "kiki@test.com",
//	                "India",
//	                "vasco",
//	                "ABC Street",
//	                "680001",
//	                "9876543210"
//	        );
//
//
//	     // Continue
//	     cop.clickBillingContinue();
//	 }

	 
	 @Test(priority = 3)
	 public void verifyExistingBillingAddressTest() {

	     // Select previously saved address
	     cop.selectExistingBillingAddress();

	     cop.clickBillingContinue();
	 }
	 
	 
	 
	 @Test(priority = 4)
	 public void verifyShippingAddressMethodTest() {

	     cop.clickShippingAddressContinue();
    
	     cop.clickshippingMethodBack();

	 }
	 
	 
	 @Test(priority = 5)
	 public void verifyfixedShippingAddressTest() {

		 cop.selectPickUpInStore();
	     cop.clickShippingAddressContinue();
	     cop.clickPaymentMethodContinue();
	     cop.clickPaymentInfoContinue();


	 }


	 @Test(priority = 8)
	 public void verifyConfirmOrderTest() {

		 // Confirm Order
	     cop.clickConfirmOrder();
	 }
	 
	 @Test(priority = 9)
	 public void verifyOrderCompletedTest() {

	     Assert.assertTrue( cop.isOrderCompleted(),  "Order was not completed successfully" );
	 }
 
}
