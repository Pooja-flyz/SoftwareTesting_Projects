package com.tricentiswebshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Tricentis_ProductPage {
	
	
	WebDriver driver;

    // -----------------------------
	
    // Category links
    // -----------------------------

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Books']")
    WebElement books;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Computers']")
    WebElement computers;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Electronics']")
    WebElement electronics;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Apparel & Shoes']")
    WebElement apparelShoes;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloads;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Jewelry']")
    WebElement jewelry;

    @FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Gift Cards']")
    WebElement giftCards;


    // -----------------------------
    // Page heading
    // -----------------------------

    @FindBy(xpath = "//div[contains(@class,'page-title')]//h1")
    WebElement pageHeading;


    // -----------------------------
    // View as dropdown
    // -----------------------------

    @FindBy(id = "products-viewmode")
    WebElement viewAsDropdown;


    // -----------------------------
    // Sort dropdown
    // -----------------------------

    @FindBy(id = "products-orderby")
    WebElement sortDropdown;

    @FindBy(id = "products-viewmode")
    WebElement viewDropdown;

    // -----------------------------
    // Display per page dropdown
    // -----------------------------

    @FindBy(id = "products-pagesize")
    WebElement displayPerPageDropdown;


    // -----------------------------
    // Product list
    // -----------------------------

    @FindBy(css = ".product-grid .product-item")
    List<WebElement> products;


    @FindBy(css = ".product-grid .product-item .product-title a")
    List<WebElement> productNames;


    @FindBy(css = ".product-grid .product-item .actual-price")
    List<WebElement> productPrices;


    // -----------------------------
    // Search
    // -----------------------------

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchButton;


    // -----------------------------
    // Constructor
    // -----------------------------

    public Tricentis_ProductPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // -----------------------------
    // Category methods
    // -----------------------------

    public void clickBooks() {
        books.click();
    }

    public void clickComputers() {
        computers.click();
    }

    public void clickElectronics() {
        electronics.click();
    }

    public void clickApparelShoes() {
        apparelShoes.click();
    }

    public void clickDigitalDownloads() {
        digitalDownloads.click();
    }

    public void clickJewelry() {
        jewelry.click();
    }

    public void clickGiftCards() {
        giftCards.click();
    }


    // -----------------------------
    // Page heading
    // -----------------------------

    public String getPageHeading() {
        return pageHeading.getText();
    }


    // -----------------------------
    // View dropdown
    // -----------------------------

//    public void selectView(String value) {
//
//        Select select = new Select(viewAsDropdown);
//
//        select.selectByVisibleText(value);
//    }
    
    public void selectView(String view) {

        Select select = new Select(viewDropdown);

        select.selectByVisibleText(view);
    }

    // -----------------------------
    // Sort dropdown
    // -----------------------------

    public void selectSortOption(String value) {

        Select select = new Select(sortDropdown);

        select.selectByVisibleText(value);
    }


    // -----------------------------
    // Display per page
    // -----------------------------

    public void selectDisplayPerPage(String value) {

        Select select = new Select(displayPerPageDropdown);

        select.selectByVisibleText(value);
    }


    // -----------------------------
    // Product methods
    // -----------------------------

    public int getProductCount() {

        return products.size();
    }


    public List<WebElement> getProducts() {

        return products;
    }


    public List<WebElement> getProductNames() {

        return productNames;
    }


    public List<WebElement> getProductPrices() {

        return productPrices;
    }


    public void clickProduct(String productName) {

        for (WebElement product : productNames) {

            if (product.getText().trim().equalsIgnoreCase(productName)) {

                product.click();

                return;
            }
        }

        throw new RuntimeException(
                "Product not found: " + productName
        );
    }


    // -----------------------------
    // Search
    // -----------------------------

    public void searchProduct(String productName) {

        searchBox.clear();

        searchBox.sendKeys(productName);

        searchButton.click();
    }


    // -----------------------------
    // Check products displayed
    // -----------------------------

    public boolean areProductsDisplayed() {

        return products.size() > 0;
    }

}
