package com.tricentiswebshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tricentis_CartPage {
	
	  WebDriver driver;

	    // Cart heading
	    @FindBy(xpath = "//div[contains(@class,'page-title')]//h1")
	    WebElement cartHeading;


	    // Product rows in cart
	    @FindBy(xpath = "//table[@class='cart']//tbody/tr")
	    List<WebElement> cartItems;


	    // Product names
	    @FindBy(xpath = "//table[@class='cart']//td[@class='product']//a")
	    List<WebElement> productNames;


	    // Quantity text boxes
	    @FindBy(xpath = "//table[@class='cart']//input[contains(@name,'itemquantity')]")
	    List<WebElement> quantityFields;


	    // Update cart button
	    @FindBy(name = "updatecart")
	    WebElement updateCartButton;


	    // Remove checkbox
	    @FindBy(xpath = "//input[@name='removefromcart']")
	    List<WebElement> removeCheckboxes;


	    // Remove / Update cart
	    @FindBy(name = "updatecart")
	    WebElement updateCart;


	    // Subtotal
	    @FindBy(xpath = "//span[@class='product-price order-total']")
	    WebElement orderTotal;


	    // Continue shopping
	    @FindBy(xpath = "//input[@value='Continue shopping']")
	    WebElement continueShoppingButton;


	    // Checkout
	    @FindBy(id = "checkout")
	    WebElement checkoutButton;

	    @FindBy(id = "termsofservice")
	    WebElement termsOfServiceCheckbox;
	    
	    // Empty cart message
	    @FindBy(xpath = "//div[@class='order-summary-content']")
	    WebElement cartMessage;


	    public Tricentis_CartPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }


	    // --------------------------------
	    // Cart heading
	    // --------------------------------

	    public String getCartHeading() {

	        return cartHeading.getText();
	    }


	    // --------------------------------
	    // Number of products
	    // --------------------------------

	    public int getCartItemCount() {

	        return cartItems.size();
	    }


	    // --------------------------------
	    // Verify product exists
	    // --------------------------------

	    public boolean isProductInCart(String productName) {

	        for (WebElement product : productNames) {

	            if (product.getText().trim()
	                    .equalsIgnoreCase(productName)) {

	                return true;
	            }
	        }

	        return false;
	    }


	    // --------------------------------
	    // Change quantity
	    // --------------------------------

	    public void changeQuantity(int index, String quantity) {

	        quantityFields.get(index).clear();

	        quantityFields.get(index).sendKeys(quantity);
	    }


	    // --------------------------------
	    // Update cart
	    // --------------------------------

	    public void clickUpdateCart() {

	        updateCartButton.click();
	    }


	    // --------------------------------
	    // Remove product
	    // --------------------------------

	    public void selectRemoveProduct(int index) {

	        removeCheckboxes.get(index).click();
	    }


	    // --------------------------------
	    // Remove selected products
	    // --------------------------------

	    public void removeSelectedProducts() {

	        updateCart.click();
	    }


	    // --------------------------------
	    // Get total
	    // --------------------------------

	    public String getOrderTotal() {

	        return orderTotal.getText();
	    }


	    // --------------------------------
	    // Continue shopping
	    // --------------------------------

	    public void clickContinueShopping() {

	        continueShoppingButton.click();
	    }


	    // --------------------------------
	    // Checkout
	    // --------------------------------

	    public void clickCheckout() {

	        checkoutButton.click();
	    }
	    public void acceptTermsOfService() {

	        if (!termsOfServiceCheckbox.isSelected()) {
	            termsOfServiceCheckbox.click();
	        }
	    }

	    // --------------------------------
	    // Cart message
	    // --------------------------------

	    public String getCartMessage() {

	        return cartMessage.getText();
	    }
	

}
