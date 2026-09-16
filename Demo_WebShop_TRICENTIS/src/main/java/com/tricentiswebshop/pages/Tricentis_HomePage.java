package com.tricentiswebshop.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tricentis_HomePage {
	
	 WebDriver driver;

	    // Constructor
	    public Tricentis_HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // =========================
	    // Home Page Elements
	    // =========================

	    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
	    WebElement homePageHeading;
	    
	    // Logo
	    @FindBy(className = "header-logo")
	    WebElement logo;

	    // Register
	    @FindBy(linkText = "Register")
	    WebElement registerLink;

	    // Login
	    @FindBy(linkText = "Log in")
	    WebElement loginLink;

	    // Shopping Cart
	    @FindBy(className = "cart-label")
	    WebElement shoppingCart;

	    // Wishlist
	    @FindBy(className = "wishlist-label")
	    WebElement wishlist;

	    // Search box
	    @FindBy(id = "small-searchterms")
	    WebElement searchBox;

	    // Search button
	    @FindBy(css = "input.button-1.search-box-button")
	    WebElement searchButton;

	    // Books category
	    @FindBy(linkText = "Books")
	    WebElement books;

	    // Computers category
	    @FindBy(linkText = "Computers")
	    WebElement computers;

	    // Electronics category
	    @FindBy(linkText = "Electronics")
	    WebElement electronics;


	    
	    // =========================
	    // Methods
	    // =========================
	    
	    public boolean isHomePageHeadingDisplayed() {
	        return homePageHeading.isDisplayed();
	    }

	    public boolean isLogoDisplayed() {
	        return logo.isDisplayed();
	    }

	    public boolean isRegisterDisplayed() {
	        return registerLink.isDisplayed();
	    }

	    public boolean isLoginDisplayed() {
	        return loginLink.isDisplayed();
	    }

	    public boolean isSearchBoxDisplayed() {
	        return searchBox.isDisplayed();
	    }

	    public boolean isSearchBoxEnabled() {
	        return searchBox.isEnabled();
	    }

	    public void clickRegister() {
	        registerLink.click();
	    }

//	    public void clickLogin() {
//	        loginLink.click();
//	    }

	    public void clickLogin() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();

	    }
	    
	    public void clickShoppingCart() {
	        shoppingCart.click();
	    }

	    public void clickWishlist() {
	        wishlist.click();
	    }

	    public void searchProduct(String product) {
	        searchBox.clear();
	        searchBox.sendKeys(product);
	        searchButton.click();
	    }

	    public void clickBooks() {
	        books.click();
	    }

	    public void clickComputers() {
	        computers.click();
	    }

	    public void clickElectronics() {
	        electronics.click();
	    }

	    public boolean isRegisterEnabled() {
	        return registerLink.isEnabled();
	    }

	    public boolean isLoginEnabled() {
	        return loginLink.isEnabled();
	    }

	    public boolean isCartDisplayed() {
	        return shoppingCart.isDisplayed();
	    }

	    public boolean isCartEnabled() {
	        return shoppingCart.isEnabled();
	    }

}
