package com.tricentiswebshop.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tricentis_CheckoutPage {

    WebDriver driver;
    


    // Page heading
    @FindBy(xpath = "//div[@class='page-title']//h1")
    WebElement checkoutHeading;

    // Billing Address
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement state;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;

    // Billing Continue
    @FindBy(xpath = "//input[@value='Continue' and contains(@onclick,'Billing')]")
    WebElement billingContinue;
    
    @FindBy(id = "billing-address-select")
    WebElement billingAddressDropdown;

//    @FindBy(xpath = "//input[@type='checkbox' and following-sibling::label[contains(.,' In-Store Pickup')]]")
//    @FindBy(id = "PickUpInStore")
//    @FindBy(xpath = "//*[@id = 'PickUpInStore']")
    @FindBy(xpath = "//div[@class = 'section pickup-in-store']//following::*[@id = 'PickUpInStore']")
    WebElement pickUpInStore;
    
    // Shipping Continue
    @FindBy(xpath = "//input[@value='Continue' and contains(@onclick,'Shipping')]")
    WebElement shippingContinue;

//    // Shipping Method Continue
//    @FindBy(xpath = "//input[@value='Continue' and contains(@onclick,'ShippingMethod')]")
//    WebElement shippingMethodContinue;

    // Payment Method Continue
    @FindBy(xpath = "//input[@value='Continue' and contains(@onclick,'PaymentMethod')]")
    WebElement paymentMethodContinue;
    
    @FindBy(id = "paymentmethod_0")
    WebElement paymentMethod;

    // Shipping Address Continue
//    @FindBy(xpath = "//input[contains(@class,'button-1 new-address-next-step-button')]")
    @FindBy(xpath = "//input[@value='Continue' and @onclick='Shipping.save()']")
    WebElement shippingAddressContinue;
    
//    @FindBy(id = "shippingoption_0")
//    WebElement groundShipping;
//    
//    @FindBy(id = "shippingoption_1")
//    WebElement nextDayAir;
//
//    @FindBy(id = "shippingoption_2")
//    WebElement secondDayAir;

    @FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
    WebElement shippingMethodContinue;
    
//    @FindBy(xpath = "//input[@value='Continue' and @onclick=' PaymentMethod.save()']")
//    WebElement paymentMethodContinue;
  
    @FindBy (xpath ="//div[@class = 'method-name']//input[@id = 'shippingoption_0']")
    WebElement groundShipping;
    
    @FindBy(xpath = "//input[@value='Confirm']")
    WebElement confirmButton;
	
    @FindBy(xpath = "//div[@id='payment-method-buttons-container']//a[contains(@onclick,'Checkout.back')]")
    WebElement paymentBack;
    
    @FindBy(xpath = "//a[@onclick='Checkout.back(); return false;']")
    WebElement backButton;
    
    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//a[contains(@onclick,'Checkout.back')]")
    WebElement shippingMethodBack;
    
    @FindBy(xpath = "//input[contains(@class,'payment-info-next-step-button')]")
    WebElement paymentInfoContinue;

    @FindBy(xpath = "//input[contains(@class,'confirm-order-next-step-button')]")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//div[contains(@class,'section order-completed')]")
    WebElement orderCompletedMessage;

    @FindBy(xpath = "//div[contains(@class,'order-number')]")
    WebElement orderNumber;
    
    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed')]")
    WebElement orderSuccessMessage;
    
    
    
    public Tricentis_CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(backButton)
        ).click();
    }
    public void enterBillingDetails(
            String fName,
            String lName,
            String mail,
            String countryName,
            String cityName,
            String addressText,
            String zip,
            String phone) {

        firstName.clear();
        firstName.sendKeys(fName);

        lastName.clear();
        lastName.sendKeys(lName);

        email.clear();
        email.sendKeys(mail);

        // Select country
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText(countryName);

        city.clear();
        city.sendKeys(cityName);

        address.clear();
        address.sendKeys(addressText);

        zipCode.clear();
        zipCode.sendKeys(zip);

        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
    }

    public void clickBillingContinue() {
        billingContinue.click();
    }
    
    public void selectExistingBillingAddress() {

        Select select = new Select(billingAddressDropdown);

        select.selectByValue("5141174");
    }
    
//    public void selectPickUpInStore() {
//    	 Webdriver.wait(1000);
//        if (!pickUpInStore.isSelected()) {
//            pickUpInStore.click();
//        }
//    }
    public void selectPickUpInStore() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pickUp = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("PickUpInStore")
            )
        );

        if (!pickUp.isSelected()) {
            pickUp.click();
        }
    }

    public void clickShippingContinue() {
        shippingContinue.click();
    }

 
//    
    public void selectGroundShipping() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement ground = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("shippingoption_1")
            )
        );

        if (!ground.isSelected()) {
            ground.click();
        }
    } 
   
    public void clickShippingMethodContinue() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class='button-1 shipping-method-next-step-button']")
            )
        );

        button.click();
    }
    
    
//    public void selectGroundShipping() {
//
//        if (!groundShipping.isSelected()) {
//            groundShipping.click();
//        }
//    }
//    
//    public void clickShippingMethodContinue() {
//        shippingMethodContinue.click();
//    }
 
    public void clickshippingMethodBack() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(shippingMethodBack)
        ).click();
    }
    
    
    
    public void clickPaymentBack() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(paymentBack)
        ).click();
    }
    public void clickPaymentMethodContinue() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(paymentMethodContinue)
        ).click();
    }
    
//    public void clickPaymentMethodContinue() {
//        paymentMethodContinue.click();
//    }
    public void selectPaymentMethod() {

        if (!paymentMethod.isSelected()) {
            paymentMethod.click();
        }
    }
    
    public String getCheckoutHeading() {
        return checkoutHeading.getText();
    }
    
    public void selectShippingAddress() {
        // select existing/new shipping address if required
    }
    
    public void clickShippingAddressContinue() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(shippingAddressContinue)
        ).click();
    }
    
//    public void clickShippingAddressContinue() {
//
//        shippingAddressContinue.click();
//    }
    public void verifyPaymentInformation() {
        // verify payment information section
    }

//    public void clickPaymentInfoContinue() {
//
//        paymentInfoContinue.click();
//    }
    public void clickPaymentInfoContinue() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(paymentInfoContinue)
        ).click();
    }
    
    public void clickConfirmOrder() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(confirmOrderButton)
        ).click();
    } 

//    public void clickConfirmOrder() {
//
//        confirmOrderButton.click();
//    }

    public String getOrderSuccessMessage() {
        return orderSuccessMessage.getText();
    }
    
//    public boolean isOrderCompleted() {
//
//        return orderCompletedMessage.isDisplayed();
//    }
    public boolean isOrderCompleted() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
            ExpectedConditions.visibilityOf(orderCompletedMessage)
        ).isDisplayed();
    }
    
    

    public String getOrderNumber() {

        return orderNumber.getText();
    }
}


