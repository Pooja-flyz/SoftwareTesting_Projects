package com.tricentiswebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tricentis_LoginPage {
	
	 WebDriver driver;
	
	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(css = "input.login-button")
	WebElement loginButton;

	@FindBy(id = "RememberMe")
	WebElement rememberMe;

	@FindBy(linkText = "Forgot password?")
	WebElement forgotPassword;
	
	public Tricentis_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterEmail(String emailId) {
	    email.sendKeys(emailId);
	}

	public void enterPassword(String pwd) {
	    password.sendKeys(pwd);
	}

	public void clickLogin() {
	    loginButton.click();
	}

	public void selectRememberMe() {
	    rememberMe.click();
	}

	public boolean isEmailDisplayed() {
	    return email.isDisplayed();
	}

	public boolean isEmailEnabled() {
	    return email.isEnabled();
	}

	public boolean isPasswordDisplayed() {
	    return password.isDisplayed();
	}

	public boolean isPasswordEnabled() {
	    return password.isEnabled();
	}

	public boolean isLoginButtonDisplayed() {
	    return loginButton.isDisplayed();
	}

	public boolean isLoginButtonEnabled() {
	    return loginButton.isEnabled();
	}

	public boolean isRememberMeSelected() {
	    return rememberMe.isSelected();
	}

	public boolean isForgotPasswordDisplayed() {
	    return forgotPassword.isDisplayed();
	}

	public void clickForgotPassword() {
	    forgotPassword.click();
	}
}
