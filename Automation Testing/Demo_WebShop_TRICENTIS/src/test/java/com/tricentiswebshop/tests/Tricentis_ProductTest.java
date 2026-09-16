package com.tricentiswebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trcentiswebshop.base.Tricentis_BaseClass;

public class Tricentis_ProductTest extends Tricentis_BaseClass {


    // 1. Verify Books category
    
    @Test(priority = 1)
    public void verifyBooksCategoryTest() {

        pp.clickBooks();

        Assert.assertEquals( pp.getPageHeading(),  "Books");

        Assert.assertTrue(pp.areProductsDisplayed(),"Books products are not displayed" );
    }


  
    // 2. Verify Jewelry category
    
    @Test(priority = 2)
    public void verifyJewelryCategoryTest() {

        pp.clickJewelry();

        Assert.assertEquals(  pp.getPageHeading(),"Jewelry");

        Assert.assertTrue(  pp.areProductsDisplayed(), "Jewelry products are not displayed" );
    }


  
    // 3. Verify product list

    @Test(priority = 3)
    public void verifyProductListTest() {

        pp.clickBooks();

        Assert.assertTrue(pp.getProductCount() > 0,  "No products displayed" );

        System.out.println("Number of products: " + pp.getProductCount());
    }


    // 4. Verify Sort - Name A to Z

    @Test(priority = 4)
    public void sortProductNameAToZTest() {

//        pp.clickApparelShoes();

        pp.selectSortOption("Name: A to Z");

        Assert.assertTrue( pp.areProductsDisplayed(),"Products not displayed after sorting");
    }



    //  Verify Sort - Name Z to A

    @Test(priority = 5)
    public void sortProductNameZToATest() {

//        pp.clickApparelShoes();

        pp.selectSortOption("Name: Z to A");

        Assert.assertTrue( pp.areProductsDisplayed(),"Products not displayed after sorting" );
    }


    // Verify Sort - Price Low to High
  
    @Test(priority = 6)
    public void sortPriceLowToHighTest() {

//        pp.clickApparelShoes();

        pp.selectSortOption("Price: Low to High");

        Assert.assertTrue(  pp.areProductsDisplayed(), "Products not displayed after price sorting");
    }



    //  Verify Sort - Price High to Low

    @Test(priority = 7)
    public void sortPriceHighToLowTest() {

//        pp.clickApparelShoes();

        pp.selectSortOption(  "Price: High to Low" );

        Assert.assertTrue(pp.areProductsDisplayed(), "Products not displayed after price sorting" );
    }


  
    //  Verify Display per page
    @Test(priority = 8)
    public void verifyDisplayPerPageTest() {

        pp.clickBooks();

        pp.selectDisplayPerPage("4");

        Assert.assertTrue(pp.getProductCount() > 0, "Products are not displayed" );

        System.out.println("Products displayed: " + pp.getProductCount());
    }



    // Verify Search
    @Test(priority = 9)
    public void searchProductTest() {

        pp.searchProduct("computer");

        Assert.assertTrue(pp.areProductsDisplayed(), "Search results are not displayed" );
    }


    // ------------------------------------------------
    // 11. Verify invalid search
    // ------------------------------------------------

    @Test(priority = 11)
    public void invalidSearchTest() {

        pp.searchProduct("xyz123456789");

        System.out.println("Invalid search executed successfully" );
    }


    // ------------------------------------------------
    // 12. Verify product details
    // ------------------------------------------------

    @Test(priority = 12)
    public void verifyProductDetailsTest() {

        pp.clickBooks();

        pp.clickProduct("Computing and Internet");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue( currentUrl.contains("/computing-and-internet"), "Product details page was not opened");
    }
	
}
