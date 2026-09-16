package com.tricentiswebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tricentis_ProductDetailsPage {
	

    WebDriver driver;
    // Product name
    @FindBy(xpath = "//div[contains(@class,'product-name')]//h1")
    WebElement productName;

    // Product price
    @FindBy(xpath = "//div[contains(@class,'product-price')]//span")
    WebElement productPrice;

    // Product description
    @FindBy(xpath = "//div[contains(@class,'full-description')]")
    WebElement productDescription;

    // Product image
    @FindBy(xpath = "//div[contains(@class,'product-essential')]//img")
    WebElement productImage;

    // Add to cart
    @FindBy(xpath = "//input[contains(@value,'Add to cart')]")
    WebElement addToCartButton;

    // Success message
    @FindBy(css = "div.bar-notification.success")
    WebElement successMessage;


    @FindBy(id = "addtocart_13_EnteredQuantity")
    WebElement quantity;




    public Tricentis_ProductDetailsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public void enterQuantity(String value) {

        quantity.clear();

        quantity.sendKeys(value);
    }


    public void clickAddToCart() {

        addToCartButton.click();
    }


    public boolean isSuccessMessageDisplayed() {

        return successMessage.isDisplayed();
    }

    public boolean isProductNameDisplayed() {

        return productName.isDisplayed();
    }
    
    public boolean isProductPriceDisplayed() {

        return productPrice.isDisplayed();
    }

    public boolean isProductDescriptionDisplayed() {

        return productDescription.isDisplayed();
    }
    public boolean isProductImageDisplayed() {

        return productImage.isDisplayed();
    }

    
}
