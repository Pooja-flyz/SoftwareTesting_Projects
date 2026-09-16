package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_ProductDetailsTest extends Tricentis_BaseClass{
	

	@Test(priority = 1)
	public void verifyProductDetailsTest() {

	    pp.clickBooks();

	    pp.clickProduct("Computing and Internet");

	    Assert.assertTrue(pdp.isProductNameDisplayed(),"Product name is not displayed");

	    Assert.assertTrue( pdp.isProductPriceDisplayed(), "Product price is not displayed" );

	    Assert.assertTrue(pdp.isProductDescriptionDisplayed(), "Product description is not displayed" );

	    Assert.assertTrue(
	        pdp.isProductImageDisplayed(), "Product image is not displayed" );
	}
	@Test(priority = 2)
	public void addProductToCartTest() {

	    pp.clickBooks();

	    pp.clickProduct("Computing and Internet");

	    pdp.clickAddToCart();
	    
	    pp.clickJewelry();
	    pp.clickProduct("Black & White Diamond Heart");
	    pdp.clickAddToCart();

	}
	

}
