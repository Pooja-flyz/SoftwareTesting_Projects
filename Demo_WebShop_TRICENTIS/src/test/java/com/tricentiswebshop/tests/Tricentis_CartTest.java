package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_CartTest extends Tricentis_BaseClass {
	

    // Verify Cart Page
    @Test(priority = 1)
    public void verifyCartPageTest() {

        driver.get("https://demowebshop.tricentis.com/cart" );

        Assert.assertEquals( cp.getCartHeading(), "Shopping cart");
    }


    // Verify Product in Cart

    @Test(priority = 2)
    public void verifyAddedProductTest() {


        driver.get("https://demowebshop.tricentis.com/cart");

        Assert.assertTrue(cp.isProductInCart("Computing and Internet"),"Computing and Internet is not displayed in cart");

            Assert.assertTrue( cp.isProductInCart("Black & White Diamond Heart"), "Black & White Diamond Heart is not displayed in cart");
    }


    // Change Quantity

    @Test(priority = 3)
    public void changeProductQuantityTest() {

        driver.get( "https://demowebshop.tricentis.com/cart" );

        cp.changeQuantity(0, "2");

        cp.clickUpdateCart();

        Assert.assertTrue(cp.getCartItemCount() > 0, "Cart is empty after quantity update");
    }


    // Verify Order Total
    @Test(priority = 4)
    public void verifyOrderTotalTest() {

        driver.get( "https://demowebshop.tricentis.com/cart" );

        String total = cp.getOrderTotal();

        System.out.println( "Order Total: " + total );

        Assert.assertFalse(total.isEmpty(),"Order total is not displayed" );
    }


    // Remove Product
 
    @Test(priority = 5)
    public void removeProductTest() {

        pp.clickJewelry();

        pp.clickProduct( "Black & White Diamond Heart");

        driver.get("https://demowebshop.tricentis.com/cart" );

        cp.selectRemoveProduct(0);

        cp.removeSelectedProducts();

        Assert.assertEquals( cp.getCartItemCount(), 1, "One product should remain after removing one product");
    }


   
    // Continue Shopping
    @Test(priority = 6)
    public void continueShoppingAndAddProductTest() {

    	 
        // Continue shopping from Cart
        cp.clickContinueShopping();

        // Search for another product
        pp.clickJewelry();

        // Open the searched product
        pp.clickProduct("Black & White Diamond Heart");

        // Add product to cart
        pdp.clickAddToCart();
        
    }

}
