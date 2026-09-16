package com.tricentiswebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tricentis_OrderCompletedPage {
	
	 WebDriver driver;
	
	@FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
	WebElement successMessage;
	
	@FindBy(xpath = "//ul[@class='details']//li[contains(text(),'Order number')]")
	WebElement orderNumber;
	
	@FindBy(xpath = "//a[contains(text(),'Click here for order details')]")
	WebElement orderDetailsLink;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;
	

	
	public Tricentis_OrderCompletedPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
	
	
	public boolean isSuccessMessageDisplayed() {
	    return successMessage.isDisplayed();
	}

	public boolean isOrderNumberDisplayed() {
	    return orderNumber.isDisplayed();
	}

	public boolean isOrderDetailsLinkDisplayed() {
	    return orderDetailsLink.isDisplayed();
	}

	public void clickOrderDetails() {
	    orderDetailsLink.click();
	}

	public void clickContinue() {
	    continueButton.click();
	}
	public void isContinueButtonEnabled() {
		continueButton.isEnabled();
	}
	

	
//	public boolean isSuccessMessageDisplayed() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    return wait.until(
//	        ExpectedConditions.visibilityOf(successMessage)
//	    ).isDisplayed();
//	}
//	
//	public boolean isOrderNumberDisplayed() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    return wait.until(
//	        ExpectedConditions.visibilityOf(orderNumber)
//	    ).isDisplayed();
//	}
//	
//	public boolean isOrderDetailsLinkDisplayed() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    return wait.until(
//	        ExpectedConditions.visibilityOf(orderDetailsLink)
//	    ).isDisplayed();
//	}
//	public void clickOrderDetails() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(
//	        ExpectedConditions.elementToBeClickable(orderDetailsLink)
//	    ).click();
//	}
//	public void clickContinue() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(
//	        ExpectedConditions.elementToBeClickable(continueButton)
//	    ).click();
//	}
}
